package moderbord.huntforcoffee;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import moderbord.huntforcoffee.Enteties.Player;

/**
 * Created by Moderbord on 2015-12-03.
 */
public class Ui extends Activity{

    protected MainActivity main;

    public Ui(Context context){
        this.main = (MainActivity) context;
    }

    /**
     *
     * @param x Acts as a switch for different button resets. 1 will clear each button of its
     *          text. 2 will check each button if it contains text and will otherwise hide it.
     */
    public void toggleButtons(int x){
        Button buttonList[] = new Button[10];
        if (x == 2) {
            for(int i = 0; i < buttonList.length; i++){
                buttonList[i]=main.attachButton(i);
                if (buttonList[i].getText().toString().equals("")){
                    buttonList[i].setVisibility(View.INVISIBLE);
                    //System.out.println("Button " + i + " set INVISIBLE");
                } else {
                    buttonList[i].setVisibility(View.VISIBLE);
                    //System.out.println("Button " + i + " set VISIBLE");
                }
            }
            System.out.println("ALL BUTTON VISIBILITY RESET");
        } else if (x == 1){
            for(int i = 0; i < buttonList.length; i++){
                buttonList[i]=main.attachButton(i);
                buttonList[i].setText("");
                //System.out.println("Button " + i + " TEXT was reset");
            }
            System.out.println("ALL BUTTON TEXT RESET");
        }
    }

    public void updateStatsAll(Entity player){
        updateLevel(player);
        updateClass(player);
        updateStats(player);
        updateState(player);
    }

    public void updateLevel(Entity player){
        main.statLvl.setText("Level " + player.geteLevel());
    }

    public void updateClass(Entity player){
        main.statClass.setText(toUp(player.geteClass()));
    }

    public void updateStats(Entity player){
        main.statPhy.setText("Physique " + player.getePhysique());
        main.statInt.setText("Intellect " + player.geteIntellect());
        main.statAgi.setText("Agility " + player.geteAgility());
        main.statQui.setText("Quickness " + player.geteQuickness());
        main.statCha.setText("Charm " + player.geteCharisma());
        main.statLuck.setText("Luck " + player.geteLuck());
        main.statLi.setText("Li "+ player.geteLi());
    }

    public void updateState(Entity player){
        main.statHealth.setText("Health " + player.geteHealth());
        main.statMana.setText("Mana "+ player.geteMana());
        main.statFatigue.setText("Fatigue " + player.geteFatigue());
        main.statLu.setText("Lu " + player.geteLu());
    }

    public String toUp(String str){
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public String toLow(String str){
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

}