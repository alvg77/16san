package com.ssan.api16san.mapper;

import com.ssan.api16san.controller.resources.BoardResource;
import com.ssan.api16san.entity.Board;
import com.ssan.api16san.entity.DiscussionThread;
import com.ssan.api16san.entity.User;
import com.ssan.api16san.repository.PostRepository;
import jdk.jfr.Name;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface BoardMapper {
    BoardMapper MAPPER = Mappers.getMapper(BoardMapper.class);


    @Mapping(target = "numberOfThreads", expression = "java(getNumberOfThreads(board.getThreads()))")
    @Mapping(target = "numberOfUsers", expression = "java(getNumberOfUsers(board.getUsers()))")
    @Mapping(target = "createdAt", source = "createdAt")
    BoardResource toBoardResource(Board board);
    Board fromBoardResource(BoardResource boardResource);

    default Integer getNumberOfThreads(List<DiscussionThread> threadList) {
        return threadList.size();
    }

    default Integer getNumberOfUsers(List<User> userList) {
        return userList.size();
    }

    List<BoardResource> toBoardResourceList(List<Board> boardList);
}
