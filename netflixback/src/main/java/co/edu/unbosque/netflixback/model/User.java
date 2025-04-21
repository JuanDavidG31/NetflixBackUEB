package co.edu.unbosque.netflixback.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entidad que representa un usuario en la base de datos.
 *
 * <p>Esta clase está mapeada a la tabla "user" en la base de datos y contiene información como el
 * identificador único, el nombre de usuario, la contraseña, el nombre completo y el correo
 * electrónico.
 */
@Entity
@Table(name = "user")
public class User {
  /**
   * Identificador único del usuario.
   *
   * <p>Se genera automáticamente mediante la estrategia de incremento.
   */
  private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id;

  /**
   * Nombre de usuario.
   *
   * <p>Debe ser único en la base de datos.
   */
  @Column(unique = true)
  private String user;

  /** Contraseña del usuario. */
  private String password;

  /** Nombre completo del usuario. */
  private String name;

  /**
   * Correo electrónico del usuario.
   *
   * <p>Debe ser único en la base de datos.
   */
  @Column(unique = true)
  private String email;

  /** Constructor por defecto. */
  public User() {
    // TODO Auto-generated constructor stub
  }

  /**
   * Constructor con parámetros.
   *
   * @param user nombre de usuario
   * @param password contraseña del usuario
   * @param name nombre completo del usuario
   * @param email correo electrónico del usuario
   */
  public User(String user, String password, String name, String email) {
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
   * Representación en cadena de la clase User.
   *
   * @return una cadena con los datos del usuario
   */
  @Override
  public String toString() {
    return "User [id="
        + id
        + ", user="
        + user
        + ", password="
        + password
        + ", name="
        + name
        + ", email="
        + email
        + "]";
  }
}
