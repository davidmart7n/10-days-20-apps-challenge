
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.github.davidmart7n.client.PokeApiClient;
import io.github.davidmart7n.domain.Pokemon;
import io.github.davidmart7n.repository.PokemonRepository;
import io.github.davidmart7n.service.PokemonServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
class PokemonServiceTest {

    @Mock
    PokeApiClient client;

    @Mock
    PokemonRepository repo;

    @InjectMocks
    PokemonServiceImpl service;

    @Test
    void capturePokemon_success() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.createObjectNode()
                .put("id", 25)
                .put("name", "pikachu");

        when(client.fetchPokemon("pikachu")).thenReturn(node);

        Pokemon result = service.capturePokemon("pikachu");

        verify(client).fetchPokemon("pikachu");
        verify(repo).save(result);
        assertEquals(25, result.getId());
        assertEquals("pikachu", result.getName());
    }
}