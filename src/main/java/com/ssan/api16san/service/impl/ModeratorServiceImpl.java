package com.ssan.api16san.service.impl;

import com.ssan.api16san.controller.resources.ModeratorResource;
import com.ssan.api16san.entity.Moderator;
import com.ssan.api16san.entity.User;
import com.ssan.api16san.repository.BoardRepository;
import com.ssan.api16san.repository.ModeratorRepository;
import com.ssan.api16san.service.ModeratorService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ssan.api16san.mapper.ModeratorMapper.MAPPER;

@Service
@RequiredArgsConstructor
public class ModeratorServiceImpl implements ModeratorService {
    private final ModeratorRepository moderatorRepository;
    private final BoardRepository boardRepository;

    @Override
    public ModeratorResource save(ModeratorResource moderatorResource, User currentUser) {
        if (boardRepository.findByName(moderatorResource.getBoardName()).getCreator().getId() != currentUser.getId()) {
            throw new RuntimeException("User is not creator of board!");
        }

        Moderator moderator = moderatorRepository.save(
                MAPPER.fromModeratorResource(moderatorResource)
        );
        moderatorResource.setId(moderator.getId());
        return moderatorResource;
    }

    @Override
    public List<ModeratorResource> getAllModeratorsFromBoard(Long boardId) {
        return MAPPER.toModeratorResourceList(
                moderatorRepository.findByBoard_Id(boardId)
        );
    }

    @Override
    public ModeratorResource getById(Long id) {
        return MAPPER.toModeratorResource(
                moderatorRepository.findById(id).orElseThrow(
                        () -> new EntityNotFoundException("No moderator role found with the specified id.")
                )
        );
    }

    @Override
    public boolean userHasModeratorRole(Long userId, Long boardId) {
        return moderatorRepository.findByUser_IdAndBoard_Id(userId, boardId).isPresent();
    }

    @Override
    public boolean userHasModeratorRole(String username, String boardName) {
        return moderatorRepository.findByUser_UsernameAndBoard_Name(username, boardName).isPresent();
    }

    @Override
    public void delete(User currentUser, Long id) {
        Moderator moderator = moderatorRepository.getReferenceById(id);

        if (moderator.getBoard().getCreator().getId() != currentUser.getId()) {
            throw new RuntimeException("User is not board creator!");
        }

        moderatorRepository.deleteById(id);
    }

}
