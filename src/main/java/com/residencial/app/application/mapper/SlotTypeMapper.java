package com.residencial.app.application.mapper;

import com.residencial.app.application.dto.SlotTypeDTO;
import com.residencial.app.domain.entities.SlotType;
import com.residencial.app.infrastructure.mapper.MapperUtil;
import org.springframework.stereotype.Component;

@Component
public class SlotTypeMapper {
    public SlotTypeDTO toDTO(SlotType slotType) {
        return MapperUtil.map(slotType, SlotTypeDTO.class);
    }
    public SlotType toEntity(SlotTypeDTO slotTypeDTO) {
        return MapperUtil.map(slotTypeDTO, SlotType.class);
    }
}