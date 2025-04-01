/**
 * Entidad que representa una película en la base de datos.
 * <p>
 * Esta clase está mapeada a la tabla "movie" en la base de datos y contiene información
 * como el identificador único, la URL del recurso, el nombre y el género de la película.
 * </p>
 */
package co.edu.unbosque.netflixback.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie {
	/**
     * Identificador único de la película.
     * <p>
     * Se genera automáticamente mediante la estrategia de incremento.
     * </p>
     */
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id;
	/**
     * URL del recurso asociado a la película.
     * <p>
     * Debe ser único en la base de datos.
     * </p>
     */
	@Column(unique = true)
	private String url;
	/**
     * Nombre de la película.
     */
	private String nombre;
	 /**
     * Género de la película.
     */
	private String genero;
	/**
     * Constructor por defecto.
     */
	public Movie() {
		// TODO Auto-generated constructor stub
	}
	 /**
     * Constructor con parámetros.
     * 
     * @param url URL del recurso asociado a la película
     * @param nombre nombre de la película
     * @param genero género de la película
     */
	public Movie(String url, String nombre, String genero) {
		super();
		this.url = url;
		this.nombre = nombre;
		this.genero = genero;
	}
	/**
     * Obtiene el identificador único de la película.
     * 
     * @return identificador único de la película
     */
	public Integer getId() {
		return id;
	}
	/**
     * Configura el identificador único de la película.
     * 
     * @param id identificador único a asignar
     */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
     * Obtiene la URL del recurso asociado a la película.
     * 
     * @return URL del recurso de la película
     */
	public String getUrl() {
		return url;
	}
	/**
     * Configura la URL del recurso asociado a la película.
     * 
     * @param url URL a asignar
     */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
     * Obtiene el nombre de la película.
     * 
     * @return nombre de la película
     */
	public String getNombre() {
		return nombre;
	}
	/**
     * Configura el nombre de la película.
     * 
     * @param nombre nombre a asignar
     */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
     * Obtiene el género de la película.
     * 
     * @return género de la película
     */
	public String getGenero() {
		return genero;
	}
	/**
     * Configura el género de la película.
     * 
     * @param genero género a asignar
     */
	public void setGenero(String genero) {
		this.genero = genero;
	}
	/**
     * Representación en cadena de la clase Movie.
     * 
     * @return una cadena con los datos de la película
     */
	@Override
	public String toString() {
		return "Movie [id=" + id + ", url=" + url + ", nombre=" + nombre + ", genero=" + genero + "]";
	}

}
