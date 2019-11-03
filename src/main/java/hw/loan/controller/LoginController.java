package hw.loan.controller;

import hw.loan.model.User;
import hw.loan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserService us;

    @RequestMapping(value= {"login", "/"}, method = RequestMethod.GET)
    public String view(Model model) {

//        List<User> userList = us.getAllUsers();
//
//        model.addAttribute("userList", userList);

        return "login";
    }
}
