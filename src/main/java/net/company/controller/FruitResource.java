/* MyCompany Italy - 2024 */
package net.company.controller;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;
import net.company.client.FruityViceService;
import net.company.dto.FruitDTO;
import net.company.entity.Fruit;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/fruit")
public class FruitResource {

  @RestClient @Inject FruityViceService fruityViceService;

  /**
   * curl -w '\n' localhost:8080/fruit
   *
   * @param fruit
   * @return
   */
  @Transactional
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response newFruit(Fruit fruit) {
    fruit.id = null;
    fruit.persist();
    return Response.status(Response.Status.CREATED).entity(fruit).build();
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<FruitDTO> fruits(@QueryParam("season") String season) {
    if (season != null) {
      return Fruit.findBySeason(season).stream()
          .map(fruit -> FruitDTO.of(fruit, fruityViceService.getFruitByName(fruit.name)))
          .collect(Collectors.toList());
    }
    return Fruit.<Fruit>listAll().stream()
        .map(fruit -> FruitDTO.of(fruit, fruityViceService.getFruitByName(fruit.name)))
        .collect(Collectors.toList());
  }
}
