package pokemon;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.micronaut.data.annotation.DateCreated;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;

@Entity
@Table(name = "pokemon")
public class Pokemon {

  @Id private String id;

  private String name;
  private int level;
  private int weight;

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  private String imageUrl;

  public OffsetDateTime getCreated_at() {
    return created_at;
  }

  public void setCreated_at(OffsetDateTime created_at) {
    this.created_at = created_at;
  }

  @DateCreated
  @JsonFormat(
      shape = JsonFormat.Shape.STRING,
      pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ",
      timezone = "UTC")
  private OffsetDateTime created_at;

  public Pokemon() {}

  public void setName(String name) {
    this.name = name;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public Pokemon(String name, int level, String imageUrl, int weight, String id) {
    this.name = name;
    this.level = level;
    this.imageUrl = imageUrl;
    this.weight = weight;
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public int getLevel() {
    return level;
  }
}
