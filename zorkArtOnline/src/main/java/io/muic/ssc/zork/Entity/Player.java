package io.muic.ssc.zork.Entity;

import io.muic.ssc.zork.GameMap.Room;

import java.util.*;

public class Player extends Entity{

    private final Map<String, Item> playerInventory;
    private final Random random;
    private int dmgMultiplier;

    public Player(int playerMaxHP, int playerAC, int dmgMultiplier ,Room startingRoom){
        super(playerMaxHP, playerAC ,startingRoom);
        this.dmgMultiplier = dmgMultiplier;
        this.playerInventory = new HashMap<>();
        this.random = new Random();
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

    public void attackWithWeapon(Monster target, Weapon weapon){
        int hitRoll = random.nextInt(20) + weapon.getProficiency();
        if (hitRoll >= (target.AC -1)){
            target.currentHP -= (weapon.getWeaponDMG() + dmgMultiplier);
        }
        else if (hitRoll == 19){
            target.currentHP -= Math.round((weapon.getWeaponDMG() + dmgMultiplier) * 1.5);
        }
        else{
            System.out.println("attack miss");
        }

        if (target.currentHP <= 0){
            target.setDead();
            target.printDefeatMessage();
            dmgMultiplier += 1;
        }
    }

    public void usePotion(Potion potion){
//        implement later
    }

    public void increaseDMG(int monsterHP){
        this.DMG += (monsterHP / 2);
    }

    public void increaseHP(){
        if (currentHP < maxHP){
            this.currentHP += (currentHP/2);
        }
        else {
            System.out.println("current HP is at MAX");
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
