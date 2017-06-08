package phasfjo.world;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by paulito on 07.06.2017.
 */

@Configuration
public class MyService {

    @Bean
    public HelloWorldIndia helloWorldIndia(){
        return new HelloWorldIndia();
    }

    @Bean
    public HelloWorld helloWorld(){
        return new HelloWorld();
    }
    @Bean
    public HelloWorld2 helloWorld2(){
        return new HelloWorld2();
    }
    @Bean
    public HelloWorld3 helloWorld3(){
        return new HelloWorld3();
    }

}
