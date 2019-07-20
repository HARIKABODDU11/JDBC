package com.stackroute;

import java.sql.*;

public class ResultSetMetadataDemo {
    public void getEmployeeDetails() {
        {
            try {

                Class.forName("com.mysql.cj.jdbc.Driver");

                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "Root@123");

                Statement statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery("Select * from employee");

                while (resultSet.next()) {
                    System.out.println("Name:" + resultSet.getString(1) + " Id:" + resultSet.getInt(2) + " gender:" + resultSet.getString(3));
                }

                ResultSetMetaData rsmd = resultSet.getMetaData();

                //getting number of columns in  resultset
                System.out.println("Total columns: "+rsmd.getColumnCount());
                System.out.println("Column Name of 1st column: "+rsmd.getColumnName(1));
                System.out.println("Column Type Name of 1st column: "+rsmd.getColumnTypeName(1));


            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}



