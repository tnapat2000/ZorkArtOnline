package io.muic.ssc.zork.Entity;

import java.util.Random;

public class Monster extends Entity{

    private final String monsterName;
    private String defeatMessage = "";
    private final int baseDMG;
    private final Random random;

    public Monster(String monsterName, int maxHP, int AC, int DMG) {
        super(maxHP, AC);
        this.baseDMG = DMG;
        this.random = new Random();
        this.monsterName = monsterName.toLowerCase();
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

    public int getBaseDMG() {
        return baseDMG;
    }
}
