package io.github.davidmart7n.repository;

import io.github.davidmart7n.domain.Pokemon;

import java.io.IOException;

public interface PokemonRepository {
    void save(Pokemon pokemon) throws IOException;
}
