

package com.daferchi.Reto3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class RepositorioReservation {
    @Autowired
    private interfaceReservation crud;
    public List<Reservation> getAll(){
        return (List<Reservation>) crud.findAll();
    }
    
    public Optional <Reservation> getReservation(int id){
        return crud.findById(id);
       
    }
    public Reservation save(Reservation reservation){
        return crud.save(reservation);
    }

    void delete(Reservation reservation) {
        crud.delete(reservation);
    }
    public List<Reservation> getReservationByStatus(String status){
      return crud.findAllByStatus(status);
    }
    public List<Reservation> getReservationPeriod(Date dateOne,Date dateTwo){
        return crud.findAllByStartDateAfterAndStartDateBefore(dateOne, dateTwo);
    }
    public List<CountCliente>getTopCliente(){
        List<CountCliente> res=new ArrayList<>();
        
       List<Object[]> report=crud.countTotalReservationByCliente();
       for(int i=0;i<report.size();i++){
           /*
           Reservation cat=(Reservation) report.get(i)[0];
       Long cantidad=(Long) report.get(i)[1];
       CountReservation cr=new CountReservation(cantidad,cat);
       res.add(cr);
       */
       res.add(new CountCliente((Long)report.get(i)[1],(Cliente)report.get(i)[0]));
       }
       return res;
    }
     
}
