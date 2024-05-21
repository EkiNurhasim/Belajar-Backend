package ekiasari.webmvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class CodeController {

    @DeleteMapping("/products/{id}")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void code(@PathVariable("id") Integer id) {
        // delete something
    }

}
