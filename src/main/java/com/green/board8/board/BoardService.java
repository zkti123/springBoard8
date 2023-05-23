package com.green.board8.board;

import com.green.board8.board.model.BoardDetailVo;
import com.green.board8.board.model.BoardDto;
import com.green.board8.board.model.BoardInsDto;
import com.green.board8.board.model.BoardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  //bean 등록하기위해
public class BoardService {
    private final BoardMapper mapper;

    @Autowired
    public BoardService(BoardMapper mapper) {
        this.mapper = mapper;
    }

    public int insBoard(BoardInsDto dto) {
        return mapper.insBoard(dto);
    }

    public List<BoardVo> selBoardAll(BoardDto dto){
       // final int ROW_PER_PAGE = 30;

        int startIdx = (dto.getPage() -1)*dto.getRowLen();
        dto.setStartIdx(startIdx);
        return mapper.selBoardAll(dto);
    }

    public BoardDetailVo selBoardById(BoardDto dto){
        return mapper.selBoardById(dto);
    }

    public int upBoard(BoardDto dto) {
        return mapper.upBoard(dto);
    }

    public int delBoard(BoardDto dto) {
        return mapper.delBoard(dto);
    }




}
