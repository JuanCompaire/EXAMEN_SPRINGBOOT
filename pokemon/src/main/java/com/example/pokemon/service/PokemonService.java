package com.example.pokemon.service;

import com.example.pokemon.model.Pokemon;
import com.example.pokemon.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {

    @Autowired
    PokemonRepository pokemonRepository;

    public List<Pokemon> insertPokemon(Pokemon pokemon) {
        System.out.println("nombre: " + pokemon.getNombre() + " region: " + pokemon.getRegion());
        ;
        if (pokemon.getId() == null) {
            pokemonRepository.insert(pokemon);
        } else {
            pokemonRepository.update(pokemon);
        }
        List<Pokemon> lista = pokemonRepository.findAll();
        for (Pokemon p : lista) {
            System.out.println("id: " + p.getId() + " nombre: " + p.getNombre() + " region: " + p.getRegion());
        }
        return lista;
    }

    public Pokemon updatePokemonList(Integer id) {
        Pokemon pok = pokemonRepository.findById(id);

        System.out.print(pok.getNombre() + " , " + pok.getRegion());
        return pok;
    }

    public List<Pokemon> deletePokemon(Integer id) {
        pokemonRepository.delete(id);

        List<Pokemon> lista = pokemonRepository.findAll();
        return lista;
    }

    public List<Pokemon> searchPokemon(String userInput) {
        List<Pokemon> lista = pokemonRepository.searchByName(userInput);
        for (Pokemon p : lista) {
            System.out.println("id: " + p.getId() + " nombre: " + p.getNombre() + " region: " + p.getRegion());
        }
        return lista;
    }

    public Pokemon searchById(long id) {
        return pokemonRepository.findById(id);
    }

    public List<Pokemon> listarTodosPokemon() {
        List<Pokemon> lista = pokemonRepository.findAll();

        return lista;
    }


}
