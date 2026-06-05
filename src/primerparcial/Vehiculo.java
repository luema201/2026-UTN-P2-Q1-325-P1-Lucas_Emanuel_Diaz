package primerparcial;

public abstract class Vehiculo {
    private String patente;
    private String marca;
    private int capacidadPasajeros;
    private int anioFabricacion;

    public Vehiculo(String patente, String marca, int capacidadPasajeros, int anioFabricacion) {
        this.patente = patente;
        this.marca = marca;
        this.capacidadPasajeros = capacidadPasajeros;
        this.anioFabricacion = anioFabricacion;
    }

    // Método abstracto: cada subclase lo implementa a su manera (polimorfismo)
    public abstract void realizarServicio();

    public String getPatente() {
        return patente;
    }

    public String getMarca() {
        return marca;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    @Override
    public String toString() {
        return "Patente: " + patente + " | Marca: " + marca +
               " | Capacidad: " + capacidadPasajeros +
               " | Año: " + anioFabricacion;
    }
}
