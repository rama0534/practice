package org.producercomsumer.service;

import org.producercomsumer.model.FileEntity;

import java.io.IOException;
import java.util.List;

public interface FileService {
    void uploadFile(FileEntity file) throws IOException;
    FileEntity getFile(Long id);
    List<FileEntity> getFilesByType(String fileType);
    void updateFile(Long id, FileEntity file);
    void deleteById(Long id);
}
