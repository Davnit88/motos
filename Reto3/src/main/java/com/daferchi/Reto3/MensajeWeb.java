
package com.daferchi.Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class MensajeWeb {
     @Autowired
    private serviciosMensajes servicios;
    @GetMapping("/all")
    public List <Messages> getMensajes(){
        return servicios.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Messages> getMensajes(@PathVariable("id") int idMessage) {
        return servicios.getMessages(idMessage);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Messages save(@RequestBody Messages messages) {
        return servicios.save(messages);
    } 
      @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Messages update(@RequestBody Messages messages) {
        return servicios.update(messages);
    } 
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteMessages(@PathVariable("id") int idMessages) {
        return servicios.deleteMessages(idMessages);
    }
}