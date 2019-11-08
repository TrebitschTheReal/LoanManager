package hw.loan.controller;

import hw.loan.model.Bike;
import hw.loan.repository.BikeRepository;
import hw.loan.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RentBikeController {

    @Autowired
    private BikeService bikeService;

    @PostMapping(value ="/rentbike")
    public String modifyBike(@ModelAttribute("id") Bike bike, Model model) {
        System.out.println(bike.getId());


        List<Bike> bikeList = bikeService.listBike();
        model.addAttribute("bikeList", bikeList);
        return "index";
    }
}
