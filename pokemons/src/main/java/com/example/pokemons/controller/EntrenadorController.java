package com.example.pokemons.controller;

import com.example.pokemons.model.Entrenador;
import com.example.pokemons.service.EntrenadorService;
import com.example.pokemons.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EntrenadorController {

    @Autowired
    EntrenadorService service;

    @Autowired
    PokemonService  pokemonService;

    @RequestMapping("/formEntrenador")
    public String formEntrenador(Model model){

        model.addAttribute("entrenador", new Entrenador());
        return "formEntrenador";
    }

    @RequestMapping("/insertEntrenador")
    public String insertarEntrenador(Entrenador entrenador, Model model){

        service.insertEntrenador(entrenador);

        model.addAttribute("entrenadores", service.listarTodosEntrenador());
        return "finEntrenador";
    }

    @RequestMapping("/updateEntrenador")
    public String actualizarEntrenador(Entrenador entrenador, Model model){
        Entrenador ent = service.updateEntrenadorList(entrenador.getId());

        model.addAttribute("entrenador", ent);
        return "index";
    }

    @RequestMapping("/deleteEntrenador")
    public String borrarEntrenador(Entrenador entrenador, Model model){
        service.deleteEntrenador(entrenador.getId());

        model.addAttribute("entrenadores", service.listarTodosEntrenador());
        return "finEntrenador";
    }

    @RequestMapping("/searchEntrenador")
    public String buscarEntrenador(Entrenador entrenador, Model model){
        service.searchEntrenador(entrenador.getNombre());

        model.addAttribute("entrenadores", service.searchEntrenador(entrenador.getNombre()));
        return "finEntrenador";
    }

    public Entrenador findById(long id){
        return service.searchById(id);
    }
}
