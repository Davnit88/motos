
package com.daferchi.Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class serviciosMotos {
    @Autowired
    private RepositorioMotos metodosCrud;
    
    public List<Motorbikes> getAll(){
        return metodosCrud.getAll();
    }
    public Optional<Motorbikes> getMotos (int idMotorbikes){
        return metodosCrud.getMotos(idMotorbikes);
    }
    
    public Motorbikes save (Motorbikes motorbikes){
        if (motorbikes.getId()==null){
            return metodosCrud.save(motorbikes);   
        }else{
            Optional<Motorbikes> evt=metodosCrud.getMotos(motorbikes.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(motorbikes);
            }else{
                return motorbikes;
            }
        }
    }
}
