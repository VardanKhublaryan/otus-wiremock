package spring.config;

import com.consol.citrus.ws.client.WebServiceClient;
import com.consol.citrus.ws.client.WebServiceEndpointConfiguration;
import com.consol.citrus.ws.message.converter.SoapMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SoapClientConfig {

   @Bean
   public WebServiceClient soapClient() {
      WebServiceEndpointConfiguration endpointConfig = new WebServiceEndpointConfiguration();
      endpointConfig.setDefaultUri("http://localhost:8081/soap/userQuery");
      endpointConfig.setMessageConverter(new SoapMessageConverter());
      return new WebServiceClient(endpointConfig);
   }
}