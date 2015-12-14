package moderbord.huntforcoffee;

import android.content.Context;

import moderbord.huntforcoffee.GameFunctions.Armour;
import moderbord.huntforcoffee.GameFunctions.Inventory;
import moderbord.huntforcoffee.GameFunctions.Resistance;
import moderbord.huntforcoffee.GameFunctions.Weapon;

/**
 * Created by Moderbord on 2015-12-07.
 */
public abstract class Entity {

    protected MainActivity main;

    private String eName, eGender, eClass, eRace, eFaction;
    private int eLevel, ePhysique, eIntellect, eAgility, eQuickness, eCharisma, eLuck, eLi, eMaxHealth, eHealth, eMaxMana, eMana, eMaxFatigue, eFatigue, eLu, eMinLu, eExperience, eExpToLvl;
    private Weapon backWep, mainWep, offWep;
    private Armour armHead, armShoulders, armChest, armGloves, armLegs, armFeet;
    private Resistance resistance;
    private Inventory inventory;


    public Entity(Context context, String eName, String eGender, String eClass, String eRace, String eFaction, int eLevel, int ePhysique,
                  int eIntellect, int eAgility, int eQuickness, int eCharisma, int eLuck, int eLi, int eMaxHealth, int eHealth,
                  int eMaxMana, int eMana, int eMaxFatigue, int eFatigue, int eLu, int eMinLu, int eExperience, int eExpToLvl,
                  Weapon backWep, Weapon mainWep, Weapon offWep, Armour armHead, Armour armShoulders, Armour armChest, Armour armGloves,
                  Armour armLegs, Armour armFeet, Resistance resistance, Inventory inventory){
        this.main = (MainActivity) context;
        this.eName = eName;
        this.eGender = eGender;
        this.eClass = eClass;
        this.eRace = eRace;
        this.eFaction = eFaction;
        this.eLevel = eLevel;
        this.ePhysique = ePhysique;
        this.eIntellect = eIntellect;
        this.eAgility = eAgility;
        this.eQuickness = eQuickness;
        this.eCharisma = eCharisma;
        this.eLuck = eLuck;
        this.eLi = eLi;
        this.eMaxHealth = eMaxHealth;
        this.eHealth = eHealth;
        this.eMaxMana = eMaxMana;
        this.eMana = eMana;
        this.eMaxFatigue = eMaxFatigue;
        this.eFatigue = eFatigue;
        this.eLu = eLu;
        this.eMinLu = eMinLu;
        this.eExperience = eExperience;
        this.eExpToLvl = eExpToLvl;
        this.backWep = backWep;
        this.mainWep = mainWep;
        this.offWep = offWep;
        this.armHead = armHead;
        this.armShoulders = armShoulders;
        this.armChest = armChest;
        this.armGloves = armGloves;
        this.armLegs = armLegs;
        this.armFeet = armFeet;
        this.resistance = resistance;
        this.inventory = inventory;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String geteGender() {
        return eGender;
    }

    public void seteGender(String eGender) {
        this.eGender = eGender;
    }

    public String geteClass() {
        return eClass;
    }

    public void seteClass(String eClass) {
        this.eClass = eClass;
    }

    public String geteRace() {
        return eRace;
    }

    public void seteRace(String eRace) {
        this.eRace = eRace;
    }

    public String geteFaction() {
        return eFaction;
    }

    public void seteFaction(String eFaction) {
        this.eFaction = eFaction;
    }

    public int geteLevel() {
        return eLevel;
    }

    public void seteLevel(int eLevel) {
        this.eLevel = eLevel;
    }

    public int getePhysique() {
        return ePhysique;
    }

    public void setePhysique(int ePhysique) {
        this.ePhysique = ePhysique;
    }

    public int geteIntellect() {
        return eIntellect;
    }

    public void seteIntellect(int eIntellect) {
        this.eIntellect = eIntellect;
    }

    public int geteAgility() {
        return eAgility;
    }

    public void seteAgility(int eAgility) {
        this.eAgility = eAgility;
    }

    public int geteQuickness() {
        return eQuickness;
    }

    public void seteQuickness(int eQuickness) {
        this.eQuickness = eQuickness;
    }

    public int geteCharisma() {
        return eCharisma;
    }

    public void seteCharisma(int eCharisma) {
        this.eCharisma = eCharisma;
    }

    public int geteLuck() {
        return eLuck;
    }

    public void seteLuck(int eLuck) {
        this.eLuck = eLuck;
    }

    public int geteLi() {
        return eLi;
    }

    public void seteLi(int eLi) {
        this.eLi = eLi;
    }

    public int geteMaxHealth() {
        return eMaxHealth;
    }

    public void seteMaxHealth(int eMaxHealth) {
        this.eMaxHealth = eMaxHealth;
    }

    public int geteHealth() {
        return eHealth;
    }

    public void seteHealth(int eHealth) {
        this.eHealth = eHealth;
    }

    public int geteMaxMana() {
        return eMaxMana;
    }

    public void seteMaxMana(int eMaxMana) {
        this.eMaxMana = eMaxMana;
    }

    public int geteMana() {
        return eMana;
    }

    public void seteMana(int eMana) {
        this.eMana = eMana;
    }

    public int geteMaxFatigue() {
        return eMaxFatigue;
    }

    public void seteMaxFatigue(int eMaxFatigue) {
        this.eMaxFatigue = eMaxFatigue;
    }

    public int geteFatigue() {
        return eFatigue;
    }

    public void seteFatigue(int eFatigue) {
        this.eFatigue = eFatigue;
    }

    public int geteLu() {
        return eLu;
    }

    public void seteLu(int eLu) {
        this.eLu = eLu;
    }

    public int geteMinLu() {
        return eMinLu;
    }

    public void seteMinLu(int eMinLu) {
        this.eMinLu = eMinLu;
    }

    public int geteExperience() {
        return eExperience;
    }

    public void seteExperience(int eExperience) {
        this.eExperience = eExperience;
    }

    public int geteExpToLvl() {
        return eExpToLvl;
    }

    public void seteExpToLvl(int eExpToLvl) {
        this.eExpToLvl = eExpToLvl;
    }

    public Weapon getBackWep() {
        return backWep;
    }

    public void setBackWep(Weapon backWep) {
        this.backWep = backWep;
    }

    public Weapon getMainWep() {
        return mainWep;
    }

    public void setMainWep(Weapon mainWep) {
        this.mainWep = mainWep;
    }

    public Weapon getOffWep() {
        return offWep;
    }

    public void setOffWep(Weapon offWep) {
        this.offWep = offWep;
    }

    public Armour getArmHead() {
        return armHead;
    }

    public void setArmHead(Armour armHead) {
        this.armHead = armHead;
    }

    public Armour getArmShoulders() {
        return armShoulders;
    }

    public void setArmShoulders(Armour armShoulders) {
        this.armShoulders = armShoulders;
    }

    public Armour getArmChest() {
        return armChest;
    }

    public void setArmChest(Armour armChest) {
        this.armChest = armChest;
    }

    public Armour getArmGloves() {
        return armGloves;
    }

    public void setArmGloves(Armour armGloves) {
        this.armGloves = armGloves;
    }

    public Armour getArmLegs() {
        return armLegs;
    }

    public void setArmLegs(Armour armLegs) {
        this.armLegs = armLegs;
    }

    public Armour getArmFeet() {
        return armFeet;
    }

    public void setArmFeet(Armour armFeet) {
        this.armFeet = armFeet;
    }

    public Resistance getResistance() {
        return resistance;
    }

    public void setResistance(Resistance resistance) {
        this.resistance = resistance;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public abstract void info();
}
