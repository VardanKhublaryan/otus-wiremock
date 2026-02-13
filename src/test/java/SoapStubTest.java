import static com.consol.citrus.ws.actions.SoapActionBuilder.soap;

import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.config.CitrusSpringConfig;
import com.consol.citrus.testng.spring.TestNGCitrusSpringSupport;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;
import spring.SpringMvcApplication;

@ContextConfiguration(classes = {CitrusSpringConfig.class})
@SpringBootTest(classes = SpringMvcApplication.class)
public class SoapStubTest extends TestNGCitrusSpringSupport {

   @Test
   @CitrusTest
   public void getUser() {
      run(soap()
            .client("soapClient")
            .send()
            .message()
            .contentType("text/xml"));

      run(soap()
            .client("soapClient")
            .receive()
            .message()
            .body("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
              + "<usr:getUserResponse xmlns:usr=\"http://example.com/user\">\n"
              + "<usr:name>Test user</usr:name>\n"
              + "<usr:score>78</usr:score>\n"
              + "</usr:getUserResponse>")
      );
   }
}
