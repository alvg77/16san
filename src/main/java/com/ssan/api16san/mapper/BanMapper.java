package com.ssan.api16san.mapper;

import com.ssan.api16san.controller.resources.BanResource;
import com.ssan.api16san.entity.Ban;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface BanMapper {
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "boardId", source = "board.id")
    BanResource toBanResource(Ban ban);

    @InheritInverseConfiguration
    Ban fromBanResource(BanResource banResource);
}
