/* MyCompany Italy - 2024 */
package net.company;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithName;

@ConfigMapping(prefix = "app")
public interface ApplicationConfig {

  @WithName("message")
  String message();
}
