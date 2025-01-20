package com.residencial.app.application.service;

import com.residencial.app.application.dto.DocumentTypeDTO;
import com.residencial.app.application.dto.ResultPageWrapper;
import org.springframework.data.domain.Pageable;

public interface DocumentTypeService {
    ResultPageWrapper<DocumentTypeDTO> getAllDocumentTypes(Pageable pageable);
    DocumentTypeDTO getDocumentTypeById(Integer id);
    DocumentTypeDTO createDocumentType(DocumentTypeDTO documentTypeDTO);
    DocumentTypeDTO updateDocumentType(Integer id, DocumentTypeDTO documentTypeDTO);
    void deleteDocumentType(Integer id);
}