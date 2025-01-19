package com.residencial.app.infrastructure.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "evaluacion_curso")
public class EvaluacionCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name =  "curso_id")
    private Curso curso;

    @Size(max = 45)
    @Column(name = "numero_unidad", length = 45)
    private String numero_unidad;

    @Size(max = 245)
    @Column(name = "horario", length = 45)
    private String horario;

    @Size(max = 245)
    @Column(name = "link_material", length = 45)
    private String linkMaterial;

    @Size(max = 245)
    @Column(name = "link_clase", length = 45)
    private String linkClase;

    public EvaluacionCurso() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getNumero_unidad() {
        return numero_unidad;
    }

    public void setNumero_unidad(String numero_unidad) {
        this.numero_unidad = numero_unidad;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getLinkMaterial() {
        return linkMaterial;
    }

    public void setLinkMaterial(String linkMaterial) {
        this.linkMaterial = linkMaterial;
    }

    public String getLinkClase() {
        return linkClase;
    }

    public void setLinkClase(String linkClase) {
        this.linkClase = linkClase;
    }
}