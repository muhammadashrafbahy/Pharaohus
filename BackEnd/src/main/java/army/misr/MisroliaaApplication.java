package army.misr;

import army.misr.entity.customerUserDetails;
import army.misr.service.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import java.util.Objects;


@EnableConfigurationProperties  // make you to config classes that read from properties files
@EnableAutoConfiguration
@ComponentScan("army.misr")
@SpringBootApplication (scanBasePackages={"army.misr.config","army.misr.entity","army.misr.api"})
public class MisroliaaApplication {

    public static void main(String[] args) {

        SpringApplication.run(MisroliaaApplication.class, args);

    }
//
//    @Autowired
//        public void authenticationManager(AuthenticationManagerBuilder builder , employeeService employeeService) throws Exception {
//        builder.userDetailsService(s -> new customerUserDetails(employeeService.login(s)));
//

//    }


}
