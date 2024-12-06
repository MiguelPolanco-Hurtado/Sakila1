package com.sakila.data;

import com.sakila.models.Actor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActorDataPost extends DataContext<Actor> {

    @Override
    protected String getTableName() {
        return "actor";  // Nombre de la tabla
    }

    @Override
    protected Actor mapRow(ResultSet rs) throws SQLException {
        int actorId = rs.getInt("actor_id");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        return new Actor(actorId, firstName, lastName);
    }

    @Override
    public void post(Actor actor) {
        String query = "INSERT INTO actor (first_name, last_name) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, actor.getFirstName());
            stmt.setString(2, actor.getLastName());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Actor get(int id) {
        String query = "SELECT * FROM actor WHERE actor_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapRow(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void put(Actor actor) {
        String query = "UPDATE actor SET first_name = ?, last_name = ? WHERE actor_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, actor.getFirstName());
            stmt.setString(2, actor.getLastName());
            stmt.setInt(3, actor.getActorId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM actor WHERE actor_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Actor> getAll() {
        List<Actor> actors = new ArrayList<>();
        String query = "SELECT * FROM actor";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                actors.add(mapRow(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actors;
    }
}
