/** Paquete que contiene los controladores de la aplicación Netflixback. */
package co.edu.unbosque.netflixback.controller;

import co.edu.unbosque.netflixback.dto.MovieDTO;
import co.edu.unbosque.netflixback.service.MovieService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para manejar las operaciones relacionadas con las películas.
 *
 * <p>Este controlador proporciona endpoints para crear, obtener y eliminar películas.
 */
@RestController
@RequestMapping("/movie")
@CrossOrigin(origins = {"*"})
public class MovieController {

  /** Servicio encargado de la lógica relacionada con las películas. */
  @Autowired private MovieService movieServ;

  /** Constructor por defecto. */
  public MovieController() {
    // TODO Auto-generated constructor stub
  }

  /**
   * Crea una nueva película a partir de los parámetros proporcionados.
   *
   * @param url URL del recurso de la película
   * @param nombre Nombre de la película
   * @param genero Género de la película
   * @return una respuesta indicando si la creación fue exitosa o no
   */
  @PostMapping("/create")
  public ResponseEntity<String> create(
      @RequestParam String url, @RequestParam String nombre, @RequestParam String genero) {
    MovieDTO newMovie = new MovieDTO(url, nombre, genero);
    int status = movieServ.create(newMovie);
    if (status == 0) {
      return new ResponseEntity<>("Pelicula creado con exito", HttpStatus.CREATED);
    } else {
      return new ResponseEntity<>("Error al crear la pelicula", HttpStatus.NOT_ACCEPTABLE);
    }
  }

  /**
   * Obtiene una lista de todas las películas disponibles.
   *
   * @return una lista de objetos {@link MovieDTO} y un código de estado HTTP
   */
  @GetMapping("/showAll")
  public ResponseEntity<ArrayList<MovieDTO>> showAll() {
    ArrayList<MovieDTO> movies = movieServ.findAll();
    if (movies.isEmpty()) {
      return new ResponseEntity<>(movies, HttpStatus.NO_CONTENT);
    } else {
      return new ResponseEntity<>(movies, HttpStatus.ACCEPTED);
    }
  }

  /**
   * Elimina una película por su ID.
   *
   * @param id identificador de la película a eliminar
   * @return una respuesta indicando si la eliminación fue exitosa o no
   */
  @DeleteMapping("/eliminarId/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Integer id) {
    int status = movieServ.deleteById(id);
    if (status == 0) {
      return new ResponseEntity<>("Pelicula eliminada con exito", HttpStatus.ACCEPTED);
    } else {
      return new ResponseEntity<>("Error al eliminar la pelicula", HttpStatus.NOT_FOUND);
    }
  }

  /**
   * Obtiene el servicio de películas.
   *
   * @return instancia de {@link MovieService}
   */
  public MovieService getMovieServ() {
    return movieServ;
  }

  /**
   * Configura el servicio de películas.
   *
   * @param movieServ instancia de {@link MovieService} a asignar
   */
  public void setMovieServ(MovieService movieServ) {
    this.movieServ = movieServ;
  }
}
