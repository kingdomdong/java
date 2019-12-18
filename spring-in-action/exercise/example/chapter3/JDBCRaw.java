package com.example.chapter3;

import tacos.Ingredient;
import tacos.data.IngredientRepository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCRaw implements IngredientRepository {

    private DataSource dataSource;

    @Override
    public Iterable<Ingredient> findAll() {
        return null;
    }

    @Override
    public Ingredient findOne(String id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("select id, name, type from Ingredient");
            statement.setString(1, id);
            resultSet = statement.executeQuery();
            Ingredient ingredient = null;
            if (resultSet.next()) {
                ingredient = new Ingredient(resultSet.getString("id"),
                        resultSet.getString("name"),
                        Ingredient.Type.valueOf(resultSet.getString("type")));
            }
            return ingredient;
        } catch (SQLException e) {
            e.printStackTrace();
            // ??? what should be done here ???
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        return null;
    }

}
