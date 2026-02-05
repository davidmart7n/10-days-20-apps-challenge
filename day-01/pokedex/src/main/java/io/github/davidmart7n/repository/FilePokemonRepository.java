package io.github.davidmart7n.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.davidmart7n.domain.Pokemon;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FilePokemonRepository implements PokemonRepository {
    //Atributos
    private Path path;
    private ObjectMapper mapper=new ObjectMapper();

    //Constructor
    public FilePokemonRepository(Path path){
        this.path=path;
        this.mapper=mapper;
    }

    //Método save en Path
    public synchronized void save(Pokemon pokemon){
    try{
        String pokeString=mapper.writeValueAsString(pokemon);
        
        if(path.getParent()!=null){
            Files.createDirectories(path.getParent());
        }
        Files.write(path, (pokeString + System.lineSeparator()).getBytes(),
        StandardOpenOption.CREATE,StandardOpenOption.APPEND);

    }catch(Exception e){

        e.printStackTrace();
    }
}
}










// private final Path file;
// private final ObjectMapper mapper = new ObjectMapper();

// public FilePokemonRepository(Path file) {
//     this.file = file;
// }

// @Override
// public synchronized void save(Pokemon pokemon) throws IOException {
//     if (file.getParent() != null) {
//         Files.createDirectories(file.getParent());
//     }
//     String json = mapper.writeValueAsString(pokemon);
//     Files.write(file, (json + System.lineSeparator()).getBytes(StandardCharsets.UTF_8),
//             StandardOpenOption.CREATE, StandardOpenOption.APPEND);
// }
