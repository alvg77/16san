package com.ssan.api16san.mapper;

import com.ssan.api16san.controller.resources.BoardResource;
import com.ssan.api16san.entity.Board;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BoardMapper {
    BoardMapper MAPPER = Mappers.getMapper(BoardMapper.class);
    BoardResource toBoardResource(Board board);
    Board fromBoardResource(BoardResource boardResource);

    List<BoardResource> toBoardResourceList(List<Board> boardList);
}
