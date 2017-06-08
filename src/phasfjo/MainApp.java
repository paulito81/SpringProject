package phasfjo;


import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import phasfjo.Text.TextEditor;
import phasfjo.Text.TextEditor2;
import phasfjo.Text.TextEditorConfig;
import phasfjo.event.custom.CustomEventPublisher;
import phasfjo.event.eventworld.EventWorld;
import phasfjo.example.ExampleBean;
import phasfjo.javacollection.JavaCollection;
import phasfjo.javacollection.JavaCollection2;
import phasfjo.world.*;

import javax.swing.*;

/**
 * Created by paul on 29.05.2017.
 */

public class MainApp {

    private static final String STATEFUL = "WEB-INF/statefulBeans.xml";
    private static final String STATELESS = "WEB-INF/statelessBeans.xml";
    private static final String EXAMPLE = "WEB-INF/example.xml";
    private static final String EXAMPLE_TWO = "WEB-INF/exampleTwo.xml";
    private static final String BEAN = "WEB-INF/beans.xml";
    private static final String BEAN2 = "WEB-INF/beans2.xml";
    private static final String BEAN3 = "WEB-INF/beans3.xml";
    private static final String BEAN4 = "WEB-INF/beans4.xml";
    private static final String BEAN5 = "WEB-INF/beans5.xml";
    private static final String BEAN6 = "WEB-INF/beans6.xml";
    private static final String BEANS7 = "WEB-INF/beans7.xml";
    private static final String BEANS8 = "WEB-INF/beans8.xml";

    private static HelloWorld object, objectTwo;
    private static HelloWorldIndia objectA;
    private static ExampleBean exampleBean;

    public static void main(String[] args) {

        Object[] beansMenuArray = new Object[]{"another", "customEvent","event", "indian", "indian2", "javaCollection", "javaCollection2", "helloWorld", "helloWorld2", "new", "spellchecker", "spellchecker2", "run", "<<quit>>"};
        Object choiceTwo;
        String choice = "";
        String inputText = "Skriv inn og velg et av programmene: \n(Skriv 'quit' for å avslutte)\n\n  -anotherProgram\n  -customEvent\n  -event\n  -javaCollection\n  -javaCollection2\n  -indianNation\n  -indianNation2\n  -helloWorld\n  -helloWorld2\n  -spellchecker\n  -spellchecker2\n  -newProgram \n  -runAProgram\n\n";
        String space = "                             ";

        object = new HelloWorld();
        objectTwo = new HelloWorld();
        objectA = new HelloWorldIndia();
        exampleBean = new ExampleBean();

        /*
            Lage en application context som bruker framework API ClassPathXmlApplicationContext.
            Laster inn bean konfigurasjon som er basert på API-et. Som lager, initialiserer og konfigurer beans.
        */

        while (!(choice.equals("quit"))) {

            choiceTwo = JOptionPane.showInputDialog(null, inputText, space + "Hoved-meny", JOptionPane.PLAIN_MESSAGE, null, beansMenuArray, beansMenuArray[7]);
            // RUN PROGRAM
            menu(choiceTwo);
        }

        /* Hente bean fra HelloWorld class. Og returnerer et generisk objekt. Som kan castes til et aktuelt objekt. Dette objektet kan brukes for å kalle en klasse metode. */
    }

    private static void menu(Object inputValue) {
        String convertValueToString = (String) inputValue;
        switch (convertValueToString) {

            case "another":
                System.out.println("anotherProgram valgt...");
                anotherProgram();
                break;

            case "customEvent":
                System.out.println("custom event valt..");
                customEvent();
                break;

            case "event":
                System.out.println("eventhandler valgt...");
                eventHandler();
                break;

            case "new":
                System.out.println("newProgram valgt...");
                newProgram();
                break;

            case "indian":
                System.out.println("theIndianApp valgt...");
                theIndianApp();
                break;

            case "indian2":
                System.out.println("theIndianApp2 valgt...");
                theIndianApp2();
                break;

            case "javaCollection":
                System.out.println("javaCollection valgt...");
                javaCollection();
                break;

            case "javaCollection2":
                System.out.println("javaCollectionTwo valgt...");
                javaCollection2();
                break;

            case "helloWorld":
                System.out.println("Helloworld valgt...");
                helloWorld();
                break;

            case "helloWorld2":
                System.out.println("Helloworld2 valgt...");
                helloWorld2();
                break;

            case "spellchecker":
                System.out.println("spellchecker valgt...");
                spellchecker();
                break;

            case "spellchecker2":
                System.out.println("spellchecker2 valgt...");
                spellchecker2();
                break;

            case "run":
                System.out.println("runTheProgram valgt...");
                RunTheProgram();
                break;

            case "<<quit>>":
                JOptionPane.showMessageDialog(null, "Good bye!");
                System.out.println("Program shutting down...");
                System.exit(0);
                break;

            default:
                JOptionPane.showMessageDialog(null, "En feil oppdaget!\nVennligst skriv inn et av valgene fra menyen!");
        }
    }


