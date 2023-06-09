package com.ssan.api16san.service.impl;

import com.ssan.api16san.controller.resources.BanResource;
import com.ssan.api16san.entity.Ban;
import static com.ssan.api16san.mapper.BanMapper.MAPPER;

import com.ssan.api16san.entity.Board;
import com.ssan.api16san.entity.User;
import com.ssan.api16san.exceptions.UnauthorizedException;
import com.ssan.api16san.exceptions.UserBanException;
import com.ssan.api16san.repository.BanRepository;
import com.ssan.api16san.repository.BoardRepository;
import com.ssan.api16san.repository.UserRepository;
import com.ssan.api16san.service.BanService;
import com.ssan.api16san.service.ModeratorService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BanServiceImpl implements BanService {
    private final BanRepository banRepository;
    private final ModeratorService moderatorService;
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    @Override
    public BanResource save(BanResource banResource, User currentUser) {
        Board board = boardRepository.findByName(banResource.getBoardName()).orElseThrow(
                () -> new EntityNotFoundException("No board with such name!")
        );

        User user = userRepository.findByUsername(banResource.getUsername()).orElseThrow(
                () -> new EntityNotFoundException("No user with such username!")
        );

        if (!moderatorService.userHasModeratorRole(currentUser, board)) {
            throw new UnauthorizedException("User must have moderator rights to ban users!");
        }

        if (isUserBanned(user, board)) {
            throw new UserBanException("User is already banned!");
        }

        if (board.getCreator().getId().equals(user.getId())) {
            throw new UnauthorizedException("Cannot ban the creator of the board!");
        }

        Ban banEntity = MAPPER.fromBanResource(banResource);
        banEntity.setCreatedAt(new Date());
        banEntity.setBoard(board);
        banEntity.setUser(user);
        banResource = MAPPER.toBanResource(banRepository.save(banEntity));

        return banResource;
    }

    public boolean isUserBanned(User user, Board board) {
        return banRepository.findByUser_IdAndBoard_Id(user.getId(), board.getId()).isPresent();
    }

    @Override
    public BanResource getById(Long id) {
        return MAPPER.toBanResource(banRepository.getReferenceById(id));
    }

    @Override
    public void delete(User currentUser, Long id) {
        Ban ban = banRepository.getReferenceById(id);
        if (!moderatorService.userHasModeratorRole(currentUser, ban.getBoard())) {
            throw new UnauthorizedException("User must have moderator rights to ban users!");
        }
        banRepository.delete(ban);
    }

    @Override
    public BanResource update(BanResource banResource, User currentUser, Long id) {
        Board board = boardRepository.findByName(banResource.getBoardName()).orElseThrow(
                () -> new EntityNotFoundException("Board does not exist!")
        );
        if (!moderatorService.userHasModeratorRole(currentUser, board)) {
            throw new UnauthorizedException("User must have moderator rights to ban users!");
        }


        Ban ban = banRepository.getReferenceById(id);

        ban.setReason(banResource.getReason());
        ban.setExpiresAt(banResource.getExpiresAt());

        return MAPPER.toBanResource(banRepository.save(ban));
    }

    @Override
    public List<BanResource> getAllBansFromBoard(long boardId) {
        boardRepository.findById(boardId).orElseThrow(
                () -> new EntityNotFoundException("Cannot find board with such id!")
        );
        return MAPPER.toBanResourceList(banRepository.findByBoard_Id(boardId));
    }
}
