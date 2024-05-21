package ekiasari.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import ekiasari.webmvc.model.User;

@Controller
public class UserController {

    @GetMapping("/user/currnt")
    @ResponseBody
    public String getUserSession(@SessionAttribute("user") User user, @CookieValue("username") String username) {
        return "Hello " + user.getUsername() + " " + username;
    }

}
