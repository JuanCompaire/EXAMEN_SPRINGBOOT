package com.example.pokemons.service;

import com.example.pokemons.model.Pokemon;
import com.example.pokemons.model.Region;
import com.example.pokemons.repository.PokemonRepository;
import com.example.pokemons.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {

    @Autowired
    RegionRepository regionRepository;

    @Autowired
    PokemonRepository pokemonRepository;

    public List<Region> insertRegion(Region region){
        System.out.println("id: "+ region.getId()+" nombre: " + region.getNombre());
        if(region.getId() == null){
            regionRepository.insert(region);
        }else{
            regionRepository.update(region);
        }
        List<Region> lista = regionRepository.findAll();
        for(Region r: lista){
            System.out.println("id: " + r.getId() + " nombre: " + r.getNombre());
        }
        return lista;
    }

    public Region updateRegionList(Integer id){
        Region region = regionRepository.findById(id);

        System.out.print(region.getNombre());
        return region;
    }

    public List<Region> searchRegion(String userInput){
        List<Region> lista = regionRepository.searchByName(userInput);
        for(Region r: lista){
            System.out.println("id: " + r.getId() + " nombre: " + r.getNombre());
        }
        return lista;
    }

    public Region searchById(long id){
        return regionRepository.findById(id);
    }

    public List<Region> listarTodosRegion(){
        List<Region> lista = regionRepository.findAll();
        for(Region r : lista){
            r.setPokemons(pokemonRepository.findPokemonsByRegion(r.getId()));
        }
        return lista;
    }

    public List<Region> deleteRegion(Integer id, String nombre){
        regionRepository.deleteByIdAndName(id, nombre);

        List<Region> lista = regionRepository.findAll();
        return lista;
    }


}
