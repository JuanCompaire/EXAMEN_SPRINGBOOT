package com.example.pokemon.controller;

import com.example.pokemon.model.Pokemon;
import com.example.pokemon.model.Region;
import com.example.pokemon.service.PokemonService;
import com.example.pokemon.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HelloController {

    @Autowired
    PokemonService pokemonService;

    @Autowired
    RegionService regionService;

    @RequestMapping("/")
    public String index(Model model){
        cargarListas(model);
        return "index";
    }

    @RequestMapping("/finRegion")
    public String finRegion(Model model){
        cargarListas(model);
        return "finRegion";
    }

    @RequestMapping("/finPokemon")
    public String finPokemon(Model model){
        cargarListas(model);
        return "finPokemon";
    }

    private void cargarListas(Model model){
        List<Pokemon> listaPokemons = pokemonService.listarTodosPokemon();
        model.addAttribute("pokemons", listaPokemons);
        List<Region> listaRegiones = regionService.listarTodosRegion();
        model.addAttribute("regiones", listaRegiones);
    }
}
