/**
 * Paquete principal de la aplicación Netflixback.
 */
package co.edu.unbosque.netflixback;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


/**
 * Clase ServletInitializer.
 * <p>
 * Extiende {@link SpringBootServletInitializer} para configurar la aplicación
 * como una aplicación web servlets en contenedores externos.
 * </p>
 */
public class ServletInitializer extends SpringBootServletInitializer {

	 /**
     * Configura la aplicación al enlazarla con la clase principal {@link NetflixbackApplication}.
     *
     * @param application instancia de {@link SpringApplicationBuilder} para construir la aplicación
     * @return una instancia configurada de {@link SpringApplicationBuilder}
     */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(NetflixbackApplication.class);
	}

}
