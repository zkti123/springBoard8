package com.green.board8.cmt;

import com.green.board8.board.model.BoardInsDto;
import com.green.board8.cmt.model.BoardCmtDelDto;
import com.green.board8.cmt.model.BoardCmtDto;
import com.green.board8.cmt.model.BoardCmtInsDto;
import com.green.board8.cmt.model.BoardCmtVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class CmtController {
    private final CmtService service;

    @Autowired
    public CmtController(CmtService service) {
        this.service = service;
    }
    @PostMapping("/cmt")
    public int postBoard(@RequestBody BoardCmtInsDto dto){
        return service.insBoard(dto);
    }

    @GetMapping("/{iboard}/cmt")
    public List<BoardCmtVo> getBoardCmt(@PathVariable int iboard){
        BoardCmtDto dto =new BoardCmtDto();
        dto.setIboard(iboard);
        return service.selBoardCmt(dto);
    }



    @DeleteMapping("/cmt")
    public int deleteBoardCmt(BoardCmtDelDto dto){
        return service.delBoardCmt(dto);
    }


}
