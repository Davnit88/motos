
package com.daferchi.Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class serviciosCliente {
     @Autowired
    private RepositorioClientes metodosCrud;
    
    public List<Cliente> getAll(){
         return metodosCrud.getAll();
    }
    
    public Optional<Cliente> getCliente(int idClient){
        return metodosCrud.getClientes(idClient);
    }
    
    
    public Cliente save(Cliente client){
        if(client.getIdClient()==null){
            return metodosCrud.save(client);
        }else{
            Optional<Cliente> evt=metodosCrud.getClientes(client.getIdClient());
            if(evt.isEmpty()){
            return metodosCrud.save(client);
            }else{
                return client;
            }
        
        
        }
    
    }
}
