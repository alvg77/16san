package com.ssan.api16san.mapper;

import com.ssan.api16san.controller.resources.BanResource;
import com.ssan.api16san.entity.Ban;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BanMapper {
    BanMapper MAPPER = Mappers.getMapper(BanMapper.class);

    @Mapping(target = "boardName", source = "board.name")
    @Mapping(target = "username", source = "user.username")
    BanResource toBanResource(Ban ban);

    @InheritInverseConfiguration
    Ban fromBanResource(BanResource banResource);

    List<BanResource> toBanResourceList(List<Ban> banList);
}
