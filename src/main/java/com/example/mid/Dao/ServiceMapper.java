package com.example.mid.Dao;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceMapper implements RowMapper<Service> {

    @Override
    public Service mapRow(ResultSet resultSet, int i) throws SQLException {
        Service service = new Service(resultSet.getInt("id"),
                resultSet.getString("name"),resultSet.getDouble("price"));

        return service;
    }
}