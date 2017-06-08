package phasfjo.event.eventworld;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

import java.util.Calendar;

/**
 * Created by paulito on 08.06.2017.
 */
public class CStartEventHandler implements ApplicationListener<ContextStartedEvent> {

    public void onApplicationEvent(ContextStartedEvent event) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(event.getTimestamp());

        System.out.println("ContextStartedEvent Received : " + calendar.getTime());
    }

}
