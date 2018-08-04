package hotelreservator.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Reservation {

    @Id
    private String id;

    private double price;

    private String reservationDate;

    @ManyToOne
    private Room room;

    @ManyToOne
    private AppUser appUser;

    public Reservation() {
    }

    public Reservation(String id, double price, String reservationDate, Room room, AppUser appUser) {
        this.id = id;
        this.price = price;
        this.reservationDate = reservationDate;
        this.room = room;
        this.appUser = appUser;
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

    public String getReservationDate() {
        return reservationDate;
    }

    public void setreservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
