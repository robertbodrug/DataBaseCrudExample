package com.example;

import com.example.dao.ClientDao;
import com.example.database.Database;
import com.example.model.Client;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Client baby = new Client(9L, "Baby");
        ClientDao clientDao = new ClientDao();

        System.out.println(clientDao.createClient(baby));
        System.out.println(clientDao.readClient(9L).toString());
        baby.setName("Bababbaba");
        System.out.println(clientDao.updateClient(baby));
        System.out.println(clientDao.readClient(9L).toString());
        System.out.println(clientDao.deleteClient(9L));
        System.out.println(clientDao.readClient(9L).toString());

    }
}