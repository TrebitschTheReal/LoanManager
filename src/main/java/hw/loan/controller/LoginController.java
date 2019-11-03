package hw.loan.controller;

import hw.loan.model.User;
import hw.loan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserService us;

    @RequestMapping(value= {"login", "/"}, method = RequestMethod.GET)
    public String view(Model model) {

        List<User> userList = us.getAllUsers();

        for (User user : userList) {
            System.out.printf("Id: %s -- Email: %s -- Permissions: %s ", user.getId(), user.getEmail(), user.getPermissions());
            System.out.println("");
        }

        model.addAttribute("userList", userList);
        return "login";
    }
}
