package com.example;
import java.sql.*;
import java.util.*;
public class PreparedStatementExample {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:postgresql://localhost:5432/practice";
        String username = "postgres";
        String password = "Shaad#98";
        String insert = "INSERT INTO student VALUES (?,?)";
        String update = "UPDATE student SET name=? WHERE id =?";
        String delete = "DELETE FROM student WHERE id = ?";
        String select = "SELECT * FROM student WHERE id = ?";
        int ch,id,r;
        String name;
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement ps;
        ResultSet rs ; 

        try{

            // How Single Prepared Statement can Use Multiple Times (No Use)

            // PreparedStatement ps = connection.prepareStatement(insert);
            // ps.setInt(1, 12);
            // ps.setString(2, "Shaad");
            // int r = ps.executeUpdate();
            // System.out.println(r+" row inserted!");

            // ps = connection.prepareStatement(update);
            // ps.setString(1, "Kamal");
            // ps.setInt(2, 5);
            // r = ps.executeUpdate();
            // System.out.println(r+" row updated!");

           while(true)
           {
            System.out.print("1.Insert\n2.Update\n3.Delete\n4.Select\n5.Exit\nEnter Your Choice : ");
            ch = sc.nextInt();
            switch(ch)
            {
                case 1->{
                    ps = connection.prepareStatement(insert);
                    System.out.print("Enter your id : ");
                    id = sc.nextInt();
                    sc.nextLine();
                    ps.setInt(1,id);
                    System.out.print("Enter your name : ");
                    name = sc.nextLine();
                    ps.setString(2, name);
                    r = ps.executeUpdate();
                    System.out.println(r+" row inserted!");
                }
                case 2->{
                    ps = connection.prepareStatement(update);
                    System.out.print("Enter your id : ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new name :  ");
                    name = sc.nextLine();
                    ps.setString(1, name);
                    ps.setInt(2, id);
                    r = ps.executeUpdate();
                    System.out.println(r+" row updated!");

                }
                case 3->{
                    ps = connection.prepareStatement(delete);
                    System.out.print("Enter id : ");
                    id = sc.nextInt();
                    ps.setInt(1, id);
                    r = ps.executeUpdate();
                    System.out.println(r+" row deleted!");
                }
                case 4->{
                    ps = connection.prepareStatement(select);
                    System.out.print("Enter id to get data of student : ");
                    id = sc.nextInt();
                    ps.setInt(1, id);
                    rs = ps.executeQuery();
                    while(rs.next())
                    {
                        System.out.println(rs.getInt(1)+" : "+rs.getString("name"));
                    }
                }
                case 5->{
                    connection.close();
                    sc.close();
                    System.exit(0);
                }
                default->{
                    System.out.println("Wrong Choice!");
                }
            }
           }
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
