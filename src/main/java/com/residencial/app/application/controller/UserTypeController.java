package com.residencial.app.application.controller;

import com.residencial.app.application.dto.ResultPageWrapper;
import com.residencial.app.application.dto.UserTypeDTO;
import com.residencial.app.application.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user-types")
public class UserTypeController {

    @Autowired
    private UserTypeService userTypeService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Map<String, Object> response = new HashMap<>();
        try {
            Pageable paging = PageRequest.of(page - 1, size);
            ResultPageWrapper<UserTypeDTO> resultPageWrapper = userTypeService.getAllUserTypes(paging);
            response.put("result", resultPageWrapper.getPagesResult());
            response.put("currentPage", resultPageWrapper.getCurrentPage());
            response.put("totalItems", resultPageWrapper.getTotalItems());
            response.put("totalPages", resultPageWrapper.getTotalPages());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserTypeDTO> getUserTypeById(@PathVariable Integer id) {
        UserTypeDTO userType = userTypeService.getUserTypeById(id);
        if (userType != null) {
            return ResponseEntity.ok(userType);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<UserTypeDTO> createUserType(@RequestBody UserTypeDTO userTypeDTO) {
        UserTypeDTO createdUserType = userTypeService.createUserType(userTypeDTO);
        return ResponseEntity.ok(createdUserType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserTypeDTO> updateUserType(@PathVariable Integer id, @RequestBody UserTypeDTO userTypeDTO) {
        UserTypeDTO updatedUserType = userTypeService.updateUserType(id, userTypeDTO);
        if (updatedUserType != null) {
            return ResponseEntity.ok(updatedUserType);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserType(@PathVariable Integer id) {
        userTypeService.deleteUserType(id);
        return ResponseEntity.noContent().build();
    }
}