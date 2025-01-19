package com.residencial.app.infrastructure.repository;

import com.residencial.app.infrastructure.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
    @Query("SELECT DISTINCT c from Curso c JOIN EvaluacionCurso ec ON ec.curso = c.id " +
            "JOIN AlumnoEvaluacionCurso aec on aec.evaluacionCurso = ec.id JOIN Alumno a ON aec.alumno = a.id WHERE a.id = :alumnoId")
    List<Curso> getCursosByAlumnoId(Integer alumnoId);
}