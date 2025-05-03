package org.producercomsumer.controller;

import org.producercomsumer.model.FileEntity;
import org.producercomsumer.service.FileService;
import org.producercomsumer.util.FileQueueManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/files")
public class FileController {

    @Value("${service.local}")
    private String LOCAL_PATH ;

    private final FileService service;
    private final FileQueueManager queueManager;

    public FileController(FileService service, FileQueueManager queueManager ) {
        this.service = service;
        this.queueManager = queueManager;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam MultipartFile file) {
        long id = System.currentTimeMillis() * 1000 + new Random().nextInt(1000);
        try {
            saveFileLocal(id, file);
            return ResponseEntity.ok("File Uploaded");
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Bad request" + e.getMessage());
        }
    }

    private void saveFileLocal(Long id, MultipartFile file) throws IOException {
        String name = file.getOriginalFilename();
        assert name != null;
        String ext = name.substring(name.lastIndexOf('.') ).toLowerCase();
        String fileName = id + ext;
        String targetPath = LOCAL_PATH + File.separator + id + ext;
        File dest = new File(targetPath);
        file.transferTo(dest);
        queueManager.produce(fileName);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateFile(@PathVariable Long id, @RequestParam MultipartFile file) {
        try {
            saveFileLocal(id, file);
            return ResponseEntity.ok("File Updated");
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Bad request" + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> findById(@PathVariable Long id) {
        FileEntity file = service.getFile(id);
        if(file == null) return  ResponseEntity.notFound().build();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFileName() + "\"")
                .contentType(MediaType.parseMediaType(file.getFileType()))
                .body(file.getData());
    }

    @GetMapping("/type")
    public List<FileEntity> findByType(@RequestParam String type) {
        return service.getFilesByType(type);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok("File Deleted with id: " + id);
    }
}
