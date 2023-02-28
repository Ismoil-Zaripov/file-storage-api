package com.example.file;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/download")
    public ResponseEntity<?> downloadImageFromSystem(
            @RequestParam String fileName
    ){
        var response = fileService.downloadImageFromSystem(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(response);
    }
}
