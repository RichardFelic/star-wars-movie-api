package com.aluracursos.consultarpeliculasstarwars.principal;

import com.aluracursos.consultarpeliculasstarwars.modelo.Pelicula;
import com.aluracursos.consultarpeliculasstarwars.modelo.StarWarsApiClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StarWarsApiClient apiClient = new StarWarsApiClient();
        Scanner scanner = new Scanner(System.in);

        List<Pelicula> peliculasSeleccionadas = new ArrayList<>(); // lista para almacenar peliculas

        String entrada;

        do {
            System.out.println("Escribe el numero de la pelicula que deseas agregar o escribe 'salir' para que termine " +
                    "todo");
            entrada = scanner.nextLine();

            if(!entrada.equalsIgnoreCase("salir")) {
                try {
                    int idPelicula = Integer.parseInt(entrada); // Hacemos un Cast de Int a la entrada
                    Optional<Pelicula> peliculaOptional = apiClient.buscarPelicula(idPelicula);

                    peliculaOptional.ifPresentOrElse(
                            pelicula -> {
                                peliculasSeleccionadas.add(pelicula);
                                System.out.println("Pelicula agregada: " + pelicula.getTitle());
                            }, () -> System.out.println("No se pudo encontrar con el ID " + idPelicula)
                    );
                } catch (NumberFormatException e) {
                    System.out.println("Por facorm ingresa un número valido");
                }
            }
        } while (!entrada.equalsIgnoreCase("salir"));

        if (!peliculasSeleccionadas.isEmpty()){
            try {
                System.out.println("Introduce el nombre del archivo (sin extensión) que desees para guardar " +
                        "las películas: ");
                String nombreArchivo = scanner.nextLine();
                apiClient.guardarPeliculaComoJson(peliculasSeleccionadas, nombreArchivo);
                System.out.println("Archivo JSON generado exitosamente con las películas seleccionadas.");
            } catch (IOException e){
                System.out.println("Error al generar el archivo JSON: " + e.getMessage());
            }
        } else {
            System.out.println("No se seleccionaron películas.");
        }

        scanner.close();
    }

}
