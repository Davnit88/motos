
package com.daferchi.Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class serviciosCategoria {
     @Autowired
    private RepositorioCategoria metodosCrud1;
    
    public List<Category> getAll(){
         return metodosCrud1.getAll();
    }
    
    public Optional<Category> getCategoria(int id){
        return metodosCrud1.getCategoria(id);
    }
    
    
    public Category save(Category categoria){
        if(categoria.getId()==null){
            return metodosCrud1.save(categoria);
        }else{
            Optional<Category> evt=metodosCrud1.getCategoria(categoria.getId());
            if(evt.isEmpty()){
            return metodosCrud1.save(categoria);
            }else{
                return categoria;
            }

        }
    }
    public Category update (Category categoria){
        if(categoria.getId()!=null){
            Optional<Category> e= metodosCrud1.getCategoria(categoria.getId());
            if(!e.isEmpty()){
                if(categoria.getName()!=null){
                    e.get().setName(categoria.getName());
                }
                if(categoria.getDescription()!=null){
                    e.get().setDescription(categoria.getDescription());
                }
                
                metodosCrud1.save(e.get());
                return e.get();
            }else{
                return categoria;
            }
        
        }else {
            return categoria;
        }
    } 
    public boolean deleteCategory(int categoriaId){
       Boolean aBoolean = getCategoria(categoriaId) .map (categoria ->{
           metodosCrud1.delete(categoria);
           return true;
       }).orElse(false);
       return aBoolean;
    }
}
