package uniandes.dpoo.aerolinea.modelo;

import java.util.ArrayList;
import java.util.List;

import uniandes.dpoo.aerolinea.tiquetes.Tiquete;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;

public class Vuelo {
    private String fecha;
    private Ruta ruta;
    private Avion avion;
    private List<Tiquete> tiquetes;
    private boolean realizado;

    public Vuelo(Ruta ruta, String fecha, Avion avion) {
        this.ruta = ruta;
        this.fecha = fecha;
        this.avion = avion;
        this.tiquetes = new ArrayList<>();
        this.realizado = false;
    }

    public String getFecha() {
        return fecha;
    }

    public Ruta getRuta() {
        return ruta;
    }
    
    public String getCodigoRuta() {
    	return ruta.getCodigoRuta();
    }

    public Avion getAvion() {
        return avion;
    }

    public List<Tiquete> getTiquetes() {
        return tiquetes;
    }
    
    public boolean getRealizado() {
 	   return realizado;
    }
  
    public int calcularDistanciaVuelo() {
        return this.ruta.calcularDistancia();
    }
    
    public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) {
        int tarifa = calculadora.calcularTarifa(this, cliente);

        for (int i = 0; i < cantidad; i++) {
            Tiquete tiquete = new Tiquete("TQ" + System.nanoTime(), this, cliente, tarifa);
            tiquetes.add(tiquete);
            cliente.agregarTiquete(tiquete);
        }
        return tarifa * cantidad;
    }

    public int getCapacidadDisponible() {
        return avion.getCapacidad() - tiquetes.size();
    }

    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
    }
    
    
        
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vuelo vuelo = (Vuelo) obj;
        return fecha.equals(vuelo.fecha) && ruta.equals(vuelo.ruta);
    }
}
