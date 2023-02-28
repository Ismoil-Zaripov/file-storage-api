package com.example.file;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    String saveToSystem(MultipartFile file);
    byte[] downloadImageFromSystem(String fileName);
}
