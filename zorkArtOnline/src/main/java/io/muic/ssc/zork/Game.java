package io.muic.ssc.zork;

import io.muic.ssc.zork.Command.Command;
import io.muic.ssc.zork.Entity.Item;
import io.muic.ssc.zork.Entity.Player;
import io.muic.ssc.zork.GameMap.DungeonGameMap;
import io.muic.ssc.zork.GameMap.GameMap;
import io.muic.ssc.zork.GameMap.Room;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {

    private final GameOutput gameOutput = new GameOutput();

    private final CommandParser commandParser = new CommandParser();

    private final Player currentPlayer = new Player(20, 13, 0,null);

    private Room playerLocation;

    private GameMap gameMap;

    private boolean inGame;

    public void chooseMap() throws IOException {
        System.out.println(availableMap());
        System.out.print("Please Select Map: ");

        Scanner in = new Scanner(System.in);
        String chosenMap = in.nextLine();

        if (chosenMap.equals("Dungeon")){
            gameMap = new DungeonGameMap(new File("C:\\\\Users\\\\NetNapat2543\\\\Desktop\\\\SSC\\\\zorkArtOnline_resources\\\\DungeonMap.txt\\\\"));
            gameMap.generateMap(this);
            gameMap.printMapInfo();
        }
        else {
            System.out.println("Choose a map in order to play the game!!!");
            this.chooseMap();
        }
    }

    public void run() throws IOException {
        chooseMap();
        while(true){
            System.out.print("Enter Command: ");
            Scanner in = new Scanner(System.in);
            String line = in.nextLine();
            List<String> words = commandParser.parse(line);
            Command command = CommandFactory.get(words.get(0));
            if (command != null){
                command.execute(this, words.subList(1, words.size()));
            }
//            gameOutput.println(line);
        }
    }

    public GameOutput getGameOutput() {
        return gameOutput;
    }

    public void exit() {
        System.exit(0);
    }

    public void info(){
        StringBuilder sb = new StringBuilder();
        sb.append("===========================================\n");
        sb.append(playerLocation.getRoomDescription()).append("\n");
        sb.append("You are now in: ").append(playerLocation.getRoomName()).append("\n");

        sb.append("=============Current Player Stats==========\n");
        sb.append("=HP/MAX HP: ").append(currentPlayer.getCurrentHP()).append("/").append(currentPlayer.getMaxHP()).append("\n");
        sb.append("=MAX DMG: ").append(currentPlayer.getMaxDMG() + currentPlayer.getDmgMultiplier()).append("\n");
        sb.append("=Inventory: ").append(currentPlayer.getPlayerInventoryString()).append("\n");

        sb.append("===============Surrounding Area============\n");
        if (playerLocation.getMonsterMap().size() > 0){
            sb.append("Current Enemies: \n");
            sb.append(playerLocation.getMonstersList()).append("\n");
        } else {
            sb.append("There is no more monster").append("\n");
        }

        if (playerLocation.getItemMap().size() > 0){
            sb.append("You found these items in the room: \n");
            sb.append(playerLocation.getItemsString()).append("\n");
        } else {
            sb.append("There is nothing left to take").append("\n");
        }
        sb.append("This room is connected to: \n").append(playerLocation.printAdjacentRoomString()).append("\n");
        sb.append("===========================================\n");
        gameOutput.println(sb.toString());
    }

    public void take(Item item, Room room){
        if (room.getItemMap().containsValue(item)){
            room.getItemMap().remove(item.getItemName());
            currentPlayer.getPlayerInventory().put(item.getItemName(), item);
            gameOutput.println("You picked up " + item.getItemName());
        } else {
            gameOutput.println("You can't take that thing, it's not here");
        }
    }

    public void drop(Item item, Room room){
        if (currentPlayer.getPlayerInventory().containsValue(item)){
            currentPlayer.getPlayerInventory().remove(item.getItemName());
            room.getItemMap().put(item.getItemName(), item);
            gameOutput.println("You dropped " + item.getItemName());
        } else {
            gameOutput.println("You can't drop that. It's not in your inventory");
        }
    }

    public void attackWith(Item item){

    }

    public void go(String direction){
        boolean ableToGo = playerLocation.getRoomMap().get(direction) != null;
        if (ableToGo){
            Room nextRoom = playerLocation.getDirectionRoom(direction);
            playerLocation = nextRoom;
            playerLocation.updateRoom(nextRoom);
        }else {
            gameOutput.println("You can't go that way. It's dead end");
        }
        gameOutput.println("You went to " + playerLocation.getRoomName());

    }

    public String availableMap(){
        String[] maps = {"Dungeon"};
        return Arrays.asList(maps).toString();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Room getPlayerLocation() {
        return playerLocation;
    }

    public void setPlayerLocation(Room playerLocation) {
        this.playerLocation = playerLocation;
    }
}
