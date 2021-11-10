
package com.daferchi.Reto3;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface interfaceReservation extends CrudRepository<Reservation,Integer>{

@Query("select c.status, COUNT(c.status)from Reservation AS c group by c.status order by COUNT(c.status)desc")
    public List<Object[]> countTotalReservationByStatus();
    
 public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne,Date dateTwo);

 public List<Reservation> findAllByStatus(String status);
    
}