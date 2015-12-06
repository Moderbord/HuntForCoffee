package moderbord.huntforcoffee;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

/**
 * Created by Moderbord on 2015-12-05.
 */
public class EventManager {

    protected MainActivity main;
    public static String EventList[] = new String[10];

    public EventManager(Context context){
        this.main = (MainActivity) context;
    }

    public void addEvent(Button sender){
        String sText = sender.getText().toString();
        System.out.println(sText + "-button was sender");
        for (int i = 0; i < EventList.length; i++){
            if (EventList[i] == null){
                if (isEvent(sText)){
                    EventList[i] = sText;
                    System.out.println(sText + " added to EventList at index " + i);
                    break;
                } else {
                System.out.println("No event was added from sender");
                    break;
                }
            } else {
                System.out.println("EventList at index " + i + " was occupied by event: " + EventList[i]);
            }
        }
        getNextEvent();
    }

    public void addNextEvent(String event){
        for (int i = 0; i < EventList.length; i++){
            if (EventList[i] == null){
                EventList[i] = event;
                System.out.println(event + " added to EventList at index " + i);
                return;

            }
        }
    }

    public void getNextEvent(){
        String event = EventList[0];
        System.out.println("Try to match event");
        if (event.equals("Forrest")){
            System.out.println("Matched Forrest...");
            main.eventClass.getForrest();
        } else {
            System.out.println("No matching event. Continuing...");
            // Add return here??
        }
        EventList[0] = null;
        sortEventlist();
    }

    public void sortEventlist(){
        for(int i = 0; i < EventList.length; i++){
            int z = i + 1;
            if(EventList[i] == null && EventList[z] != null){
                EventList[i] = EventList[z];
                EventList[z] = null;
            } else {
                return;
            }
        }
        System.out.println("EventList sorted");
    }

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
                System.out.println("Button visibility set");
            }
        } else if (x == 1){
            for(int i = 0; i < buttonList.length; i++){
                buttonList[i].setText("");
            }
            System.out.println("Button text reset");
        }
    }

    public boolean isEvent(String event){
        if(event.equals("Forrest") || event.equals("City")){
            return true;
        } else {
            return false;
        }
    }

}
