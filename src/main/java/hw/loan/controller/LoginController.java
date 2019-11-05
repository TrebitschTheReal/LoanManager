//package hw.loan.controller;
//
//import hw.loan.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import java.util.List;
//
//@Controller
//public class LoginController {
//
//    @RequestMapping(value = "signup")
//    public String signup(Model model, @RequestHeader("X-Requested-With") String requestedWith) {
//
//        model.addAttribute(new SignupForm());
//        if (AjaxUtils.isAjaxRequest(requestedWith)) {
//            return SIGNUP_VIEW_NAME.concat(" :: signupForm");
//        }
//        return SIGNUP_VIEW_NAME;
//
//    }
//}
