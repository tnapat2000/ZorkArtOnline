package io.muic.ssc.zork.GameMap.DungeonMapRooms;

import io.muic.ssc.zork.Entity.Item;
import io.muic.ssc.zork.Entity.Monster;
import io.muic.ssc.zork.GameMap.Room;

import java.util.List;

public class CellRoom extends Room {

    @Override
    public String insertRoomName() {
        return "CELL ROOM";
    }

    @Override
    public String insertRoomDescription() {
        return "There is a peculiarly-placed cell with its door open. You see a pile of bones within the cell.";
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
        return null;
    }

    @Override
    public String insertEastRoom() {
        return null;
    }

    @Override
    public String insertWestRoom() {
        return "BONFIRE ROOM";
    }

    @Override
    public String insertSouthRoom() {
        return null;
    }
}
