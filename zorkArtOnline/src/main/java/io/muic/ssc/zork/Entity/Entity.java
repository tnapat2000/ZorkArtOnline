package io.muic.ssc.zork.Entity;

import io.muic.ssc.zork.GameMap.Room;

public class Entity {

    protected int maxHP;
    protected int currentHP;
    protected int AC;
    protected boolean isAlive;

    public Entity(int maxHP, int AC){
        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.AC = AC;
        this.isAlive = true;
    }

    public boolean isDead(){
        return currentHP <= 0;
    }

    public void setDead(){
        isAlive = false;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public int getAC() {
        return AC;
    }

    public void setAC(int AC) {
        this.AC = AC;
    }

}
