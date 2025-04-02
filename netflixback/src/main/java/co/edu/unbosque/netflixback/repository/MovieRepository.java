
package co.edu.unbosque.netflixback.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.netflixback.model.Movie;
/**
 * Repositorio para manejar las operaciones CRUD relacionadas con la entidad {@link Movie}.
 * <p>
 * Extiende {@link CrudRepository} y proporciona un método personalizado para buscar
 * objetos {@link Movie} según su género.
 * </p>
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
