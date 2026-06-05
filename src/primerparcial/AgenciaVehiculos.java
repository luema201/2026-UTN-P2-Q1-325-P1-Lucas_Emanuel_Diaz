package primerparcial;

import java.util.ArrayList;

public class AgenciaVehiculos {
    private ArrayList<Vehiculo> vehiculos;

    public AgenciaVehiculos() {
        this.vehiculos = new ArrayList<>();
    }

    // agrega

    public void agregarVehiculo(Vehiculo v) {
        if (existePatente(v.getPatente())) {
            System.out.println("Error: ya existe un vehículo con la patente " + v.getPatente() + ".");
            return;
        }
        vehiculos.add(v);
        System.out.println("Vehículo agregado correctamente.");
    }

    // muestraa todo

    public void mostrarTodos() {
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
            return;
        }
        for (Vehiculo v : vehiculos) {
            System.out.println(v);
        }
    }

    // realiza servicio

    public void realizarServicios() {
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
            return;
        }
        for (Vehiculo v : vehiculos) {
            v.realizarServicio();
        }
    }

    // busco patente
    public void buscarPorPatente(String patente) {
        for (Vehiculo v : vehiculos) {
            if (v.getPatente().equalsIgnoreCase(patente)) {
                System.out.println("Vehículo encontrado: " + v);
                return;
            }
        }
        System.out.println("No se encontró ningún vehículo con la patente " + patente + ".");
    }

    // filtro de capacitdad

    public void mostrarPorCapacidadMayorA(int minimo) {
        boolean encontrado = false;
        for (Vehiculo v : vehiculos) {
            if (v.getCapacidadPasajeros() > minimo) {
                System.out.println(v);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No hay vehículos con capacidad mayor a " + minimo + ".");
        }
    }

    // oden en base al año

    public void mostrarOrdenadosPorAnio() {
        ArrayList<Vehiculo> copia = new ArrayList<>(vehiculos);
        for (int i = 0; i < copia.size() - 1; i++) {
            for (int j = 0; j < copia.size() - 1 - i; j++) {
                if (copia.get(j).getAnioFabricacion() < copia.get(j + 1).getAnioFabricacion()) {
                    Vehiculo temp = copia.get(j);
                    copia.set(j, copia.get(j + 1));
                    copia.set(j + 1, temp);
                }
            }
        }
        for (Vehiculo v : copia) {
            System.out.println(v);
        }
    }

    // orden descendente - la capacidad

    public void mostrarOrdenadosPorCapacidad() {
        ArrayList<Vehiculo> copia = new ArrayList<>(vehiculos);
        for (int i = 0; i < copia.size() - 1; i++) {
            for (int j = 0; j < copia.size() - 1 - i; j++) {
                if (copia.get(j).getCapacidadPasajeros() < copia.get(j + 1).getCapacidadPasajeros()) {
                    Vehiculo temp = copia.get(j);
                    copia.set(j, copia.get(j + 1));
                    copia.set(j + 1, temp);
                }
            }
        }
        for (Vehiculo v : copia) {
            System.out.println(v);
        }
    }


    private boolean existePatente(String patente) {
        //metodo de ayuda que lo hice private por que solo ayuda aca
        for (Vehiculo v : vehiculos) {
            
            if (v.getPatente().equalsIgnoreCase(patente)) {
                return true;
            }
        }
        return false;
    }
}
