

package co.edu.unbosque.netflixback.dto;
/**
 * Clase que representa los datos de una película.
 * <p>
 * Esta clase contiene propiedades para el identificador único, la URL del recurso, el nombre y el género de la película.
 * </p>
 */
public class MovieDTO {
	/**
     * Identificador único de la película.
     */
	private Integer id;
	/**
     * URL del recurso asociado a la película.
     */
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
	public MovieDTO() {
		// TODO Auto-generated constructor stub
	}
	/**
     * Constructor con parámetros.
     * 
     * @param url URL del recurso asociado a la película
     * @param nombre nombre de la película
     * @param genero género de la película
     */
	public MovieDTO(String url, String nombre, String genero) {
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
     * Representación en cadena de la clase MovieDTO.
     * 
     * @return una cadena con los datos de la película
     */
	@Override
	public String toString() {
		return "MovieDTO [id=" + id + ", url=" + url + ", nombre=" + nombre + ", genero=" + genero + "]";
	}

}
