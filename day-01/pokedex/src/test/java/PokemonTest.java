import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.davidmart7n.domain.Pokemon;


public class PokemonTest {
    

    @Test
    void fromJson ()throws Exception{

        ObjectMapper mapper=new ObjectMapper();
        Pokemon pokemon=new Pokemon(1,"bulbasaur");

        String jsonString=mapper.writeValueAsString(pokemon);
        JsonNode jsonNode= mapper.readTree(jsonString);

         
        assertEquals(pokemon.getId(), Pokemon.fromJson(jsonNode).getId());
        assertEquals(pokemon.getName(), Pokemon.fromJson(jsonNode).getName());
        
    }
}
