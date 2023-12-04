package com.example.pokemon.model;

import lombok.Data;
import lombok.Getter;

@Getter
@Data

public class Pokemon {
    private Integer id;
    private String nombre;
    private Integer region;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getRegion() {
        return region;
    }

    public void setRegion(Integer region) {
        this.region = region;
    }
}
