package com.green.board8.fileupload;

import com.green.board8.fileupload.model.FileLoadDto;
import com.green.board8.fileupload.model.FileuploadInsDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/fileupload")
public class FileUpLoadController {
    private Logger LOGGER;
    private final FileUpLoadService service;

    @Autowired
    public FileUpLoadController(FileUpLoadService service) {
        LOGGER = LoggerFactory.getLogger(FileUpLoadController.class);
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Resource> download(FileLoadDto dto) {
        Resource file = service.fileLoad(dto);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }



    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public void fileupLoad(@RequestPart FileuploadInsDto dto, @RequestPart MultipartFile img){
        LOGGER.info("dto : "+ dto);
        LOGGER.info("imgFileName :"+img.getOriginalFilename());
      service.fileUpload(dto,img);
        }
    //consumes  적으면 @RequestPart 무조건 적는다.



}
