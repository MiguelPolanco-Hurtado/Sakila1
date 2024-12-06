package com.sakila.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class DataContext<T> implements IDataPost<T> {
    protected Connection connection;

    public DataContext() {
        this.connection = DatabaseConnection.getConnection();  // Obtención de conexión
    }

    @Override
    public void post(T entity) {
        // Implementación concreta para insertar
    }

    @Override
    public T get(int id) {
        // Implementación concreta para obtener un solo dato
        return null;
    }

    @Override
    public List<T> getAll() {
        // Implementación concreta para obtener todos los datos
        return new ArrayList<>();
    }

    @Override
    public void put(T entity) {
        // Implementación concreta para actualizar
    }

    @Override
    public void delete(int id) {
        // Implementación concreta para eliminar
    }

    protected abstract String getTableName();   // Nombre de la tabla
    protected abstract T mapRow(ResultSet rs) throws SQLException;  // Mapear los resultados
}
