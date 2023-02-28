package com.example.file;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {
    private final FileRepository fileRepository;
    @Value("${files.folder.path}")
    private String filesFolderPath;
    @Override
    public String saveToSystem(MultipartFile fileRequest) {
        String filePath = filesFolderPath + fileRequest.getOriginalFilename();
        var file = FileEntity.builder()
                .name(fileRequest.getOriginalFilename())
                .type(fileRequest.getContentType())
                .path(filePath)
                .createdDate(LocalDateTime.now())
                .build();

        fileRepository.save(file);

        try {
            fileRequest.transferTo(new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (file != null) return "File successfully uploaded : " + filePath;
        return null;
    }

    @Override
    public byte[] downloadImageFromSystem(String fileName) {
        var file = fileRepository.findByName(fileName);

        byte[] bytes;
        try {
            bytes = Files.readAllBytes(new File(file.getPath()).toPath());
        } catch (IOException e) {
            return null;
        }

        return bytes;
    }
}
