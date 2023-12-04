package com.example.pokemon.model;


import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Getter

public class Region {
    private Integer id;
    private String nombre;

    private List<Pokemon> pokemons;


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

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
}
