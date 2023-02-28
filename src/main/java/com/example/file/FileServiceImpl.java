package com.example.file;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {
    @Override
    public String saveToSystem(MultipartFile file) {
        return null;
    }

    @Override
    public byte[] downloadImageFromSystem(String fileName) {
        return new byte[0];
    }
}
