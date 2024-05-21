package ekiasari.webmvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FormController {

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @PostMapping(path = "/form/person", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public String postMethodName(
            @RequestParam("name") String name,
            @RequestParam("birthDate") Date birthDate,
            @RequestParam("address") String address) {
        return "Success create person with name : " + name +
                ", birthDate : " + simpleDateFormat.format(birthDate) +
                ", address : " + address;
    }

    @PostMapping(path = "/form/hello", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String requestMethodName(@RequestParam("name") String name) {
        return """
                    <html>
                    <head>
                    <title>Hello $name</title>
                    </head>
                    <body>
                    <h1>Hello $name</h1>
                    </body>
                    </html>
                """.replace("$name", name);
    }

}
