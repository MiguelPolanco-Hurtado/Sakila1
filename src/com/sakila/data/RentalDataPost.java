package com.sakila.data;

import com.sakila.entity.Rental;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class RentalDataPost {
	
	private static final String URL = "jdbc:mysql://localhost:3306/sakila";
    private static final String USER = "root";
    private static final String PASS = "12345";


    public List<Rental> getAll() {
        List<Rental> rentals = new ArrayList<>();
        String query = "SELECT rental_id, rental_date, return_date FROM rental";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int rentalId = rs.getInt("rental_id");
                Date rentalDate = rs.getDate("rental_date");
                Date returnDate = rs.getDate("return_date");
                Rental rental = new Rental(rentalId, rentalDate, returnDate);
                rentals.add(rental);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentals;
    }

    // Método para obtener alquileres por el ID de cliente
    public List<Rental> getByCustomerId(int customerId) {
        List<Rental> rentals = new ArrayList<>();
        String query = "SELECT rental_id, rental_date, return_date FROM rental WHERE customer_id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, customerId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int rentalId = rs.getInt("rental_id");
                Date rentalDate = rs.getDate("rental_fecha");
                Date returnDate = rs.getDate("return_fecha");
                Rental rental = new Rental(rentalId, rentalDate, returnDate);
                rentals.add(rental);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentals;
    }
}

