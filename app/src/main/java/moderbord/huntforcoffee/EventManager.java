package moderbord.huntforcoffee;

import android.content.Context;
import android.view.View;
import android.widget.Button;

/**
 * Created by Moderbord on 2015-12-05.
 */
public class EventManager {

    protected MainActivity main;
    public String eventList[] = new String[10];
    public String eventChoice;

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

    public void addNextEvent(String event){
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

    /**
     *
     * @param x Acts as a switch for different button resets. 1 will clear each button of its
     *          text. 2 will check each button if it contains text and will otherwise hide it.
     */
    public void toggleButtons(int x){
        Button buttonList[] = new Button[10];
        buttonList[0] = main.button0;
        buttonList[1] = main.button1;
        buttonList[2] = main.button2;
        buttonList[3] = main.button3;
        buttonList[4] = main.button4;
        buttonList[5] = main.button5;
        buttonList[6] = main.button6;
        buttonList[7] = main.button7;
        buttonList[8] = main.button8;
        buttonList[9] = main.button9;
        if (x == 2) {
            for(int i = 0; i < buttonList.length; i++){
                if (buttonList[i].getText().toString().equals("")){
                    buttonList[i].setVisibility(View.INVISIBLE);
                } else {
                    buttonList[i].setVisibility(View.VISIBLE);
                }
                System.out.println("Button visibility reset");
            }
        } else if (x == 1){
            for(int i = 0; i < buttonList.length; i++){
                buttonList[i].setText("");
            }
            System.out.println("Button text reset");
        }
    }

    public String getEventChoice(){
        return eventChoice;
    }

    public boolean isEvent(String event){
        if(event.equals("Forrest") || event.equals("City")){
            return true;
        } else {
            return false;
        }
    }

}
