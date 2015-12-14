package moderbord.huntforcoffee.GameFunctions;

/**
 * Created by Moderbord on 2015-12-14.
 */

public class Gear extends Item{

    private int gearLvl, gearExp, gearExpToLvl, gearSlot;

    public Gear(String iName, String type, int amount, int gearLvl,
                int gearExp, int gearExpToLvl, int gearSlot) {
        super(iName, type, amount);
        this.gearLvl = gearLvl;
        this.gearExp = gearExp;
        this.gearExpToLvl = gearExpToLvl;
        this.gearSlot = gearSlot;
    }

    public int getGearLvl() {
        return gearLvl;
    }

    public void setGearLvl(int gearLvl) {
        this.gearLvl = gearLvl;
    }

    public int getGearExp() {
        return gearExp;
    }

    public void setGearExp(int gearExp) {
        this.gearExp = gearExp;
    }

    public int getGearExpToLvl() {
        return gearExpToLvl;
    }

    public void setGearExpToLvl(int gearExpToLvl) {
        this.gearExpToLvl = gearExpToLvl;
    }

    public int getGearSlot() {
        return gearSlot;
    }

    public void setGearSlot(int gearSlot) {
        this.gearSlot = gearSlot;
    }
}
