
package co.edu.unbosque.netflixback.service;

import java.util.ArrayList;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.netflixback.dto.MovieDTO;
import co.edu.unbosque.netflixback.model.Movie;
import co.edu.unbosque.netflixback.repository.MovieRepository;
/**
 * Servicio que maneja la lógica relacionada con las películas.
 * <p>
 * Este servicio incluye métodos para crear, obtener y eliminar películas, así como para mapear
 * objetos entre {@link Movie} y {@link MovieDTO}.
 * </p>
 */
@Service
public class MovieService {
	/**
     * Repositorio para acceder y manipular la información de las películas en la base de datos.
     */
	@Autowired
	private MovieRepository movieRepo;
	 /**
     * ModelMapper para convertir entre objetos de tipo {@link Movie} y {@link MovieDTO}.
     */
	@Autowired
	private ModelMapper modelMapper;
	/**
     * Constructor por defecto.
     */
	public MovieService() {
		// TODO Auto-generated constructor stub
	}
	/**
     * Crea una nueva película basada en los datos proporcionados.
     * 
     * @param data objeto {@link MovieDTO} con los datos de la película
     * @return 0 si la operación fue exitosa, 1 en caso de error
     */
	public int create(MovieDTO data) {
		Movie entity = modelMapper.map(data, Movie.class);
		try {
			movieRepo.save(entity);
			return 0;
		} catch (Exception e) {
			return 1;
		}
	}
	/**
     * Obtiene todas las películas registradas y las devuelve como una lista de objetos {@link MovieDTO}.
     * 
     * @return lista de objetos {@link MovieDTO}
     */
	public ArrayList<MovieDTO> findAll() {
		ArrayList<Movie> entityList = (ArrayList<Movie>) movieRepo.findAll();
		ArrayList<MovieDTO> dtoList = new ArrayList<>();

		entityList.forEach((entity) -> {

			MovieDTO dto = modelMapper.map(entity, MovieDTO.class);
			dtoList.add(dto);

		});

		return dtoList;
	}
	 /**
     * Elimina una película por su identificador.
     * 
     * @param id identificador de la película a eliminar
     * @return 0 si la operación fue exitosa, 1 en caso de error
     */
	public int deleteById(Integer id) {
		Optional<Movie> found = movieRepo.findById(id);
		if (found.isPresent()) {

			movieRepo.delete(found.get());
			return 0;
		} else {
			return 1;
		}
	}
	/**
     * Obtiene el repositorio de películas.
     * 
     * @return instancia de {@link MovieRepository}
     */
	public MovieRepository getMovieRepo() {
		return movieRepo;
	}
	 /**
     * Configura el repositorio de películas.
     * 
     * @param movieRepo instancia de {@link MovieRepository} a asignar
     */
	public void setMovieRepo(MovieRepository movieRepo) {
		this.movieRepo = movieRepo;
	}
	/**
     * Obtiene el ModelMapper utilizado para conversiones.
     * 
     * @return instancia de {@link ModelMapper}
     */
	public ModelMapper getModelMapper() {
		return modelMapper;
	}
	/**
     * Configura el ModelMapper utilizado para conversiones.
     * 
     * @param modelMapper instancia de {@link ModelMapper} a asignar
     */
	public void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

}
