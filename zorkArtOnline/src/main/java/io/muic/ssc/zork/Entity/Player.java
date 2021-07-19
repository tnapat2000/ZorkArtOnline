package io.muic.ssc.zork.Entity;


import java.util.*;

public class Player extends Entity{

    private final Map<String, Item> playerInventory;
    private int dmgMultiplier;

    public Player(int playerMaxHP, int playerAC, int dmgMultiplier){
        super(playerMaxHP, playerAC);
        this.dmgMultiplier = dmgMultiplier;
        this.playerInventory = new HashMap<>();
    }

    public Map<String, Item> getPlayerInventory() {
        return playerInventory;
    }

    public List<String> getPlayerInventoryString(){
        List<String> ret = new ArrayList<>();
        for (Item item : playerInventory.values()){
            ret.add(item.getItemName());
        }
        return ret;
    }


    public void usePotion(Potion potion){
//        implement later
    }

    public void increaseDMGMultiplier(int monsterHP){
        this.dmgMultiplier += Math.round(monsterHP * 0.1);
    }

    public void increaseHP(){
        if (currentHP < maxHP){
            this.currentHP += Math.round(currentHP * 0.5);
        }
    }

    public void increaseMAXHP(){
        this.maxHP += Math.round(maxHP * 0.5);
    }

    public int getDmgMultiplier() {
        return dmgMultiplier;
    }

    public int getMaxDMG(){
        int maxDMGSoFar = 0;
        for (Item item : playerInventory.values()){
            if ((item instanceof Weapon) && (((Weapon) item).getWeaponDMG() > maxDMGSoFar)){
                maxDMGSoFar = ((Weapon) item).getWeaponDMG();
            }
        }
        return maxDMGSoFar;
    }

}
