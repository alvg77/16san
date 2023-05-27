package com.ssan.api16san.mapper;

import com.ssan.api16san.controller.resources.CommunityBoardResource;
import com.ssan.api16san.entity.Board;
import org.mapstruct.Mapper;

@Mapper
public interface CommunityBoardMapper {
    CommunityBoardResource toCommunityBoardResource(Board board);
    Board fromCommunityBoardResource(CommunityBoardResource communityBoardResource);
}
