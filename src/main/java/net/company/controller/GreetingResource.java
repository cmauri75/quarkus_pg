/* MyCompany Italy - 2024 */
package net.company.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import net.company.ApplicationConfig;

@Path("/hello")
public class GreetingResource {

  @Inject ApplicationConfig applicationConfig;

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String hello() {
    return applicationConfig.message() + " from Quarkus REST";
  }
}