    private static void anotherProgram() {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext(EXAMPLE_TWO);
        exampleBean = (ExampleBean) context.getBean("exampleBean");
        exampleBean.getMessage();
        context.registerShutdownHook();
    }

    private static void customEvent(){
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(BEANS8);
        CustomEventPublisher eventPublisher = (CustomEventPublisher) context.getBean("customEventPublisher");
        eventPublisher.publish();
        eventPublisher.publish();
    }

    private static void eventHandler() {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(BEANS7);
        context.start();
        EventWorld eventWorld = (EventWorld) context.getBean("eventWorld");
        eventWorld.setEventmessage("This event rules!!");
        eventWorld.getEventmessage();
        context.stop();
    }

    private static void helloWorld() {
        ApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfig.class);
        HelloWorld helloWorld = context.getBean(HelloWorld.class);
        helloWorld.setMessage1("Hello world!");
        helloWorld.getMessage1();

    }

    private static void helloWorld2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(HelloWorldImpl.class);
        context.register(MyService.class);
        context.refresh();

        MyService myService = context.getBean(MyService.class);

        myService.helloWorldIndia().setMessage1("Hello Indian world!");
        myService.helloWorld().setMessage1("Hello world 1");
        myService.helloWorld2().setMessage("Hello world 2!");
        myService.helloWorld3().setMessage("Hello world3!");

        myService.helloWorld().getMessage1();
        myService.helloWorld2().getMessage();
        myService.helloWorld3().getMessage();
        myService.helloWorldIndia().getMessage1();
    }

    private static void javaCollection() {
        ApplicationContext context = new ClassPathXmlApplicationContext(BEAN4);
        JavaCollection java = (JavaCollection) context.getBean("javaCollection");

        java.getAddressList();
        java.getAddressSet();
        java.getAddressMap();
        java.getAddressProp();
    }

    private static void javaCollection2() {
        ApplicationContext context2 = new ClassPathXmlApplicationContext(BEAN5);
        JavaCollection2 java2 = (JavaCollection2) context2.getBean("javaCollection");

        java2.getAddressList();
        java2.getAddressSet();
        java2.getAddressMap();
    }

    private static void newProgram() {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext(EXAMPLE);
        exampleBean = (ExampleBean) context.getBean("exampleBean");
        exampleBean.getMessage();
        context.registerShutdownHook();
    }

    private static void theIndianApp() {
        ApplicationContext context = new ClassPathXmlApplicationContext(BEAN);

        object = (HelloWorld) context.getBean("helloWorld");
        object.getMessage1();
        object.getMessage2();

        objectA = (HelloWorldIndia) context.getBean("helloIndia");
        objectA.getMessage1();
        objectA.getMessage2();
        objectA.getMessage3();
    }

    private static void theIndianApp2() {

        ApplicationContext context = new ClassPathXmlApplicationContext(BEAN2);

        objectA = (HelloWorldIndia) context.getBean("helloIndia");
        objectA.getMessage1();
        objectA.getMessage2();
        objectA.getMessage3();
    }

    private static void spellchecker() {
        ApplicationContext context = new ClassPathXmlApplicationContext(BEAN3);
        TextEditor textEditor = (TextEditor) context.getBean("textEditor");
        textEditor.spellCheck();
    }

    private static void spellchecker2() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TextEditorConfig.class);
        TextEditor2 textEditor2 = context.getBean(TextEditor2.class);
        textEditor2.spellCheck();
    }

    private static void RunTheProgram() {
        String space = "                         ";
        Object[] array = new Object[]{"stateful", "stateless"};
        Object valgTo;
        String inputTxt = "Velg mellom:\n\n-stateful bean\n-stateless bean\n\n";
        valgTo = JOptionPane.showInputDialog(null, inputTxt, space + "RUN_THE_PROGRAM", JOptionPane.PLAIN_MESSAGE, null, array, array[1]);
        String temp = (String) valgTo;

        switch (temp) {

            case "stateful":

                ApplicationContext context = new ClassPathXmlApplicationContext(STATEFUL);
                object = (HelloWorld) context.getBean("helloWorld");
                object.setMessage("I'am object A");
                object.getMessage();
                objectTwo = (HelloWorld) context.getBean("helloWorld");
                objectTwo.getMessage();

                break;

            case "stateless":
                context = new ClassPathXmlApplicationContext(STATELESS);
                HelloWorld object = (HelloWorld) context.getBean("helloWorld");
                object.setMessage("I'am object A");
                object.getMessage();
                HelloWorld object2 = (HelloWorld) context.getBean("helloWorld");
                object2.getMessage();

                break;

            default:
                JOptionPane.showMessageDialog(null, "Error");
        }

    }

}
