package swapi.base;

import configuration.Properties;
import configuration.PropertyName;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

public class TestBase {
  private static final String API_URL = Properties.getStringValue(PropertyName.BASE_URL);

  @BeforeSuite
  public void beforeSuiteSetup() {
    RestAssured.baseURI = API_URL;
  }
}
