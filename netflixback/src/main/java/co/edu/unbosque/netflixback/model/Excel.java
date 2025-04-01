/**
 * Entidad que representa un archivo Excel en la base de datos.
 * <p>
 * Esta clase está mapeada a la tabla "excel" en la base de datos y contiene información sobre el identificador
 * y el usuario asociado al archivo.
 * </p>
 */
package co.edu.unbosque.netflixback.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "excel")
public class Excel {
	/**
	 * Identificador único del archivo Excel.
	 * <p>
	 * Se genera automáticamente mediante la estrategia de incremento.
	 * </p>
	 */
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id;
	/**
	 * Usuario asociado al archivo Excel.
	 */
	private String user;
	private String date;

	/**
	 * Constructor por defecto.
	 */

	public Excel() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor con parámetros.
	 * 
	 * @param user nombre del usuario asociado al archivo Excel
	 */
	public Excel(String user, String date) {
		super();
		this.user = user;
		this.date = date;
	}

	/**
	 * Obtiene el identificador único del archivo Excel.
	 * 
	 * @return identificador único del archivo Excel
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
	 * Obtiene el usuario asociado al archivo Excel.
	 * 
	 * @return usuario asociado al archivo Excel
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Configura el usuario asociado al archivo Excel.
	 * 
	 * @param user usuario a asignar
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * Representación en cadena de la clase Excel.
	 * 
	 * @return una cadena con los datos del archivo Excel
	 */

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Excel [id=" + id + ", user=" + user + ", date=" + date + "]";
	}

}
