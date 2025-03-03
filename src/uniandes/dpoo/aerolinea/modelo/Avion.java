package uniandes.dpoo.aerolinea.modelo;

public class Avion {
	private String modelo;
    private int capacidad;

    public Avion(String modelo, int capacidad) {
        this.modelo = modelo;
        this.capacidad = capacidad;
        }

    public String getModelo() {
		return modelo;
    }
  
    
	public int getCapacidad() {
		return capacidad;
	}

}
