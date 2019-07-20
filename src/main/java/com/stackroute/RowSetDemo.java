package com.stackroute;



import com.sun.rowset.JdbcRowSetImpl;

import javax.sql.rowset.*;
import java.sql.*;

/**
 * Java Program to illustrate how to use RowSet, RowSetProvider, and RowSetFactory in JDBC
 * In this example, RowSet is used to retrieve data from database instead of ResultSet.
 * @author Javin Paul
 */
public class RowSetDemo {
    private Connection connection;

    public void getEmployeeDetails() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "Root@123");
            JdbcRowSet jdbcRowSet = new JdbcRowSetImpl(connection);
            jdbcRowSet.setCommand("Select * from employee"); // set properties
            jdbcRowSet.setUrl("jdbc:mysql://localhost:3306/employeedb"); // connect to database
            jdbcRowSet.setUsername("root");
            jdbcRowSet.setPassword("Root@123");
            jdbcRowSet.execute();

            while (jdbcRowSet.next()) {
                System.out.println("Name: " + jdbcRowSet.getString(1) + "Id:" + jdbcRowSet.getInt(2) + "gender: " + jdbcRowSet.getString(3));
            }
        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}





