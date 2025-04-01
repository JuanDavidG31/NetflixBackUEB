/**
 * Paquete principal de la aplicación Netflixback.
 */
package co.edu.unbosque.netflixback;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
/**
 * Clase principal de la aplicación Netflixback.
 * <p>
 * Esta clase configura y arranca la aplicación Spring Boot.
 * </p>
 */
@SpringBootApplication
public class NetflixbackApplication {

	/**
     * Método principal para ejecutar la aplicación.
     * 
     * @param args argumentos de línea de comandos
     */
	public static void main(String[] args) {
		SpringApplication.run(NetflixbackApplication.class, args);
	}
	
	/**
     * Bean que proporciona una instancia de {@link ModelMapper}.
     * 
     * @return una nueva instancia de ModelMapper
     */
    @Bean
    ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
