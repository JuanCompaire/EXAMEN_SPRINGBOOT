package com.example.pokemons.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EntrenadorRowMapper implements RowMapper<Entrenador> {

    @Override
    public Entrenador mapRow(ResultSet rs, int rowNum) throws SQLException {
        Entrenador entrenador = new Entrenador();
        entrenador.setId(rs.getInt("id"));
        entrenador.setNombre(rs.getString("nombre"));
        entrenador.setActivo(rs.getBoolean("activo"));

        return entrenador;
    }
}
