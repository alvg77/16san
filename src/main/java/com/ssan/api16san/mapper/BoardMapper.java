package com.ssan.api16san.mapper;

import com.ssan.api16san.controller.resources.BoardResource;
import com.ssan.api16san.entity.Board;
import com.ssan.api16san.entity.DiscussionThread;
import com.ssan.api16san.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BoardMapper {
    BoardMapper MAPPER = Mappers.getMapper(BoardMapper.class);


    @Mapping(target = "numberOfThreads", expression = "java(getNumberOfThreads(board.getThreads()))")
    @Mapping(target = "createdAt", source = "createdAt")
    BoardResource toBoardResource(Board board);
    Board fromBoardResource(BoardResource boardResource);

    default Integer getNumberOfThreads(List<DiscussionThread> threadList) {
        return threadList != null ? threadList.size() : 0;
    }

    List<BoardResource> toBoardResourceList(List<Board> boardList);
}
