package com.example.service;

import com.example.dao.ClientDao;
import com.example.model.Client;

import java.io.InvalidObjectException;
import java.util.List;

public class ClientService {
    private static ClientDao dao = new ClientDao();
    public static long createByName(String name) throws Exception {
        if(name.length()>1&&name.length()<1000) {
            Client client = new Client(0L, name);
            return dao.createClient(client) + 1;
        }else {
            throw new Exception("invalid name");
        }
    }
    public static String getNameById(long id) throws Exception {
        if(id>0) {
            return dao.readClient(id).getName();
        }else {
            throw new Exception("invalid id");
        }
    }

    public static void setName(long id, String name) throws Exception {
        if(name.length()>1&&name.length()<1000 && id>0) {
            Client client = new Client(id, name);
             dao.updateClient(client) ;
        }else {
            throw new Exception("invalid name");
        }
    }
    public static void deleteById(long id) throws Exception {
        if(id>0) {
            dao.deleteClient(id);
        }else {
            throw new Exception("invalid id");
        }

    }

    public static List<Client> listAll(){
        return dao.readAllClients();
    }
}
