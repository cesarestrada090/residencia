package com.residencial.app.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

@Embeddable
public class AlumnoEvaluacionCursoId implements Serializable {
    private static final long serialVersionUID = 1605247810173684734L;
    @NotNull
    @Column(name = "evaluacion_curso_id", nullable = false)
    private Integer evaluacionCursoId;

    @NotNull
    @Column(name = "alumno_id", nullable = false)
    private Integer alumnoId;

    public AlumnoEvaluacionCursoId() {
    }

    public Integer getEvaluacionCursoId() {
        return evaluacionCursoId;
    }

    public void setEvaluacionCursoId(Integer evaluacionCursoId) {
        this.evaluacionCursoId = evaluacionCursoId;
    }

    public Integer getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(Integer alumnoId) {
        this.alumnoId = alumnoId;
    }
}