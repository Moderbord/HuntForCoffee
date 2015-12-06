package moderbord.huntforcoffee;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    
    public EventManager eventManager = new EventManager(this);
    public EventClass eventClass = new EventClass(this);
    public CharCreation charCreation = new CharCreation(this);


    TextView mainTextWindow, subTextWindow, statStr, statInt, statAgi, statQui, statCha, statLuck, statLi, statHealth, statMana, statFatigue, statLu, statLvl, statClass, timeClock, timeDate;
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    String text = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainTextWindow = (TextView)findViewById(R.id.mainTextWindow);
        subTextWindow = (TextView)findViewById(R.id.subTextWindow);
        statStr = (TextView)findViewById(R.id.statStr);
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

    }

    public void appendText(String append){
        text = text + append + " ";
    }

    public void submitText(){
        mainTextWindow.setText(text);
        text = "";
    }

    public void b0(View view){
        eventManager.addEvent(button0);
    }

    public void b1(View view){
    }

    public void b2(View view){
    }

    public void b3(View view){
    }

    public void b4(View view){
    }

    public void b5(View view){
    }

    public void b6(View view){
    }

    public void b7(View view){
    }

    public void b8(View view){
    }

    public void b9(View view){
    }
}
