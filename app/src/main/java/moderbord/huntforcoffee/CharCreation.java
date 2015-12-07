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

            String capName = tempName.substring(0, 1).toUpperCase() + tempName.substring(1);
            main.player.seteName(capName);

            main.appendText("Well well, aren't you a peculiar one " + main.player.geteName() + ".");
            main.submitText();
            main.appendInfo(main.player.geteName() + " huh? Not sure if I like it or not");
            main.submitInfo();

            main.eventManager.addNextEvent("ccPartFour");
        }
    }

    public void ccPartFour(){
        System.out.println("CCPARTFOUR from CharacterCreation here!");


    }

    public void ccPartFive(){
        System.out.println("CCPARTFIVE from CharacterCreation here!");

        
    }

    public void ccPartSix(){
        System.out.println("CCPARTSIX from CharacterCreation here!");
        main.ui.toggleButtons(1);
        main.button0.setText("Warrior");
        main.button1.setText("Druid");
        main.button2.setText("Spellbinder");
        main.ui.toggleButtons(2);

        main.appendText("Time to choose class!");
        main.submitText();

        main.eventManager.addNextEvent("ccPartSeven");
    }

    public void ccPartSeven(){
        System.out.println("CCPARTSEVEN from CharacterCreation here!");

        String choice = main.eventManager.getEventChoice();
        main.player.seteClass(choice);
        main.statClass.setText(choice);
        main.appendText("So " + choice + " it is huh? Figured.");
        main.appendText("\n\nAt the moment this is as far as we go. Please check back at a later time.");
        main.submitText();

        int phy, eInt, agi, qui, cha, luck, li, health, mana;
        System.out.println("Matching class...");
        if(choice.equals("Warrior")){
            System.out.println("Found " + choice);
            phy = 30; eInt = 10; agi = 15; qui = 15; cha = 20; luck = 10; li = 10; health = 200; mana = 20;
        } else if (choice.equals("Druid")){
            System.out.println("Found " + choice);
            phy = 20; eInt = 20; agi = 25; qui = 30; cha = 15; luck = 10; li = 10; health = 130; mana = 60;
        } else if (choice.equals("Spellbinder")){
            System.out.println("Found " + choice);
            phy = 10; eInt = 30; agi = 20; qui = 20; cha = 20; luck = 15; li = 10; health = 100; mana = 120;
        } else {
            System.out.println("Couldn't match class: " + choice + "!!");
            phy = 0; eInt = 0; agi = 0; qui = 0; cha = 0; luck = 0; li = 0; health = 0; mana = 0;
        }

        System.out.println("Updating UI stats..");
        try {
            main.player.seteLevel(1);
            main.player.seteClass(choice);
            main.player.setePhysique(phy);
            main.player.seteIntellect(eInt);
            main.player.seteAgility(agi);
            main.player.seteQuickness(qui);
            main.player.seteCharisma(cha);
            main.player.seteLuck(luck);
            main.player.seteLi(li);
            main.player.seteMaxHealth(health);
            main.player.seteHealth(health);
            main.player.seteMaxMana(mana);
            main.player.seteMana(mana);
            main.player.seteMaxFatigue(100);
            main.player.seteFatigue(0);
            main.player.seteLu(0);
            main.player.seteMinLu(0);
            main.player.seteExperience(0);
            main.player.seteExpToLvl(200);
            main.ui.updateStats(main.player);
        } catch (Exception e) {
            String error = e.getMessage();
            System.out.println(error);
        }

        main.ui.toggleButtons(1);
        main.button0.setText("Temp");
        main.ui.toggleButtons(2);

    }
}
