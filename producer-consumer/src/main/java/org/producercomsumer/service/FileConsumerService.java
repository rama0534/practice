package org.producercomsumer.service;

import jakarta.annotation.PostConstruct;
import org.producercomsumer.model.FileEntity;
import org.producercomsumer.repository.FileRepository;
import org.producercomsumer.util.FileQueueManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
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
                    System.out.println("test.." + (fileName.substring(0, fileName.lastIndexOf('.'))));
                    long id = Long.parseLong(fileName.substring(0, fileName.lastIndexOf('.')));

                    if (isStable(file)) {
                        byte[] bytes = Files.readAllBytes(file.toPath());
                        FileEntity entity = new FileEntity();
                        entity.setId(id);
                        entity.setFileName(file.getName());
                        entity.setFileType(Files.probeContentType(file.toPath()));
                        entity.setData(bytes);
                        if (repository.existById(id)) {
                            service.updateFile(id, entity);
                        } else {
                            service.uploadFile(entity);
                        }

                        file.delete();
                        System.out.println("File saved to DB and deleted: " + id);
                    } else {
                        queueManager.produce(fileName); // retry later
                        Thread.sleep(10000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }).start();
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
