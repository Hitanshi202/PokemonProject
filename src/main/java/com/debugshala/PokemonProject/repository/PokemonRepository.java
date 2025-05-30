package com.debugshala.PokemonProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.debugshala.PokemonProject.dto.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {}
