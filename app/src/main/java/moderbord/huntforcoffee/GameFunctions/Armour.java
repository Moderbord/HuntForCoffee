package moderbord.huntforcoffee.GameFunctions;

/**
 * Created by Moderbord on 2015-12-14.
 */

public class Armour extends Gear {

    private String armClass, armStrong, armWeak;
    private int armDef;

    public Armour(String iName, String type, int amount, int gearLvl, int gearExp, int gearExpToLvl, int gearSlot, String armClass, String armStrong, String armWeak, int armDef) {
        super(iName, type, amount, gearLvl, gearExp, gearExpToLvl, gearSlot);
        this.armClass = armClass;
        this.armStrong = armStrong;
        this.armWeak = armWeak;
        this.armDef = armDef;
    }

    public String getArmClass() {
        return armClass;
    }

    public void setArmClass(String armClass) {
        this.armClass = armClass;
    }

    public String getArmStrong() {
        return armStrong;
    }

    public void setArmStrong(String armStrong) {
        this.armStrong = armStrong;
    }

    public String getArmWeak() {
        return armWeak;
    }

    public void setArmWeak(String armWeak) {
        this.armWeak = armWeak;
    }

    public int getArmDef() {
        return armDef;
    }

    public void setArmDef(int armDef) {
        this.armDef = armDef;
    }
}
