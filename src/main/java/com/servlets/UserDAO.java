package com.servlets;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static final UserDAO INCTANCE = new UserDAO();

    private static final String SQL_FIND_ALL = "SELECT" +
            " id, first_name, last_name, age" +
            " FROM users";

    private static final String SQL_SAVE = "INSERT INTO users (first_name, last_name, age)" +
            " VALUES (?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE users "+
            "SET first_name = ?, "+
            "last_name = ?, "+
            "age = ? "+
            "WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM users "+
            "WHERE id = ?";


    @SneakyThrows
    public List<User> findAll() {
        try (Connection connection = ConnectionManager.openConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ALL)) {


            ResultSet resultSet = preparedStatement.executeQuery();
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                User user = User.builder()
                        .id(resultSet.getObject("id", Integer.class))
                        .firstName(resultSet.getObject("first_name", String.class))
                        .lastName(resultSet.getObject("last_name", String.class))
                        .age(resultSet.getObject("age", Integer.class))
                        .build();
                users.add(user);
            }
            return users;


        }
    }

    @SneakyThrows
    public void update(User entity) {
        try(Connection connection = ConnectionManager.openConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE)){
            preparedStatement.setObject(1, entity.getFirstName());
            preparedStatement.setObject(2, entity.getLastName());
            preparedStatement.setObject(3, entity.getAge());
            preparedStatement.setObject(4, entity.getId());


            preparedStatement.executeUpdate();

        }

    }
    @SneakyThrows
    public void save (User entity) {
        try (Connection connection = ConnectionManager.openConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SAVE)) {
            preparedStatement.setObject(1, entity.getFirstName());
            preparedStatement.setObject(2, entity.getLastName());
            preparedStatement.setObject(3, entity.getAge());


            preparedStatement.executeUpdate();

        }
    }

    @SneakyThrows
    public void delete (Integer id){
        try (Connection connection = ConnectionManager.openConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE)) {

            preparedStatement.setObject(1, id);

            preparedStatement.executeUpdate();

        }
    }
    public static UserDAO getInctance (){
        return INCTANCE;
    }
}
