package hotelreservator.controlers;

import hotelreservator.entities.AppUser;
import hotelreservator.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppUserControler {

    @Autowired
    private AppUserService appUserService;

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public void register(@RequestBody AppUser appUser){
        appUserService.registerNewAppUser(appUser);
    }




}
