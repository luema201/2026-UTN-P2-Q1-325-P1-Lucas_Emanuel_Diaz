package primerparcial;

import java.util.Scanner;

public class PrimerParcial {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AgenciaVehiculos agencia = new AgenciaVehiculos();
        int opcion;

        do {
            System.out.println("\n===== SISTEMA DE GESTIÓN DE TRANSPORTE TURÍSTICO =====");
            System.out.println("1. Agregar vehículo");
            System.out.println("2. Mostrar todos los vehículos");
            System.out.println("3. Realizar servicios turísticos");
            System.out.println("4. Buscar vehículo por patente");
            System.out.println("5. Mostrar vehículos con capacidad mayor a un valor");
            System.out.println("6. Mostrar vehículos ordenados por año de fabricación");
            System.out.println("7. Mostrar vehículos ordenados por capacidad de pasajeros");
            System.out.println("8. Salir");
            System.out.print("Ingrese una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    agregarVehiculo(scanner, agencia);
                    break;
                case 2:
                    agencia.mostrarTodos();
                    break;
                case 3:
                    agencia.realizarServicios();
                    break;
                case 4:
                    System.out.print("Ingrese la patente a buscar: ");
                    String patente = scanner.nextLine();
                    agencia.buscarPorPatente(patente);
                    break;
                case 5:
                    System.out.print("Ingrese la capacidad mínima: ");
                    int capacidad = scanner.nextInt();
                    scanner.nextLine();
                    agencia.mostrarPorCapacidadMayorA(capacidad);
                    break;
                case 6:
                    agencia.mostrarOrdenadosPorAnio();
                    break;
                case 7:
                    agencia.mostrarOrdenadosPorCapacidad();
                    break;
                case 8:
                    System.out.println("Saliendo del sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Ingrese un número entre 1 y 8.");
            }

        } while (opcion != 8);

        scanner.close();
    }

    // agrego Vehiculos

    private static void agregarVehiculo(Scanner scanner, AgenciaVehiculos agencia) {
        System.out.println("\n¿Qué tipo de vehículo desea agregar?");
        System.out.println("1. Colectivo turístico");
        System.out.println("2. Van ejecutiva");
        System.out.println("3. Lancha turística");
        System.out.print("Opción: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Patente: ");
        String patente = scanner.nextLine().trim();
        if (patente.isEmpty()) {
            System.out.println("Error: la patente no puede estar vacía.");
            return;
        }

        System.out.print("Marca: ");
        String marca = scanner.nextLine().trim();

        System.out.print("Capacidad de pasajeros: ");
        int capacidad = scanner.nextInt();
        scanner.nextLine();
        if (capacidad <= 0) {
            System.out.println("Error: la capacidad debe ser mayor a cero.");
            return;
        }

        System.out.print("Año de fabricación: ");
        int anio = scanner.nextInt();
        scanner.nextLine();
        if (anio < 1990 || anio > 2026) {
            System.out.println("Error: el año debe estar entre 1990 y 2026.");
            return;
        }

        switch (tipo) {
            case 1:
                System.out.print("Cantidad de pisos (1 o 2): ");
                int pisos = scanner.nextInt();
                scanner.nextLine();
                if (pisos != 1 && pisos != 2) {
                    System.out.println("Error: la cantidad de pisos debe ser 1 o 2.");
                    return;
                }
                agencia.agregarVehiculo(new ColectivoTuristico(patente, marca, capacidad, anio, pisos));
                break;

            case 2:
                System.out.print("¿Tiene aire acondicionado? (1 = Sí / 2 = No): ");
                int aire = scanner.nextInt();
                scanner.nextLine();
                if (aire != 1 && aire != 2) {
                    System.out.println("Error: ingrese 1 para Sí o 2 para No.");
                    return;
                }
                agencia.agregarVehiculo(new VanEjecutiva(patente, marca, capacidad, anio, aire == 1));
                break;

            case 3:
                System.out.println("Tipo de motor (1 = NAFTA / 2 = DIESEL / 3 = ELECTRICO): ");
                int motor = scanner.nextInt();
                scanner.nextLine();
                TipoMotor tipoMotor;
                if (motor == 1) {
                    tipoMotor = TipoMotor.NAFTA;
                } else if (motor == 2) {
                    tipoMotor = TipoMotor.DIESEL;
                } else if (motor == 3) {
                    tipoMotor = TipoMotor.ELECTRICO;
                } else {
                    System.out.println("Error: tipo de motor inválido.");
                    return;
                }
                agencia.agregarVehiculo(new LanchaTuristica(patente, marca, capacidad, anio, tipoMotor));
                break;

            default:
                System.out.println("Tipo de vehículo inválido.");
        }
    }
}
