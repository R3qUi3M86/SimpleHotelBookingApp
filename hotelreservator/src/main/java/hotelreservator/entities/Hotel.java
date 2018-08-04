package hotelreservator.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Hotel {

    @Id
    private String id;
    private String city;

    public Hotel() {
    }

    public Hotel(String id, String city) {
        this.id = id;
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
