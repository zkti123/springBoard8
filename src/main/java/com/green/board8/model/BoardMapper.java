package com.green.board8.model;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int insBoard(BoardInsDto dto);
    List<BoardVo> selBoardAll();
    BoardDetailVo selBoardById(BoardDto dto);
    int upBoard(BoardDto dto);
    int delBoard(BoardDto dto);


}
