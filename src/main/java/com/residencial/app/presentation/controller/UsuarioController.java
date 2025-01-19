package com.residencial.app.presentation.controller;

import com.residencial.app.application.dto.ResultPageWrapper;
import com.residencial.app.application.dto.UsuarioDto;
import com.residencial.app.domain.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping("/app")
public class UsuarioController {
    private final UsuarioService usuarioService;
    private static final Logger log = Logger.getLogger(UsuarioController.class.getName());
    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @RequestMapping(value="usuario/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
    public ResponseEntity<UsuarioDto> authenticate(@Valid @RequestBody UsuarioDto usuarioDto){
        try {
            log.info("Request: " + usuarioDto);
            usuarioDto = usuarioService.getUserByUserAndPassword(usuarioDto);
        } catch (Exception e){
            return new ResponseEntity<>(usuarioDto, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(usuarioDto, HttpStatus.OK);
    }

    @RequestMapping(value="usuario/{id}", method = RequestMethod.GET, consumes = {"*/*"}, produces = "application/json")
    public ResponseEntity<UsuarioDto> getUsuarioById(@PathVariable(value = "id") Integer id){
        UsuarioDto usuarioDto = null;
        try {
            log.info("Request by id: " + id);
            usuarioDto = usuarioService.getUserById(id);
        } catch (Exception e){
            return new ResponseEntity<>(usuarioDto, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(usuarioDto, HttpStatus.OK);
    }
    @RequestMapping(value="usuario", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
    public ResponseEntity<UsuarioDto> save(@Valid @RequestBody UsuarioDto usuarioDto){
        try {
            log.info("Request: " + usuarioDto);
            usuarioDto = usuarioService.save(usuarioDto);
        } catch (Exception e){
            return new ResponseEntity<>(usuarioDto, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(usuarioDto, HttpStatus.CREATED);
    }

    @PutMapping(value="usuario/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> update(@PathVariable(value = "id") int id, @Valid @RequestBody UsuarioDto usuarioDto){
        try {
            usuarioService.update(id, usuarioDto);
        } catch (IllegalArgumentException e){
            log.info("Excepcion en: "+e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value="usuario")
    public ResponseEntity<Map<String,Object>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "20") int size){
        Map<String, Object> response = new HashMap<>();
        try {
            Pageable paging = PageRequest.of(page-1, size);
            ResultPageWrapper<UsuarioDto> resultPageWrapper = usuarioService.getAll(paging);
            response.put("usuarios", resultPageWrapper.getPagesResult());
            response.put("currentPage", resultPageWrapper.getCurrentPage());
            response.put("totalItems", resultPageWrapper.getTotalItems());
            response.put("totalPages", resultPageWrapper.getTotalPages());
        } catch (Exception e){
            log.info("Excepcion en: "+e.getMessage());
return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
