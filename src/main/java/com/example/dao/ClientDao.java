package com.example.dao;

import com.example.database.Database;
import com.example.model.Client;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;


public class ClientDao {
    private static final String READ_USER_QUERY = "SELECT id,name FROM CLIENT WHERE ID =  ?  ";
    private static final String DELETE_USER_QUERY = "DELETE FROM CLIENT WHERE ID = ? ";
    private static final String UPDATE_USER_QUERY = "UPDATE CLIENT SET ID = ?,NAME = ? WHERE ID=?; ";
    private static final String CREATE_USER_QUERY = "INSERT INTO CLIENT (ID,NAME) SELECT ?,? WHERE NOT EXISTS (SELECT id FROM CLIENT WHERE id = ?);";




    public Client readClient(Long id){
        try (PreparedStatement statement = Database.getConnection().prepareStatement(READ_USER_QUERY)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            Client result = new Client();
            while(resultSet.next()){
                    result.setId(resultSet.getLong(1));
                    result.setName(resultSet.getString(2));

            }
        if(Objects.isNull(result.getId())) {
            System.out.println("Client not found");
        }
        return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public boolean createClient(Client client) {
        try (PreparedStatement statement = Database.getConnection().prepareStatement(CREATE_USER_QUERY)) {
            statement.setLong(1,client.getId());
            statement.setString(2,client.getName());
            statement.setLong(3,client.getId());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Client is not created");
            throw new RuntimeException(e);
        }
    }
    public boolean updateClient(Client client) {
        try (PreparedStatement statement = Database.getConnection().prepareStatement(UPDATE_USER_QUERY)) {
            statement.setLong(1,client.getId());
            statement.setString(2,client.getName());
            statement.setLong(3,client.getId());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Client is not updated");
            throw new RuntimeException(e);
        }
    }


    public boolean deleteClient(Long id) {
        try (PreparedStatement statement = Database.getConnection().prepareStatement(DELETE_USER_QUERY)) {
            statement.setLong(1,id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Client is not deleted");
            throw new RuntimeException(e);
        }
    }
}
