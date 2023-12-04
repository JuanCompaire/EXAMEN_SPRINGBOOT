package com.example.pokemon.controller;

import com.example.pokemon.model.Region;
import com.example.pokemon.repository.RegionRepository;
import com.example.pokemon.service.RegionService;
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
public class RegionController {

    @Autowired
    RegionService regionService;

    @RequestMapping("/formRegion")
    public String formRegion(Model model){
        model.addAttribute("nuevaRegion", new Region());
        return "formRegion";
    }

    @RequestMapping("/insertRegion")
    public String insertarRegion(@ModelAttribute("nuevaRegion")Region region, BindingResult result,Model model){
        model.addAttribute("regiones", regionService.insertRegion(region));
        return "finRegion";
    }

    @RequestMapping("/deleteRegion")
    public String borrarRegion(@RequestParam(name = "newId", required = false) Integer newId,
                               @RequestParam(name= "newNombre", required = false) String newNombre,
                               @RequestParam(name = "oldId", required = false) Integer oldId,
                               @RequestParam(name = "oldNombre", required = false) String oldNombre,
                                 Model model){
        if(newId != null && newNombre != null){
            regionService.deleteRegion(newId, newNombre);
        }

        if(oldId != null && oldNombre != null){
            regionService.deleteRegion(oldId, oldNombre);
        }

        model.addAttribute("regiones", regionService.listarTodosRegion());

        return "finRegion";
    }

    @RequestMapping("/updateAlmacen/{id}")
    public String actualizarAlmacen(@PathVariable Integer id,Model model){
        Region region = regionService.updateRegionList(id);
        model.addAttribute("nuevaRegion", region);
        return "finalRegion";
    }

    @RequestMapping("/searchRegion")
    public String buscarRegion(@RequestParam("search") String userInput,Model model){
        List<Region> lista = regionService.searchRegion(userInput);
        model.addAttribute("regiones", lista);
        return "finRegion";
    }
}
