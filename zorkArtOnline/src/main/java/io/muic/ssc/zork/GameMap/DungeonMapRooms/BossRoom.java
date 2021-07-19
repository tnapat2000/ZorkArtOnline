package io.muic.ssc.zork.GameMap.DungeonMapRooms;

import io.muic.ssc.zork.Entity.Item;
import io.muic.ssc.zork.Entity.Monster;
import io.muic.ssc.zork.GameMap.Room;

import java.util.List;

public class BossRoom extends Room {
    @Override
    public String insertRoomName() {
        return "BOSS ROOM";
    }

    @Override
    public String insertRoomDescription() {
        return "You see a gigantic crystal Golem, with comically large crystal club";
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
        return "CRYSTAL COVE";
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
