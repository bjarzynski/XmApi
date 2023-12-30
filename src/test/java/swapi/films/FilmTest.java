package swapi.films;

import org.testng.annotations.Test;
import swapi.base.TestBase;

import static io.restassured.RestAssured.given;

public class FilmTest extends TestBase {
  @Test
  public void sendIncorrectJsonPetFormat() {
    given().
            when().
            post("films").
            then().
            statusCode(200);
  }
}
