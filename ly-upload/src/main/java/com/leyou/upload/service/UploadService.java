package com.leyou.upload.service;

import com.leyou.common.exception.ExceptionEnum;
import com.leyou.common.exception.LyException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class UploadService {

    private static final List<String> ALLOW_TYPES = Arrays.asList("image/png","image/jpeg","image/jpg");

    public String uploadImage(MultipartFile file) {

        try {
            //校验文件
            String contenType = file.getContentType();
            if (!ALLOW_TYPES.contains(contenType)){
                throw new LyException(ExceptionEnum.INVALID_FILE_TYPE);
            }
            //校验文件内容
            BufferedImage image = ImageIO.read(file.getInputStream());
            if (null == image){
                throw new LyException(ExceptionEnum.INVALID_FILE_TYPE);
            }

            //准备存储路径
            File dest = new File("E:\\ideaWorkspace\\LGworkspace\\leyou\\ly-upload\\src\\main\\resources\\static", file.getOriginalFilename());
            //文件保存到本地
            file.transferTo(dest);
            return "http://image.leyou.com/"+file.getOriginalFilename();
        } catch (IOException e) {
            throw new LyException(ExceptionEnum.UPLOAD_FILE_ERROR);
        }
    }


}
