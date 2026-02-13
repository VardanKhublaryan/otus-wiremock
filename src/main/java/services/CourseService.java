package services;

import io.restassured.RestAssured;
import java.util.List;
import models.CourseModel;
import org.springframework.stereotype.Service;

@Service
public class CourseService extends RestService {

   public List<CourseModel> getAllCourses() {
      return RestAssured.given(requestSpecification())
             .when()
             .get("/cource/get/all")
             .then().log().all()
             .statusCode(200)
             .extract()
             .jsonPath()
             .getList("", CourseModel.class); // deserialize JSON array
   }
}