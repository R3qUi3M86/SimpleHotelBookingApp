package hotelreservator.repositories;

import hotelreservator.entities.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation, String> {
    List<Reservation> findByRoomId(String roomId);
    List<Reservation> findByAppUserId(String userId);
}
