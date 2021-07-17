package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHandler {

    String connectionUrl = "jdbc:mysql://127.0.0.1:3306/todolist?serverTimeZone=UTC";
    String user = "root";
    String password = "root";

    private Connection connection;

    public DBHandler(){
        try {
            connection  = DriverManager.getConnection(connectionUrl,user,password);
        } catch (SQLException e) {
            System.out.println("TODO List is unable to connect to data storage system");
            e.printStackTrace();
        }
    }
    public Connection getConnection(){
        return connection;
    }

}


