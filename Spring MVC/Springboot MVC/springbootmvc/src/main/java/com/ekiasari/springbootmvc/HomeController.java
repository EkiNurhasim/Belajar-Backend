package com.ekiasari.springbootmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

  @RequestMapping("/")
  public String home() {
    return "index";
  }

  @RequestMapping("add")
  public String add(@RequestParam("num1") int i, @RequestParam("num2") int j, Model model) {

    int k = i + j;
    model.addAttribute("data", k);
    return "add";
  }

  @RequestMapping("addAlien")
  public String addAlien(@RequestParam("id") int id, @RequestParam("name") String name, Model model) {

    Alien a = new Alien();
    a.setId(id);
    a.setName(name);

    model.addAttribute("data", a);

    return "addAlien";
  }

  @RequestMapping("addAlienShort")
  public String addAlienShort(@ModelAttribute("data") Alien alien, Model model) {
    model.addAttribute("data", alien);
    return "addAlienNew";
  }
}
