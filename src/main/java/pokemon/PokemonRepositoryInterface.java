package pokemon;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PokemonRepositoryInterface extends CrudRepository<Pokemon, String> {
  List<Pokemon> findByName(String name);

  @Override
  @NonNull
  Optional<Pokemon> findById(@NonNull String s);

  void deleteByName(String name);
}
