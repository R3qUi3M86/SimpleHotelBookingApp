package hotelreservator.services;

import hotelreservator.entities.Reservation;
import hotelreservator.entities.SearchCriteria;
import hotelreservator.entities.Room;
import hotelreservator.repositories.HotelRepository;
import hotelreservator.repositories.ReservationRepository;
import hotelreservator.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Room> getMatchingRooms(SearchCriteria searchCriteria){
        Calendar fromDate = convertStringDateToCalendar(searchCriteria.getFromDate());
        Calendar toDate = convertStringDateToCalendar(searchCriteria.getToDate());
        List<Room> rooms = new ArrayList<>();
        roomRepository.findAll().forEach(rooms::add);
        rooms = rooms.stream().
                filter(t->t.getHotel().getCity().equals(searchCriteria.getCity())).collect(Collectors.toList())
                .stream()
                .filter(t->t.getPrice()<=searchCriteria.getMaxPrice()).collect(Collectors.toList())
                .stream()
                .filter(t->t.getPrice()>=searchCriteria.getMinPrice()).collect(Collectors.toList());
        List<Room> roomsLessReservations = new ArrayList<>(rooms);
        for(Room room : rooms){
            List<Reservation> roomReservations = new ArrayList<>();
            reservationRepository.findByRoomId(room.getId()).forEach(roomReservations::add);
            for(Reservation roomReservation : roomReservations){
                Calendar reservationDate = convertStringDateToCalendar(roomReservation.getReservationDate());
                System.out.println(fromDate.getTimeInMillis());
                System.out.println(reservationDate.getTimeInMillis());
                System.out.println(toDate.getTimeInMillis());
                if(reservationDate.getTimeInMillis()+3600000>=fromDate.getTimeInMillis() && reservationDate.getTimeInMillis()+3600000<=toDate.getTimeInMillis()){
                    roomsLessReservations.remove(roomRepository.findById(room.getId()).get());
                }
            }
        }
        return roomsLessReservations;
    }

    private Calendar convertStringDateToCalendar(String stringDate){
        String[] dateChunk = stringDate.split("-");
        int year = Integer.parseInt(dateChunk[0]);
        int month = Integer.parseInt(dateChunk[1])-1;
        int day = Integer.parseInt(dateChunk[2]);
        Calendar calendar = Calendar.getInstance();
        calendar.set(year,month,day,12,0);
        return calendar;
    }
}
