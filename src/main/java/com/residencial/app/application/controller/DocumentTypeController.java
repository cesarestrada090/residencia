package com.residencial.app.application.controller;

import com.residencial.app.application.dto.DocumentTypeDTO;
import com.residencial.app.application.dto.ResultPageWrapper;
import com.residencial.app.application.service.DocumentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/document-type")
public class DocumentTypeController {

    @Autowired
    private DocumentTypeService documentTypeService;

    @GetMapping
    public ResponseEntity<ResultPageWrapper<DocumentTypeDTO>> getAllDocumentTypes(Pageable pageable) {
        return ResponseEntity.ok(documentTypeService.getAllDocumentTypes(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentTypeDTO> getDocumentTypeById(@PathVariable Integer id) {
        DocumentTypeDTO documentTypeDTO = documentTypeService.getDocumentTypeById(id);
        if (documentTypeDTO != null) {
            return ResponseEntity.ok(documentTypeDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<DocumentTypeDTO> createDocumentType(@RequestBody DocumentTypeDTO documentTypeDTO) {
        DocumentTypeDTO createdDocumentType = documentTypeService.createDocumentType(documentTypeDTO);
        return ResponseEntity.ok(createdDocumentType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocumentTypeDTO> updateDocumentType(@PathVariable Integer id, @RequestBody DocumentTypeDTO documentTypeDTO) {
        DocumentTypeDTO updatedDocumentType = documentTypeService.updateDocumentType(id, documentTypeDTO);
        if (updatedDocumentType != null) {
            return ResponseEntity.ok(updatedDocumentType);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocumentType(@PathVariable Integer id) {
        documentTypeService.deleteDocumentType(id);
        return ResponseEntity.noContent().build();
    }
}