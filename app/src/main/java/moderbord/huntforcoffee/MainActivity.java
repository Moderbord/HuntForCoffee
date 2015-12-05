package moderbord.huntforcoffee;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView mainTextWindow, subTextWindow, statStr, statInt, statAgi, statQui, statCha, statLuck, statLi, statHealth, statMana, statFatigue, statLu, statLvl, statClass, timeClock, timeDate;
    Button bu0, bu1, bu2, bu3, bu4, bu5, bu6, bu7, bu8, bu9;
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
    }

    public void appendText(String append){
        text = text + " " + append;
    }

    public void submitText(){
        mainTextWindow.setText(text);
    }

    public void b0(View view){
        bu0 = (Button)findViewById(R.id.b0);
        submitText();
        text = "";
    }

    public void b1(View view){
        bu1 = (Button)findViewById(R.id.b1);
        appendText("test ");
        System.out.println(text);
    }

    public void b2(View view){
        bu2 = (Button)findViewById(R.id.b2);
        appendText(bu2.getText().toString());
        submitText();
        text = "";
    }

    public void b3(View view){
        bu2 = (Button)findViewById(R.id.b3);
    }

    public void b4(View view){
        bu2 = (Button)findViewById(R.id.b4);
    }

    public void b5(View view){
        bu2 = (Button)findViewById(R.id.b5);
    }

    public void b6(View view){
        bu2 = (Button)findViewById(R.id.b6);
    }

    public void b7(View view){
        bu2 = (Button)findViewById(R.id.b7);
    }

    public void b8(View view){
        bu2 = (Button)findViewById(R.id.b8);
    }

    public void b9(View view){
        bu2 = (Button)findViewById(R.id.b9);
    }
}