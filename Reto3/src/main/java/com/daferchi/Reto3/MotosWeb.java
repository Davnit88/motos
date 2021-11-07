
package com.daferchi.Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Motorbike")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})


public class MotosWeb {
    @GetMapping("/holamundo")
    public String saludar(){
        return "hola mundo totoria";
    }
    @Autowired
    private serviciosMotos servicios;
    @GetMapping ("/all")
    public List <Motorbikes> getMotos(){
        return servicios.getAll();
    }
    @GetMapping ("/{id}")
    public Optional<Motorbikes> getMotos (@PathVariable("id") int idMotos){
        return servicios.getMotos(idMotos);    
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Motorbikes save (@RequestBody Motorbikes motorbikes){
        return servicios.save(motorbikes);
    }
}
