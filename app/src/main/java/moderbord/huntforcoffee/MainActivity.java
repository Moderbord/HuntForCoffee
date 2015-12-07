package moderbord.huntforcoffee;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import moderbord.huntforcoffee.Enteties.Player;

public class MainActivity extends Activity {

    public EventManager eventManager = new EventManager(this);
    public EventClass eventClass = new EventClass(this);
    public CharCreation charCreation = new CharCreation(this);
    public Ui ui = new Ui(this);
    public Player player = new Player(null, null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);


    TextView mainTextWindow, subTextWindow, statPhy, statInt, statAgi, statQui, statCha, statLuck, statLi, statHealth, statMana, statFatigue, statLu, statLvl, statClass, timeClock, timeDate;
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    EditText nameInput;
    String text = "", info = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainTextWindow = (TextView)findViewById(R.id.mainTextWindow);
        subTextWindow = (TextView)findViewById(R.id.subTextWindow);
        statPhy = (TextView)findViewById(R.id.statPhy);
        statInt = (TextView)findViewById(R.id.statInt);
        statAgi = (TextView)findViewById(R.id.statAgi);
        statQui = (TextView)findViewById(R.id.statQui);
        statCha = (TextView)findViewById(R.id.statCha);
        statLuck = (TextView)findViewById(R.id.statLuck);
        statLi = (TextView)findViewById(R.id.statLi);
        statHealth = (TextView)findViewById(R.id.statHealth);
        statMana = (TextView)findViewById(R.id.statMana);
        statFatigue = (TextView)findViewById(R.id.statFatigue);
        statLu = (TextView)findViewById(R.id.statLu);
        statLvl = (TextView)findViewById(R.id.statLvl);
        statClass = (TextView)findViewById(R.id.statClass);
        timeClock = (TextView)findViewById(R.id.timeClock);
        timeDate = (TextView)findViewById(R.id.timeDate);

        button0 = (Button)findViewById(R.id.b0);
        button1 = (Button)findViewById(R.id.b1);
        button2 = (Button)findViewById(R.id.b2);
        button3 = (Button)findViewById(R.id.b3);
        button4 = (Button)findViewById(R.id.b4);
        button5 = (Button)findViewById(R.id.b5);
        button6 = (Button)findViewById(R.id.b6);
        button7 = (Button)findViewById(R.id.b7);
        button8 = (Button)findViewById(R.id.b8);
        button9 = (Button)findViewById(R.id.b9);

        nameInput = (EditText)findViewById(R.id.nameInput);
        eventManager.addNextEvent("ccPartOne");
    }

    public void appendText(String append){
        text = text + append + " ";
    }

    public void submitText(){
        mainTextWindow.setText(text);
        text = "";
    }

    public void appendInfo(String append){
        info = info + append + " ";
    }

    public void submitInfo(){
        subTextWindow.setText(info);
        info = "";
    }

    public void b0(View view){
        eventManager.addEvent(button0);
    }

    public void b1(View view){
        eventManager.addEvent(button1);
    }

    public void b2(View view){
        eventManager.addEvent(button2);
    }

    public void b3(View view){
        eventManager.addEvent(button3);
    }

    public void b4(View view){
        eventManager.addEvent(button4);
    }

    public void b5(View view){
        eventManager.addEvent(button5);
    }

    public void b6(View view){
        eventManager.addEvent(button6);
    }

    public void b7(View view){
        eventManager.addEvent(button7);
    }

    public void b8(View view){
        eventManager.addEvent(button8);
    }

    public void b9(View view){
        eventManager.addEvent(button9);
    }
}
