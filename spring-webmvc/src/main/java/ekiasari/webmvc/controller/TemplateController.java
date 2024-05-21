package ekiasari.webmvc.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TemplateController {

    @GetMapping("/web/hello")
    public ModelAndView hello(@RequestParam(value = "name", required = false) String name) {
        return new ModelAndView("hello", Map.of("title", "Belajar View", "name", name));
    }
}
