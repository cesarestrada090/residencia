package com.residencial.app.infrastructure.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "alumno_evaluacion_curso")
public class AlumnoEvaluacionCurso {
    @EmbeddedId
    private AlumnoEvaluacionCursoId id;

    @MapsId("alumnoId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "alumno_id", nullable = false)
    private Alumno alumno;

    @MapsId("evaluacionCursoId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "evaluacion_curso_id", nullable = false)
    private EvaluacionCurso evaluacionCurso;

    @Column(name = "fecha_matricula")
    private LocalDate fechaMatricula;


    @Column(name = "activo")
    Integer activo;

    public AlumnoEvaluacionCurso() {
    }

    public AlumnoEvaluacionCursoId getId() {
        return id;
    }

    public void setId(AlumnoEvaluacionCursoId id) {
        this.id = id;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public EvaluacionCurso getEvaluacionCurso() {
        return evaluacionCurso;
    }

    public void setEvaluacionCurso(EvaluacionCurso evaluacionCurso) {
        this.evaluacionCurso = evaluacionCurso;
    }

    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }

    public LocalDate getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(LocalDate fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }
}