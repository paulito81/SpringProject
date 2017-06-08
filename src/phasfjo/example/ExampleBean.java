package phasfjo.example;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by paul on 29.05.2017.
 */
public class ExampleBean implements InitializingBean, DisposableBean {

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public void getMessage() {
        System.out.println("Your message: '" + message+"'");
    }

    public void init() {
        System.out.println("Bean '" + message +"' is going through init...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Nothing happening?");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Bean '" + message+ "' is being destroyed..");
    }
}
