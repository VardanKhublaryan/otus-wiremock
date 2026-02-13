package services;

import io.restassured.RestAssured;
import java.util.List;
import models.AssessmentsModel;
import models.UserModel;
import org.springframework.stereotype.Service;

@Service
public class UserService extends RestService {

   public AssessmentsModel getUserById(int userId) {
      return RestAssured.given(requestSpecification())
          .when().log().all()
          .get("/user/get/" + userId)
          .then().log().all()
          .spec(responseSpecification())
          .extract()
          .as(AssessmentsModel.class);
   }

   public List<UserModel> getAllUsers() {
      return RestAssured.given(requestSpecification())
          .when().log().all()
          .get("/user/get/all")
          .then().log().all()
          .spec(responseSpecification())
          .extract()
          .body()
          .jsonPath()
          .getList("", UserModel.class);
   }

}
