package travelThruAir;

import java.sql.*;  
import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

// this class will handle Database connections, we will write following methods
// getDeals
// addDeal
// getFlights

public class Database{
    private static String username = "root";
    private static String password = "";
    private static String connection_url = "jdbc:mysql://localhost:3306/travelthruair";

    public static ArrayList<Deals> getDeals(){
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection(connection_url,username,password);  
            Statement stmt=con.createStatement();  
            int now = LocalDateTime.now().getHour()*100 + LocalDateTime.now().getMinute();
            String sql_stmt = "select * from deals where expiry>"+ Integer.toString(now);
            System.out.println(sql_stmt);
            ResultSet rs=stmt.executeQuery(sql_stmt);  
            ArrayList<Deals> results = new ArrayList<>();
            while(rs.next())  
                results.add(new Deals(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
            con.close();  
            return results;
        }
        catch(Exception e){
            System.out.println(e);
        }               
        return null;
    }

    public static void addDeal(String depart, String arrival, int price, int expiryTime){
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection(connection_url,username,password);  
            Statement stmt=con.createStatement();  
            String sql_query = "INSERT INTO `deals` (`departure`, `arrival`, `discount`, `expiry`, `description`) VALUES ('" + depart + "', '" + arrival + "', '" + Integer.toString(price) + "', '" + Integer.toString(expiryTime) + "', '');";
            System.out.println(sql_query);
            stmt.executeUpdate(sql_query);  
            
            con.close();  
            return;
        }
        catch(Exception e){
            System.out.println(e);
        }               
    }
    
    public static void main(){  
        int i = 1;
    }
    // public static void addDeal(String depart, String arrival, int price, int expiryTime){

    // }
}