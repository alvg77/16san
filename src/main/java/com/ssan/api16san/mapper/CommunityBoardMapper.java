package com.ssan.api16san.mapper;

import com.ssan.api16san.controller.resources.CommunityBoardResource;
import com.ssan.api16san.entity.CommunityBoard;
import org.mapstruct.Mapper;

@Mapper
public interface CommunityBoardMapper {
    CommunityBoardResource toCommunityBoardResource(CommunityBoard communityBoard);
    CommunityBoard fromCommunityBoardResource(CommunityBoardResource communityBoardResource);
}
