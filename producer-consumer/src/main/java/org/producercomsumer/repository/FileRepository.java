package org.producercomsumer.repository;

import org.producercomsumer.model.FileEntity;

import java.util.List;
import java.util.Optional;

public interface FileRepository {
    void save(FileEntity file);
    Optional<FileEntity> findById(Long id);
    List<FileEntity> findByFileType(String fileType);
    void updateFile(FileEntity file);
    void deleteById(Long id);
    boolean existById(Long id);
}
