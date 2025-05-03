package org.producercomsumer.service;

import jakarta.annotation.PostConstruct;
import org.producercomsumer.model.FileEntity;
import org.producercomsumer.repository.FileRepository;
import org.producercomsumer.util.FileQueueManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Service
public class FileConsumerService {

    @Value("${service.local}")
    private String LOCAL_PATH ;

    private final FileQueueManager queueManager;
    private final FileService service;
    private final FileRepository repository;

    public FileConsumerService(FileQueueManager queueManager, FileService service, FileRepository repository) {
        this.queueManager = queueManager;
        this.service = service;
        this.repository = repository;
    }

    @PostConstruct
    public void startConsumerThread() {
        new Thread(() -> {
            while (true) {
                try {
                    String  fileName = queueManager.consume(); // Blocks until available
                    File file = new File(LOCAL_PATH + File.separator + fileName);
                    long id = Long.parseLong(fileName.substring(0, fileName.lastIndexOf('.')));
                    saveFileInDB(file, id, fileName);
                } catch (Exception e) {
                   throw new RuntimeException();
                }
            }
        }).start();
    }

    private void saveFileInDB(File file, long id, String fileName) throws IOException, InterruptedException {
        try {
            if (isStable(file)) {
                if (!file.exists()) {
                    throw new IllegalArgumentException("File not found");
                }
                byte[] bytes = Files.readAllBytes(file.toPath());
                String fileType = Files.probeContentType(file.toPath());
                if (fileType == null) fileType = "application/octet-stream";
                FileEntity entity = new FileEntity();
                entity.setId(id);
                entity.setFileName(file.getName());
                entity.setFileType(fileType);
                entity.setData(bytes);
                if (repository.existById(id)) {
                    service.updateFile(id, entity);
                } else {
                    service.uploadFile(entity);
                }
            } else {
                queueManager.produce(fileName); // retry later
                Thread.sleep(10000);
            }
        } finally {
            file.delete();
        }

    }

    private boolean isStable(File file) {
        long initialSize = file.length();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        long finalSize = file.length();
        return initialSize == finalSize;
    }
}
