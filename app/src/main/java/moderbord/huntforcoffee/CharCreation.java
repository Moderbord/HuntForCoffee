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

    public void ccPartOne(){ //10000
        System.out.println("CCPARTONE from CharacterCreation here!");
        main.appendText("So this is where your journey will start");
        main.submitText();

        main.eventManager.addNextEvent("ccPartTwo" ,10000);
    }

    public void ccPartTwo(){ //20000
        System.out.println("CCPARTTWO from CharacterCreation here!");
        main.appendText("We will begin by getting to know your name");
        main.submitText();
        main.appendInfo("If you're smart you'll not enter you real name.");
        main.submitInfo();

        main.nameInput.setVisibility(View.VISIBLE);

        main.eventManager.addNextEvent("ccPartThree" ,20000);
    }

    public void ccPartThree(){ //30000
        System.out.println("CCPARTTHREE from CharacterCreation here!");
        main.nameInput.setVisibility(View.INVISIBLE);
        tempName = main.nameInput.getText().toString();
        if (tempName.length() < 2 || tempName.length() > 16 || tempName.isEmpty() || tempName.matches(".*\\d.*")){
            main.appendText("Try entering a better name");
            main.submitText();
            main.eventManager.addNextEvent("ccPartTwo" ,30000);
        } else {
            System.out.println("Good choice of name detected");
            main.nameInput.setVisibility(View.GONE);
            System.out.println("Removed input window");

            String capName = main.ui.toUp(tempName);
            main.player.seteName(capName);

            main.appendText("Well well, aren't you a peculiar one " + main.player.geteName() + ".");
            main.appendText("\n\nWhat is your gender?");
            main.submitText();
            main.appendInfo(main.player.geteName() + " huh? Not sure if I like it or not");
            main.appendInfo("\n\nIs there a 3rd gender coming??");
            main.submitInfo();

            main.ui.toggleButtons(1);
            main.button0.setText("Male");
            main.button1.setText("Female");
            main.ui.toggleButtons(2);

            main.eventManager.addNextEvent("ccPartFour" ,30000);
        }
    }

    public void ccPartFour(){ //40000
        System.out.println("CCPARTFOUR from CharacterCreation here!");
        String gender = main.eventManager.getEventChoice();
        main.player.seteGender(main.ui.toLow(gender));
        System.out.println("Chose " + gender + "?");

        main.appendText("You also have the opportunity to choose a race...");
        main.submitText();
        main.appendInfo("Be wise!");
        main.submitInfo();

        main.ui.toggleButtons(1);
        main.button0.setText("Human");
        main.button1.setText("Orc");
        main.button2.setText("Elf");
        main.ui.toggleButtons(2);

        main.eventManager.addNextEvent("ccPartFive" ,40000);
    }

    public void ccPartFive(){ //50000
        System.out.println("CCPARTFIVE from CharacterCreation here!");
        String race = main.eventManager.getEventChoice();
        main.player.seteRace(main.ui.toLow(race));

        main.appendText("...and a class...");
        main.submitText();

        main.ui.toggleButtons(1);
        String class1, class2, class3;
        System.out.println("Matching " + race + " to classes..");
        if(race.equals("Human")){
            System.out.println("Showing human classes");
            class1 = "Ranger"; class2 = "Spellbinder"; class3 = "Duelist";
        } else if (race.equals("Orc")){
            System.out.println("Showing orc classes");
            class1 = "Berserk"; class2 = "Shaman"; class3 = "Packmaster";
        } else {
            System.out.println("Showing elf classes");
            class1 = "Sentinel"; class2 = "Farseer"; class3 = "Druid";
        }
        main.button0.setText(class1);
        main.button1.setText(class2);
        main.button2.setText(class3);
        main.ui.toggleButtons(2);

        main.eventManager.addNextEvent("ccPartSix" ,50000);
    }

    public void ccPartSix(){ //60000
        System.out.println("CCPARTSIX from CharacterCreation here!");
        String eClass = main.eventManager.getEventChoice();
        main.player.seteClass(main.ui.toLow(eClass));
        main.statClass.setText(eClass);

        main.appendText("...and finally a faction.");
        main.submitText();
        main.appendInfo("So " + eClass + " it is huh? Figured.");
        main.submitInfo();

        main.ui.toggleButtons(1);
        String cho1, cho2, cho3;
        if(main.player.geteRace().equals("human")){
            cho1 = "Protectors"; cho2 = "Factionless"; cho3 = "Demonic";
        } else if (main.player.geteRace().equals("orc")){
            cho1 = "Protectors"; cho2 = "Undaunted"; cho3 = "Demonic";
        } else {
            cho1 = "Protectors"; cho2 = "Devaint"; cho3 = "Demonic";
        }
        main.button0.setText(cho1);
        main.button1.setText(cho2);
        main.button2.setText(cho3);
        main.ui.toggleButtons(2);

        main.eventManager.addNextEvent("ccPartSeven" ,60000);
    }

    public void ccPartSeven(){ //70000
        System.out.println("CCPARTSEVEN from CharacterCreation here!");
        String faction = main.eventManager.getEventChoice();
        main.player.seteFaction(faction);
        if(faction.equals("Factionless")){
            main.appendText("You decided to be a factionless human? How pitiful.");
        } else if (faction.equals("Demonic")){
            main.appendText("A demon huh? Your journey will become interesting to say the least");
        } else {
            main.appendText("You are one of the " + faction + ". Will you do your best?");
        }

        main.appendText("\n\nThis concludes character creation.");
        main.appendText("\n\nHave fun!");
        main.submitText();

        main.appendInfo("Good job!");
        main.submitInfo();

        String eClass = main.player.geteClass();
        int phy, eInt, agi, qui, cha, luck, li, health, mana;
        System.out.println("Matching class...");
        if(eClass.equals("ranger") || eClass.equals("berserk") || eClass.equals("sentinel")){
            System.out.println("Found " + eClass);
            phy = 30; eInt = 10; agi = 15; qui = 15; cha = 20; luck = 10; li = 10; health = 200; mana = 20;
        } else if (eClass.equals("duelist") || eClass.equals("packmaster") || eClass.equals("druid")){
            System.out.println("Found " + eClass);
            phy = 20; eInt = 20; agi = 25; qui = 30; cha = 15; luck = 10; li = 10; health = 130; mana = 60;
        } else if (eClass.equals("spellbinder") || eClass.equals("shaman") || eClass.equals("farseer")){
            System.out.println("Found " + eClass);
            phy = 10; eInt = 30; agi = 20; qui = 20; cha = 20; luck = 15; li = 10; health = 100; mana = 120;
        } else {
            System.out.println("Couldn't match class: " + eClass + "!!");
            phy = 0; eInt = 0; agi = 0; qui = 0; cha = 0; luck = 0; li = 0; health = 0; mana = 0;
        }

        System.out.println("Updating UI and player stats..");
        try {
            main.player.seteLevel(1);
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
            main.ui.updateStatsAll(main.player);
        } catch (Exception e) {
            String error = e.getMessage();
            System.out.println(error);
        }

        main.eventManager.addNextEvent("introGood" ,70000);

        main.ui.toggleButtons(1);
        main.button0.setText("Begin...");
        main.ui.toggleButtons(2);

    }
}
