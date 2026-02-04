package io.github.davidmart7n.domain;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Pokemon {
    private int id;
    private String name;

    public Pokemon() {
    }

    public Pokemon(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Pokemon fromJson(JsonNode node) {
        int id = node.path("id").asInt(0);
        String name = node.path("name").asText(null);
        return new Pokemon(id, name);
    }

}
