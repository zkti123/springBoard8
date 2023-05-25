package com.green.board8.fileupload;

import com.green.board8.fileupload.model.FileEntity;
import com.green.board8.fileupload.model.FileLoadDto;
import com.green.board8.fileupload.model.FileuploadInsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.UUID;

@Service
public class FileUpLoadService{
    private final FileuploadMapper mapper;

    @Value("${file.dir}")
    private String fileDir;

    @Autowired
    public FileUpLoadService(FileuploadMapper mapper) {
        this.mapper = mapper;
    }

    public Resource fileLoad(FileLoadDto dto) {
        FileEntity entity = mapper.selFileById(dto);
        try {
            File file = new File(fileDir + entity.getPath());
            Resource resource = new UrlResource(file.toURI());
            if(resource.exists()) {
                return resource;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }



    public void fileUpload(FileuploadInsDto dto, MultipartFile img) {
        System.out.println("file : " + fileDir);

        //원래 파일 이름 추출
        String originFileName = img.getOriginalFilename();

        //파일 이름으로 사용할 uuid 생성
        String uuid = UUID.randomUUID().toString();

        int dotIdx = originFileName.lastIndexOf(".");
        String ext =  originFileName.substring(dotIdx);

        String svaedFileName = uuid + ext;
        String savedFilePath = fileDir + svaedFileName;

        File file = new File(savedFilePath);
        try {
            img.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileEntity entity= FileEntity.builder().path(svaedFileName)
                            .uploader(dto.getUploader())
                            .levelValue(dto.getLevelValue())
                            .build();
         mapper.insFile(entity);
    }

}






