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
    public String rentBike(@ModelAttribute("id") Bike bike, Model model) {
        bike.setRentable(false);
        bikeService.updateBike(bike);

        List<Bike> bikeList = bikeService.listBike();
        model.addAttribute("bikeList", bikeList);
        return "index";
    }

    @PostMapping(value ="/repairbike")
    public String repairBike(@ModelAttribute("id") Bike bike, Model model) {
        bike.setUnderRepair(!bike.getUnderRepair());
        bikeService.updateBike(bike);

        List<Bike> bikeList = bikeService.listBike();
        model.addAttribute("bikeList", bikeList);
        return "redirect:/rentbike";
    }

    @PostMapping(value ="/deletebike")
    public String deleteBike(@RequestParam("id") long modifiableBikeId, Model model) {
        System.out.println(modifiableBikeId);
        bikeService.deleteBike(modifiableBikeId);


        List<Bike> bikeList = bikeService.listBike();
        model.addAttribute("bikeList", bikeList);
        return "index";
    }

}
