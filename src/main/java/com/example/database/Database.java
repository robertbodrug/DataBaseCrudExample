package com.example.database;

import com.example.config.DatabaseConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public final class Database {
    private static Connection connection;


    private Database(){

    }

    public static Connection getConnection(){
        if (Objects.isNull(connection)){
            try {
                connection = DriverManager.getConnection(DatabaseConfig.getDbUrl(),DatabaseConfig.getDbUsername(),DatabaseConfig.getDbPassword());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return connection;
    }

}

