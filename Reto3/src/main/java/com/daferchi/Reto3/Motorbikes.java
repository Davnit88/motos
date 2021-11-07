package com.daferchi.Reto3;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="motorbikes")
/**
 *
 * @author David F. Chingate
 */
public class Motorbikes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String brand;
    private Integer year;
    private String description;

    @ManyToOne
    @JoinColumn(name= "categoryId")
    @JsonIgnoreProperties("motorbikes")
    private Category category;
    
      @OneToMany (cascade= {CascadeType.PERSIST},mappedBy="motorbike")
    @JsonIgnoreProperties({"motorbike","client"})
    private List <Messages> messages;
      
       @OneToMany (cascade= {CascadeType.PERSIST},mappedBy="motorbike")
    @JsonIgnoreProperties("motorbike")
    private List <Reservation> reservation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Messages> getMessages() {
        return messages;
    }

    public void setMessages(List<Messages> messages) {
        this.messages = messages;
    }

    public List<Reservation> getReservations() {
        return reservation;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservation = reservations;
    }

   
     

    
    
}
