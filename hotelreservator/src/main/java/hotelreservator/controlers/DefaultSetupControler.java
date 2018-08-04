package hotelreservator.controlers;

import hotelreservator.services.DefaultSetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultSetupControler {

    @Autowired
    private DefaultSetupService defaultSetupService;

    @RequestMapping(method = RequestMethod.POST, value = "/demo")
    public void createDemoDatabase(){
        defaultSetupService.registerDefaultAppUsers();
        defaultSetupService.addDefaultHotels();
        defaultSetupService.addDefaultRooms();
        defaultSetupService.addDefaultReservations();
    }
}
