package phasfjo.event.custom;

import org.springframework.context.ApplicationEvent;

/**
 * Created by paulito on 08.06.2017.
 */
public class CustomEvent extends ApplicationEvent {

    public CustomEvent(Object source) {
        super(source);
    }
    public String toString() {
        return "My Custom Event";
    }
}
