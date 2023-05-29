package com.ssan.api16san.mapper;

import com.ssan.api16san.controller.resources.ModeratorResource;
import com.ssan.api16san.entity.Moderator;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ModeratorMapper {
    ModeratorMapper MAPPER = Mappers.getMapper(ModeratorMapper.class);


    @Mapping(target = "username", source = "user.username")
    @Mapping(target = "boardName", source = "board.name")
    ModeratorResource toModeratorResource(Moderator moderator);

    @InheritInverseConfiguration
    Moderator fromModeratorResource(ModeratorResource moderatorResource);

    List<ModeratorResource> toModeratorResourceList(List<Moderator> moderatorList);
}
