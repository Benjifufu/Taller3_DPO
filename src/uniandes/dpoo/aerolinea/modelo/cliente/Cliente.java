package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.ArrayList;
import java.util.List;

import uniandes.dpoo.aerolinea.exceptions.ClienteRepetidoException;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class Cliente {
    protected String identificador;
    protected List<Tiquete> tiquetesSinUsar;
    protected List<Tiquete> tiquetesUsados;
    private static List<String> clientesRegistrados = new ArrayList<>();

    public Cliente(String identificador) throws ClienteRepetidoException {
        if (clientesRegistrados.contains(identificador)) {
            throw new ClienteRepetidoException(getTipoCliente(), identificador);
        }
        this.identificador = identificador;
        this.tiquetesSinUsar = new ArrayList<>();
        this.tiquetesUsados = new ArrayList<>();
        clientesRegistrados.add(identificador);
    }

    public String getIdentificador() {
        return identificador;
    }

    public void agregarTiquete(Tiquete tiquete) {
        this.tiquetesSinUsar.add(tiquete);
    }

    public void usarTiquete(Tiquete tiquete) {
        if (this.tiquetesSinUsar.contains(tiquete)) {
            this.tiquetesSinUsar.remove(tiquete);
            this.tiquetesUsados.add(tiquete);
            tiquete.marcarComoUsado();
        }
    }

    public int calcularValorTotalTiquetes() {
        return tiquetesSinUsar.stream().mapToInt(Tiquete::getTarifa).sum();
    }

    public int calcularSaldoPendiente() {
        return calcularValorTotalTiquetes();
    }

    public List<Tiquete> getTiquetesSinUsar() {
        return new ArrayList<>(tiquetesSinUsar);
    }

    public List<Tiquete> getTiquetesUsados() {
        return new ArrayList<>(tiquetesUsados);
    }

    public abstract String getTipoCliente();
}
