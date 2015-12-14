package moderbord.huntforcoffee.GameFunctions;

import android.content.Context;

import moderbord.huntforcoffee.MainActivity;

/**
 * Created by Moderbord on 2015-12-14.
 */

public class Item {

    protected MainActivity main;

    public Item(Context context){
        this.main = (MainActivity) context;
    }

    private String iName, type;
    private int amount;

    public Item(String iName, String type, int amount){
        this.iName = iName;
        this.type = type;
        this.amount = amount;
    }

    public String getiName() {
        return iName;
    }

    public void setiName(String iName) {
        this.iName = iName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
