package com.stackroute;

import java.sql.*;

public class DatabaseMetadataDemo {
    public void getEmployeeDetails(){
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/employeedb","root","Root@123");
        DatabaseMetaData dbmd=con.getMetaData();

        System.out.println("Driver Name: "+dbmd.getDriverName());
        System.out.println("Driver Version: "+dbmd.getDriverVersion());
        System.out.println("UserName: "+dbmd.getUserName());
        System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());
        System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());

        String table[]={"TABLE"};
        ResultSet rs=dbmd.getTables(null,null,null,table);

        while(rs.next()){
            System.out.println(rs.getString(3));
        }

        con.close();
    }catch (ClassNotFoundException ex) {
        ex.printStackTrace();
    }
    catch (SQLException ex) {
        ex.printStackTrace();
    }
    }
}
