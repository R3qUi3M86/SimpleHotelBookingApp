package hotelreservator.services;


import hotelreservator.entities.AppUser;
import hotelreservator.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    public void registerNewAppUser(AppUser appUser){
        if(appUserRepository.findById(appUser.getId()).isPresent()){
            System.out.println("User Id already exists in DB!");
        } else {
            appUserRepository.save(appUser);
        }
    }
}
