/* MyCompany Italy - 2024 */
package net.company;

import io.smallrye.health.checks.UrlHealthCheck;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.HttpMethod;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.Readiness;

@ApplicationScoped
public class CustomHealthCheck {

  @ConfigProperty(name = "quarkus.rest-client.\"net.company.client.FruityViceService\".url")
  String externalURL;

  @Readiness
  HealthCheck checkURL() {
    return new UrlHealthCheck(externalURL + "/api/fruit/banana")
        .name("ExternalURL health check")
        .requestMethod(HttpMethod.GET)
        .statusCode(200);
  }
}
