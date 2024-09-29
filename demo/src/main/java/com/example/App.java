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
        String insert = "INSERT INTO student (id,name) VALUES (1,'Ravi')";
        String update = "UPDATE student SET name='Pavan' WHERE id = 2";
        String delete = "DELETE FROM student WHERE id = 3";
        String select = "SELECT * FROM student";
        // System.out.println( "Hello World!" );
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement st = connection.createStatement();
            int r = st.executeUpdate(insert);
            System.out.println(r+" row inserted!");

            r = st.executeUpdate(update);
            System.out.println(r+" row updated!");

            r = st.executeUpdate(delete);
            System.out.println(r+" row deleted!");

            ResultSet rs = st.executeQuery(select);
            while(rs.next())
            {
                System.out.println(rs.getInt(1)+" : "+rs.getString(2));
            }
            System.out.println("All operations are successfully performed!");
            connection.close();
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
