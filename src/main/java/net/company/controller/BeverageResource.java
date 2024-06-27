/* MyCompany Italy - 2024 */
package net.company.controller;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import net.company.entity.Beverage;

@Path("/beverage")
public class BeverageResource {

  /** curl -w '\n' localhost:8080/beverage */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Beverage> beverages() {
    return Beverage.listAll();
  }

  /**
   * curl -w '\n' -d "{\"name\": \"Mojito\", \"flavour\": \"Mint\"}" -H "Content-Type:
   * application/json" http://localhost:8080/beverage
   */
  @Transactional
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response createBeverage(Beverage beverage) {
    beverage.persist();
    return Response.status(Response.Status.CREATED).entity(beverage).build();
  }
}
