package com.servlets;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
    private static final ConnectionManager INCTANCE = new ConnectionManager();
    public static final String URL_DB = "db.url";
    public static final String USER_DB = "db.username";
    public static final String USER_PASSWORD_DB = "db.password";

    static {
        loadDriver();
    }

    @SneakyThrows
    public static Connection openConnection(){
        return DriverManager.getConnection(PropertiesUtil.getProperty(URL_DB),
                PropertiesUtil.getProperty(USER_DB),
                PropertiesUtil.getProperty(USER_PASSWORD_DB));
    }
    @SneakyThrows
    private static void loadDriver() {

        Class.forName("org.postgresql.Driver");

    }

}
