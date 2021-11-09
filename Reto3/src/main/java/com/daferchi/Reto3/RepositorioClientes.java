

package com.daferchi.Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class RepositorioClientes {
    @Autowired
    private interfaceClientes crud;
    public List<Cliente> getAll(){
        return (List<Cliente>) crud.findAll();
    }
    
    public Optional <Cliente> getClientes(int id){
        return crud.findById(id);
       
    }
    public Cliente save(Cliente client){
        return crud.save(client);
    }
     void delete(Cliente client) {
        crud.delete(client);
    }
}
