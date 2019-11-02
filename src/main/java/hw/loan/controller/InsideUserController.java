package hw.loan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InsideUserController {

    @RequestMapping(value= {"inside/user",}, method = RequestMethod.GET)


    public String view() {
        return "main-inside-user";
    }

}
