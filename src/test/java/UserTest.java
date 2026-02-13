import java.util.List;
import models.AssessmentsModel;
import models.UserModel;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.Random;

public class UserTest extends TestBase {

   @Test
   public void getUserByIdValidation() {
      SoftAssert softAssert = new SoftAssert();
      AssessmentsModel userById = userRestService.getUserById(new Random().nextInt(0,200));
      softAssert.assertEquals("Test user", userById.getName(), "ScoreModel name does not match");
      softAssert.assertEquals(87, userById.getScore(), "ScoreModel score does not match");
      softAssert.assertAll();
   }

   @Test
   public void getAllUsersJsonSchemaValidation() {
      SoftAssert softAssert = new SoftAssert();
      List<UserModel> users = userRestService.getAllUsers();
      UserModel user = users.getFirst();

      softAssert.assertEquals(23, user.getAge(), "User age does not match");
      softAssert.assertEquals("Test user", user.getName(), "User name does not match");
      softAssert.assertEquals("QA", user.getCourse(), "User course does not match");
      softAssert.assertEquals("test@test.test", user.getEmail(), "User email does not match");
      softAssert.assertAll();
   }

}