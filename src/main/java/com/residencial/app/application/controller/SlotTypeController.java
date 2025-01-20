package com.residencial.app.application.controller;

import com.residencial.app.application.dto.SlotTypeDTO;
import com.residencial.app.application.dto.ResultPageWrapper;
import com.residencial.app.application.service.SlotTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/slot-type")
public class SlotTypeController {

    @Autowired
    private SlotTypeService slotTypeService;

    @GetMapping
    public ResponseEntity<ResultPageWrapper<SlotTypeDTO>> getAllSlotTypes(Pageable pageable) {
        return ResponseEntity.ok(slotTypeService.getAllSlotTypes(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SlotTypeDTO> getSlotTypeById(@PathVariable Integer id) {
        SlotTypeDTO documentTypeDTO = slotTypeService.getSlotTypeById(id);
        if (documentTypeDTO != null) {
            return ResponseEntity.ok(documentTypeDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<SlotTypeDTO> createSlotType(@RequestBody SlotTypeDTO documentTypeDTO) {
        SlotTypeDTO createdSlotType = slotTypeService.createSlotType(documentTypeDTO);
        return ResponseEntity.ok(createdSlotType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SlotTypeDTO> updateSlotType(@PathVariable Integer id, @RequestBody SlotTypeDTO documentTypeDTO) {
        SlotTypeDTO updatedSlotType = slotTypeService.updateSlotType(id, documentTypeDTO);
        if (updatedSlotType != null) {
            return ResponseEntity.ok(updatedSlotType);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSlotType(@PathVariable Integer id) {
        slotTypeService.deleteSlotType(id);
        return ResponseEntity.noContent().build();
    }
}