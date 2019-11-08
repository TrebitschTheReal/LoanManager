package hw.loan.controller;

import hw.loan.model.Bike;
import hw.loan.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ListBikeController {

    @Autowired
    private BikeService bikeService;

    @GetMapping(value={"rentbike", "managebike"})
    public String listAllBike(Model model) {
        List<Bike> bikeList = bikeService.listBike();
        model.addAttribute("bikeList", bikeList);
        return "index";
    }
}
