package soapgroupb.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import localhost.universities.GetUniversityResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.context.annotation.Bean;
import soapgroupb.demo.client.UniversityClient;

import java.io.IOException;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(UniversityClient client) {
        return args -> {
            String name = "JKUAT";

            if (args.length > 0) {
                name = args[0];
            }

            GetUniversityResponse response = client.getUniversity(name);

            ObjectMapper obj = new ObjectMapper();

            try {
                // get University object as a json string
                String jsonStr = obj.writeValueAsString(response.getUniversity());

                // Displaying JSON String
                System.out.println(jsonStr);
            } catch (IOException e) {

                System.err.println(e);
            }
        };
    }

}
