package com.residencial.app.application.mapper;

import com.residencial.app.application.dto.DocumentTypeDTO;
import com.residencial.app.domain.entities.DocumentType;
import com.residencial.app.infrastructure.mapper.MapperUtil;
import org.springframework.stereotype.Component;

@Component
public class DocumentTypeMapper  {
    public DocumentTypeDTO toDTO(DocumentType documentType) {
        return MapperUtil.map(documentType, DocumentTypeDTO.class);
    }
    public DocumentType toEntity(DocumentTypeDTO documentTypeDTO) {
        return MapperUtil.map(documentTypeDTO, DocumentType.class);
    }
}