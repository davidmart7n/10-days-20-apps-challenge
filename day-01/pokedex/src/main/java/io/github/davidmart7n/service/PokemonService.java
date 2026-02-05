package io.github.davidmart7n.service;

import io.github.davidmart7n.domain.Pokemon;

public interface PokemonService {
    
    public Pokemon capturePokemon(String nameOrId) throws Exception;

}
