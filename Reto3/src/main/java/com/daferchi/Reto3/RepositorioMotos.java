
package com.daferchi.Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioMotos {
    @Autowired
    private interfaceMotos crud;
    public List<Motorbikes> getAll(){
        return (List<Motorbikes>) crud.findAll();
    }
    
    public Optional <Motorbikes> getMotos(int id){
        return crud.findById(id);
       
    }
    public Motorbikes save(Motorbikes motorbikes){
        return crud.save(motorbikes);
    }
}
