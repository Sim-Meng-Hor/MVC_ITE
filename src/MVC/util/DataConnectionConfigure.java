package MVC.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataConnectionConfigure {
    private static String username = "postgres";
    private static String password = "12345";
    private static String url = "jdbc:postgresql://localhost:5432/ite";

    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(url,username,password);
        }catch (Exception exception){
            throw new RuntimeException("Failed to connect to database: " + exception.getMessage(), exception);
        }
    }
}
