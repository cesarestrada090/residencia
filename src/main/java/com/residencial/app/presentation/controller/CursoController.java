package com.residencial.app.presentation.controller;
import com.residencial.app.application.dto.CursoDto;
import com.residencial.app.application.dto.EvaluacionCursoDto;
import com.residencial.app.domain.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/app")
public class CursoController {
    private final CursoService cursoService;
    private static final Logger log = Logger.getLogger(CursoController.class.getName());
    @Autowired
    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping(value="cursosPorAlumnoId")
    public ResponseEntity<List<CursoDto>> getAll(
            @RequestParam(name = "alumnoId") int alumnoId){
        List<CursoDto> cursoDtos;
        try {
           cursoDtos = cursoService.getCursosByAlumno(alumnoId);
        } catch (Exception e){
            log.info("Excepcion en: "+e.getMessage());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(cursoDtos, HttpStatus.OK);
    }

    @GetMapping(value="evaluacionCurso/{cursoId}/{alumnoId}")
    public ResponseEntity<List<EvaluacionCursoDto>> getAllBy(
            @PathVariable(value = "cursoId") int cursoId, @PathVariable(value = "alumnoId") int alumnoId){
        List<EvaluacionCursoDto> evaluacionCursoDtos;
        try {
            evaluacionCursoDtos = cursoService.getEvaluacionesByCursoId(cursoId,alumnoId);
        } catch (Exception e){
            log.info("Excepcion en: "+e.getMessage());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(evaluacionCursoDtos, HttpStatus.OK);
    }

    @GetMapping(value="curso")
    public ResponseEntity<List<CursoDto>> getAll(){
        try {
            List<CursoDto> cursoDtoList = cursoService.getCursos();
            return ResponseEntity.ok(cursoDtoList);
        } catch (Exception e){
            log.info("Exception en: "+e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
