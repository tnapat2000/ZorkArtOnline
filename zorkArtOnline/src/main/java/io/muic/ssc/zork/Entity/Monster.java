package io.muic.ssc.zork.Entity;

import io.muic.ssc.zork.GameMap.Room;

import java.util.Random;

public class Monster extends Entity{

    private final String monsterName;
    private String defeatMessage;
    private final int baseDMG;
    private final Random random;

    public Monster(String monsterName, int maxHP, int AC, int DMG) {
        super(maxHP, AC);
        this.baseDMG = DMG;
        this.random = new Random();
        this.monsterName = monsterName;
    }

    public void attack(Player player){
        int hitRoll = random.nextInt(20);
        if (hitRoll >= (player.AC -1)){
            player.currentHP -= baseDMG;
        }
        else if (hitRoll == 19){
            player.currentHP -= Math.round(baseDMG * 1.5);
        }
        else {
            System.out.println("Monster attack miss");
        }
        if (player.currentHP <= 0){
//            restart the game
        }
    }

    public void printDefeatMessage(){
        if (!isAlive){System.out.println(defeatMessage);}
    }

    public void setDefeatMessage(String defeatMessage) {
        this.defeatMessage = defeatMessage;
    }

    public String getMonsterName() {
        return monsterName;
    }
}
