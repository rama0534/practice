package org.hackerrankapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "files")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileEntity {
    @Id
    private Long id;
    @Column(name = "filename")
    private String fileName;
    @Column(name = "filetype")
    private String fileType;
    @Column(name = "data", columnDefinition="bytea")
    private byte[] data;
}
