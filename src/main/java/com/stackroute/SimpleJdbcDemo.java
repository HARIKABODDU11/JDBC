package com.stackroute;

import java.sql.*;


public class SimpleJdbcDemo {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public void getEmployeeDetails() {
        /*Load driver and register with DRiverManager*/

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            /*use driverManager to get Connection*/
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "Root@123");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("Select * from employee");
            while (resultSet.next()) {
                System.out.println( "Name:" + resultSet.getString(1)+"ID: " + resultSet.getInt(2) );
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();

        }finally {

            try {
                connection.close();
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /*Print ResultSet in reverse order*/
    public void getEmployeeDetailsInReverseOrder() {
        try {
            // Load driver and register with driver manager
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "Root@123");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("Select * from employee");
            resultSet.afterLast();
            while (resultSet.previous()) {
                System.out.println( "Name: " + resultSet.getString(1)+"Id: " + resultSet.getInt(2) );
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /*Move ResultSet to second row and print in reverse order*/
    public void getEmployeeDetailsFromSecondRowInReverse() {
        try {
            // Load driver and register with driver manager
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "Root@123");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("Select * from employee");
            resultSet.absolute(2);
            while (resultSet.previous()) {
                System.out.println( "Name: " + resultSet.getString(1)+"Id: " + resultSet.getInt(2));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



    }


    //Use PreparedStatement to display by name and gender

    public void getEmployeeDetailsByNameAndGender(String name,String gender) {
        try {
            // Load driver and register with driver manager
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "Root@123");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("Select * from employee where Name='"+name+"' and gender='" + gender+"'" );
            while (resultSet.next()) {
                System.out.println("Name: " + resultSet.getString(1)+"Id: " + resultSet.getInt(2) + "gender:" +resultSet.getString(3));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



    }



}