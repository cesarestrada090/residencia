package com.residencial.app.domain.service.impl;

import com.residencial.app.application.dto.CursoDto;
import com.residencial.app.application.dto.EvaluacionCursoDto;
import com.residencial.app.infrastructure.entities.Curso;
import com.residencial.app.infrastructure.entities.EvaluacionCurso;
import com.residencial.app.infrastructure.repository.CursoRepository;
import com.residencial.app.infrastructure.repository.EvaluacionCursoRepository;
import com.residencial.app.domain.service.CursoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoServiceImpl implements CursoService {
    private final CursoRepository cursoRepository;
    private final EvaluacionCursoRepository evaluacionCursoRepository;
    private final ModelMapper mapper;
    @Autowired
    public CursoServiceImpl(final CursoRepository cursoRepository,
                            final EvaluacionCursoRepository evaluacionCursoRepository,
                            final ModelMapper mapper) {
        this.cursoRepository = cursoRepository;
        this.evaluacionCursoRepository = evaluacionCursoRepository;
        this.mapper = mapper;
    }

    @Override
    public List<CursoDto> getCursosByAlumno(Integer alumnoId) {
        List<Curso> cursos = cursoRepository.getCursosByAlumnoId(alumnoId);
        return cursos.stream().map(x ->mapper.map(x,CursoDto.class)).collect(Collectors.toList());
    }

    public List<EvaluacionCursoDto> getEvaluacionesByCursoId(Integer cursoId, Integer alumnoId){
        List<EvaluacionCurso> evaluacionCurso = evaluacionCursoRepository.findEvaluacionCursoByCursoId(cursoId,alumnoId);
        return evaluacionCurso.stream().map(x ->mapper.map(x,EvaluacionCursoDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<CursoDto> getCursos() {
        List<Curso> cursos = cursoRepository.findAll();
        return cursos.stream().map(x ->mapper.map(x,CursoDto.class)).collect(Collectors.toList());
    }

}
