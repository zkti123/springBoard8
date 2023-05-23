package com.green.board8.cmt;

import com.green.board8.board.model.BoardInsDto;
import com.green.board8.cmt.model.BoardCmtDelDto;
import com.green.board8.cmt.model.BoardCmtDto;
import com.green.board8.cmt.model.BoardCmtInsDto;
import com.green.board8.cmt.model.BoardCmtVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmtService {
    private final CmtMapper mapper;

    @Autowired
    public CmtService(CmtMapper mapper) {
        this.mapper = mapper;
    }

    public int insBoard(BoardCmtInsDto dto){
        return mapper.insBoard(dto);
    }


    public int delBoardCmt(BoardCmtDelDto dto) {
        return mapper.delBoardCmt(dto);
    }

    public List<BoardCmtVo> selBoardCmt(BoardCmtDto dto){
        return mapper.selBoardCmt(dto);
    }
}
