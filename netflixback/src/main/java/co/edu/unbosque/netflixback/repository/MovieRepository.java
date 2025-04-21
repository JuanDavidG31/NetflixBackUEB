package co.edu.unbosque.netflixback.repository;

import co.edu.unbosque.netflixback.model.Movie;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * Repositorio para manejar las operaciones CRUD relacionadas con la entidad {@link Movie}.
 *
 * <p>Extiende {@link CrudRepository} y proporciona un método personalizado para buscar objetos
 * {@link Movie} según su género.
 */
public interface MovieRepository extends CrudRepository<Movie, Integer> {
  /**
   * Busca una lista de películas por género.
   *
   * @param genero género de las películas a buscar
   * @return una lista de objetos {@link Movie} que pertenecen al género especificado
   */
  List<Movie> findByGenero(String genero);
}
