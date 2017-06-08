package phasfjo.event.eventworld;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;

import java.util.Calendar;

/**
 * Created by paulito on 08.06.2017.
 */
public class CStopEventHandler implements ApplicationListener<ContextStoppedEvent> {

    public void onApplicationEvent(ContextStoppedEvent event){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(event.getTimestamp());
        System.out.println("ContextStoppedEvent Received : " + calendar.getTime());
    }

}
