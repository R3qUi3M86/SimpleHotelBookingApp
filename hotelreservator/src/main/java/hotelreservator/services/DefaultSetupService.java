package hotelreservator.services;

import hotelreservator.entities.AppUser;
import hotelreservator.entities.Hotel;
import hotelreservator.entities.Reservation;
import hotelreservator.entities.Room;
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
public class DefaultSetupService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private ReservationRepository reservationRepository;


    private AppUser user1 = new AppUser("UserNickname1","Firstname1","Lastname1","user1@mail.com");
    private AppUser user2 = new AppUser("UserNickname2","Firstname2","Lastname2","user2@mail.com");
    private AppUser user3 = new AppUser("UserNickname3","Firstname3","Lastname3","user3@mail.com");

    private Hotel marriot = new Hotel("Marriot","Warsaw");
    private Hotel hilton = new Hotel("Hilton","Warsaw");
    private Hotel uHalinki = new Hotel("U Halinki","Zakopane");

    private Room room1 = new Room("RoomMarriot001",180, marriot);
    private Room room2 = new Room("RoomMarriot002",150, marriot);
    private Room room3 = new Room("RoomMarriot003",155, marriot);
    private Room room4 = new Room("RoomMarriot004",220, marriot);
    private Room room5 = new Room("RoomHilton001",130, hilton);
    private Room room6 = new Room("RoomHilton002",99.99, hilton);
    private Room room7 = new Room("RoomHilton003",190, hilton);
    private Room room8 = new Room("RoomUHalinki001",95, uHalinki);
    private Room room9 = new Room("RoomUHalinki002",115, uHalinki);

    private Reservation reservation1 = new Reservation("Reservation001",90,"2018-10-25",room1,user1);
    private Reservation reservation2 = new Reservation("Reservation002",90,"2018-10-26",room1,user1);
    private Reservation reservation3 = new Reservation("Reservation003",90,"2018-10-27",room1,user1);
    private Reservation reservation4 = new Reservation("Reservation004",140,"2018-09-25",room5,user2);
    private Reservation reservation5 = new Reservation("Reservation005",200,"2018-08-29",room4,user1);
    private Reservation reservation6 = new Reservation("Reservation006",280,"2018-08-30",room4,user3);

    private List<AppUser> appUsers = new ArrayList<>(Arrays.asList(user1,user2,user3));

    private List<Hotel> hotels = new ArrayList<>(Arrays.asList(marriot,hilton,uHalinki));

    private List<Room> rooms = new ArrayList<>(Arrays.asList(room1,room2,room3,room4,room5,room6,room7,room8,room9));

    private List<Reservation> reservations = new ArrayList<>(Arrays.asList(reservation1,reservation2,reservation3,reservation4,reservation5,reservation6));

    public void registerDefaultAppUsers(){
        for(AppUser appUser : appUsers){
            appUserRepository.save(appUser);
        }
    }

    public void addDefaultHotels(){
        for(Hotel hotel : hotels){
            hotelRepository.save(hotel);
        }
    }

    public void addDefaultRooms(){
        for(Room room : rooms){
            roomRepository.save(room);
        }
    }

    public void addDefaultReservations(){
        for(Reservation reservation : reservations){
            reservationRepository.save(reservation);
        }
    }
}
