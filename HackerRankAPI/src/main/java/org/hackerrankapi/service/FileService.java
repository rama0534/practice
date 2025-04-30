package org.hackerrankapi.service;

import org.hackerrankapi.model.FileEntity;
import org.hackerrankapi.repository.FileRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

@Service
public class FileService {

    @Value("${service.local}")
    private String LOCAL_PATH ;

    private final FileRepository repository;

    public FileService(FileRepository repository) {
        this.repository = repository;
    }

    @Scheduled(fixedDelay = 60000)
    public void saveFileToDatabase() {
        File folder = new File(LOCAL_PATH);
        File[] files = folder.listFiles();
        if(files == null) return;
        for (File file : files) {
            if(file.isFile()) {
                try {
                    byte[] fileBytes = Files.readAllBytes(file.toPath());
                    FileEntity fileEntity = new FileEntity();
                    long id = System.currentTimeMillis() * 1000 + new Random().nextInt(1000);
                    fileEntity.setId(id);
                    fileEntity.setFileName(file.getName());
                    fileEntity.setFileType(Files.probeContentType(file.toPath()));
                    fileEntity.setData(fileBytes);
                    repository.save(fileEntity);
                    file.delete();
                } catch (IOException e) {
                    throw new RuntimeException("Not able to save the file to Database.");
                }
            }
        }
    }

    public String saveFileInLocal(String sourcePath) throws IOException {
        try {
            File sourceFile = new File(sourcePath);
            byte[] fileBytes = Files.readAllBytes(sourceFile.toPath());

            File uploadDir = new File(LOCAL_PATH);
            if(!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String name = sourceFile.getName();
            String ext = name.substring(name.lastIndexOf('.') ).toLowerCase();
            long id = System.currentTimeMillis() * 1000 + new Random().nextInt(1000);
            String localFileName = id + ext;
            String targetPath = LOCAL_PATH + File.separator + localFileName;
            Files.write(Paths.get(targetPath), fileBytes);
            return localFileName;
        } catch (IOException e) {
            throw new RuntimeException("Not able to save the file in the local database");
        }
    }
}
