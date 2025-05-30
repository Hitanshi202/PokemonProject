package com.debugshala.PokemonProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.debugshala.PokemonProject.dto.Pokemon;
import com.debugshala.PokemonProject.service.PokemonService;

@RestController
public class PokemonController {

    @Autowired
    private PokemonService service;

    
    @PostMapping("/pokemonSave")
    public Pokemon addPokemon(@RequestBody Pokemon pokemon) {
        return service.addPokemon(pokemon);
    }
    
    
    @GetMapping("/pokemonGet")
    public List<Pokemon> getAllPokemon() {
        return service.getAllPokemon();
    }

    
    @PutMapping("/pokemonupdate/{id}")
    public Pokemon updatePokemon(@PathVariable Long id, @RequestBody Pokemon pokemon) {
        return service.updatePokemon(id, pokemon);
    }

    
    @DeleteMapping("/pokemonDelete/{id}")
    public void deletePokemon(@PathVariable Long id) {
        service.deletePokemon(id);
    } 
}
