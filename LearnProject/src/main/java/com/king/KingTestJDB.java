package com.king;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class KingTestJDB {
    final static String user = "root";
    final static String pwd = "123456";
    static String dbName = "kingtest";
    static String tableNameOne = "memberships";    
    static String URL = "jdbc:mysql://localhost/" + dbName +
            "?useUnicode=true" + 
            "&characterEncoding=utf-8" +
            "&verifyServerCertificate=false" + // is set to bypass certificate validation
            "&useSSL=true" + // added to the JDBC URL to attempt to communicate via SSL
            "&requireSSL=false"; // added to only connect if the database server supports SSL

    static PrintWriter writer = new PrintWriter(System.out);
    
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection connection = DriverManager.getConnection(URL, user, pwd);
            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM " + tableNameOne;
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Integer numColumns = resultSet.getMetaData().getColumnCount();
                writer.println(resultSet.getRow() + ":");
                for (int index = 1; index <= numColumns; index++) {
                    writer.println(String.format("\t%-20s%s", resultSet.getMetaData().getColumnName(index), resultSet.getObject(index)));
                    //                    writer.flush(); // way 1
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.close(); // way 2
        }

    }

}
