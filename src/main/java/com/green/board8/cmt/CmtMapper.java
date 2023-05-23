package com.green.board8.cmt;

import com.green.board8.board.model.BoardInsDto;
import com.green.board8.board.model.BoardVo;
import com.green.board8.cmt.model.BoardCmtDelDto;
import com.green.board8.cmt.model.BoardCmtDto;
import com.green.board8.cmt.model.BoardCmtInsDto;
import com.green.board8.cmt.model.BoardCmtVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CmtMapper {
    int insBoard(BoardCmtInsDto dto);
    int delBoardCmt(BoardCmtDelDto dto);
    List<BoardCmtVo> selBoardCmt(BoardCmtDto dto);
}
