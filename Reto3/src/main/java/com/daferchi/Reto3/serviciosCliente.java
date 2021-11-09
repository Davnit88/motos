
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
    public Cliente update (Cliente client){
        if(client.getIdClient()!=null){
            Optional<Cliente> e= metodosCrud.getClientes(client.getIdClient());
            if(!e.isEmpty()){
                if(client.getName()!=null){
                    e.get().setName(client.getName());
                }
                if(client.getEmail()!=null){
                    e.get().setEmail(client.getEmail());
                }
                if(client.getPassword()!=null){
                    e.get().setPassword(client.getPassword());
                }
                if(client.getMessages()!=null){
                    e.get().setMessages(client.getMessages());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return client;
            }
        
        }else {
            return client;
        }
    } 
    public boolean deleteCliente(int clientId){
       Boolean aBoolean = getCliente(clientId) .map (client ->{
           metodosCrud.delete(client);
           return true;
       }).orElse(false);
       return aBoolean;
    }
}
