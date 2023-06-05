package com.ssan.api16san.service.impl;

import com.ssan.api16san.controller.resources.BanResource;
import com.ssan.api16san.entity.Ban;
import static com.ssan.api16san.mapper.BanMapper.MAPPER;

import com.ssan.api16san.entity.User;
import com.ssan.api16san.exceptions.UnauthorizedException;
import com.ssan.api16san.repository.BanRepository;
import com.ssan.api16san.repository.BoardRepository;
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

    @Override
    public BanResource save(BanResource banResource, User currentUser) {
        boardRepository.findByName(banResource.getBoardName()).orElseThrow(
                () -> new EntityNotFoundException("No board with such name!")
        );

        if (!moderatorService.userHasModeratorRole(currentUser.getUsername(), banResource.getBoardName())) {
            throw new UnauthorizedException("User must have moderator rights to ban users!");
        }

        Ban banEntity = MAPPER.fromBanResource(banResource);
        banEntity.setCreatedAt(new Date());
        banResource = MAPPER.toBanResource(banRepository.save(banEntity));

        return banResource;
    }

    @Override
    public BanResource getById(Long id) {
        return MAPPER.toBanResource(banRepository.getReferenceById(id));
    }

    @Override
    public void delete(User currentUser, Long id) {
        Ban ban = banRepository.getReferenceById(id);
        if (!moderatorService.userHasModeratorRole(currentUser.getId(), ban.getBoard().getId())) {
            throw new UnauthorizedException("User must have moderator rights to ban users!");
        }
        banRepository.delete(ban);
    }

    @Override
    public BanResource update(BanResource banResource, User currentUser, Long id) {
        if (!moderatorService.userHasModeratorRole(currentUser.getUsername(), banResource.getBoardName())) {
            throw new UnauthorizedException("User must have moderator rights to ban users!");
        }


        Ban ban = banRepository.getReferenceById(id);

        ban.setReason(banResource.getReason());
        ban.setExpiresAt(banResource.getExpiresAt());

        return MAPPER.toBanResource(banRepository.save(ban));
    }

    @Override
    public List<Ban> getAllBansFromBoard(String boardName) {
        return banRepository.findByBoard_Name(boardName);
    }
}
