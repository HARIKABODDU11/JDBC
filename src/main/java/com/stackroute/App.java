package com.stackroute;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SimpleJdbcDemo simpleJdbcDemo=new SimpleJdbcDemo();
        System.out.println( "---------------Employee Details-------------------" );
        simpleJdbcDemo.getEmployeeDetails();
        System.out.println("----------------EmployeeDetails in reverse order----------------");
        simpleJdbcDemo.getEmployeeDetailsInReverseOrder();
        System.out.println("-----------------EmployeeDetailsFromSecondRowInReverse---------------");
        simpleJdbcDemo.getEmployeeDetailsFromSecondRowInReverse();
        System.out.println("-----------------EmployeeDetailsByNameAndGender---------------------");
        simpleJdbcDemo.getEmployeeDetailsByNameAndGender("harika","female");


        RowSetDemo rowSetDemo=new RowSetDemo();
        System.out.println("-----------------------RowSetDemo--------------------------------");
        rowSetDemo.getEmployeeDetails();


        ResultSetMetadataDemo resultSetMetadataDemo=new ResultSetMetadataDemo();
        System.out.println("-------------------------------ResultSetMetadataDemo---------------------------------");
        resultSetMetadataDemo.getEmployeeDetails();


        DatabaseMetadataDemo databaseMetadataDemo=new DatabaseMetadataDemo();
        System.out.println("---------------------DatabaseMetadataDemo-------------------------");
        databaseMetadataDemo.getEmployeeDetails();



        JdbcBatchDemo jdbcBatchDemo=new JdbcBatchDemo();
        System.out.println("-----------------------------JdbcBatchDemo -----------------------");
        jdbcBatchDemo.getEmployeeDetails();



        JdbcTransactionDemo jdbcTransactionDemo=new JdbcTransactionDemo();
        System.out.println("----------------------------------JdbcTransactionDemo-----------------------");
        jdbcTransactionDemo.getEmployeeDetails();


    }
}
