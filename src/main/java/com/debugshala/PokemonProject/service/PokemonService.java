package com.debugshala.PokemonProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.debugshala.PokemonProject.dto.Pokemon;
import com.debugshala.PokemonProject.repository.PokemonRepository;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository repository;

    
    public Pokemon addPokemon(Pokemon pokemon) {
        return repository.save(pokemon);
    }

    
   
    public List<Pokemon> getAllPokemon() {
        return repository.findAll();
    }

    
   
    public Pokemon updatePokemon(Long id, Pokemon updatedPokemon) {
        Pokemon existing = repository.findById(id).orElseThrow();
        existing.setName(updatedPokemon.getName());
        existing.setBreed(updatedPokemon.getBreed());
        existing.setDescription(updatedPokemon.getDescription());
        return repository.save(existing);
    }

    
    // delete Pokemon
    public void deletePokemon(Long id) {
        repository.deleteById(id);
    }
}