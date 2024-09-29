package com.example;
import java.sql.*;
/**
 * Hello world!
 * @author Shaad Bangi
 * @version 1.1
 * @since 2024
 */
public class App 
{
    public static void main( String[] args )
    {
        String url = "jdbc:postgresql://localhost:5432/practice";
        String username = "postgres";
        String password = "Shaad#98";
        System.out.println( "Hello World!" );
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection is Successful!");
            connection.close();
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
