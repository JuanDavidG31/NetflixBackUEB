package co.edu.unbosque.netflixback.repository;

import co.edu.unbosque.netflixback.model.Excel;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 * Repositorio para manejar las operaciones CRUD relacionadas con la entidad {@link Excel}.
 *
 * <p>Extiende {@link CrudRepository} y proporciona un método personalizado para buscar objetos
 * {@link Excel} por el nombre de usuario asociado.
 */
public interface ExcelRepository extends CrudRepository<Excel, Integer> {
  /**
   * Busca un objeto {@link Excel} por el nombre de usuario asociado.
   *
   * @param user nombre del usuario a buscar
   * @return un objeto {@link Optional} que contiene el archivo Excel si se encuentra
   */
  Optional<Excel> findByUser(String user);
}
