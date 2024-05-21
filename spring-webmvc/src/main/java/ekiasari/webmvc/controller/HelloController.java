package ekiasari.webmvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ekiasari.webmvc.config.Database;
import ekiasari.webmvc.event.UserPojo;
import ekiasari.webmvc.event.UserEvent;
import ekiasari.webmvc.service.HelloService;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class HelloController {

    @Autowired
    private Database database;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private HelloService helloService;

    @RequestMapping(path = "/eventListener", method = RequestMethod.GET)
    @ResponseBody
    public List<String> hello() {
        List<String> data = new ArrayList<>();
        data.add(database.getName());
        data.add(database.getPassword());
        publisher.publishEvent(new UserEvent(new UserPojo(database.getName(), database.getPassword())));
        return data;
    }

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public void home(@RequestParam(name = "name", required = false) String name, HttpServletResponse res)
            throws IOException {
        String responseBody = helloService.hello(name);
        res.getWriter().println(responseBody);
    }

}
