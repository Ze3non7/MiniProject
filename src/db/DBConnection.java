package db;

import java.sql.*;


public class DBConnection {

    private static DBConnection dbConnection;
    private Connection connection;

    private DBConnection() {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","<Change this to your user>","<Your password>");
            System.out.println("Connected to database");
        }
        catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

    public static DBConnection getInstance() {
        if (dbConnection == null) {
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }

    public Connection getConnection() {
        return connection;
    }
}
