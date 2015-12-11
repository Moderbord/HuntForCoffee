package moderbord.huntforcoffee.Enteties;

import android.content.Context;

import moderbord.huntforcoffee.Entity;

/**
 * Created by Moderbord on 2015-12-07.
 */
public class Player extends Entity{

    public Player(String eName, String eGender, String eClass, String eRace, String eFaction, int eLevel, int ePhysique, int eIntellect, int eAgility, int eQuickness, int eCharisma, int eLuck, int eLi, int eMaxHealth, int eHealth, int eMaxMana, int eMana, int eMaxFatigue, int eFatigue, int eLu, int eMinLu, int eExperience, int eExpToLvl) {
        super(eName, eGender, eClass, eRace, eFaction, eLevel, ePhysique, eIntellect, eAgility, eQuickness, eCharisma, eLuck, eLi, eMaxHealth, eHealth, eMaxMana, eMana, eMaxFatigue, eFatigue, eLu, eMinLu, eExperience, eExpToLvl);
    }

    public void tempDisc(){
        main.appendText("YOU ARE STRONG!");
        main.submitText();

        main.ui.toggleButtons(1);
        main.button9.setText("Back");
        main.ui.toggleButtons(2);
    }

}
