package io.muic.ssc.zork.GameMap.DungeonMapRooms;

import io.muic.ssc.zork.Entity.Item;
import io.muic.ssc.zork.Entity.Monster;
import io.muic.ssc.zork.GameMap.Room;

import java.util.List;

public class BonfireRoom extends Room {

    @Override
    public String insertRoomName() {
        return "BONFIRE ROOM";
    }

    @Override
    public String insertRoomDescription() {
        return "You see a cackling bonfire in the middle of the room, with a sword sticking into it.\n" +
                                "Somehow you feel this place is a relaxing place.";
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
        return "SPIRAL STAIR";
    }

    @Override
    public String insertEastRoom() {
        return "CELL ROOM";
    }

    @Override
    public String insertWestRoom() {
        return null;
    }

    @Override
    public String insertSouthRoom() {
        return null;
    }

}
