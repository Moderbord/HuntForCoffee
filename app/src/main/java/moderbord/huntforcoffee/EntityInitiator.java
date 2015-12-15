package moderbord.huntforcoffee;

import android.content.Context;

import moderbord.huntforcoffee.Enteties.Player;

/**
 * Created by Moderbord on 2015-12-15.
 */

public class EntityInitiator {

    protected MainActivity main;

    public EntityInitiator(Context context){
        this.main = (MainActivity) context;
    }

    public void initJheero(){
        main.jheero = new Player(main, null, null, null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null, null, null, null, null, null, null);
    }

}
