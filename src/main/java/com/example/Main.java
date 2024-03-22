package com.example;

import com.example.dao.ClientDao;
import com.example.database.Database;
import com.example.model.Client;
import com.example.service.ClientService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(ClientService.listAll());
        System.out.println(ClientService.createByName("Robertos"));
        System.out.println(ClientService.getNameById(5L));
        ClientService.setName(1L,"Nasty");
        ClientService.deleteById(6L);
        System.out.println(ClientService.listAll());



    }
}