package hotelreservator.repositories;

import hotelreservator.entities.Hotel;
import org.springframework.data.repository.CrudRepository;

public interface HotelRepository extends CrudRepository<Hotel,String> {
}
