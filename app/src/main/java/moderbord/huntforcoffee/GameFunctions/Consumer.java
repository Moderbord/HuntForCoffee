package moderbord.huntforcoffee.GameFunctions;

import android.content.Context;

import moderbord.huntforcoffee.Entity;
import moderbord.huntforcoffee.MainActivity;

/**
 * Created by Moderbord on 2015-12-15.
 */
public class Consumer {

    protected MainActivity main;

    public Consumer(Context context){
        this.main = (MainActivity) context;
    }

    public void consumeSwitch(Entity entity, Item iName){
        main.flags.consuming = true;
        switch (iName.getiName()){
            case "burger":
                conBurger(entity);
                break;
            default:
                main.appendText("You can't consume that!!");
                main.flags.consuming = false;
                break;
        }
    }

    public void conBurger(Entity entity){
        main.appendText("That must have been one of the most delicious burger you have ever eaten! So much. in fact," +
                " that you feel more vigorated than before.");
        entity.seteLu(entity.geteLu() + 1);
        main.ui.updateState(entity);
    }




}
