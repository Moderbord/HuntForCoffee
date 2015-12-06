package moderbord.huntforcoffee;

import android.content.Context;
import android.view.View;

/**
 * Created by Moderbord on 2015-12-06.
 */
public class CharCreation {

    protected MainActivity main;
    public String tempName;

    public CharCreation(Context context){
        this.main = (MainActivity) context;
    }

    public void ccPartOne(){
        System.out.println("CCPARTONE from CharacterCreation here!");
        main.appendText("So this is where your journey will start");
        main.submitText();

        main.eventManager.addNextEvent("ccPartTwo");
    }

    public void ccPartTwo(){
        System.out.println("CCPARTTWO from CharacterCreation here!");
        main.appendText("We will begin by getting to know your name");
        main.submitText();
        main.appendInfo("If you're smart you'll not enter you real name.");
        main.submitInfo();

        main.nameInput.setVisibility(View.VISIBLE);

        main.eventManager.addNextEvent("ccPartThree");
    }

    public void ccPartThree(){
        System.out.println("CCPARTTHREE from CharacterCreation here!");
        main.nameInput.setVisibility(View.INVISIBLE);
        tempName = main.nameInput.getText().toString();
        if (tempName.length() < 2 || tempName.length() > 16 || tempName.isEmpty() || tempName.matches(".*\\d.*")){
            main.appendText("Try entering a better name");
            main.submitText();
            main.eventManager.addNextEvent("ccPartTwo");
        } else {
            System.out.println("Good choice of name detected");
            main.nameInput.setVisibility(View.GONE);
            System.out.println("Removed input window");

            main.appendText("Well well, aren't you a peculiar one, " + tempName + "?");
            main.appendText("\n\nAt the moment this is as far as we go. Please check back at a later date.");
            main.submitText();
        }
    }

}
