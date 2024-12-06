package com.sakila.reports;

import com.sakila.models.Actor;
import com.sakila.entity.Film;
import com.sakila.entity.Customer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import com.google.gson.Gson;

public class ReportGenerator {

    // Exporta actores a CSV
    public static void exportToCSV(List<Actor> actors, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.append("ActorID,Nombre,Apellido\\n");
            for (Actor actor : actors) {
                writer.append(String.valueOf(actor.getActorId()))
                        .append(",")
                        .append(actor.getFirstName())
                        .append(",")
                        .append(actor.getLastName())
                        .append("\n");
            }
            System.out.println("Exportación CSV exitosa.");
            
            System.out.println("Presione Enter para continuar...");
            try {
                System.in.read(); // Espera a que el usuario presione Enter
            } catch (IOException e) {
                e.printStackTrace();
            }
       
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Exporta actores a JSON
    public static void exportToJSON(List<Actor> actors, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            Gson gson = new Gson();
            gson.toJson(actors, writer);
            System.out.println("Exportación JSON exitoso.");
            
            System.out.println("Presione Enter para continuar...");
            try {
                System.in.read(); // Espera a que el usuario presione Enter
            } catch (IOException e) {
                e.printStackTrace();
            }
       
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Métodos adicionales para otras tablas como Films, Customers, etc., podrían añadirse aquí.
}
