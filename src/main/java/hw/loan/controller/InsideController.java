package hw.loan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InsideController {

    @RequestMapping(value= {"inside", "/",}, method = RequestMethod.GET)
    public String view() {
        return "inside";
    }
}
