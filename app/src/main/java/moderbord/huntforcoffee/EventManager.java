package moderbord.huntforcoffee;

import android.content.Context;
import android.widget.Button;

/**
 * Created by Moderbord on 2015-12-05.
 */
public class EventManager {

    protected MainActivity main;
    public String eventList[] = new String[10];
    public String eventChoice;
    public int caller;

    public EventManager(Context context){
        this.main = (MainActivity) context;
    }

    public void addEvent(Button sender){
        String sText = sender.getText().toString();
        System.out.println(sText + "-button was sender");
        eventChoice = sText;
        for (int i = 0; i < eventList.length; i++){
            if (eventList[i] == null){
                if (isEvent(sText)){
                    eventList[i] = sText;
                    System.out.println(sText + " added to eventList at index " + i);
                    break;
                } else {
                System.out.println("No event was added from sender");
                    break;
                }
            } else {
                System.out.println("eventList at index " + i + " was occupied by event: " + eventList[i]);
            }
        }
        getNextEvent();
    }

    public void addNextEvent(String event, int caller){
        this.caller = caller;
        for (int i = 0; i < eventList.length; i++){
            if (eventList[i] == null){
                eventList[i] = event;
                System.out.println(event + " added to eventList at index " + i);
                return;

            }
        }
    }

    public void getNextEvent(){
        String event = eventList[0];
        System.out.println("Try to match event");

        if (event.equals("ccPartOne")){
            System.out.println("Matched " + event + "...");
            main.charCreation.ccPartOne();

        } else if (event.equals("ccPartTwo")){
            System.out.println("Matched " + event + "...");
            main.charCreation.ccPartTwo();

        } else if (event.equals("ccPartThree")){
            System.out.println("Matched " + event + "...");
            main.charCreation.ccPartThree();

        } else if (event.equals("ccPartFour")){
            System.out.println("Matched " + event + "...");
            main.charCreation.ccPartFour();

        } else if (event.equals("ccPartFive")){
            System.out.println("Matched " + event + "...");
            main.charCreation.ccPartFive();

        } else if (event.equals("ccPartSix")){
            System.out.println("Matched " + event + "...");
            main.charCreation.ccPartSix();

        } else if (event.equals("ccPartSeven")){
            System.out.println("Matched " + event + "...");
            main.charCreation.ccPartSeven();

        } else if (event.equals("introGood")){
            System.out.println("Matched " + event + "...");
            main.charCreation.ccPartSeven();

        } else if (event.equals("Forrest") && caller == 80000){
            System.out.println("Matched " + event + " with caller: " + "80000...");
            main.eventClass.getForrest();

        } else if (event.equals("Hero") && caller == 80000){
            System.out.println("Matched " + event + " with caller: " + "80000...");
            main.eventClass.getForrest();

        } else {
            System.out.println("No matching event. Continuing...");
            // Add return here??
        }
        System.out.println("Removing " + event + " from Eventlist index 0...");
        eventList[0] = null;
        System.out.println("Event removed. Sorting list...");
        sortEventlist();
    }

    public void sortEventlist(){
        for(int i = 0; i < eventList.length; i++){
            int z = i + 1;
            if(eventList[i] == null && eventList[z] != null){
                eventList[i] = eventList[z];
                eventList[z] = null;
                System.out.println(eventList[i] + " is now at index " + i + " from index " + z);
            } else {
                System.out.println("eventList sorted");
                return;
            }
        }
    }

    public String getEventChoice(){
        return eventChoice;
    }

    public void setCaller(int i){
        this.caller = i;
    }

    public boolean isEvent(String event){
        if(event.equals("Forrest") || event.equals("Hero")){
            return true;
        } else {
            return false;
        }
    }

}
