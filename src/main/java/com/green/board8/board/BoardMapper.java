package com.green.board8.board;

import com.green.board8.board.model.BoardDetailVo;
import com.green.board8.board.model.BoardDto;
import com.green.board8.board.model.BoardInsDto;
import com.green.board8.board.model.BoardVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int insBoard(BoardInsDto dto);
    List<BoardVo> selBoardAll(BoardDto dto);
    BoardDetailVo selBoardById(BoardDto dto);
    int upBoard(BoardDto dto);
    int delBoard(BoardDto dto);


}
