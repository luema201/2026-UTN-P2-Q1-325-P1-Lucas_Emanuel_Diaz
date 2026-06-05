package primerparcial;

public class VanEjecutiva extends Vehiculo {
    private boolean aireAcondicionado;

    public VanEjecutiva(String patente, String marca, int capacidadPasajeros, 
                        int anioFabricacion, boolean aireAcondicionado) {
        super(patente, marca, capacidadPasajeros, anioFabricacion);
        this.aireAcondicionado = aireAcondicionado;
    }

    public boolean isAireAcondicionado() {
        return aireAcondicionado;
    }

    @Override
    public void realizarServicio() {
        System.out.println("La van " + getMarca() + " (patente: " + getPatente() +
                           ") está realizando un traslado ejecutivo" +
                           (aireAcondicionado ? " con aire acondicionado." : " sin aire acondicionado."));
    }

    @Override
    public String toString() {
        return "[ VAN ] " + super.toString() + " | Aire acondicionado: " + 
               (aireAcondicionado ? "Sí" : "No");
    }
}
