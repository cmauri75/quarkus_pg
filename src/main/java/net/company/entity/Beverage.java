/* MyCompany Italy - 2024 */
package net.company.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Beverage extends PanacheEntity {
  public String name;
  public String flavour;
}
