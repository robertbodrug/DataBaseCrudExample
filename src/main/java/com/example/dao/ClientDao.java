package com.example.dao;

import com.example.database.Database;
import com.example.model.Client;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class ClientDao {
    private static final String READ_USER_QUERY = "SELECT name FROM CLIENT WHERE ID =  ?;";
    private static final String READ_ALL_QUERY = "SELECT id,name FROM CLIENT;";
    private static final String DELETE_USER_QUERY = "DELETE FROM CLIENT WHERE ID = ?;";
    private static final String UPDATE_USER_QUERY = "UPDATE CLIENT SET NAME = (?) WHERE ID = ? ; ";
    private static final String CREATE_USER_QUERY = "UPDATE CLIENT SET name=name WHERE id >0;INSERT INTO CLIENT (NAME) VALUES (?);";




    public Client readClient(Long id){
        try (PreparedStatement statement = Database.getConnection().prepareStatement(READ_USER_QUERY)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            Client result = new Client();
            while(resultSet.next()){
                    result.setId(id);
                    result.setName(resultSet.getString(1));

            }
        if(Objects.isNull(result.getId())) {
            System.out.println("Client not found");
        }
        return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Client> readAllClients(){
        try (Statement statement = Database.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(READ_ALL_QUERY);
            List<Client> result = new ArrayList<>();
            while(resultSet.next()){
                result.add(new Client(resultSet.getLong(1),resultSet.getString(2)));
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public long createClient(Client client) {
        try (PreparedStatement statement = Database.getConnection().prepareStatement(CREATE_USER_QUERY)) {
            statement.setString(1,client.getName());
            return statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Client is not created");
            throw new RuntimeException(e);
        }
    }
    public boolean updateClient(Client client) {
        try (PreparedStatement statement = Database.getConnection().prepareStatement(UPDATE_USER_QUERY)) {
            statement.setString(1,client.getName());
            statement.setLong(2,client.getId());
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
