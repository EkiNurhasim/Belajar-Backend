package com.orange.orangeapi;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class AlienResource {

  @Autowired
  AlienRepository repo;

  @RequestMapping("aliens")
  public List<Alien> getAliens(){
    List<Alien> aliens = (List<Alien>) repo.findAll();
    return aliens;
  }

}
