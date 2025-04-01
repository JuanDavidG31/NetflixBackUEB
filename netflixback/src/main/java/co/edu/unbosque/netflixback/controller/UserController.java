/**
 * Paquete que contiene los controladores de la aplicación Netflixback.
 */
package co.edu.unbosque.netflixback.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.netflixback.dto.UserDTO;
import co.edu.unbosque.netflixback.service.UserService;
/**
 * Controlador para manejar las operaciones relacionadas con los usuarios.
 * <p>
 * Este controlador proporciona endpoints para crear, actualizar, obtener y eliminar usuarios.
 * </p>
 */
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = { "*" })
public class UserController {
	 /**
     * Servicio encargado de la lógica relacionada con los usuarios.
     */
	@Autowired
	private UserService userServ;
	 /**
     * Constructor por defecto.
     */
	public UserController() {
	}
	/**
     * Crea un nuevo usuario a partir de un objeto JSON.
     * 
     * @param nuevo objeto {@link UserDTO} que contiene los datos del usuario
     * @return una respuesta indicando si la creación fue exitosa o no
     */
	@PostMapping("/crearjson")
	public ResponseEntity<String> crearConJson(@RequestBody UserDTO nuevo) {

		UserDTO newUser = nuevo;
		int status = userServ.create(newUser);

		if (status == 0) {
			return new ResponseEntity<>("Usuario creado con éxito", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Error al crear el Usuario", HttpStatus.NOT_ACCEPTABLE);
		}

	}
	/**
     * Obtiene una lista de todos los usuarios.
     * 
     * @return una lista de objetos {@link UserDTO} y un código de estado HTTP
     */
	@GetMapping("/showAll")
	public ResponseEntity<ArrayList<UserDTO>> showAll() {
		ArrayList<UserDTO> users = userServ.findAll();
		if (users.isEmpty()) {
			return new ResponseEntity<>(users, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(users, HttpStatus.ACCEPTED);
		}
	}
	/**
     * Elimina un usuario por su ID.
     * 
     * @param id identificador del usuario a eliminar
     * @return una respuesta indicando si la eliminación fue exitosa o no
     */
	@DeleteMapping("/eliminarId/{id}")

	public ResponseEntity<String> deleteById(@PathVariable Integer id) {
		int status = userServ.deleteById(id);
		if (status == 0) {
			return new ResponseEntity<>("Usuario eliminado con exito", HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>("Error al eliminar el usuario", HttpStatus.NOT_FOUND);
		}
	}
	/**
     * Elimina un usuario por su nombre de usuario.
     * 
     * @param user nombre del usuario a eliminar
     * @return una respuesta indicando si la eliminación fue exitosa o no
     */
	@DeleteMapping("/eliminar/user/{user}")
	public ResponseEntity<String> eliminarPorUser(@PathVariable String user) {
		int estado = userServ.deleteByUser(user);
		return estado == 0 ? new ResponseEntity<>("Usuario eliminado con éxito", HttpStatus.OK)
				: new ResponseEntity<>("No encontrado", HttpStatus.NOT_FOUND);
	}
	/**
     * Actualiza los datos de un usuario a partir de un objeto JSON.
     * 
     * @param nuevo objeto {@link UserDTO} con los nuevos datos
     * @return una respuesta indicando si la actualización fue exitosa o no
     */
	@PutMapping("/actualizarjson")
	public ResponseEntity<String> actualizar(@RequestBody UserDTO nuevo) {

		UserDTO userUpdate = nuevo;

		int estado = userServ.update(userUpdate);
		if (estado == 0) {
			return new ResponseEntity<>("Usuario actualizado con éxito", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Error al actualizar el usuario", HttpStatus.NOT_FOUND);
		}
	}
	/**
     * Obtiene el servicio de usuarios.
     * 
     * @return instancia de {@link UserService}
     */
	public UserService getUserServ() {
		return userServ;
	}
	 /**
     * Configura el servicio de usuarios.
     * 
     * @param userServ instancia de {@link UserService} a asignar
     */
	public void setUserServ(UserService userServ) {
		this.userServ = userServ;
	}

}
