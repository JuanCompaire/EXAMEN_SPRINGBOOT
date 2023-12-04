package com.example.pokemons.service;

import com.example.pokemons.model.Entrenador;
import com.example.pokemons.repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrenadorService {

    @Autowired
    EntrenadorRepository entrenadorRepository;

    public List<Entrenador> insertEntrenador(Entrenador entrenador) {
        System.out.println("nombre: " + entrenador.getNombre() + " activo: " + entrenador.getActivo());;
        if (entrenador.getId() == null) {
            entrenadorRepository.insert(entrenador);
        } else {
            entrenadorRepository.update(entrenador);
        }
        List<Entrenador> lista = entrenadorRepository.findAll();
        for (Entrenador e : lista) {
            System.out.println("id: " + e.getId() + " nombre: " + e.getNombre() + " activo: " + e.getActivo());
        }
        return lista;
    }


    public Entrenador updateEntrenadorList(Integer id){
        Entrenador ent = entrenadorRepository.findById(id);

        System.out.print(ent.getNombre() + " , " + ent.getActivo());
        return ent;
    }

    public List<Entrenador> deleteEntrenador(Integer id){
        entrenadorRepository.delete(id);

        List<Entrenador> lista = entrenadorRepository.findAll();
        return lista;
    }

    public List<Entrenador> searchEntrenador(String userInput){
        List<Entrenador> lista = entrenadorRepository.searchByName(userInput);
        for (Entrenador e : lista) {
            System.out.println("id: " + e.getId() + " nombre: " + e.getNombre() + " activo: " + e.getActivo());
        }
        return lista;
    }


    public Entrenador searchById(long id){
        return entrenadorRepository.findById(id);
    }

    public List<Entrenador> listarTodosEntrenador(){
        List<Entrenador> lista = entrenadorRepository.findAll();

        return lista;
    }
}
