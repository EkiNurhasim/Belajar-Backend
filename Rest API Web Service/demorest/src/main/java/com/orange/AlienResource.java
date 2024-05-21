package com.orange;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("aliens")
public class AlienResource 
{

  AlienRepository repo = new AlienRepository();

  @GET
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})  
  public List<Alien> getAliens()
  { 
    System.out.println("CALLED FUNCTION = getAliens()");   
    return repo.getAliens();
  }

  @GET
  @Path("alien/{id}")
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  public Alien getAlien(@PathParam("id") int id){
    return repo.getAlien(id);
  }

  @POST
  @Path("alien")
  @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public Alien createAlien(Alien a1)
  {
    System.out.println(a1);
    repo.createAlien(a1);
    return a1;
  }

  @PUT
  @Path("alien")
  @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public Alien updateAlien(Alien a1)
  {
    System.out.println(a1);
    if(repo.getAlien(a1.getId()).getId() == 0)
    {
      repo.createAlien(a1);
    }else
    {
      repo.updateAlien(a1);      
    }
    return a1;
  }

  @DELETE
  @Path("alien/{id}")
  @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public Alien deleteAlien(@PathParam("id") int id)
  {
    Alien alien = repo.getAlien(id);
    if(alien.getId() != 0)
      repo.deleteAlien(id);
    return alien;
  }

}
