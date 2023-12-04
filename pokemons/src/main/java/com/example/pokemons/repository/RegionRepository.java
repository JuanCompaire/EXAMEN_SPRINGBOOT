package com.example.pokemons.repository;

import com.example.pokemons.model.Region;
import com.example.pokemons.model.RegionRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RegionRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insert(Region region){
        jdbcTemplate.update("INSERT INTO REGION (nombre) VALUES (?);",
                 region.getNombre());
    }

    public void update(Region region){
        jdbcTemplate.update("UPDATE REGION SET nombre = ? WHERE id = ?;",
                region.getNombre(), region.getId());
    }

    public void delete(Integer id){
        jdbcTemplate.update("DELETE FROM REGION WHERE id = ?", new Object[]{id});
    }

    public void deleteAll(){
        jdbcTemplate.update("DELETE FROM REGION");
    }

    public List<Region> findAll(){
        return jdbcTemplate.query("SELECT * FROM REGION", new RegionRowMapper());
    }

    public Region findById(long id){
        return jdbcTemplate.queryForObject("SELECT * FROM REGION WHERE id = ?",
                new RegionRowMapper(), new Object[]{id});
    }

    public List<Region> searchByName(String userInput){
        return jdbcTemplate.query("SELECT * FROM REGION WHERE nombre LIKE ?",
            new RegionRowMapper(),userInput);
    }

    public void deleteByIdAndName(Integer id, String name){
        jdbcTemplate.update("DELETE FROM REGION WHERE id = ? AND nombre = ?",id, name);
    }

}
