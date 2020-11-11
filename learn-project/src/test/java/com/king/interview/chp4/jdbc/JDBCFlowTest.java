package com.king.interview.chp4.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Access steps of JDBC
 *
 * @author Yum
 * @version 1.0
 * @since 2020-09-12 10:47:00
 */
public class JDBCFlowTest {

    @Test
    void should_JDBC_connect_correct_with_driver() {
        String userName = "root";
        String password = "tool18795957519";
        String url = "jdbc:mysql://localhost:3306/Test";
        String driver = "com.mysql.cj.jdbc.Driver";

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(url, userName, password); Statement statement = connection.createStatement()) {
            statement.execute("INSERT INTO Employee values (1, 'Conner', 25)");
            statement.execute("INSERT INTO Employee values (2, 'Spancer', 65)");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Employee LIMIT 5");
            assertEquals(resultSet.getInt(1), 1);
            assertEquals(resultSet.getString(2), "Conner");
            assertEquals(resultSet.getString(3), 25);
            assertEquals(resultSet.getInt(2), 2);
            assertEquals(resultSet.getString(2), "Spancer");
            assertEquals(resultSet.getString(3), 65);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
