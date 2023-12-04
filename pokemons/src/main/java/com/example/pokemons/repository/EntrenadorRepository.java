package com.example.pokemons.repository;

import com.example.pokemons.model.Entrenador;
import com.example.pokemons.model.EntrenadorRowMapper;
import com.example.pokemons.model.Pokemon;
import com.example.pokemons.model.PokemonRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EntrenadorRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insert(Entrenador entrenador){
        jdbcTemplate.update("INSERT INTO ENTRENADOR ( nombre, activo) VALUES ( ?, ?);",
                entrenador.getNombre(), entrenador.getActivo());

    }

    public void update(Entrenador entrenador){
        jdbcTemplate.update("UPDATE ENTRENADOR SET nombre = ?, activo = ? WHERE id = ?;",
                entrenador.getNombre(), entrenador.getActivo(), entrenador.getId());
    }

    public void delete(Integer id){
        jdbcTemplate.update("DELETE FROM ENTRENADOR WHERE id = ?", new Object[]{id});
    }

    public List<Entrenador> findAll(){
        return jdbcTemplate.query("SELECT * FROM ENTRENADOR", new EntrenadorRowMapper());
    }

    public Entrenador findById(long id){
        return jdbcTemplate.queryForObject("SELECT * FROM ENTRENADOR WHERE id = ?",
                new EntrenadorRowMapper(), new Object[]{id});
    }

    public List<Entrenador> searchByName(String userInput){
        return jdbcTemplate.query("SELECT * FROM ENTRENADOR WHERE nombre LIKE ?",
            new EntrenadorRowMapper(),userInput);
    }

    public List<Pokemon> findPokemonsByEntrenador(Integer entrenadorId){
        String query = "SELECT * FROM POKEMON WHERE entrenador = ?";
        return jdbcTemplate.query(query, new PokemonRowMapper(), entrenadorId);
    }
}
