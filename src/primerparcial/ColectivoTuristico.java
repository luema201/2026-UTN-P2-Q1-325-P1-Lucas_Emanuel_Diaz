package primerparcial;

public class ColectivoTuristico extends Vehiculo {
    private int cantidadPisos;

    public ColectivoTuristico(String patente, String marca, int capacidadPasajeros, 
                              int anioFabricacion, int cantidadPisos) {
        super(patente, marca, capacidadPasajeros, anioFabricacion);
        this.cantidadPisos = cantidadPisos;
    }

    public int getCantidadPisos() {
        return cantidadPisos;
    }

    @Override
    public void realizarServicio() {
        System.out.println("El colectivo " + getMarca() + " (patente: " + getPatente() +
                           ") está realizando una excursión turística en un vehículo de " +
                           cantidadPisos + " piso/s.");
    }

    @Override
    public String toString() {
        return "[ COLECTIVO ] " + super.toString() + " | Pisos: " + cantidadPisos;
    }
}
