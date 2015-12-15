package moderbord.huntforcoffee.GameFunctions;


import moderbord.huntforcoffee.Entity;

/**
 * Created by Moderbord on 2015-12-14.
 */

public class Inventory{

    private Item inventory[] = new Item[5];

    public  String printInventory(Entity entity){ // ID 11110
        this.inventory = entity.getInventory().inventory;
        String string = "";
            for(int i = 0; i < inventory.length; i++){
                if (inventory[i] != null) {
                    string = string + "\n"+ inventory[i].getiName() + ", " + inventory[i].getAmount();
                }
            }
        String inv = "\n\nInventory:\n" + string;
        return inv;
    }

    public String addItemToInv(Entity entity, Item item, int amount){
        this.inventory = entity.getInventory().inventory;
        String string = "\n\nYou have no room for " + item.getiName() + " in your inventory";
        for(int i = 0; i < inventory.length; i++){
            if(inventory[i] != null && inventory[i].getiName().equals(item.getiName()) && !item.equals(Gear.class)){
                inventory[i].setAmount(inventory[i].getAmount() + amount);
                if(amount > 1){
                    string = "\n\n" + entity.geteName() + " have received " + amount + " additional " + item.getiName() + "s";
                } else {
                    string = "\n\n" + entity.geteName() + " have received one additional " + item.getiName();
                }
                entity.setInventory(this);
                return string;
            } else if(inventory[i] == null){
                inventory[i] = item;
                inventory[i].setAmount(amount);
                string = "\n\n" + entity.geteName() + " has received " + item.getiName();
                entity.setInventory(this);
                return string;
            }
        }
        return string;
    }

    public Item getInvItem(Entity entity, int x){
        this.inventory = entity.getInventory().inventory;
        if(inventory[x] != null){
            return inventory[x];
        } else {
            return null;
        }
    }

    public void setInvItem(Entity entity, int x, Item item) {
        this.inventory = entity.getInventory().inventory;
        inventory[x] = item;
    }
}
