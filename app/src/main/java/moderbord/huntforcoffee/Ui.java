package moderbord.huntforcoffee;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Moderbord on 2015-12-03.
 */
public class Ui extends Activity{

    protected MainActivity context;

    public Ui(Context context){
        this.context = (MainActivity) context;
    }


    /*public void appendText(String append){
        text = text + " " + append;
    }

    public void submitText(){
        context.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                context.mainTextWindow.setText(text);
            }
        });
    }*/

}