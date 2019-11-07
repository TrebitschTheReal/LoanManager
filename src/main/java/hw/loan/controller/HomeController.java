package hw.loan.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    private String mainPage = "index";

    @GetMapping("index")
    public String index(){
        return mainPage;
    }

    @GetMapping("login")
    public String login(){return mainPage;}

//    @GetMapping("managebike")
//    public String managebike(){return mainPage;}

    @GetMapping("manageusers")
    public String manageusers(){return mainPage;}

//    @GetMapping("rentbike")
//    public String rentbike(){return mainPage;}

    @GetMapping("403")
    public String accesdenied(){return mainPage;}
}
