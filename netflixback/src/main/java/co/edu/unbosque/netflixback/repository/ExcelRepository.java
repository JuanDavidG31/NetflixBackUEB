/**
 * Repositorio para manejar las operaciones CRUD relacionadas con la entidad {@link Excel}.
 * <p>
 * Extiende {@link CrudRepository} y proporciona un método personalizado para buscar
 * objetos {@link Excel} por el nombre de usuario asociado.
 * </p>
 */
package co.edu.unbosque.netflixback.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.netflixback.model.Excel;
import co.edu.unbosque.netflixback.model.User;

public interface ExcelRepository extends CrudRepository<Excel, Integer> {
	/**
     * Busca un objeto {@link Excel} por el nombre de usuario asociado.
     * 
     * @param user nombre del usuario a buscar
     * @return un objeto {@link Optional} que contiene el archivo Excel si se encuentra
     */
	Optional<Excel> findByUser(String user);
}
