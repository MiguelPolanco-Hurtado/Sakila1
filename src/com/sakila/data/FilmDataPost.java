package com.sakila.data;

import com.sakila.entity.Film;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;




	public class FilmDataPost {
	   
	    private static final String URL = "jdbc:mysql://localhost:3306/sakila";
	    private static final String USER = "root";
	    private static final String PASS = "12345";

    public List<Film> getAll() {
        List<Film> films = new ArrayList<>();
        String query = "SELECT film_id, title, description FROM film";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int filmId = rs.getInt("film_id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                Film film = new Film(filmId, title, description);
                films.add(film);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return films;
    }
}
