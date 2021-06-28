package io.muic.ssc.zork.GameMap;

import io.muic.ssc.zork.Entity.Item;
import io.muic.ssc.zork.Entity.Monster;
import io.muic.ssc.zork.Entity.Weapon;
import io.muic.ssc.zork.Game;

import java.io.*;
import java.util.Arrays;

public class DungeonGameMap implements GameMap {

    private final String mapInfo;

    public DungeonGameMap(File path) throws IOException {

        InputStream inputStream = new FileInputStream(path);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        StringBuilder sb = new StringBuilder();

        while ((line = bufferedReader.readLine()) != null){
            sb.append(line).append('\n');
        }

        mapInfo = sb.toString();
    }

    public void generateMap(Game game){

//        sorry this is hard-coded
        Item[] items;
        Monster[] monsters;

        Room startRoom = new Room("STARTING ROOM","You start here, noob.");
        Room storage = new Room("STORAGE ROOM","there's a candlestick, 2-3 sleeping bags, and probably some stuff to eat.");
        Room hallway1 = new Room("HALLWAY SECTION 1","You see a long, and probably ominous, hallway.");
        Room hallway2 = new Room("HALLWAY SECTION 2","The hallway seems to continue, you'll never know what lies at the end.");
        Room hallway3 = new Room("HALLWAY SECTION 3","Fortunately, this is the ends of the hallway.");
        Room bonfire = new Room("BONFIRE ROOM","You see a cackling bonfire in the middle of the room, with a sword sticking into it.\n" +
                                "Somehow you feel this place is a relaxing place.");
        Room cell = new Room("CELL ROOM","There is a peculiarly-placed cell with its door open. You see a pile of bones within the cell.");
        Room spiralStair = new Room("SPIRAL STAIR","You see the spiral stair leading to the bottom of this place\n." +
                                "Maybe, you'll find some treasure there, but the stairs won't let you pass easily.");
        Room crystalCove = new Room("CRYSTAL COVE","Beneath the dungeon, there seems to be an alluring cove made out of entirely crystal.");
        Room treasureRoom = new Room("TREASURE ROOM","There it is, the shiny golden chest you've been looking for." +
                                "But fortunately, the real treasure is the friends we made along the way.");
        Room bossRoom = new Room("BOSS ROOM","You see a gigantic crystal Golem, with comically large crystal club");

//        start room
        game.setPlayerLocation(startRoom);
        Weapon simpleStick = new Weapon("Simple Stick", "", 3, 0);
        items = new Item[]{simpleStick};
        startRoom.setItems(Arrays.asList(items));
        startRoom.setAdjacentRooms(hallway1, null, null, null);

//        storage room

        Weapon ironSword = new Weapon("Iron Sword", "", 3, 4);
        Weapon vikingAxe = new Weapon("Viking Axe", "", 5, 2);
        items = new Item[]{ironSword, vikingAxe};
        storage.setItems(Arrays.asList(items));
        storage.setAdjacentRooms(null, hallway1, null, null);

//        hallway 1
        Monster skeleton = new Monster("Skeleton", 15, 8, 3, hallway1);
        monsters = new Monster[]{skeleton};
        hallway1.setMonsters(Arrays.asList(monsters));
        hallway1.setAdjacentRooms(null, hallway2, startRoom, storage);

//        hallway 2
        hallway2.setAdjacentRooms(null, hallway3, null, hallway1);

//        hallway 3
        hallway3.setAdjacentRooms(bonfire, null, null, hallway2);

//        bonfire
        bonfire.setAdjacentRooms(spiralStair, cell, hallway3, null);

//        cell
        cell.setAdjacentRooms(null, null, null, bonfire);

//        spiral stair
        spiralStair.setAdjacentRooms(null, null, bonfire, crystalCove);

//        crystal cove
        crystalCove.setAdjacentRooms(treasureRoom, spiralStair, null, bossRoom);

//        treasure
        treasureRoom.setAdjacentRooms(null, null, crystalCove, null);

//        final boss room
        bossRoom.setAdjacentRooms(null, crystalCove, null, null);

    }

    public void printMapInfo(){
        System.out.println(mapInfo);
    }


}
