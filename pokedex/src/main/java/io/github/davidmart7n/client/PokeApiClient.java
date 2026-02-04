package io.github.davidmart7n.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PokeApiClient {
    private final HttpClient http;
    private final ObjectMapper mapper;

    public PokeApiClient() {


        this.http = HttpClient.newHttpClient();
        this.mapper = new ObjectMapper();
    }

    public JsonNode fetchPokemon(String nameOrId) throws Exception {
        String url = "https://pokeapi.co/api/v2/pokemon/" + nameOrId.toLowerCase();
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> resp = http.send(req, HttpResponse.BodyHandlers.ofString());
        if (resp.statusCode() >= 200 && resp.statusCode() < 300) {
            return mapper.readTree(resp.body());
        }
        throw new RuntimeException("PokeAPI returned status " + resp.statusCode());
    }
}
