package ekiasari.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HeaderController {

    @GetMapping(path = "/header/token")
    @ResponseBody
    public String requestMethodName(@RequestHeader(name = "X-TOKEN") String token) {
        if ("EKI".equals(token)) {
            return "OK";
        } else {
            return "KO";
        }
    }

}