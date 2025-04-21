package co.edu.unbosque.netflixback.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 * Clase que maneja solicitudes HTTP externas y proporciona utilidades para procesar las respuestas.
 *
 * <p>Incluye métodos para enviar solicitudes HTTP GET y formatear respuestas JSON de manera
 * legible.
 */
public class ExternalHTTPRequestHandler {

  /**
   * Cliente HTTP utilizado para enviar solicitudes.
   *
   * <p>Configurado con una conexión de tiempo de espera de 10 segundos y la versión HTTP/2.
   */
  private static final HttpClient HTTP_CLIENT =
      HttpClient.newBuilder()
          .version(HttpClient.Version.HTTP_2)
          .connectTimeout(Duration.ofSeconds(10))
          .build();

  /**
   * Realiza una solicitud HTTP GET a una URL y devuelve la respuesta JSON formateada de manera
   * legible.
   *
   * @param url URL a la que se debe enviar la solicitud
   * @return una cadena JSON formateada de manera legible
   */
  public static String doGetAndParse(String url) {
    HttpRequest request =
        HttpRequest.newBuilder()
            .GET()
            .uri(URI.create(url))
            .header("Content-type", "application/json")
            .build();

    HttpResponse<String> response = null;

    try {
      response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("status code -> " + response.statusCode());
    String uglyJson = response.body();
    return prettyPrintUsingGson(uglyJson);
  }

  /**
   * Formatea una cadena JSON en una representación legible utilizando Gson.
   *
   * @param uglyJson cadena JSON sin formato
   * @return cadena JSON formateada de manera legible
   */
  public static String prettyPrintUsingGson(String uglyJson) {
    Gson gson = new GsonBuilder().setLenient().setPrettyPrinting().create();
    JsonElement jsonElement = JsonParser.parseString(uglyJson);
    String prettyJsonString = gson.toJson(jsonElement);
    return prettyJsonString;
  }
}
