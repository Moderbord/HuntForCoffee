package moderbord.huntforcoffee.GameFunctions;

/**
 * Created by Moderbord on 2015-12-14.
 */

public class Weapon extends Gear {

    private String wepType, dmgType;
    private int minDmg, maxDmg;

    public Weapon(String iName, String type, int amount, int gearLvl, int gearExp, int gearExpToLvl, int gearSlot, String wepType, String dmgType, int minDmg, int maxDmg) {
        super(iName, type, amount, gearLvl, gearExp, gearExpToLvl, gearSlot);
        this.wepType = wepType;
        this.dmgType = dmgType;
        this.minDmg = minDmg;
        this.maxDmg = maxDmg;
    }

    public String getWepType() {
        return wepType;
    }

    public void setWepType(String wepType) {
        this.wepType = wepType;
    }

    public String getDmgType() {
        return dmgType;
    }

    public void setDmgType(String dmgType) {
        this.dmgType = dmgType;
    }

    public int getMinDmg() {
        return minDmg;
    }

    public void setMinDmg(int minDmg) {
        this.minDmg = minDmg;
    }

    public int getMaxDmg() {
        return maxDmg;
    }

    public void setMaxDmg(int maxDmg) {
        this.maxDmg = maxDmg;
    }
}
