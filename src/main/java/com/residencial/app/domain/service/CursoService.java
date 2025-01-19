package com.residencial.app.domain.service;


import com.residencial.app.application.dto.CursoDto;
import com.residencial.app.application.dto.EvaluacionCursoDto;

import java.util.List;

public interface CursoService {
    List<CursoDto> getCursosByAlumno(Integer alumnoId);

    List<EvaluacionCursoDto> getEvaluacionesByCursoId(Integer cursoId, Integer alumnoId);

    List<CursoDto> getCursos();
}
