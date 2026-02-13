package services;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.springframework.stereotype.Service;

@Service
public abstract class RestService {

   protected RequestSpecification requestSpecification() {
      RestAssured.defaultParser = Parser.JSON;
      RestAssured.given().baseUri(System.getProperty("base.uri")).log().all();
      return RestAssured.given().baseUri(System.getProperty("base.uri"));
   }

   protected ResponseSpecification responseSpecification() {
      RestAssured.defaultParser = Parser.JSON;
      return RestAssured.given()
          .then()
          .statusCode(200);
   }
}
