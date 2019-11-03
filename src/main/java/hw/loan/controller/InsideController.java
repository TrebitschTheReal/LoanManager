package hw.loan.controller;

import hw.loan.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class InsideController {

    @Autowired
//    private UserService us;

    @RequestMapping(value = {"inside"}, method = RequestMethod.GET)
    public String view() {

//        List<User> userList = us.getAllUsers();

//        for (User user : userList) {
//            System.out.printf("Id: %s -- Email: %s -- Permissions: %s ", user.getId(), user.getEmail(), user.getPermissions());
//            System.out.println("");
//            //lista az összes juzerrel
//        }

//        model.addAttribute("userList", userList);

        return "inside";
    }
}
