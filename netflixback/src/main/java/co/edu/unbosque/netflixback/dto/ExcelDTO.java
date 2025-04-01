/**
 * Clase que representa los datos de un archivo Excel.
 * <p>
 * Contiene propiedades como el identificador del archivo y el usuario asociado.
 * </p>
 */
package co.edu.unbosque.netflixback.dto;

public class ExcelDTO {
	/**
	 * Identificador único del archivo Excel.
	 */
	private Integer id;
	/**
	 * Nombre del usuario asociado al archivo Excel.
	 */
	private String user;

	private String date;

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
	public ExcelDTO(String user, String date) {
		super();
		this.user = user;
		this.date = date;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ExcelDTO [id=" + id + ", user=" + user + ", date=" + date + "]";
	}

}
