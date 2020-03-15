package com.example.mid.Dao;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DetailMapper implements RowMapper<Detail> {

    @Override
    public Detail mapRow(ResultSet resultSet, int i) throws SQLException {
        Detail detail = new Detail(resultSet.getInt("id"),
                resultSet.getString("name"),resultSet.getDouble("price"));

        return detail;
    }
}
