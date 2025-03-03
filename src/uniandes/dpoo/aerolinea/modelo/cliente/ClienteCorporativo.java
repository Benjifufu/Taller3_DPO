package uniandes.dpoo.aerolinea.modelo.cliente;

import org.json.JSONObject;
import uniandes.dpoo.aerolinea.exceptions.ClienteRepetidoException;

/**
 * Esta clase se usa para representar a los clientes de la aerolínea que son empresas
 */
public class ClienteCorporativo extends Cliente {
    public static final String CORPORATIVO = "Corporativo";
    public static final int GRANDE = 1;
    public static final int MEDIANA = 2;
    public static final int PEQUENA = 3; // Corregí "PEQUEÑA" para evitar problemas con caracteres especiales en código

    private String nombreEmpresa;
    private int tamanoEmpresa;

    /**
     * Constructor para crear un ClienteCorporativo con un identificador generado automáticamente
     * @param nombreEmpresa Nombre de la empresa
     * @param tamanoEmpresa Tamaño de la empresa (GRANDE, MEDIANA, PEQUENA)
     * @throws ClienteRepetidoException Si el cliente ya existe
     */
    public ClienteCorporativo(String nombreEmpresa, int tamanoEmpresa) throws ClienteRepetidoException {
        super(ClienteCorporativo.generarIdentificador());
        this.nombreEmpresa = nombreEmpresa;
        this.tamanoEmpresa = tamanoEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public int getTamanoEmpresa() {
        return tamanoEmpresa;
    }

    @Override
    public String getTipoCliente() {
        return CORPORATIVO;
    }

    /**
     * Devuelve el identificador del cliente
     * @return Identificador del cliente
     */
    public String getIdentificador() {
        return super.getIdentificador();
    }

    /**
     * Método que carga un ClienteCorporativo desde un objeto JSON
     * @param cliente Objeto JSON con la información del cliente
     * @return Un objeto ClienteCorporativo con los datos cargados
     * @throws ClienteRepetidoException Si el cliente ya existe
     */
    public static ClienteCorporativo cargarDesdeJSON(JSONObject cliente) throws ClienteRepetidoException {
        String nombreEmpresa = cliente.getString("nombreEmpresa");
        int tamanoEmpresa = cliente.getInt("tamanoEmpresa");
        String identificador = cliente.getString("identificador"); // Se toma el identificador del JSON
        ClienteCorporativo nuevoCliente = new ClienteCorporativo(nombreEmpresa, tamanoEmpresa);
        nuevoCliente.setIdentificador(identificador); // Se asigna el identificador original
        return nuevoCliente;
    }

    /**
     * Salva este objeto de tipo ClienteCorporativo dentro de un objeto JSONObject
     * @return El objeto JSON con toda la información del cliente corporativo
     */
    public JSONObject salvarEnJSON() {
        JSONObject jobject = new JSONObject();
        jobject.put("nombreEmpresa", this.nombreEmpresa);
        jobject.put("tamanoEmpresa", this.tamanoEmpresa);
        jobject.put("tipo", CORPORATIVO);
        jobject.put("identificador", getIdentificador()); // Se guarda el identificador en el JSON
        return jobject;
    }

    /**
     * Método para generar un identificador único para nuevos clientes
     * @return Identificador único generado
     */
    private static String generarIdentificador() {
        return "CORP-" + System.currentTimeMillis();
    }

    /**
     * Método para asignar un identificador específico a un cliente ya creado
     * @param identificador Identificador a asignar
     */
    private void setIdentificador(String identificador) {
        try {
            java.lang.reflect.Field field = Cliente.class.getDeclaredField("identificador");
            field.setAccessible(true);
            field.set(this, identificador);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("No se pudo asignar el identificador", e);
        }
    }
}
