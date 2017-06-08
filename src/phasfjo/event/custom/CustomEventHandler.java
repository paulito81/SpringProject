package phasfjo.event.custom;

import org.springframework.context.ApplicationListener;

/**
 * Created by paulito on 08.06.2017.
 */
public class CustomEventHandler implements ApplicationListener<CustomEvent> {

    @Override
    public void onApplicationEvent(CustomEvent customEvent) {
        System.out.println(customEvent.toString());
    }
}
