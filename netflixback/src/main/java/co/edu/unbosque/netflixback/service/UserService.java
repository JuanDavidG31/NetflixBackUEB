package co.edu.unbosque.netflixback.service;

import co.edu.unbosque.netflixback.dto.UserDTO;
import co.edu.unbosque.netflixback.model.User;
import co.edu.unbosque.netflixback.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio que maneja la lógica relacionada con los usuarios.
 *
 * <p>Este servicio incluye métodos para crear, actualizar, obtener y eliminar usuarios, así como
 * para mapear objetos entre {@link User} y {@link UserDTO}.
 */
@Service
public class UserService {
  /** Repositorio para acceder y manipular la información de los usuarios en la base de datos. */
  @Autowired private UserRepository userRepo;

  /** ModelMapper para convertir entre objetos de tipo {@link User} y {@link UserDTO}. */
  @Autowired private ModelMapper modelMapper;

  /** Constructor por defecto. */
  public UserService() {}

  /**
   * Crea un nuevo usuario basado en los datos proporcionados.
   *
   * @param data objeto {@link UserDTO} con los datos del usuario
   * @return 0 si la operación fue exitosa, 1 en caso de error
   */
  public int create(UserDTO data) {
    User entity = modelMapper.map(data, User.class);
    try {
      userRepo.save(entity);
      return 0;
    } catch (Exception e) {
      return 1;
    }
  }

  /**
   * Encuentra todos los usuarios registrados y los devuelve como una lista de objetos {@link
   * UserDTO}.
   *
   * @return lista de objetos {@link UserDTO}
   */
  public ArrayList<UserDTO> findAll() {
    ArrayList<User> entityList = (ArrayList<User>) userRepo.findAll();
    ArrayList<UserDTO> dtoList = new ArrayList<>();

    entityList.forEach(
        (entity) -> {
          UserDTO dto = modelMapper.map(entity, UserDTO.class);
          dtoList.add(dto);
        });

    return dtoList;
  }

  /**
   * Elimina un usuario por su identificador.
   *
   * @param id identificador del usuario a eliminar
   * @return 0 si la operación fue exitosa, 1 en caso de error
   */
  public int deleteById(Integer id) {
    Optional<User> found = userRepo.findById(id);
    if (found.isPresent()) {

      userRepo.delete(found.get());
      return 0;
    } else {
      return 1;
    }
  }

  /**
   * Elimina un usuario basado en su nombre de usuario.
   *
   * @param user nombre del usuario a eliminar
   * @return 0 si la operación fue exitosa, 1 en caso de error
   */
  public int deleteByUser(String user) {
    List<User> found = userRepo.findByUser(user);

    if (!found.isEmpty()) {
      userRepo.deleteAll(found);
      return 0;
    } else {
      return 1;
    }
  }

  /**
   * Actualiza la información de un usuario basado en los datos proporcionados.
   *
   * @param data objeto {@link UserDTO} con los nuevos datos del usuario
   * @return 0 si la operación fue exitosa, 1 en caso de error
   */
  public int update(UserDTO data) {
    Optional<User> existingUser = userRepo.findByEmail(data.getEmail());

    if (existingUser.isPresent()) {
      User entity = existingUser.get();

      if (data.getName() != null && !data.getName().isEmpty()) {
        entity.setName(data.getName());
      }

      if (data.getPassword() != null && !data.getPassword().isEmpty()) {
        entity.setPassword(data.getPassword());
      }
      if (data.getUser() != null && !data.getUser().isEmpty()) {
        entity.setUser(data.getUser());
      }
      if (data.getEmail() != null && !data.getEmail().isEmpty()) {
        entity.setEmail(data.getEmail());
      }

      try {
        userRepo.save(entity);
        return 0;
      } catch (Exception e) {
        return 1;
      }
    } else {
      return 1;
    }
  }

  /**
   * Obtiene el repositorio de usuarios.
   *
   * @return instancia de {@link UserRepository}
   */
  public UserRepository getUserRepo() {
    return userRepo;
  }

  /**
   * Configura el repositorio de usuarios.
   *
   * @param userRepo instancia de {@link UserRepository} a asignar
   */
  public void setUserRepo(UserRepository userRepo) {
    this.userRepo = userRepo;
  }

  /**
   * Obtiene el ModelMapper usado para conversiones.
   *
   * @return instancia de {@link ModelMapper}
   */
  public ModelMapper getModelMapper() {
    return modelMapper;
  }

  /**
   * Configura el ModelMapper usado para conversiones.
   *
   * @param modelMapper instancia de {@link ModelMapper} a asignar
   */
  public void setModelMapper(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }
}
