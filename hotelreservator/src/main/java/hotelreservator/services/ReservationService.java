package hotelreservator.services;

import hotelreservator.entities.Reservation;
import hotelreservator.repositories.AppUserRepository;
import hotelreservator.repositories.HotelRepository;
import hotelreservator.repositories.ReservationRepository;
import hotelreservator.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getUserReservations(String userId){
        return reservationRepository.findByAppUserId(userId);
    }

    public void addUserReservation(Reservation[] reservation){
        List<Reservation> reservationList = Arrays.asList(reservation);
        reservationRepository.saveAll(reservationList);
    }

    public void deleteAllUserReservations(String userId){
        List<Reservation> reservations = new ArrayList<>();
        reservationRepository.findByAppUserId(userId).forEach(reservations::add);
        for(Reservation reservation : reservations){
            reservationRepository.delete(reservation);
        }
    }

    public void deleteSpecificUserReservations(String reservationId){
        reservationRepository.deleteById(reservationId);
    }

}
