package hotelreservator.repositories;

import hotelreservator.entities.Room;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room,String>{
}
