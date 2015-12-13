package moderbord.huntforcoffee;

import android.content.Context;
import android.widget.Button;

/**
 * Created by Moderbord on 2015-12-05.
 */
public class EventManager {

    protected MainActivity main;
    public int eventList[] = new int[10];
    public String eventChoice;

    public EventManager(Context context){
        this.main = (MainActivity) context;
    }

    /**
     *
     * @param text The text that will appear on the button.
     * @param eventID ID of the event to be added in the prepList.
     * @param button On which button, 0-9.
     */
    public void prepEvent(String text, int eventID, int button){
        Button receiver = main.attachButton(button);
        receiver.setText(text);
        addNextEvent(button, eventID);
    }

    public void getNextEvent(int bIndex, String text){
        eventChoice = text;
        if (eventList[bIndex] != 0){
            System.out.println("Try to match event with ID: " + eventList[bIndex] + " with index: " + bIndex);

            if (eventList[bIndex] == 99991){
                System.out.println("Matched event with ID " + eventList[bIndex] + "...");
                main.charCreation.ccPartOne();

            } else if (eventList[bIndex] == 99992){
                System.out.println("Matched event with ID " + eventList[bIndex] + "...");
                main.charCreation.ccPartTwo();

            } else if (eventList[bIndex] == 99993){
                System.out.println("Matched event with ID " + eventList[bIndex] + "...");
                main.charCreation.ccPartThree();

            } else if (eventList[bIndex] == 99994){
                System.out.println("Matched event with ID " + eventList[bIndex] + "...");
                main.charCreation.ccPartFour();

            } else if (eventList[bIndex] == 99995){
                System.out.println("Matched event with ID " + eventList[bIndex] + "...");
                main.charCreation.ccPartFive();

            } else if (eventList[bIndex] == 99996){
                System.out.println("Matched event with ID " + eventList[bIndex] + "...");
                main.charCreation.ccPartSix();

            } else if (eventList[bIndex] == 99997){
                System.out.println("Matched event with ID " + eventList[bIndex] + "...");
                main.charCreation.ccPartSeven();

            } else if (eventList[bIndex] == 99980){
                System.out.println("Matched event with ID " + eventList[bIndex] + "...");
                main.eventClass.introGood();

            } else if (eventList[bIndex] == 11111){
                System.out.println("Matched event with ID " + eventList[bIndex] + "...");
                main.player.info();

            } else if (eventList[bIndex] == 10001){
                System.out.println("Matched event with ID " + eventList[bIndex] + "...");
                main.eventClass.getForrest();

            } else if (eventList[bIndex] == 8008){
                System.out.println("Matched event with ID " + eventList[bIndex] + "...");
                main.saveLoad.mainMenu();

            } else if (eventList[bIndex] == 9000){
                System.out.println("Matched event with ID " + eventList[bIndex] + "...");
                main.saveLoad.saveGame();

            } else if (eventList[bIndex] == 9001){
                System.out.println("Matched event with ID " + eventList[bIndex] + "...");
                main.saveLoad.saveGameSlot();

            } else if (eventList[bIndex] == 9002){
                System.out.println("Matched event with ID " + eventList[bIndex] + "...");
                main.saveLoad.loadGame();

            } else if (eventList[bIndex] == 9003){
                System.out.println("Matched event with ID " + eventList[bIndex] + "...");
                main.saveLoad.loadGameSlot();

            } else if (eventList[bIndex] == 9099){
                System.out.println("Matched event with ID " + eventList[bIndex] + "...");
                main.saveLoad.gameOptions();

            } else {
                System.out.println("No matching event.");
                return;
            }
        }
    }

    public void addNextEvent(int i, int eventID){
        eventList[i] = eventID;
        System.out.println("Event with ID " + eventID + " added to eventList at index " + i);
    }

    public void clrEventList(){
        for (int i = 0; i < eventList.length; i++){
            eventList[i]=0;
        }
    }

    public String getEventChoice(){
        return eventChoice;
    }

}
