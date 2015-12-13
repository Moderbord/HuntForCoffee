package moderbord.huntforcoffee.Enteties;

import android.content.Context;

import moderbord.huntforcoffee.Entity;

/**
 * Created by Moderbord on 2015-12-07.
 */
public class Player extends Entity{

    public Player(Context context, String eName, String eGender, String eClass, String eRace, String eFaction, int eLevel, int ePhysique, int eIntellect, int eAgility, int eQuickness, int eCharisma, int eLuck, int eLi, int eMaxHealth, int eHealth, int eMaxMana, int eMana, int eMaxFatigue, int eFatigue, int eLu, int eMinLu, int eExperience, int eExpToLvl) {
        super(context, eName, eGender, eClass, eRace, eFaction, eLevel, ePhysique, eIntellect, eAgility, eQuickness, eCharisma, eLuck, eLi, eMaxHealth, eHealth, eMaxMana, eMana, eMaxFatigue, eFatigue, eLu, eMinLu, eExperience, eExpToLvl);
    }

    public void info(){ // ID 11111
        main.flags.mainMenu = false;
        System.out.println("INFO from Player here!");
        main.appendText("YOU ARE STRONG " + geteName() + "!");
        main.submitText();

        main.ui.toggleButtons(1);
        main.eventManager.clrEventList();
        main.eventManager.prepEvent("Options", 9099, 4);
        main.eventManager.prepEvent("Back", 99980, 9); //IntroGood
        main.ui.toggleButtons(2);
    }
}
