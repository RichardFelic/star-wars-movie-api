# Proyecto Star Wars API Client

Este proyecto es una aplicación en Java que interactúa con la API de Star Wars (https://swapi.dev) para consultar y almacenar detalles de las películas de Star Wars en un archivo JSON.

## Descripción

La aplicación permite al usuario buscar películas de Star Wars por su ID utilizando la API de Star Wars. Los detalles de las películas se obtienen y se muestran en la consola, y el usuario puede seleccionar múltiples películas para agregarlas a una lista. Al final, la lista de películas seleccionadas se guarda en un archivo JSON.

### Funcionalidades principales:
1. **Consulta de películas**: Busca información de una película específica por ID.
2. **Agregar películas a la lista**: Permite al usuario seleccionar varias películas de Star Wars.
3. **Generar archivo JSON**: Guarda los detalles de las películas seleccionadas en un archivo JSON.

## Estructura del Proyecto

- **StarWarsApiClient**: Esta clase gestiona la comunicación con la API de Star Wars, utilizando `HttpClient` para realizar solicitudes GET y obteniendo los detalles de las películas. También es responsable de guardar la lista de películas seleccionadas en un archivo JSON.

- **Pelicula**: Modelo que representa los datos de una película de Star Wars. Incluye atributos como título, episodio, director, productores, y fecha de lanzamiento, entre otros.

- **Main**: Clase principal que contiene la lógica de interacción con el usuario. Permite buscar películas por ID, agregar las seleccionadas a una lista, y luego generar un archivo JSON con los detalles de las películas.

## Uso

### Requisitos previos

Asegúrate de tener Java y las dependencias necesarias instaladas.

- [Gson 2.11.0](https://repo1.maven.org/maven2/com/google/code/gson/gson/2.11.0/gson-2.11.0.jar)
- [Apache HttpClient 5.4](https://repo1.maven.org/maven2/org/apache/httpcomponents/client5/httpclient5/5.4/httpclient5-5.4.jar)


### Instrucciones

1. Ejecuta la aplicación.
2. Se te pedirá que ingreses el número de la película que deseas agregar (corresponde al ID en la API de Star Wars). Puedes seguir ingresando IDs de películas o escribir `salir` para finalizar.
3. Si has agregado películas, se te pedirá un nombre de archivo (sin la extensión) para guardar los detalles en un archivo JSON.
4. El archivo JSON se generará con las películas seleccionadas en la carpeta llamada `archivos`.

### Ejemplo de Uso

- **Entrada**: ID de película = 1
- **Salida**:  **Archivo JSON generado**: `peliculas.json`

```json
[
{
  "title": "A New Hope",
  "episode_id": 4,
  "opening_crawl": "It is a period of civil war...",
  "director": "George Lucas",
  "producer": "Gary Kurtz, Rick McCallum",
  "release_date": "1977-05-25",
  "characters": [...],
  "planets": [...],
  "starships": [...],
  "vehicles": [...],
  "species": [...],
  "created": "2014-12-10T14:23:31.880000Z",
  "edited": "2014-12-20T19:49:45.256000Z",
  "url": "https://swapi.dev/api/films/1/"
}
]
```
## Contribuciones

Las contribuciones son bienvenidas. Siéntete libre de hacer un fork del proyecto y enviar un pull request.
