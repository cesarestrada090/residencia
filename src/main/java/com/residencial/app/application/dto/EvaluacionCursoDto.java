package com.residencial.app.application.dto;


import com.residencial.app.infrastructure.entities.Usuario;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
/**
 * DTO for {@link Usuario}
 */
public class EvaluacionCursoDto implements Serializable {
    private Integer id;
    @Size(max = 145)
    private String numero_unidad;
    @Size(max = 345)
    private String linkClase;
    @Size(max = 345)
    private String linkMaterial;
    private String horario;

    public EvaluacionCursoDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero_unidad() {
        return numero_unidad;
    }

    public void setNumero_unidad(String numero_unidad) {
        this.numero_unidad = numero_unidad;
    }

    public String getLinkClase() {
        return linkClase;
    }

    public void setLinkClase(String linkClase) {
        this.linkClase = linkClase;
    }

    public String getLinkMaterial() {
        return linkMaterial;
    }

    public void setLinkMaterial(String linkMaterial) {
        this.linkMaterial = linkMaterial;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}