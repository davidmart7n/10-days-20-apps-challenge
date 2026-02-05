package io.github.davidmart7n.service;

import java.net.http.HttpClient;

import com.fasterxml.jackson.databind.JsonNode;
import io.github.davidmart7n.client.PokeApiClient;
import io.github.davidmart7n.domain.Pokemon;
import io.github.davidmart7n.repository.PokemonRepository;

public class PokemonServiceImpl implements PokemonService {

    private final PokeApiClient httpClient;
    private final PokemonRepository repo;

    public PokemonServiceImpl(PokeApiClient httpClient, PokemonRepository repo) {
        this.httpClient = httpClient;
        this.repo = repo;
    }

    public Pokemon capturePokemon(String nameOrId) throws Exception {

        JsonNode pokeJson = httpClient.fetchPokemon(nameOrId);
        Pokemon pokemon = new Pokemon(
                pokeJson.path("id").asInt(),
                pokeJson.path("name").asText());

        this.repo.save(pokemon);
        return pokemon;
    }

}
