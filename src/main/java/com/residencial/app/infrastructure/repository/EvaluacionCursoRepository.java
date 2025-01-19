package com.residencial.app.infrastructure.repository;

import com.residencial.app.infrastructure.entities.AlumnoEvaluacionCurso;
import com.residencial.app.infrastructure.entities.EvaluacionCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EvaluacionCursoRepository extends JpaRepository<AlumnoEvaluacionCurso, Integer> {
    @Query(value = "select ec from AlumnoEvaluacionCurso aec join "+
    "EvaluacionCurso ec on aec.evaluacionCurso = ec.id where ec.curso.id = :cursoId and aec.alumno.id = :alumnoId")
    List<EvaluacionCurso> findEvaluacionCursoByCursoId(Integer cursoId, Integer alumnoId);
}