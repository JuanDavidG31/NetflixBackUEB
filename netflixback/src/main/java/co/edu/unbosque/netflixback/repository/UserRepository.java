
package co.edu.unbosque.netflixback.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.netflixback.model.User;
/**
 * Repositorio para manejar las operaciones CRUD relacionadas con la entidad {@link User}.
 * <p>
 * Extiende {@link CrudRepository} y proporciona métodos personalizados para buscar usuarios
 * por nombre de usuario, buscar por correo electrónico y eliminar usuarios por nombre de usuario.
 * </p>
 */
public interface UserRepository extends CrudRepository<User, Integer> {
	/**
     * Busca una lista de usuarios por nombre de usuario.
     * 
     * @param user nombre de usuario a buscar
     * @return una lista de objetos {@link User} que coinciden con el nombre de usuario proporcionado
     */
	List<User> findByUser(String user);
	/**
     * Busca un usuario por su correo electrónico.
     * 
     * @param email correo electrónico del usuario a buscar
     * @return un objeto {@link Optional} que contiene el usuario si se encuentra
     */
	Optional<User> findByEmail(String email);
	/**
     * Elimina un usuario por su nombre de usuario.
     * 
     * @param user nombre de usuario del usuario a eliminar
     */
	void deleteByUser(String user);
}
