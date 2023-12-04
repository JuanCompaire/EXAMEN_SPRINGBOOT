package com.example.pokemons.controller;

import com.example.pokemons.model.Pokemon;
import com.example.pokemons.service.PokemonService;
import com.example.pokemons.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PokemonController {

    @Autowired
    PokemonService service;

    @Autowired
    RegionService regionService;

    @RequestMapping("/formPokemon")
    public String formPokemon(Model model){
        model.addAttribute("pokemon", new Pokemon());
        model.addAttribute("regiones", regionService.listarTodosRegion());
        return "formPokemon";
    }

    @RequestMapping("/insertPokemon")
    public String insertarPokemon(@ModelAttribute("pokemon")Pokemon pokemon, BindingResult result, Model model){
        List<Pokemon> lista = service.insertPokemon(pokemon);

        model.addAttribute("pokemons", lista);
        return "finPokemon";
    }

    @RequestMapping("/updatePokemon/{id}")
    public String actualizarPokemon(@PathVariable Integer id,Model model){
        Pokemon pok = service.updatePokemonList(id);

        model.addAttribute("pokemon", pok);
        return "index";
    }

    @RequestMapping("/deletePokemon/{id}")
    public String borrarPokemon(@PathVariable Integer id, Model model){
        List<Pokemon> lista = service.deletePokemon(id);

        model.addAttribute("pokemons", lista);
        return "finPokemon";
    }

    @RequestMapping("/searchPokemon")
    public String buscarPokemon(@RequestParam("search") String userInput, Model model){
        List<Pokemon> lista = service.searchPokemon(userInput);

        model.addAttribute("pokemons", lista);
        return "finPokemon";
    }

    public Pokemon findById(long id){
        Pokemon pok = service.searchById(id);
        return pok;
    }
}
