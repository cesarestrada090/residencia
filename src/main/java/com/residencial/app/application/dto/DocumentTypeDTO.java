package com.residencial.app.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DocumentTypeDTO {
    private Integer id;
    private String name;
    private Byte status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
