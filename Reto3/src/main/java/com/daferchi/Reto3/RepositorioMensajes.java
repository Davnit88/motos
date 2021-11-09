

package com.daferchi.Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class RepositorioMensajes {
    @Autowired
    private interfaceMensajes crud;
    public List<Messages> getAll(){
        return (List<Messages>) crud.findAll();
    }
    
    public Optional <Messages> getMessages(int id){
        return crud.findById(id);
       
    }
    public Messages save(Messages messages){
        return crud.save(messages);
    }
     void delete(Messages messages) {
        crud.delete(messages);
    }
}
