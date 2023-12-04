package com.example.pokemon.repository;

import com.example.pokemon.model.Pokemon;
import com.example.pokemon.model.PokemonRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PokemonRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insert(Pokemon pokemon){
        jdbcTemplate.update("INSERT INTO POKEMON (id, nombre, region) VALUES (?, ?, ?);",
                pokemon.getId(), pokemon.getNombre(), pokemon.getRegion());
    }

    public void update(Pokemon pokemon){
        jdbcTemplate.update("UPDATE POKEMON SET nombre = ?, region = ? WHERE id = ?;",
                pokemon.getNombre(), pokemon.getRegion(), pokemon.getId());
    }

    public void delete(Integer id){
        jdbcTemplate.update("DELETE FROM POKEMON WHERE id = ?", new Object[]{id});
    }

    public List<Pokemon> findAll(){
        return jdbcTemplate.query("SELECT * FROM POKEMON", new PokemonRowMapper());
    }

    public Pokemon findById(long id){
        return jdbcTemplate.queryForObject("SELECT * FROM POKEMON WHERE id = ?",
                new BeanPropertyRowMapper<Pokemon>(Pokemon.class), new Object[]{id});
    }

    public List<Pokemon> searchByName(String userInput){
        return jdbcTemplate.query("SELECT * FROM POKEMON WHERE nombre LIKE ?",
            new PokemonRowMapper(),userInput);
    }

    public List<Pokemon> findPokemonsByRegion(Integer regionId){
        String query = "SELECT * FROM POKEMON WHERE region = ?";
        return jdbcTemplate.query(query, new PokemonRowMapper(), regionId);
    }
}

