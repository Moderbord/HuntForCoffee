package moderbord.huntforcoffee.Enteties;

import moderbord.huntforcoffee.Entity;

/**
 * Created by Moderbord on 2015-12-07.
 */
public class Player extends Entity{

    public Player(String eName, String eGender, String eClass, String eRace, String eFaction, int eLevel, int ePhysique, int eIntellect, int eAgility, int eQuickness, int eCharisma, int eLuck, int eLi, int eMaxHealth, int eHealth, int eMaxMana, int eMana, int eMaxFatigue, int eFatigue, int eLu, int eMinLu, int eExperience, int eExpToLvl) {
        super(eName, eGender, eClass, eRace, eFaction, eLevel, ePhysique, eIntellect, eAgility, eQuickness, eCharisma, eLuck, eLi, eMaxHealth, eHealth, eMaxMana, eMana, eMaxFatigue, eFatigue, eLu, eMinLu, eExperience, eExpToLvl);
    }

    public void info(){ // ID 11111
        System.out.println("INFO from Player here!");
        sub.appendText("YOU ARE STRONG!");
        sub.submitText();

        sub.ui.toggleButtons(1);
        sub.eventManager.clrEventList();
        sub.eventManager.prepEvent("Back", 99980, 9);
        sub.ui.toggleButtons(2);
    }
}
