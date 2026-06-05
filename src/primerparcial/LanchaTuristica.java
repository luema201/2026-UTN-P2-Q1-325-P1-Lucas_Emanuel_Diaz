package primerparcial;

public class LanchaTuristica extends Vehiculo {
    private TipoMotor tipoMotor;

    public LanchaTuristica(String patente, String marca, int capacidadPasajeros, 
                           int anioFabricacion, TipoMotor tipoMotor) {
        super(patente, marca, capacidadPasajeros, anioFabricacion);
        this.tipoMotor = tipoMotor;
    }

    public TipoMotor getTipoMotor() {
        return tipoMotor;
    }

    @Override
    public void realizarServicio() {
        System.out.println("La lancha " + getMarca() + " (patente: " + getPatente() + 
                           ") está realizando un paseo acuático con motor " + tipoMotor + ".");
    }

    @Override
    public String toString() {
        return "[ LANCHA ] " + super.toString() + " | Motor: " + tipoMotor;
    }
}
