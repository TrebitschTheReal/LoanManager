package hw.loan.controller;

import hw.loan.model.Bike;
import hw.loan.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ListBikeController {

    @Autowired
    private BikeService bikeService;

    @RequestMapping(value={"rentbike", "managebike"}, method = RequestMethod.GET)
    public String listAllBike(Model model) {
        List<Bike> bikeList = bikeService.listBike();
        model.addAttribute("bikeList", bikeList);
        return "index";
    }

    @RequestMapping(value={"rentbike", "managebike"}, params = {"modifiableBikeId"}, method = RequestMethod.POST)
    public String modifyBike(@RequestParam("modifiableBikeId") String modifiableBikeId, Model model) {
        List<Bike> bikeList = bikeService.listBike();
        System.out.println(modifiableBikeId);




       // model.addAttribute("bikeList", bikeList);
        return "index";
    }
}
