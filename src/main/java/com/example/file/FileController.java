package com.example.file;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/file")
public class FileController {
    private final FileService fileService;
    @PostMapping("/upload")
    public ResponseEntity<?> uploadImageToSystem(
            @RequestParam("image") MultipartFile request
    ){
        var response = fileService.saveToSystem(request);
        return ResponseEntity.ok(response);
    }
}
