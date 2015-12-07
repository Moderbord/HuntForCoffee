package moderbord.huntforcoffee;


import android.content.Context;

/**
 * Created by Moderbord on 2015-12-05.
 */
public class EventClass {

    protected MainActivity main;

    public EventClass(Context context){
        this.main = (MainActivity) context;
    }

    public void getForrest(){
        System.out.println("FORREST from EventClass here!");
        main.appendText("Welcome to the jungle!");
        main.appendText("We hope you brought lotion.");
        main.submitText();

        main.ui.toggleButtons(1);
        main.button0.setText("Lotion");
        main.ui.toggleButtons(2);

    }

}
