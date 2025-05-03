package org.producercomsumer.service;

import org.producercomsumer.exception.FileNotFoundException;
import org.producercomsumer.model.FileEntity;
import org.producercomsumer.repository.FileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    public final FileRepository fileRepository;

    public FileServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public void uploadFile(FileEntity file) {
        if (fileRepository.findById(file.getId()).isEmpty()) {
            throw new FileNotFoundException(file.getId());
        }
        FileEntity entity = new FileEntity(
                file.getId(),
                file.getFileName(),
                file.getFileType(),
                file.getData()
        );
        fileRepository.save(entity);
    }

    @Override
    public FileEntity getFile(Long id) {
        return fileRepository.findById(id)
                .orElseThrow(() -> new FileNotFoundException(id));
    }

    @Override
    public List<FileEntity> getFilesByType(String fileType) {
        return fileRepository.findByFileType(fileType);
    }

    @Override
    public void updateFile(Long id, FileEntity file) {
//        if (fileRepository.findById(id).isEmpty()) {
//            throw new FileNotFoundException(id);
//        }
        if(fileRepository.existById(id)) {
            fileRepository.updateFile(file);
        } else {
            throw new FileNotFoundException(id);
        }

    }

    @Override
    public void deleteById(Long id) {
        if(fileRepository.existById(id)) {
            fileRepository.deleteById(id);
        } else {
            throw new FileNotFoundException(id);
        }
    }
}
