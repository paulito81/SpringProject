package phasfjo.event.eventworld;

/**
 * Created by paulito on 08.06.2017.
 */
public class EventWorld {
    private String eventmessage;

    public String getEventmessage() {
        System.out.println("Your message : " + eventmessage);
        return eventmessage;
    }

    public void setEventmessage(String eventmessage) {
        this.eventmessage = eventmessage;
    }


}
