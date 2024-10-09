package com.aluracursos.consultarpeliculasstarwars.modelo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

public class StarWarsApiClient {
    private static final String BASE_URL = "https://swapi.dev/api/films/";
    private final HttpClient httpClient;
    private final Gson gson;


    public StarWarsApiClient() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    // Metodo para obtener detalles de una película específica
    public Optional<Pelicula> buscarPelicula(int id) {
        try {
            String uri = BASE_URL + id + "/";
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                Pelicula pelicula = gson.fromJson(response.body(), Pelicula.class);
                return Optional.of(pelicula);
            } else {
                System.out.println("Error al buscar la película: " + response.statusCode());
                return Optional.empty();
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("Error de comunicación: " + e.getMessage());
            Thread.currentThread().interrupt();
            return Optional.empty();
        }
    }

    // Metodo para guardar la película seleccionada en un archivo JSON
    public void guardarPeliculaComoJson(List<Pelicula> peliculas, String nombreArchivo) throws IOException {
        // Especificar la ruta del archivo JSON en el directorio "archivos"
        String rutaArchivo = "archivos/" + nombreArchivo + ".json";
        FileWriter writer = new FileWriter(rutaArchivo);
        gson.toJson(peliculas, writer);
        writer.flush();
        writer.close();
    }
}
