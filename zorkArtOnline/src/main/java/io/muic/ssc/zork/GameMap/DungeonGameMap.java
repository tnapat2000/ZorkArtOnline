package io.muic.ssc.zork.GameMap;

import io.muic.ssc.zork.Entity.Item;
import io.muic.ssc.zork.Entity.Monster;
import io.muic.ssc.zork.Entity.Weapon;
import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.GameMap.DungeonMapRooms.*;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DungeonGameMap implements GameMap {

    private String mapInfo;

    public Map<String, Room> getROOMS_MAPS() {
        return ROOMS_MAPS;
    }

    private final Map<String, Room > ROOMS_MAPS = new HashMap<>();
    {
        Room startingRoom = new StartingRoom();
        Room storageRoom = new StorageRoom();
        Room hallway1 = new Hallway1();
        Room hallway2 = new Hallway2();
        Room hallway3 = new Hallway3();
        Room bonfire = new BonfireRoom();
        Room cell = new CellRoom();
        Room spiralStair = new SpiralStair();
        Room crystalCove = new CrystalCove();
        Room bossRoom = new BossRoom();

        ROOMS_MAPS.put(startingRoom.insertRoomName(), startingRoom);
        ROOMS_MAPS.put(storageRoom.insertRoomName(), storageRoom);
        ROOMS_MAPS.put(hallway1.insertRoomName(), hallway1);
        ROOMS_MAPS.put(hallway2.insertRoomName(), hallway2);
        ROOMS_MAPS.put(hallway3.insertRoomName(), hallway3);
        ROOMS_MAPS.put(bonfire.insertRoomName(), bonfire);
        ROOMS_MAPS.put(cell.insertRoomName(), cell);
        ROOMS_MAPS.put(spiralStair.insertRoomName(), spiralStair);
        ROOMS_MAPS.put(crystalCove.insertRoomName(), crystalCove);
        ROOMS_MAPS.put(bossRoom.insertRoomName(), bossRoom);
    }



    public void setMapInfo(String path) throws IOException {
        InputStream inputStream = new FileInputStream(path);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        StringBuilder sb = new StringBuilder();

        while ((line = bufferedReader.readLine()) != null){
            sb.append(line).append('\n');
        }
        mapInfo = sb.toString();
    }

    public void printMapInfo(){
        System.out.println(mapInfo);
    }


    public void generateMap(Game game, String path) throws IOException {
        setMapInfo(path);

        game.setPlayerLocation(ROOMS_MAPS.get("STARTING ROOM"));
        Room room;
        for (Map.Entry <String,Room> roomEntry : ROOMS_MAPS.entrySet()){

            room = roomEntry.getValue();
            room.setRoomName(room.insertRoomName());
            room.setRoomDescription(room.insertRoomDescription());
            room.setItems(room.insertItems());
            room.setMonsters(room.insertMonsters());
            room.setAdjacentRooms(
                    ROOMS_MAPS.get(room.insertNorthRoom()),
                    ROOMS_MAPS.get(room.insertEastRoom()),
                    ROOMS_MAPS.get(room.insertSouthRoom()),
                    ROOMS_MAPS.get(room.insertWestRoom())
            );
        }
    }

    public String getMapName() {
        return "dungeon";
    }
}
