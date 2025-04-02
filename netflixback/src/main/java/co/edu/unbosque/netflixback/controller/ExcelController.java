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

import co.edu.unbosque.netflixback.dto.ExcelDTO;
import co.edu.unbosque.netflixback.service.ExcelService;

/**
 * Controlador para manejar las operaciones relacionadas con los archivos Excel.
 * <p>
 * Este controlador proporciona endpoints para crear, actualizar, obtener y
 * eliminar archivos Excel.
 * </p>
 */
@RestController
@RequestMapping("/excel")
@CrossOrigin(origins = { "*" })
public class ExcelController {

	/**
	 * Servicio encargado de la lógica relacionada con los archivos Excel.
	 */
	@Autowired
	private ExcelService excelServ;

	/**
	 * Constructor por defecto.
	 */
	public ExcelController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Crea un nuevo archivo Excel a partir de un objeto JSON.
	 * 
	 * @param nuevo objeto {@link ExcelDTO} que contiene los datos del Excel
	 * @return una respuesta indicando si la creación fue exitosa o no
	 */

	@PostMapping("/crearjson")
	public ResponseEntity<String> crearConJson(@RequestBody ExcelDTO nuevo) {

		ExcelDTO newUser = nuevo;
		int status = excelServ.create(newUser);

		if (status == 0) {
			return new ResponseEntity<>("Excel creado con éxito", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Error al crear el excel", HttpStatus.NOT_ACCEPTABLE);
		}

	}

	/**
	 * Actualiza un archivo Excel existente a partir de un objeto JSON.
	 * 
	 * @param nuevo objeto {@link ExcelDTO} con los nuevos datos
	 * @return una respuesta indicando si la actualización fue exitosa o no
	 */

	@PutMapping("/actualizarjson")
	public ResponseEntity<String> actualizar(@RequestBody ExcelDTO nuevo) {

		ExcelDTO excelUpdate = nuevo;

		int estado = excelServ.update(excelUpdate);
		if (estado == 0) {
			return new ResponseEntity<>("Excel actualizado con éxito", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Error al actualizar el excel", HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Obtiene una lista de todos los archivos Excel.
	 * 
	 * @return una lista de objetos {@link ExcelDTO} y un código de estado HTTP
	 */

	@GetMapping("/showAll")
	public ResponseEntity<ArrayList<ExcelDTO>> showAll() {
		ArrayList<ExcelDTO> excels = excelServ.findAll();
		if (excels.isEmpty()) {
			return new ResponseEntity<>(excels, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(excels, HttpStatus.ACCEPTED);
		}
	}

	/**
	 * Elimina un archivo Excel por su ID.
	 * 
	 * @param id identificador del archivo Excel a eliminar
	 * @return una respuesta indicando si la eliminación fue exitosa o no
	 */
	@DeleteMapping("/eliminarId/{id}")

	public ResponseEntity<String> deleteById(@PathVariable Integer id) {
		int status = excelServ.deleteById(id);
		if (status == 0) {
			return new ResponseEntity<>("Excel eliminado con exito", HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>("Error al eliminar el Excel", HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Obtiene el servicio de Excel.
	 * 
	 * @return instancia de {@link ExcelService}
	 */
	public ExcelService getExcelServ() {
		return excelServ;
	}

	/**
	 * Configura el servicio de Excel.
	 * 
	 * @param excelServ instancia de {@link ExcelService} a asignar
	 */
	public void setExcelServ(ExcelService excelServ) {
		this.excelServ = excelServ;
	}

}
