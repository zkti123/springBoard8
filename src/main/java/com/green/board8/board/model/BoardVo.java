package com.green.board8.board.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BoardVo {
    private int iboard;
    private String title;
    private String writer;
    private String createdAt;
}
