package moderbord.huntforcoffee;

import android.content.Context;

/**
 * Created by Moderbord on 2015-12-13.
 */
public class Flags {

    protected MainActivity main;
    public Flags(Context context){this.main = (MainActivity) context;}

    public boolean mainMenu = true;
    public boolean activeGame = false;
    public boolean consuming = true;

}
