package io.muic.ssc.zork.Entity;

import io.muic.ssc.zork.GameMap.Room;

public class Weapon extends Item {

    private final int weaponDMG;
    private final int proficiency;

    public Weapon(String itemName, String itemDescription, int weaponDMG, int proficiency) {
        super(itemName, itemDescription);
        this.weaponDMG = weaponDMG;
        this.proficiency = proficiency;
    }

    public int getWeaponDMG() {
        return weaponDMG;
    }

    public int getProficiency() {
        return proficiency;
    }
}
