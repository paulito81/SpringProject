package phasfjo.world;

/**
 * Created by paulito on 08.06.2017.
 */

public class HelloWorldImpl implements HelloWorldInter {

    private String text;

    public void getText(String text){
        this.text = text;
    }

    public String setText(){
        System.out.println("Helloworld implementation :" + text);
        return text;
    }

    @Override
    public String sayHi(String text) {
        System.out.println("sayHi called");
        return "Hello " + text;
    }
}
