package pokemon;

import io.micronaut.data.model.Sort;
import jakarta.inject.Singleton;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Singleton
public class PokemonService {
  private final PokemonRepositoryInterface repository;

  public PokemonService(PokemonRepositoryInterface repository) {
    this.repository = repository;
  }

  public List<Pokemon> getAllPokemons() {
    return repository.findAll();
  }

  public Pokemon addPokemon(PokemonRequest pokemonRequest) {
    Pokemon pokemon =
        new Pokemon(
            pokemonRequest.name(),
            pokemonRequest.level(),
            pokemonRequest.imageUrl(),
            pokemonRequest.weight(),
            pokemonRequest.id());
    repository.save(pokemon);
    return pokemon;
  }

  public List<Pokemon> findByName(String name) {
    if (name.isEmpty()) return repository.findAll();

    return repository.findByName(name);
  }

  public void deleteByName(String name) {
    repository.deleteByName(name);
  }

  public Optional<Pokemon> findById(Optional<String> id) {
    if (id.isEmpty()) return Optional.empty();
    return repository.findById(id.get());
  }
}
