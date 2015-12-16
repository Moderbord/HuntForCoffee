package moderbord.huntforcoffee;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import moderbord.huntforcoffee.Enteties.Player;
import moderbord.huntforcoffee.GameFunctions.Consumer;
import moderbord.huntforcoffee.GameFunctions.Item;

public class MainActivity extends Activity {

    public EventManager eventManager = new EventManager(this);
    public EventClass eventClass = new EventClass(this);
    public CharCreation charCreation = new CharCreation(this);
    public Ui ui = new Ui(this);
    public Flags flags = new Flags(this);
    public SaveLoad saveLoad = new SaveLoad(this);
    public Item item = new Item(this);
    public EntityInitiator entityInitiator = new EntityInitiator(this);
    public Consumer consumer = new Consumer(this);
    public Entity player = new Player(this, null, null, null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null, null, null, null, null, null, null);
    public Entity jheero;


    TextView mainTextWindow, subTextWindow, statPhy, statInt, statAgi, statQui, statCha, statLuck, statLi, statHealth, statMana, statFatigue, statLu, statLvl, statClass, timeClock, timeDate;
    public Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    EditText nameInput;
    String text = "", info = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Move to other place?
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

        nameInput = (EditText)findViewById(R.id.nameInput);
        eventManager.addNextEvent(0, 8008); //MainMenu
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

    public void buttonClick(View view){
        Button b = (Button)view;
        int id = Integer.parseInt(b.getTag().toString());
        String text = b.getText().toString();
        eventManager.getNextEvent(id, text);
    }

    public Button attachButton (int i){
        //System.out.println("Attaching button with index: " +i + "...");
        Button button;
        switch (i){
            case 0:
                button = (Button)findViewById(R.id.b0);
                //System.out.println("..Attached button " +i);
                break;
            case 1:
                button = (Button)findViewById(R.id.b1);
                //System.out.println("..Attached button " +i);
                break;
            case 2:
                button = (Button)findViewById(R.id.b2);
                //System.out.println("..Attached button " +i);
                break;
            case 3:
                button = (Button)findViewById(R.id.b3);
                //System.out.println("..Attached button " +i);
                break;
            case 4:
                button = (Button)findViewById(R.id.b4);
                //System.out.println("..Attached button " +i);
                break;
            case 5:
                button = (Button)findViewById(R.id.b5);
                //System.out.println("..Attached button " +i);
                break;
            case 6:
                button = (Button)findViewById(R.id.b6);
                //System.out.println("..Attached button " +i);
                break;
            case 7:
                button = (Button)findViewById(R.id.b7);
                //System.out.println("..Attached button " +i);
                break;
            case 8:
                button = (Button)findViewById(R.id.b8);
                //System.out.println("..Attached button " +i);
                break;
            case 9:
                button = (Button)findViewById(R.id.b9);
                //System.out.println("..Attached button " +i);
                break;
            default:
                button = (Button)findViewById(R.id.b0);
                //System.out.println("..Attached default button");
        }
        return button;
    }
}
