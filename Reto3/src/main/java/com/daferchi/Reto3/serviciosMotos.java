
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
     public Motorbikes update (Motorbikes motorbikes){
        if(motorbikes.getId()!=null){
            Optional<Motorbikes> e= metodosCrud.getMotos(motorbikes.getId());
            if(!e.isEmpty()){
                if(motorbikes.getName()!=null){
                    e.get().setName(motorbikes.getName());
                }
                if(motorbikes.getBrand()!=null){
                    e.get().setBrand(motorbikes.getBrand());
                }
                if(motorbikes.getYear()!=null){
                    e.get().setYear(motorbikes.getYear());
                }
                if(motorbikes.getDescription()!=null){
                    e.get().setDescription(motorbikes.getDescription());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return motorbikes;
            }
        
        }else {
            return motorbikes;
        }
    } 
    public boolean deleteMotorbikes(int motorbikesId){
       Boolean aBoolean = getMotos(motorbikesId) .map (motorbikes ->{
           metodosCrud.delete(motorbikes);
           return true;
       }).orElse(false);
       return aBoolean;
    }
}
