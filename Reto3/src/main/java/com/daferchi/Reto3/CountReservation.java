
package com.daferchi.Reto3;


public class CountReservation {
    private Long total;
    private Reservation reservacion;

    public CountReservation(Long total, Reservation reservacion) {
        this.total = total;
        this.reservacion = reservacion;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Reservation getReservacion() {
        return reservacion;
    }

    public void setReservacion(Reservation reservacion) {
        this.reservacion = reservacion;
    }
    
}
