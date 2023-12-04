package com.example.pokemons.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RegionRowMapper implements RowMapper<Region> {
    @Override
    public Region mapRow(ResultSet rs, int rowNum) throws SQLException {
        Region region = new Region();
        region.setId(rs.getInt("id"));
        region.setNombre(rs.getString("nombre"));

        return region;
    }

}
