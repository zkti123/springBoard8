package com.green.board8;

import com.green.board8.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name="게시판", description = "게시판 CRUD")
@RestController
@RequestMapping("/")
public class BoardController {
    private final Logger LOGGER;
    private final BoardService service;

    @Autowired
    public BoardController(BoardService service){
        LOGGER = LoggerFactory.getLogger(BoardController.class);
        this.service = service;
    }


    @PostMapping
    @Operation(summary = "글등록", description = "<h1>글 등록 할 수있습니다.</h1>"+
    "title(string) : 제목 <br> \n"+"ctnt(string) : 내용<br>\n"+"writer(string) : 작성자")
    public int postBoard(@RequestBody BoardInsDto dto){
        LOGGER.warn("경고,글 등록이 됩니다.");
            return service.insBoard(dto);
    }


    @GetMapping
    public List<BoardVo> getBoard(){
        return service.selBoardAll();
    }

    @GetMapping("/{iboard}")
    public BoardDetailVo getBoardDetail(@PathVariable int iboard){
        BoardDto dto = new BoardDto();
        dto.setIboard(iboard);
        LOGGER.info(dto.toString());
        return service.selBoardById(dto);
    }


    @PutMapping
    public int putBoard(@RequestBody BoardDto dto){
        return service.upBoard(dto);
    }

    @DeleteMapping("/{iboard}")
    public int delBoard(@PathVariable int iboard){
        BoardDto entity = new BoardDto();
        entity.setIboard(iboard);
        return service.delBoard(entity);
    }


}
