package hotelreservator.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Room {

    @Id
    private String id;
    private double price;

    @ManyToOne
    private Hotel hotel;

    public Room() {
    }

    public Room(String id, double price, Hotel hotel) {
        this.id = id;
        this.price = price;
        this.hotel = hotel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
