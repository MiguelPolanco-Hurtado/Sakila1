package com.sakila1;

import com.sakila.controllers.ActorController;
import com.sakila.models.Actor;
import com.sakila.reports.Statistics;


import java.util.List;
import java.util.Scanner;

public class ConsoleUI {
    private ActorController actorController;
    private Scanner scanner;

    public ConsoleUI() {
        actorController = new ActorController();
        scanner = new Scanner(System.in);
    }

    
    // este es el menu para seleccionar la opcion que vamos a trabajar
    public void showMenu() {
        while (true) {
            System.out.println("1. Agregar actor");
            System.out.println("2. Ver Actor");
            System.out.println("3. Ver todos los Actores");
            System.out.println("4. Actualizar Actor");
            System.out.println("5. Borrar Actor");
            System.out.println("6. Generar Reporte CSV de Actores");
            System.out.println("7. Generar Reporte JSON de Actores");
            System.out.println("8. Ver Estadísticas");
            System.out.println("9. Exit");
            System.out.println();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    addActor();
                    break;
                case 2:
                    viewActor();
                    break;
                case 3:
                    viewAllActors();
                    break;
                case 4:
                    updateActor();
                    break;
                case 5:
                    deleteActor();
                    break;       
                case 6:
                    actorController.exportActorsToCSV("actors.csv");
                    break;
                case 7:
                    actorController.exportActorsToJSON("actors.json");
                    break;
                case 8:
                    showStatistics();
                    break;
                case 9:
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Elección no válida, inténtalo de nuevo.");
            }
        }
    }

    private void addActor() {
        System.out.println("Introduzca el nombre:");
        String firstName = scanner.nextLine();
        System.out.println("Introduzca el apellido:");
        String lastName = scanner.nextLine();
        actorController.addActor(firstName, lastName);
        System.out.println("¡Actor agregado exitosamente!");
        pause(); // Pausa para ver la información
    }

    private void viewActor() {
        System.out.println("Ingrese el ID del actor:");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline character
        Actor actor = actorController.getActor(id);
        if (actor != null) {
            System.out.println(actor);
        } else {
            System.out.println("Actor no encontrado.");
        }
        pause(); // Pausa para ver la información
    }

    private void viewAllActors() {
        List<Actor> actors = actorController.getAllActors();
        if (actors.isEmpty()) {
            System.out.println("No se encontraron actores.");
        } else {
            for (Actor actor : actors) {
                System.out.println(actor);
            }
        }
        pause(); // Pausa para ver la información
    }

    private void updateActor() {
        System.out.println("Ingrese el ID del actor para actualizar:");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline character
        System.out.println("Ingrese un nuevo nombre:");
        String firstName = scanner.nextLine();
        System.out.println("Ingrese nuevo apellido:");
        String lastName = scanner.nextLine();
        actorController.updateActor(id, firstName, lastName);
        System.out.println("¡Actor actualizado exitosamente!");
        pause(); // Pausa para ver la información
    }

    private void deleteActor() {
        System.out.println("Ingrese el ID del actor para eliminar:");
        int id = scanner.nextInt();
        actorController.deleteActor(id);
        System.out.println("Actor eliminado con éxito!");
        pause(); // Pausa para ver la información
    }

   
    
    private void showStatistics() {
        System.out.println("Total de películas en inventario: " + Statistics.getTotalFilmsInInventory());
        System.out.println("Promedio de películas por actor: " + Statistics.getAverageFilmsPerActor());
        System.out.println("Aging de cuentas por cobrar: " + Statistics.getAgingAccountsReceivable());
        // Agregar más estadísticas según sea necesario
        pause();
    }
    
    private void pause() {
        System.out.println("Presione Enter para continuar...");
        scanner.nextLine(); // Espera hasta que el usuario presione Enter
    }
    
}
