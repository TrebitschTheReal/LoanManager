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
public class BikeController {

    @Autowired
    private BikeService bikeService;

    @GetMapping(value={"rentbike", "managebike"})
    public String listAllBike(Model model) {
        List<Bike> bikeList = bikeService.listBike();
        model.addAttribute("bikeList", bikeList);
        return "index";
    }

    @PostMapping(value ="/rentbike")
    public String rentBike(@ModelAttribute("id") Bike bike) {
        bike.setRentable(false);
        bikeService.updateBike(bike);

        return "redirect:/rentbike";
    }

    @PostMapping(value ="/repairbike")
    public String repairBike(@ModelAttribute("id") Bike bike) {
        bike.setUnderRepair(!bike.getUnderRepair());
        bikeService.updateBike(bike);
        return "redirect:/rentbike";
    }

    @PostMapping(value ="/deletebike")
    public String deleteBike(@ModelAttribute("id") Bike bike) {
        bikeService.deleteBike(bike.getId());
        return "redirect:/rentbike";
    }

    @PostMapping(value ="/resetbikestatus")
    public String resetBikeStatus(@ModelAttribute("id") Bike bike) {
        bike.setRentable(true);
        bike.setUnderRepair(false);
        bikeService.updateBike(bike);
        return "redirect:/rentbike";
    }

    @PostMapping(value ="/setcondition")
    public String setBikeCondition(@ModelAttribute Bike bike) {
        System.out.println(bike.getCondition());
        System.out.println(bike.getId());

        return "redirect:/rentbike";
    }
}
