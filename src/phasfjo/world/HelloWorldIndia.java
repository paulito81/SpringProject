package phasfjo.world;

/**
 * Created by paul on 30.05.2017.
 */
public class HelloWorldIndia {

    private String message1;
    private String message2;
    private String message3;


    public void setMessage1(String message1) {
        this.message1 = message1;
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }

    public void setMessage3(String message3) {
        this.message3 = message3;
    }

    public void getMessage1() {
        System.out.println("India Message 1 : " + message1);
    }

    public void getMessage2() {
        System.out.println("India Message 2 : " + message2);
    }

    public void getMessage3() {
        System.out.println("India Message 3 : " + message3);
    }
}
