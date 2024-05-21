package com.ekiasari.springjdbc.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ekiasari.springjdbc.model.Alien;

@Repository
public class AlienRepo {

  private JdbcTemplate template;
  
  public JdbcTemplate getTemplate() {
    return template;
  }
  
  @Autowired
  public void setTemplate(JdbcTemplate template) {
    this.template = template;
  }

  public void save(Alien alien){
    String query = "insert into alien (id, name, tech) values (?,?,?)";
    int result = template.update(query, alien.getId(), alien.getName(), alien.getTech());
    System.out.println(result + " row/s effected");    
  }

  public List<Alien> findAll(){
    String query = "select * from alien";
    
    RowMapper<Alien> mapper = new RowMapper<Alien>() {
      @Override
      public Alien mapRow(ResultSet rs, int rowNum) throws SQLException {

        Alien a = new Alien();
        a.setId(rs.getInt(1));  
        a.setName(rs.getString(2));
        a.setTech(rs.getString(3));

        return a;
      }
    };

    List<Alien> alien = template.query(query, mapper);
    return alien;
  }

}
