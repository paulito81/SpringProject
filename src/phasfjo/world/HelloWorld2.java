package phasfjo.world;

/**
 * Created by paulito on 08.06.2017.
 */
public class HelloWorld2 {

    private String message;
    private String message2;

    public String getMessage() {
        System.out.println("world 2 message : " + message);
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage2() {
        System.out.println("Hello world 2 : " + message2);
        return message2;
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }


}
