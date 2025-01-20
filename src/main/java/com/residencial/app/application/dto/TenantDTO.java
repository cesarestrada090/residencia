package com.residencial.app.application.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class TenantDTO {
    private Integer id;
    private String name;
    private Integer organizationId;
    private String organizationName;
    private Boolean status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
