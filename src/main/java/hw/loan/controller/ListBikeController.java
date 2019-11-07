package hw.loan.controller;

import hw.loan.model.Bike;
import hw.loan.service.ListBikeService;
import hw.loan.service.NewBikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ListBikeController {

    @Autowired
    private ListBikeService listBikeService;

    @RequestMapping(value={"rentbike", "managebike"}, method = RequestMethod.GET)
    public String listAllBike(@RequestParam (required = false)String bikeParam, Model model) {
        List<Bike> bikeList = listBikeService.listBike();
        System.out.println(bikeParam);



        model.addAttribute("bikeList", bikeList);
        return "index";
    }
}