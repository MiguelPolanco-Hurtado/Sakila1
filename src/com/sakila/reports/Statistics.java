package com.sakila.reports;

import com.sakila.data.ActorDataPost;
import com.sakila.data.FilmDataPost;
import com.sakila.data.RentalDataPost;
import com.sakila.models.Actor;
import com.sakila.entity.Film;
import com.sakila.entity.Rental;
import com.sakila.reports.ReportGenerator;
import java.time.LocalDate;
import java.util.List;

public class Statistics {

    // Total de películas en inventario
    public static int getTotalFilmsInInventory() {
        FilmDataPost filmData = new FilmDataPost();
        List<Film> films = filmData.getAll();
        return films.size();
    }

    // Promedio de películas por actor
    public static double getAverageFilmsPerActor() {
        // Se calcularía en base a la relación entre películas y actores
        // Este es un ejemplo simple.
        FilmDataPost filmData = new FilmDataPost();
        int totalFilms = filmData.getAll().size();
        ActorDataPost actorData = new ActorDataPost();
        int totalActors = actorData.getAll().size();
        return (double) totalFilms / totalActors;
    }

    // Aging de cuentas por cobrar (Ejemplo simple: número de días entre la renta y el pago)
    public static double getAgingAccountsReceivable() {
        RentalDataPost rentalData = new RentalDataPost();
        List<Rental> rentals = rentalData.getAll();
        int totalDays = 0;
        for (Rental rental : rentals) {
            // Convertir a LocalDate si es necesario
            LocalDate rentalDate = rental.getRentalDate().toLocalDate(); // Convertir a LocalDate
            LocalDate returnDate = rental.getReturnDate().toLocalDate(); // Convertir a LocalDate
            
            // Calcular días entre la fecha de alquiler y devolución
            totalDays += returnDate.getDayOfYear() - rentalDate.getDayOfYear();
        }
        return (double) totalDays / rentals.size();
    }

    // Renta por cliente
    public static double getRentalsByCustomer(int customerId) {
        RentalDataPost rentalData = new RentalDataPost();
        List<Rental> rentals = rentalData.getByCustomerId(customerId);
        return rentals.size();
    }

    // Pagos por cliente
    public static double getPaymentsByCustomer(int customerId) {
        // Implementar la lógica para obtener los pagos realizados por un cliente
        // Ejemplo: buscar pagos en la base de datos
        return 100.0; // Ejemplo de retorno
    }

    // Renta por tienda (Ejemplo)
    public static double getRentalsByStore(int storeId) {
        // Lógica similar a la anterior
        return 50.0; // Ejemplo de retorno
    }
}
