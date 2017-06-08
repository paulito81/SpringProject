package phasfjo.world;

import javax.swing.*;

/**
 * Created by paul on 29.05.2017.
 */

public class HelloWorld {

    private String message;
    private String message1;
    private String message2;


    public void setMessage(String message) {
        this.message = message;
    }

    public void setMessage1(String message1) {
        this.message1 = message1;
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }

    public void getMessage() {

        if (message == null) {
            System.out.println("---->Your have initiated a prototype giving you an null value: " + message);
        }
        JOptionPane.showMessageDialog(null, "Your message1: " + message);
        System.out.println("Your message1 : " + message);
    }

    public void getMessage1() {
        System.out.println("world 1 message1 : " + message1);
    }

    public void getMessage2() {
        System.out.println("world message 2 : " + message2);
    }

}
