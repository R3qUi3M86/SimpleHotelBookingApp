package hotelreservator.controlers;

import hotelreservator.entities.Reservation;
import hotelreservator.entities.Room;
import hotelreservator.entities.SearchCriteria;
import hotelreservator.services.ReservationService;
import hotelreservator.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationControler {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private SearchService searchService;

    @RequestMapping(method = RequestMethod.POST, value = "/search")
    public List<Room> searchForRoom(@RequestBody SearchCriteria searchCriteria){
        return searchService.getMatchingRooms(searchCriteria);
    }

    @RequestMapping("/{userId}/reservations")
    public List<Reservation> getUserReservations(@PathVariable String userId){
        return reservationService.getUserReservations(userId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{userId}/reservations")
    public void addUserReservation(@RequestBody Reservation[] reservation){
        reservationService.addUserReservation(reservation);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{userId}/reservations")
    public void deleteAllUserReservations(@PathVariable String userId){
        reservationService.deleteAllUserReservations(userId);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{userId}/reservations/{reservationId}")
    public void deleteSpecificUserReservations(@PathVariable String reservationId){
        reservationService.deleteSpecificUserReservations(reservationId);
    }
}
