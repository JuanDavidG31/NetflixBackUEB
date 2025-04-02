
package co.edu.unbosque.netflixback.dto;

/**
 * Clase que representa los datos de un usuario.
 * <p>
 * Esta clase contiene información como el identificador, nombre de usuario, contraseña, nombre completo y correo electrónico del usuario.
 * </p>
 */
public class UserDTO {
	/**
     * Identificador único del usuario.
     */
	private Integer id;
	/**
     * Nombre de usuario.
     */
	private String user;
	/**
     * Contraseña del usuario.
     */
	private String password;
	/**
     * Nombre completo del usuario.
     */
	private String name;
	/**
     * Correo electrónico del usuario.
     */
	private String email;
	/**
     * Constructor por defecto.
     */
	public UserDTO() {
	}
	 /**
     * Constructor con parámetros.
     * 
     * @param user nombre de usuario
     * @param password contraseña del usuario
     * @param name nombre completo del usuario
     * @param email correo electrónico del usuario
     */
	public UserDTO(String user, String password, String name, String email) {
		super();
		this.user = user;
		this.password = password;
		this.name = name;
		this.email = email;
	}
	/**
     * Obtiene el identificador único del usuario.
     * 
     * @return identificador único del usuario
     */
	public Integer getId() {
		return id;
	}
	/**
     * Configura el identificador único del usuario.
     * 
     * @param id identificador único a asignar
     */
	public void setId(Integer id) {
		this.id = id;
	}
	 /**
     * Obtiene el nombre de usuario.
     * 
     * @return nombre de usuario
     */
	public String getUser() {
		return user;
	}
	/**
     * Configura el nombre de usuario.
     * 
     * @param user nombre de usuario a asignar
     */
	public void setUser(String user) {
		this.user = user;
	}
	/**
     * Obtiene la contraseña del usuario.
     * 
     * @return contraseña del usuario
     */
	public String getPassword() {
		return password;
	}
	 /**
     * Configura la contraseña del usuario.
     * 
     * @param password contraseña a asignar
     */
	public void setPassword(String password) {
		this.password = password;
	}
	 /**
     * Obtiene el nombre completo del usuario.
     * 
     * @return nombre completo del usuario
     */
	public String getName() {
		return name;
	}
	 /**
     * Configura el nombre completo del usuario.
     * 
     * @param name nombre completo a asignar
     */
	public void setName(String name) {
		this.name = name;
	}
	/**
     * Obtiene el correo electrónico del usuario.
     * 
     * @return correo electrónico del usuario
     */
	public String getEmail() {
		return email;
	}
	/**
     * Configura el correo electrónico del usuario.
     * 
     * @param email correo electrónico a asignar
     */
	public void setEmail(String email) {
		this.email = email;
	}
	 /**
     * Representación en cadena de la clase UserDTO.
     * 
     * @return una cadena con los datos del usuario
     */
	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", user=" + user + ", password=" + password + ", name=" + name + ", email=" + email
				+ "]";
	}

}
