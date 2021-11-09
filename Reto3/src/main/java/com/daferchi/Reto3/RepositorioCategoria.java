
package com.daferchi.Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCategoria {
    @Autowired
    private interfaceCategoria crud1;
    public List<Category> getAll(){
        return (List<Category>) crud1.findAll();
    }
    
    public Optional <Category> getCategoria(int id){
        return crud1.findById(id);
       
    }
    public Category save(Category categoria){
        return crud1.save(categoria);
    }
     void delete(Category categoria) {
        crud1.delete(categoria);
    }
}
