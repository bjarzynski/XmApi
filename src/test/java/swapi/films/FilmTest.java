package swapi.films;

import org.testng.annotations.Test;
import swapi.base.TestBase;

import java.util.Map;

import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

public class FilmTest extends TestBase {
  public static Map findFilmWithLatestReleaseDate() {
    return
    when()
            .get("films")
    .then()
            .extract()
            .path("results.max { it.release_date }");
  }

  @Test
  public void findTallestPersonInLatestFilm() {
    String latestFilmUrl = (String) findFilmWithLatestReleaseDate().get("url");
    when()
            .get("people")
    .then()
            .body("results.findAll{ it.films = '" + latestFilmUrl + "' }.max { it.height.toInteger() }.name",
                    is("Darth Vader"));
  }

  @Test
  public void findTallestPersonEverInSW() {
    when()
            .get("people")
    .then()
            .body("results.max { it.height.toInteger() }.name", is("Darth Vader"));
  }

  @Test
  public void checkPeopleJsonSchemaValidation() {
    when()
            .get("people")
    .then()
            .assertThat()
            .body(matchesJsonSchemaInClasspath("people.json"));
  }
}
