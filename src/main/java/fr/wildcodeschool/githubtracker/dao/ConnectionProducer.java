package fr.wildcodeschool.githubtracker.dao;

//import lombok.extern.slf4j.Slf4j;

import javax.annotation.PreDestroy;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

//@Slf4j
@Singleton
public class ConnectionProducer {

    // -------------------------
    // Class unused in the quest
    // -------------------------

    public static final String CONNECTION_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/githubtracker?useUnicode=true&serverTimezone=CET";
    public static final String CONNECTION_USER = "newuser";
    public static final String CONNECTION_PASSWORD = "password";

    private Connection connection;

    static {
        try {
            Class<?> driverClass = Class.forName(CONNECTION_DRIVER);
            DriverManager.registerDriver((Driver)driverClass.newInstance());
        } catch (SQLException | IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            // log.error(e.getMessage(), e);
        }
    }

    @Produces
    public Connection getConnection() throws SQLException {
        if(connection != null && !connection.isValid(2000)) {
            closeConnection();
            connection = null;
        }

        if(connection == null) {
            connection = DriverManager.getConnection(CONNECTION_URL, CONNECTION_USER, CONNECTION_PASSWORD);
            System.out.println("connection created");
        }
        return connection;
    }


    @PreDestroy
    private void closeConnection() {
        try {
            connection.close();
        }
        catch (SQLException e) {
            // log.warn(e.getMessage(), e);
        }
    }
}
