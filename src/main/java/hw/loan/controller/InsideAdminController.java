package hw.loan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InsideAdminController {

    @RequestMapping(value= {"inside/admin",}, method = RequestMethod.GET)
    public String view() {
        return "main-inside-admin";
    }
}
