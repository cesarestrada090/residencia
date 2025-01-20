package com.residencial.app.application.controller;

import com.residencial.app.application.dto.OrganizationDTO;
import com.residencial.app.application.dto.ResultPageWrapper;
import com.residencial.app.application.dto.TenantDTO;
import com.residencial.app.application.service.TenantService;
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
@RequestMapping("/api/tenants")
public class TenantController {

    @Autowired
    private TenantService tenantService;
    
    @GetMapping
    public ResponseEntity<Map<String,Object>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Map<String, Object> response = new HashMap<>();
        try {
            Pageable paging = PageRequest.of(page-1, size);
            ResultPageWrapper<TenantDTO> resultPageWrapper = tenantService.getAllTenants(paging);
            response.put("result", resultPageWrapper.getPagesResult());
            response.put("currentPage", resultPageWrapper.getCurrentPage());
            response.put("totalItems", resultPageWrapper.getTotalItems());
            response.put("totalPages", resultPageWrapper.getTotalPages());
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TenantDTO> getTenantById(@PathVariable Integer id) {
        TenantDTO tenant = tenantService.getTenantById(id);
        if (tenant != null) {
            return ResponseEntity.ok(tenant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<TenantDTO> createTenant(@RequestBody TenantDTO tenantDTO) {
        TenantDTO createdTenant = tenantService.createTenant(tenantDTO);
        return ResponseEntity.ok(createdTenant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TenantDTO> updateTenant(@PathVariable Integer id, @RequestBody TenantDTO tenantDTO) {
        TenantDTO updatedTenant = tenantService.updateTenant(id, tenantDTO);
        if (updatedTenant != null) {
            return ResponseEntity.ok(updatedTenant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTenant(@PathVariable Integer id) {
        tenantService.deleteTenant(id);
        return ResponseEntity.noContent().build();
    }
}