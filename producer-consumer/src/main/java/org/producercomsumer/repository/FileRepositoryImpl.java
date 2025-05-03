package org.producercomsumer.repository;

import org.producercomsumer.model.FileEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FileRepositoryImpl implements FileRepository {

    public final JdbcTemplate jdbcTemplate;

    public FileRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<FileEntity> fileMapper = (rs, rowNum) -> new FileEntity(
            rs.getLong("id"),
            rs.getString("filename"),
            rs.getString("filetype"),
            rs.getBytes("data")
    );

    @Override
    public void save(FileEntity file) {
        String sql = "INSERT INTO files (id, fileName, fileType, data) VALUES(?, ?, ?, ?)";
        jdbcTemplate.update(sql, file.getId(), file.getFileName(), file.getFileType(), file.getData());
    }

    @Override
    public Optional<FileEntity> findById(Long id) {
        String sql = "SELECT * FROM files WHERE id = ?";
        List<FileEntity> result = jdbcTemplate.query(sql, fileMapper, id);
        return result.stream().findFirst();
    }

    @Override
    public List<FileEntity> findByFileType(String fileType) {
         String sql = "SELECT * FROM files WHERE fileType = ?";
         return jdbcTemplate.query(sql, fileMapper, fileType);
    }

    @Override
    public void updateFile(FileEntity fileDetails) {
        String sql = "UPDATE files SET fileName = ?, fileType = ?, data = ? WHERE id = ?";
        jdbcTemplate.update(sql,fileDetails.getFileName(), fileDetails.getFileType(), fileDetails.getData(), fileDetails.getId());
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM files WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public boolean existById(Long id) {
        String sql = "SELECT EXISTS (SELECT 1 FROM files WHERE id = ?)";
        try {
            Boolean exists = jdbcTemplate.queryForObject(sql, Boolean.class, id);
            return Boolean.TRUE.equals(exists);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
