package pokemon;

import io.micronaut.http.annotation.*;
import org.hibernate.query.QueryParameter;

import java.util.List;
import java.util.Optional;

@Controller("/pokemons")
public class PokemonController {
    PokemonService service;

    public PokemonController(PokemonService service) {
        this.service = service;
    }

    @Get
    public List<Pokemon> getAllPokemons() {
        return service.getAllPokemons();
    }

    @Post
    public Pokemon addPokemon(@Body PokemonRequest pokemonRequest) {
        return service.addPokemon(pokemonRequest);
    }

    @Get("/search")
    public Optional<Pokemon> getById(@QueryValue("id") Optional<String> id) {
        return service.findById(id);
    }

    @Get("/search/{name}")
    public List<Pokemon> getByName(String name) {
        return service.findByName(name);
    }

    @Get("/delete")
    public void deleteByName(String name) {
        service.deleteByName(name);
    }
}
