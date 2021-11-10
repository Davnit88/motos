
package com.daferchi.Reto3;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface interfaceReservation extends CrudRepository<Reservation,Integer>{

@Query("select c.client, COUNT(c.client)from Reservation AS c group by c.client order by COUNT(c.client)desc")
    public List<Object[]> countTotalReservationByCliente();
    
 public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne,Date dateTwo);

 public List<Reservation> findAllByStatus(String status);
    
}