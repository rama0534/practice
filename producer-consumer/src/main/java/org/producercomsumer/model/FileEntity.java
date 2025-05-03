package org.producercomsumer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("files")
public class FileEntity {
    @Id
    private Long id;
    private String fileName;
    private String fileType;
    private byte[] data;
}
