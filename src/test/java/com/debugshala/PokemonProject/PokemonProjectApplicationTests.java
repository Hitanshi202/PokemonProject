package com.debugshala.PokemonProject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.debugshala.PokemonProject.dto.Pokemon;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
public class PokemonProjectApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    static Long pokemonId;

    @Test
    @Order(1)
    public void testAddPokemon() throws Exception {
        Pokemon pokemon = new Pokemon("Pikachu", "Electric", "Fast electric Pokémon");

        String response = mockMvc.perform(post("/pokemonSave")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(pokemon)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Pikachu"))
                .andExpect(jsonPath("$.breed").value("Electric"))
                .andReturn()
                .getResponse()
                .getContentAsString();

        // Extract and store the ID from response with type casting
        pokemonId = JsonPath.parse(response).read("$.id", Long.class);
    }

    @Test
    @Order(2)
    public void testGetAllPokemon() throws Exception {
        mockMvc.perform(get("/pokemonGet"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    @Order(3)
    public void testUpdatePokemon() throws Exception {
        Pokemon updated = new Pokemon("Raichu", "Electric", "Evolved form of Pikachu");

        mockMvc.perform(put("/pokemonupdate/" + pokemonId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updated)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Raichu"))
                .andExpect(jsonPath("$.description").value("Evolved form of Pikachu"));
    }

    @Test
    @Order(4)
    public void testDeletePokemon() throws Exception {
        mockMvc.perform(delete("/pokemonDelete/" + pokemonId))
                .andExpect(status().isOk());
    }

    @Test
    @Order(5)
    public void testGetAfterDelete() throws Exception {
        mockMvc.perform(get("/pokemonGet"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }
}
