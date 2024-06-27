/* MyCompany Italy - 2024 */
package net.company.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import net.company.dto.FruityVice;
import org.eclipse.microprofile.faulttolerance.ExecutionContext;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.FallbackHandler;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/fruit")
@RegisterRestClient
public interface FruityViceService {

  @GET
  @Path("/{name}")
  @Produces(MediaType.APPLICATION_JSON)
  @Retry(maxRetries = 3, delay = 2000)
  @Fallback(FruityViceFallback.class)
  FruityVice getFruitByName(@PathParam("name") String name);

  public static class FruityViceFallback implements FallbackHandler<FruityVice> {

    private static final FruityVice EMPTY_FRUITY_VICE =
        new FruityVice("empty", new FruityVice.Nutritions(0.0, 0.0));

    @Override
    public FruityVice handle(ExecutionContext context) {
      return EMPTY_FRUITY_VICE;
    }
  }
}
