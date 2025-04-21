package co.edu.unbosque.netflixback.service;

import co.edu.unbosque.netflixback.dto.ExcelDTO;
import co.edu.unbosque.netflixback.model.Excel;
import co.edu.unbosque.netflixback.repository.ExcelRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio que maneja la lógica relacionada con los archivos Excel.
 *
 * <p>Este servicio incluye métodos para crear, actualizar, obtener y eliminar archivos Excel, así
 * como para mapear objetos entre {@link Excel} y {@link ExcelDTO}.
 */
@Service
public class ExcelService {
  /** Repositorio para acceder y manipular los archivos Excel en la base de datos. */
  @Autowired private ExcelRepository excelRepo;

  /** ModelMapper para convertir entre objetos de tipo {@link Excel} y {@link ExcelDTO}. */
  @Autowired private ModelMapper modelMapper;

  /** Constructor por defecto. */
  public ExcelService() {
    // TODO Auto-generated constructor stub
  }

  /**
   * Crea un nuevo archivo Excel basado en los datos proporcionados.
   *
   * @param data objeto {@link ExcelDTO} con los datos del archivo Excel
   * @return 0 si la operación fue exitosa, 1 en caso de error
   */
  public int create(ExcelDTO data) {
    Excel entity = modelMapper.map(data, Excel.class);
    try {
      excelRepo.save(entity);
      return 0;
    } catch (Exception e) {
      return 1;
    }
  }

  /**
   * Obtiene todos los archivos Excel registrados y los devuelve como una lista de objetos {@link
   * ExcelDTO}.
   *
   * @return lista de objetos {@link ExcelDTO}
   */
  public ArrayList<ExcelDTO> findAll() {
    ArrayList<Excel> entityList = (ArrayList<Excel>) excelRepo.findAll();
    ArrayList<ExcelDTO> dtoList = new ArrayList<>();

    entityList.forEach(
        (entity) -> {
          ExcelDTO dto = modelMapper.map(entity, ExcelDTO.class);
          dtoList.add(dto);
        });

    return dtoList;
  }

  /**
   * Elimina un archivo Excel por su identificador.
   *
   * @param id identificador del archivo Excel a eliminar
   * @return 0 si la operación fue exitosa, 1 en caso de error
   */
  public int deleteById(Integer id) {
    Optional<Excel> found = excelRepo.findById(id);
    if (found.isPresent()) {

      excelRepo.delete(found.get());
      return 0;
    } else {
      return 1;
    }
  }

  /**
   * Actualiza un archivo Excel basado en los datos proporcionados.
   *
   * @param data objeto {@link ExcelDTO} con los nuevos datos del archivo Excel
   * @return 0 si la operación fue exitosa, 1 en caso de error
   */
  public int update(ExcelDTO data) {
    Optional<Excel> existingExcel = excelRepo.findByUser(data.getUser());

    if (existingExcel.isPresent()) {
      Excel entity = existingExcel.get();

      if (data.getUser() != null && !data.getUser().isEmpty()) {
        entity.setUser(data.getUser());
      }

      try {
        excelRepo.save(entity);
        return 0;
      } catch (Exception e) {
        return 1;
      }
    } else {
      return 1;
    }
  }

  /**
   * Obtiene el repositorio de archivos Excel.
   *
   * @return instancia de {@link ExcelRepository}
   */
  public ExcelRepository getExcelRepo() {
    return excelRepo;
  }

  /**
   * Configura el repositorio de archivos Excel.
   *
   * @param excelRepo instancia de {@link ExcelRepository} a asignar
   */
  public void setExcelRepo(ExcelRepository excelRepo) {
    this.excelRepo = excelRepo;
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
