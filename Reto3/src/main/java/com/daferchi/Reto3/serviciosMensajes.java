
package com.daferchi.Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class serviciosMensajes {
     @Autowired
    private RepositorioMensajes metodosCrud;
    
    public List<Messages> getAll(){
         return metodosCrud.getAll();
    }
    
    public Optional<Messages> getMessages(int idMessage){
        return metodosCrud.getMessages(idMessage);
    }
    
    
    public Messages save(Messages messages){
        if(messages.getIdMessage()==null){
            return metodosCrud.save(messages);
        }else{
            Optional<Messages> evt=metodosCrud.getMessages(messages.getIdMessage());
            if(evt.isEmpty()){
            return metodosCrud.save(messages);
            }else{
                return messages;
            }

        }
    }
    public Messages update (Messages messages){
        if(messages.getIdMessage()!=null){
            Optional<Messages> e= metodosCrud.getMessages(messages.getIdMessage());
            if(!e.isEmpty()){
                if(messages.getMessageText()!=null){
                    e.get().setMessageText(messages.getMessageText());
                }
               
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return messages;
            }
        
        }else {
            return messages;
        }
    } 
    public boolean deleteMessages(int messagesId){
       Boolean aBoolean = getMessages(messagesId) .map (messages ->{
           metodosCrud.delete(messages);
           return true;
       }).orElse(false);
       return aBoolean;
    }
}
