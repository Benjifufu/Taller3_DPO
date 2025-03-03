package uniandes.dpoo.aerolinea.persistencia;

import uniandes.dpoo.aerolinea.modelo.Aerolinea;
import org.json.JSONObject;
import org.json.JSONArray;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Clase que maneja la persistencia de la aerolínea en formato JSON.
 */
public class PersistenciaAerolineaJson implements IPersistenciaAerolinea {

    /**
     * Carga los datos de una aerolínea desde un archivo JSON.
     * 
     * @param archivo Ruta del archivo JSON.
     * @param aerolinea Objeto Aerolinea donde se cargarán los datos.
     * @throws IOException Si ocurre un error al leer el archivo.
     */
    @Override
    public void cargarAerolinea(String archivo, Aerolinea aerolinea) throws IOException {
        String contenido = new String(Files.readAllBytes(Paths.get(archivo))); // Leer el archivo
        JSONObject jsonAerolinea = new JSONObject(contenido);

        // Aquí debes llamar a los métodos de Aerolinea para cargar los datos
        aerolinea.setNombre(jsonAerolinea.getString("nombre"));

        // Ejemplo para cargar vuelos, aeropuertos, rutas y aviones (ajustar según la implementación)
        JSONArray vuelos = jsonAerolinea.getJSONArray("vuelos");
        for (int i = 0; i < vuelos.length(); i++) {
            JSONObject vueloJson = vuelos.getJSONObject(i);
            // aerolinea.agregarVuelo(new Vuelo(...)); // Convertir JSON a Vuelo
        }

        JSONArray aeropuertos = jsonAerolinea.getJSONArray("aeropuertos");
        for (int i = 0; i < aeropuertos.length(); i++) {
            JSONObject aeropuertoJson = aeropuertos.getJSONObject(i);
            // aerolinea.agregarAeropuerto(new Aeropuerto(...)); // Convertir JSON a Aeropuerto
        }
    }

    /**
     * Guarda los datos de una aerolínea en un archivo JSON.
     * 
     * @param archivo Ruta del archivo JSON donde se guardarán los datos.
     * @param aerolinea Objeto Aerolinea cuyos datos se guardarán.
     * @throws IOException Si ocurre un error al escribir el archivo.
     */
    @Override
    public void salvarAerolinea(String archivo, Aerolinea aerolinea) throws IOException {
        JSONObject jsonAerolinea = new JSONObject();
        jsonAerolinea.put("nombre", aerolinea.getNombre());

        // Ejemplo para guardar vuelos, aeropuertos, rutas y aviones (ajustar según la implementación)
        JSONArray vuelos = new JSONArray();
        // for (Vuelo vuelo : aerolinea.getVuelos()) {
        //     vuelos.put(vuelo.toJson()); // Suponiendo que Vuelo tiene un método toJson()
        // }
        jsonAerolinea.put("vuelos", vuelos);

        JSONArray aeropuertos = new JSONArray();
        // for (Aeropuerto aeropuerto : aerolinea.getAeropuertos()) {
        //     aeropuertos.put(aeropuerto.toJson()); // Suponiendo que Aeropuerto tiene un método toJson()
        // }
        jsonAerolinea.put("aeropuertos", aeropuertos);

        // Guardar en el archivo
        try (FileWriter file = new FileWriter(archivo)) {
            file.write(jsonAerolinea.toString(4)); // Formateado con 4 espacios de indentación
        }
    }
}
