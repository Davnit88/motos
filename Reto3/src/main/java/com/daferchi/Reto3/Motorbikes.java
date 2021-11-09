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
 /**
 * clase
 */
public class Motorbikes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
 * variable
 */
    private Integer id;
     /**
 * variable
 */
    private String name;
     /**
 * variable
 */
    private String brand;
     /**
 * variable
 */
    private Integer year;
     /**
 * variable
 */
    private String description;

    @ManyToOne
    @JoinColumn(name= "categoryId")
    @JsonIgnoreProperties("motorbikes")
     /**
 * variable
 */
    private Category category;
    
      @OneToMany (cascade= {CascadeType.PERSIST},mappedBy="motorbike")
    @JsonIgnoreProperties({"motorbike","client"})
       /**
 * variable
 */
    private List <Messages> messages;
      
       @OneToMany (cascade= {CascadeType.PERSIST},mappedBy="motorbike")
    @JsonIgnoreProperties("motorbike")
        /**
 * variable
 */
    private List <Reservation> reservation;
/**
 *
 * seters y geters
 */
    public Integer getId() {
        return id;
    }
/**
 *
 * seters y geters
 */
    public void setId(Integer id) {
        this.id = id;
    }
/**
 *
 * seters y geters
 */
    public String getName() {
        return name;
    }
/**
 *
 * seters y geters
 */
    public void setName(String name) {
        this.name = name;
    }
/**
 *
 * seters y geters
 */
    public String getBrand() {
        return brand;
    }
/**
 *
 * seters y geters
 */
    public void setBrand(String brand) {
        this.brand = brand;
    }
/**
 *
 * seters y geters
 */
    public Integer getYear() {
        return year;
    }
/**
 *
 * seters y geters
 */
    public void setYear(Integer year) {
        this.year = year;
    }
/**
 *
 * seters y geters
 */
    public String getDescription() {
        return description;
    }
/**
 *
 * seters y geters
 */
    public void setDescription(String description) {
        this.description = description;
    }
/**
 *
 * seters y geters
 */
    public Category getCategory() {
        return category;
    }
/**
 *
 * seters y geters
 */
    public void setCategory(Category category) {
        this.category = category;
    }
/**
 *
 * seters y geters
 */
    public List<Messages> getMessages() {
        return messages;
    }
/**
 *
 * seters y geters
 */
    public void setMessages(List<Messages> messages) {
        this.messages = messages;
    }
/**
 *
 * seters y geters
 */
    public List<Reservation> getReservations() {
        return reservation;
    }
/**
 *
 * seters y geters
 */
    public void setReservations(List<Reservation> reservations) {
        this.reservation = reservations;
    }

   
     

    
    
}
