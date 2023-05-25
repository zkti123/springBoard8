package com.green.board8.fileupload.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Builder
@Getter
public class FileEntity {
    private int ifile;
    private String path;
    private String uploader;
    private int levelValue;
}
