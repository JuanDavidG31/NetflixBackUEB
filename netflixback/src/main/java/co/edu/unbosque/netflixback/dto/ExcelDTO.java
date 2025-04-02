
package co.edu.unbosque.netflixback.dto;

/**
 * Clase que representa los datos de un archivo Excel.
 * <p>
 * Contiene propiedades como el identificador del archivo y el usuario asociado.
 * </p>
 */
public class ExcelDTO {
	 /**
     * Identificador único del archivo Excel.
     */
	private Integer id;
	/**
     * Nombre del usuario asociado al archivo Excel.
     */
	private String user;

	 /**
     * Constructor por defecto.
     */
	public ExcelDTO() {
		// TODO Auto-generated constructor stub
	}
	/**
     * Constructor con parámetros.
     * 
     * @param user nombre del usuario asociado al archivo Excel
     */
	public ExcelDTO(String user) {
		super();
		this.user = user;
	}
	/**
     * Obtiene el identificador único del archivo Excel.
     * 
     * @return identificador del archivo Excel
     */
	public Integer getId() {
		return id;
	}
	 /**
     * Configura el identificador único del archivo Excel.
     * 
     * @param id identificador único a asignar
     */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
     * Obtiene el nombre del usuario asociado al archivo Excel.
     * 
     * @return nombre del usuario
     */
	public String getUser() {
		return user;
	}
	/**
     * Configura el nombre del usuario asociado al archivo Excel.
     * 
     * @param user nombre del usuario a asignar
     */
	public void setUser(String user) {
		this.user = user;
	}
	/**
     * Representación en cadena de la clase ExcelDTO.
     * 
     * @return una cadena con el id y el usuario del archivo Excel
     */
	@Override
	public String toString() {
		return "ExcelDTO [id=" + id + ", user=" + user + "]";
	}

}
