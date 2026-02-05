import static org.mockito.Mockito.when;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import io.github.davidmart7n.domain.Pokemon;
import io.github.davidmart7n.repository.FilePokemonRepository;

@ExtendWith(MockitoExtension.class)
public class FilePokemonRepositoryTest {
    
    
    Path path=Paths.get("");

    @Mock
    FilePokemonRepository repository=new FilePokemonRepository(path);


    // @Test
    // void save() throws IOException {

    //     Pokemon pokemon=new Pokemon(1,"Bulbasaur");

    //     when(repository.save(pokemon)).thenReturn();
    // }
}
