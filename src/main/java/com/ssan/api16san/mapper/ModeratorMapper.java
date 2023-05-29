package com.ssan.api16san.mapper;

import com.ssan.api16san.controller.resources.ModeratorResource;
import com.ssan.api16san.entity.Moderator;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ModeratorMapper {
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "boardId", source = "board.id")
    ModeratorResource toModeratorResource(Moderator moderator);

    @InheritInverseConfiguration
    Moderator fromModeratorResource(ModeratorResource moderatorResource);
}
