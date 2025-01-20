package com.residencial.app.application.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserTenantDTO {
    private Integer id;
    private Integer userId;
    private Integer tenantId;
}