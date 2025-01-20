package com.residencial.app.application.service.impl;

import com.residencial.app.application.dto.DocumentTypeDTO;
import com.residencial.app.application.dto.ResultPageWrapper;
import com.residencial.app.application.mapper.DocumentTypeMapper;
import com.residencial.app.application.service.DocumentTypeService;
import com.residencial.app.domain.entities.DocumentType;
import com.residencial.app.domain.repository.DocumentTypeRepository;
import com.residencial.app.infrastructure.pagination.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DocumentTypeServiceImpl implements DocumentTypeService {

    @Autowired
    private DocumentTypeRepository documentTypeRepository;

    @Autowired
    private DocumentTypeMapper documentTypeMapper;

    @Override
    public ResultPageWrapper<DocumentTypeDTO> getAllDocumentTypes(Pageable pageable) {
        Page<DocumentType> documentTypeList = documentTypeRepository.findAll(pageable);
        return PaginationUtil.prepareResultWrapper(documentTypeList, DocumentTypeDTO.class);
    }

    @Override
    public DocumentTypeDTO getDocumentTypeById(Integer id) {
        return documentTypeRepository.findById(id)
                .map(documentTypeMapper::toDTO)
                .orElse(null);
    }

    @Override
    public DocumentTypeDTO createDocumentType(DocumentTypeDTO documentTypeDTO) {
        DocumentType documentType = documentTypeMapper.toEntity(documentTypeDTO);
        return documentTypeMapper.toDTO(documentTypeRepository.save(documentType));
    }

    @Override
    public DocumentTypeDTO updateDocumentType(Integer id, DocumentTypeDTO documentTypeDTO) {
        if (documentTypeRepository.existsById(id)) {
            DocumentType documentType = documentTypeMapper.toEntity(documentTypeDTO);
            documentType.setId(id);
            return documentTypeMapper.toDTO(documentTypeRepository.save(documentType));
        }
        return null;
    }

    @Override
    public void deleteDocumentType(Integer id) {
        documentTypeRepository.deleteById(id);
    }
}