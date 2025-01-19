package com.residencial.app.infrastructure.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 45)
    @Column(name = "codigo_curso", length = 45)
    private String codigo_curso;

    @Size(max = 45)
    @Column(name = "nombre_curso", length = 45)
    private String nombre_curso;

    @Size(max = 45)
    @Column(name = "ciclo", length = 45)
    private String ciclo;

    @Size(max = 145)
    @Column(name = "universidad", length = 145)
    private String universidad;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name =  "docente_id")
    private Docente docente;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo_curso() {
        return codigo_curso;
    }

    public void setCodigo_curso(String codigo_curso) {
        this.codigo_curso = codigo_curso;
    }

    public String getNombre_curso() {
        return nombre_curso;
    }

    public void setNombre_curso(String nombre_curso) {
        this.nombre_curso = nombre_curso;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }
}