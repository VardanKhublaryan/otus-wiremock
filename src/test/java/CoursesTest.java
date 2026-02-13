import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import java.util.List;
import models.CourseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import services.CourseService;

public class CoursesTest extends TestBase {

   @Autowired
   private CourseService courseService;

   @Test
   public void checkAllCourses() {
      SoftAssert softAssert = new SoftAssert();

      List<CourseModel> courses = courseService.getAllCourses();

      CourseModel course1 = courses.get(0);
      softAssert.assertEquals(course1.getName(), "QA java", "Course 1 name mismatch");
      softAssert.assertEquals(course1.getPrice(), 15000, "Course 1 price mismatch");

      CourseModel course2 = courses.get(1);
      softAssert.assertEquals(course2.getName(), "Java", "Course 2 name mismatch");
      softAssert.assertEquals(course2.getPrice(), 12000, "Course 2 price mismatch");

      softAssert.assertAll();
   }
}