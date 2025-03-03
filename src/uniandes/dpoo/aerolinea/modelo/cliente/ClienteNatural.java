package uniandes.dpoo.aerolinea.modelo.cliente;

import uniandes.dpoo.aerolinea.exceptions.ClienteRepetidoException;

/**
 * Esta clase representa a los clientes naturales de la aerolínea.
 */
public class ClienteNatural extends Cliente {
    public static final String NATURAL = "Natural";
    private String nombre;

    /**
     * Constructor para crear un ClienteNatural con un identificador generado automáticamente.
     * @param nombre Nombre del cliente natural.
     * @throws ClienteRepetidoException Si el cliente ya existe.
     */
    public ClienteNatural(String nombre) throws ClienteRepetidoException {
        super(ClienteNatural.generarIdentificador());
        this.nombre = nombre;
    }

  

	/**
     * Retorna el identificador del cliente.
     * @return Identificador del cliente.
     */
    public String getIdentificador() {
        return super.getIdentificador();
    }

    /**
     * Retorna el tipo de cliente.
     * @return Tipo de cliente (Natural).
     */
    @Override
    public String getTipoCliente() {
        return NATURAL;
    }

    /**
     * Método para generar un identificador único para el cliente.
     * @return Identificador único generado.
     */
    private static String generarIdentificador() {
        return "NAT-" + System.currentTimeMillis();
    }

	public String getNombre() {
		return nombre;
	}

}
