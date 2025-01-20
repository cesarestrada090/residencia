package com.residencial.app.application.service.impl;

import com.residencial.app.application.dto.SlotTypeDTO;
import com.residencial.app.application.dto.ResultPageWrapper;
import com.residencial.app.application.mapper.SlotTypeMapper;
import com.residencial.app.application.service.SlotTypeService;
import com.residencial.app.domain.entities.SlotType;
import com.residencial.app.domain.repository.SlotTypeRepository;
import com.residencial.app.infrastructure.pagination.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SlotTypeServiceImpl implements SlotTypeService {

    @Autowired
    private SlotTypeRepository slotTypeRepository;

    @Autowired
    private SlotTypeMapper slotTypeMapper;

    @Override
    public ResultPageWrapper<SlotTypeDTO> getAllSlotTypes(Pageable pageable) {
        Page<SlotType> documentTypeList = slotTypeRepository.findAll(pageable);
        return PaginationUtil.prepareResultWrapper(documentTypeList, SlotTypeDTO.class);
    }

    @Override
    public SlotTypeDTO getSlotTypeById(Integer id) {
        return slotTypeRepository.findById(id)
                .map(slotTypeMapper::toDTO)
                .orElse(null);
    }

    @Override
    public SlotTypeDTO createSlotType(SlotTypeDTO slotTypeDTO) {
        SlotType documentType = slotTypeMapper.toEntity(slotTypeDTO);
        return slotTypeMapper.toDTO(slotTypeRepository.save(documentType));
    }

    @Override
    public SlotTypeDTO updateSlotType(Integer id, SlotTypeDTO slotTypeDTO) {
        if (slotTypeRepository.existsById(id)) {
            SlotType documentType = slotTypeMapper.toEntity(slotTypeDTO);
            documentType.setId(id);
            return slotTypeMapper.toDTO(slotTypeRepository.save(documentType));
        }
        return null;
    }

    @Override
    public void deleteSlotType(Integer id) {
        slotTypeRepository.deleteById(id);
    }
}