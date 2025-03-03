package uniandes.dpoo.aerolinea.persistencia;

import uniandes.dpoo.aerolinea.modelo.Aerolinea;
import java.io.IOException;

/**
 * Interfaz que define los métodos para la persistencia de los datos de una aerolínea.
 */
public interface IPersistenciaAerolinea {
    
    /**
     * Carga los datos de una aerolínea desde un archivo.
     * 
     * @param archivo Ruta del archivo de donde se cargarán los datos.
     * @param aerolinea Objeto de la aerolínea donde se almacenarán los datos cargados.
     * @throws IOException Si hay un error al leer el archivo.
     */
    void cargarAerolinea(String archivo, Aerolinea aerolinea) throws IOException;

    /**
     * Guarda los datos de una aerolínea en un archivo.
     * 
     * @param archivo Ruta del archivo donde se guardarán los datos.
     * @param aerolinea Objeto de la aerolínea cuyos datos se guardarán.
     * @throws IOException Si hay un error al escribir en el archivo.
     */
    void salvarAerolinea(String archivo, Aerolinea aerolinea) throws IOException;
}
