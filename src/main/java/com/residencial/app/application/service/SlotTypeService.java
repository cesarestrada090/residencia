package com.residencial.app.application.service;

import com.residencial.app.application.dto.SlotTypeDTO;
import com.residencial.app.application.dto.ResultPageWrapper;
import org.springframework.data.domain.Pageable;

public interface SlotTypeService {
    ResultPageWrapper<SlotTypeDTO> getAllSlotTypes(Pageable pageable);
    SlotTypeDTO getSlotTypeById(Integer id);
    SlotTypeDTO createSlotType(SlotTypeDTO slotTypeDTO);
    SlotTypeDTO updateSlotType(Integer id, SlotTypeDTO slotTypeDTO);
    void deleteSlotType(Integer id);
}