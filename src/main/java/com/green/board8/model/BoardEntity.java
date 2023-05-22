package com.green.board8.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class BoardEntity {
    private int iboard;
    private String title;
    private String ctnt;
    private String writer;
    private String createdAt;
    private String updatedAt;

}
