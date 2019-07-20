package com.stackroute;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import java.sql.*;
import java.util.Scanner;

public class JdbcTransactionDemo {

    public void getEmployeeDetails(){
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","Root@123");
            con.setAutoCommit(false);

            PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?)");

            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            while(true){



                System.out.println("enter name");
                String name=br.readLine();



                System.out.println("enter id");
                String s1=br.readLine();
                int id=Integer.parseInt(s1);

                System.out.println("enter gender");
                String name1=br.readLine();

                ps.setString(1,name);
                ps.setInt(2,id);
                ps.setString(3,name1);
                ps.executeUpdate();

                System.out.println("commit/rollback");
                String answer=br.readLine();
                if(answer.equals("commit")){
                    con.commit();
                }
                if(answer.equals("rollback")){
                    con.rollback();
                }


                System.out.println("Want to add more records y/n");
                String ans=br.readLine();
                if(ans.equals("n")){
                    break;
                }

            }
            con.commit();
            System.out.println("record successfully saved");

            con.close();//before closing connection commit() is called
        }catch(Exception e){System.out.println(e);}

    }

    }