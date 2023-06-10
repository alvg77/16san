package com.ssan.api16san.service.impl;

import com.ssan.api16san.controller.resources.ModeratorResource;
import com.ssan.api16san.entity.Moderator;
import com.ssan.api16san.entity.User;
import com.ssan.api16san.exceptions.UnauthorizedException;
import com.ssan.api16san.repository.BoardRepository;
import com.ssan.api16san.repository.ModeratorRepository;
import com.ssan.api16san.service.ModeratorService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.ssan.api16san.entity.Board;

import java.util.List;

import static com.ssan.api16san.mapper.ModeratorMapper.MAPPER;

@Service
@RequiredArgsConstructor
public class ModeratorServiceImpl implements ModeratorService {
    private final ModeratorRepository moderatorRepository;
    private final BoardRepository boardRepository;

    @Override
    public ModeratorResource save(ModeratorResource moderatorResource, User currentUser) {
        if (
                !boardRepository.findByName(moderatorResource.getBoardName())
                .orElseThrow(
                        EntityNotFoundException::new
                )
                .getCreator()
                .getId().equals(currentUser.getId())
        ) {
            throw new UnauthorizedException("User is not creator of board!");
        }

        Moderator moderator = moderatorRepository.save(
                MAPPER.fromModeratorResource(moderatorResource)
        );

        moderatorResource.setId(moderator.getId());
        return moderatorResource;
    }

    @Override
    public List<ModeratorResource> getAllModeratorsFromBoard(Long boardId) {
        boardRepository.findById(boardId).orElseThrow(
                () -> new EntityNotFoundException("Board with such id not found!")
        );
        return MAPPER.toModeratorResourceList(
                moderatorRepository.findByBoard_Id(boardId)
        );
    }

    @Override
    public ModeratorResource getById(Long id) {
        return MAPPER.toModeratorResource(
                moderatorRepository.getReferenceById(id)
        );
    }

    @Override
    public boolean userHasModeratorRole(User user, Board board) {
        return moderatorRepository.findByUser_IdAndBoard_Id(user.getId(), board.getId()).isPresent();
    }

    @Override
    public void delete(User currentUser, Long id) {
        Moderator moderator = moderatorRepository.getReferenceById(id);

        if (!moderator.getBoard().getCreator().getId().equals(currentUser.getId())) {
            throw new UnauthorizedException("User is not board creator!");
        }

        moderatorRepository.deleteById(id);
    }

}
