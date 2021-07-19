package io.muic.ssc.zork.GameMap.DungeonMapRooms;

import io.muic.ssc.zork.Entity.Item;
import io.muic.ssc.zork.Entity.Monster;
import io.muic.ssc.zork.GameMap.Room;

import java.util.List;

public class CrystalCove extends Room {

    @Override
    public String insertRoomName() {
        return "CRYSTAL COVE";
    }

    @Override
    public String insertRoomDescription() {
        return "Beneath the dungeon, there seems to be an alluring cove made out of entirely crystal.";
    }

    @Override
    public List<Item> insertItems() {
        return null;
    }

    @Override
    public List<Monster> insertMonsters() {
        return null;
    }

    @Override
    public String insertNorthRoom() {
        return "TREASURE ROOM";
    }

    @Override
    public String insertEastRoom() {
        return "SPIRAL STAIR";
    }

    @Override
    public String insertWestRoom() {
        return "BOSS ROOM";
    }

    @Override
    public String insertSouthRoom() {
        return null;
    }
}
