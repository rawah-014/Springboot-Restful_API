package com.bezkoder.springjwt.services;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Optional;
import java.util.UUID;

import java.nio.file.Path;
import java.nio.file.Paths;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.bezkoder.springjwt.models.Image;
import com.bezkoder.springjwt.repository.ImageRepository;

@Service
public class ImageService {

    @Value("${app.upload.dir:${user.home}}")
    public String uploadDir;

    @Autowired
    private ImageRepository imageRepository;

    public Image saveImage(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String fileType = file.getContentType();
        String uploadPath = getUploadPath();
        File directory = new File(uploadPath);
        if (!directory.exists()) {
            directory.mkdir();
        }
        String fileExtension = getFileExtension(fileName);
        String newFileName = UUID.randomUUID().toString() + fileExtension;
        Path filePath = Paths.get(uploadPath + newFileName);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        Image image = new Image();
        image.setName(fileName);
        image.setContentType(fileType);
        image.setPath(newFileName);
        return imageRepository.save(image);
    }

    public Optional<Image> getImageById(Long id) {
        return imageRepository.findById(id);
    }

    public void deleteImage(Image image) {
        String uploadPath = getUploadPath();
        File file = new File(uploadPath + image.getPath());
        if (file.exists()) {
            file.delete();
        }
        imageRepository.delete(image);
    }

    public String getUploadPath() {
        return uploadDir + "/uploads/";
    }

    private String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex > 0 && dotIndex < fileName.length() - 1) {
            return "." + fileName.substring(dotIndex + 1);
        }
        return "";
    }
}

