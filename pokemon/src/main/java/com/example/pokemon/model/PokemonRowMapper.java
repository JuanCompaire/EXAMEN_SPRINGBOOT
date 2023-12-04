package com.example.pokemon.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PokemonRowMapper implements RowMapper<Pokemon> {
    @Override
    public Pokemon mapRow(ResultSet rs, int rowNum) throws SQLException{
        Pokemon pokemon = new Pokemon();
        pokemon.setId(rs.getInt("id"));
        pokemon.setNombre(rs.getString("nombre"));
        pokemon.setRegion(rs.getInt("region"));

        return pokemon;
    }
}
