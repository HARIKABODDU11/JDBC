package com.stackroute;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcBatchDemo {
    private Connection connection;

public void getEmployeeDetails(){

        /*Load driver and register with DRiverManager*/
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        /*use driverManager to get Connection*/
        connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","Root@123");
        connection.setAutoCommit(false);

        Statement stmt=connection.createStatement();
        stmt.addBatch("insert into employee values('pujitha',12,'female')");
        stmt.addBatch("insert into employee values('neha',21,'female')");

        stmt.executeBatch();
        }

        catch (ClassNotFoundException e) {
        e.printStackTrace();

        try {
        connection.rollback();
        } catch (SQLException ex) {
        ex.printStackTrace();
        }
        }
        catch (SQLException e) {
        e.printStackTrace();
        }
        }
        }
