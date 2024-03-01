/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.parqueaderoventuraplaza;

import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class ParqueaderoVenturaplaza {

      public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//CANTIDAD DE CUPOS DE PARQUEADERO
        int totalPuestos = 5;
        boolean[] cuposDisponibles = new boolean[totalPuestos];

        // INICIA CON TODOS LOS CUPOS DISPONIBLES 
        for (int i = 0; i < totalPuestos; i++) {
            cuposDisponibles[i] = true;
        }

        while (true) {
            System.out.println("\n*** ----BIENVENIDOS----****");
            System.out.println("\n*** PARQUEADERO VENTURA PLAZA  ***");
            System.out.println("1. Ingreso de carro");
            System.out.println("2. Salida de carro");
            System.out.println("3. Visualizar disponibilidad");
            System.out.println("4. Salir");

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    ingresarCarro(cuposDisponibles);
                    break;
                case 2:
                    salirCarro(cuposDisponibles);
                    break;
                case 3:
                    visualizarDisponibilidad(cuposDisponibles);
                    break;
                case 4:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }

    private static void ingresarCarro(boolean[] cuposDisponibles) {
        for (int i = 0; i < cuposDisponibles.length; i++) {
            if (cuposDisponibles[i]) {
                cuposDisponibles[i] = false;
                System.out.println("Carro ingresado en el cupo " + (i + 1));
                return;
            }
        }
        System.out.println("El parqueadero está lleno. No hay puestos disponibles.");
    }

    private static void salirCarro(boolean[] cuposDisponibles) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de cupo del carro que desea sacar: ");
        int cupos = scanner.nextInt();

        if (cupos>= 1 && cupos <= cuposDisponibles.length) {
            if (!cuposDisponibles[cupos - 1]) {
                cuposDisponibles[cupos - 1] = true;
                System.out.println("Carro retirado del puesto " + cupos);
            } else {
                System.out.println("No hay un carro en el puesto " +cupos);
            }
        } else {
            System.out.println("Número de puesto no válido.");
        }
    }
// CONTADOR DE DISPONIBILIDAD DE CUPOS 
    private static void visualizarDisponibilidad(boolean[] cuposDisponibles) {
        System.out.println("\n*** Disponibilidad de Puestos ***");
        for (int i = 0; i < cuposDisponibles.length; i++) {
            System.out.println(" ZONA-A " + (i + 1) + ": " + (cuposDisponibles[i] ? "Disponible" : "Ocupado"));
        }
    }
}
