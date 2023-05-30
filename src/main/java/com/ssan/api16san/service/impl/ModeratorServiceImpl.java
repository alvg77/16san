package com.ssan.api16san.service.impl;

import com.ssan.api16san.controller.resources.ModeratorResource;
import com.ssan.api16san.entity.Moderator;
import com.ssan.api16san.mapper.ModeratorMapper;
import com.ssan.api16san.repository.ModeratorRepository;
import com.ssan.api16san.service.ModeratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ssan.api16san.mapper.ModeratorMapper.MAPPER;

@Service
@RequiredArgsConstructor
public class ModeratorServiceImpl implements ModeratorService {
    private final ModeratorRepository moderatorRepository;

    @Override
    public ModeratorResource save(ModeratorResource moderatorResource) {
        Moderator moderator = moderatorRepository.save(
                MAPPER.fromModeratorResource(moderatorResource)
        );
        moderatorResource.setId(moderator.getId());
        return moderatorResource;
    }

    @Override
    public List<ModeratorResource> getAll() {
        return MAPPER.toModeratorResourceList(
                moderatorRepository.findAll()
        );
    }

    @Override
    public ModeratorResource get(Long id) {
        return MAPPER.toModeratorResource(
                moderatorRepository.findById(id).orElseThrow()
        );
    }

    @Override
    public void delete(Long id) {
        moderatorRepository.deleteById(id);
    }

}
