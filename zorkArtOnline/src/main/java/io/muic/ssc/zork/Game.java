package io.muic.ssc.zork;

import io.muic.ssc.zork.Command.Command;
import io.muic.ssc.zork.Entity.Item;
import io.muic.ssc.zork.Entity.Monster;
import io.muic.ssc.zork.Entity.Player;
import io.muic.ssc.zork.Entity.Weapon;
import io.muic.ssc.zork.GameMap.DungeonGameMap;
import io.muic.ssc.zork.GameMap.GameMap;
import io.muic.ssc.zork.GameMap.Room;

import java.io.*;
import java.util.*;

public class Game {

    private final GameOutput gameOutput = new GameOutput();

    private final CommandParser commandParser = new CommandParser();

    private final Player currentPlayer = new Player(25, 13, 0);

    private Monster currentTarget = null;

    private Room playerLocation;

    private GameMap gameMap;

    private final Random random = new Random();

//    private List<String> gameStates = Arrays.asList("in-game", "out-game", "in-and-out");

//    private String playerState = gameStates.get(1);

    public void startGame() throws IOException {
        gameOutput.println("===========================================");
        gameOutput.println("Play New Game or Load?");
        gameOutput.println("Please Select Map: "  + availableMap());
        gameOutput.println("===========================================");

        while (true){
            System.out.print("Enter Command (out of game): ");
            Scanner in = new Scanner(System.in);
            String line = in.nextLine();
            if (!line.isBlank()){
                List<String> words = commandParser.parse(line);

                Command command = CommandFactory.get(words.get(0));
                if (command != null && (command.gameState() == 1)){
                    command.execute(this, words.subList(1, words.size()));
                    break;
                } else if (command != null && (command.gameState() == 2)){
                    command.execute(this, words.subList(1, words.size()));
                } else if (command != null && (command.gameState() == 0)){
                    gameOutput.println("This command is not available while not in game");
                } else {
                    gameOutput.println("Enter the right command to play the game");
                }
            }else {
                gameOutput.println("Empty Command!");
            }
        }
    }

    public void run() throws IOException {
        gameOutput.println("Starting Game...");
        startGame();
        while(true){
            System.out.print("Enter Command (in game): ");
            Scanner in = new Scanner(System.in);
            String line = in.nextLine();
            if (!line.isBlank()){
                List<String> words = commandParser.parse(line);
                Command command = CommandFactory.get(words.get(0));
                if (command != null && (command.gameState() == 0 || command.gameState() == 2)){
                    command.execute(this, words.subList(1, words.size()));
                } else if (command != null && (command.gameState() == 1)){
                    gameOutput.println("This command is not available while in game");
                }
                else {
                    gameOutput.println("Enter the right command to play the game");
                }
            } else {
                gameOutput.println("Empty Command!");
            }
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

    public void take(Item item){
        if (playerLocation.getItemMap().containsValue(item)){
            playerLocation.getItemMap().remove(item.getItemName());
            currentPlayer.getPlayerInventory().put(item.getItemName(), item);
            gameOutput.println("===========================================");
            gameOutput.println("You picked up " + item.getItemName());
            gameOutput.println("===========================================");
        } else {
            gameOutput.println("===========================================");
            gameOutput.println("You can't take that thing, it's not here");
            gameOutput.println("===========================================");
        }
    }

    public void drop(Item item, Room room){
        if (currentPlayer.getPlayerInventory().containsValue(item)){
            currentPlayer.getPlayerInventory().remove(item.getItemName());
            room.getItemMap().put(item.getItemName(), item);
            gameOutput.println("===========================================");
            gameOutput.println("You dropped " + item.getItemName());
            gameOutput.println("===========================================");
        } else {
            gameOutput.println("===========================================");
            gameOutput.println("You can't drop that. It's not in your inventory");
            gameOutput.println("===========================================");
        }
    }

    public void target(Monster target){
        if (playerLocation.getMonsterMap().containsValue(target)){
            currentTarget = target;
            gameOutput.println("===========================================");
            gameOutput.println(String.format("Now, your target is %s", currentTarget.getMonsterName()));
            gameOutput.println("===========================================");
        } else {
            gameOutput.println("===========================================");
            gameOutput.println("You can't target that monster. It's not in the area");
            gameOutput.println("===========================================");
        }
    }

    public void attackWith(Weapon weapon) throws IOException {
        if (currentTarget == null){
            gameOutput.println("===========================================");
            gameOutput.println("You haven't selected a target yet");
            gameOutput.println("===========================================");
            return;
        }
        if (!currentTarget.isDead() && currentPlayer.getPlayerInventory().containsValue(weapon)){
            int playerHitRoll = random.nextInt(20) + weapon.getProficiency();
            int playerDMG = 0;
            if (playerHitRoll >= (currentTarget.getAC() -1)){
                playerDMG = weapon.getWeaponDMG() + currentPlayer.getDmgMultiplier();
                int newTargetHP = currentTarget.getCurrentHP() - playerDMG;
                currentTarget.setCurrentHP(newTargetHP);
            }
            else if (playerHitRoll == 19){
                playerDMG = (int) Math.round( weapon.getWeaponDMG() + (currentPlayer.getDmgMultiplier() * 1.5));
                int newTargetHP = currentTarget.getCurrentHP() - playerDMG;
                currentTarget.setCurrentHP(newTargetHP);
            }
            else{
                gameOutput.println("===========================================");
                System.out.println("attack miss");
            }

            if (currentTarget.getCurrentHP() <= 0){
                playerLocation.getMonsterMap().remove(currentTarget.getMonsterName());
//                currentTarget.setDead();
//                currentTarget.printDefeatMessage();
                currentPlayer.increaseDMGMultiplier(currentTarget.getMaxHP());
                gameOutput.println("===========================================");
                gameOutput.println("Your target is now dead");
                gameOutput.println("===========================================");
                return;
            }

            int monsterHitRoll = random.nextInt(20);
            int monsterDMG = 0;
            if (monsterHitRoll >= (currentPlayer.getAC() -1)){
                monsterDMG = currentTarget.getBaseDMG();
                int newPlayerHP = currentPlayer.getCurrentHP() - monsterDMG;
                currentPlayer.setCurrentHP(newPlayerHP);
            }
            else if (monsterHitRoll == 19){
                monsterDMG = (int) Math.round(currentTarget.getBaseDMG() * 1.5);
                int newPlayerHP = currentPlayer.getCurrentHP() - monsterDMG;
                currentPlayer.setCurrentHP(newPlayerHP);
            }
            else {
                gameOutput.println("===========================================");
                System.out.println("Monster attack miss");
            }

            gameOutput.println("===========================================");
            gameOutput.println(String.format("You deal %d to %s (%d/%d)", playerDMG,
                                                                        currentTarget.getMonsterName(),
                                                                        currentPlayer.getCurrentHP(),
                                                                        currentPlayer.getMaxHP()));
            gameOutput.println(String.format("%s deal %d to you (%d/%d)", currentTarget.getMonsterName(),
                                                                        monsterDMG,
                                                                        currentTarget.getCurrentHP(),
                                                                        currentTarget.getMaxHP()));
            gameOutput.println("===========================================");

            if (currentPlayer.getCurrentHP() <= 0){
                String sb = "===========================================\n" +
                        "============YOU======ARE======DEAD=========\n" +
                        "===========================================\n";
                gameOutput.println(sb);
                startGame();
            }

        } else if (currentTarget.isDead()){
            gameOutput.println("===========================================");
            gameOutput.println("The target is already dead!");
            gameOutput.println("===========================================");
        } else if (!currentPlayer.getPlayerInventory().containsValue(weapon)){
            gameOutput.println("===========================================");
            gameOutput.println("You can't attack with this. It's not in your inventory");
            gameOutput.println("===========================================");
        }
    }

    public void help(){
        String sb = "===========================================\n" +
                "These are available commands: \n" +
                CommandFactory.getAllCommands() + "\n" +
                "===========================================\n";
        gameOutput.println(sb);
    }

    public void go(String direction){
        boolean ableToGo = playerLocation.getRoomMap().get(direction) != null;
        if (ableToGo){
            currentTarget = null;
            currentPlayer.increaseHP();
            Room nextRoom = playerLocation.getDirectionRoom(direction);
            playerLocation = nextRoom;
            playerLocation.updateRoom(nextRoom);
            gameOutput.println("===========================================");
            gameOutput.println("You went to " + playerLocation.getRoomName());
            gameOutput.println("===========================================");
        }else {
            gameOutput.println("===========================================");
            gameOutput.println("You can't go that way. It's dead end");
            gameOutput.println("===========================================");
        }

    }

    public void quit() throws IOException {
        startGame();
    }

    public void playMap(String mapName) throws IOException {
        switch (mapName.toLowerCase()){
            case "dungeon":
                gameMap = new DungeonGameMap();
                gameMap.generateMap(this, "C:\\\\Users\\\\NetNapat2543\\\\Desktop\\\\SSC\\\\zorkArtOnline_resources\\\\DungeonMap.txt\\\\");
                gameMap.printMapInfo();
                break;
        }
    }

    public void load(String saveFilename) throws IOException {
        // work in progress
//        String mapName = gameMap.getMapName();
//
//        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\NetNapat2543\\Desktop\\SSC\\zorkArtOnline_resources\\"
//                + saveFilename + ".txt");
//        try ( ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
//
//        }
        
    }

    public void save(String saveFilename) throws IOException {

        // work in progress


//        String mapName = gameMap.getMapName();
//        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\NetNapat2543\\Desktop\\SSC\\zorkArtOnline_resources\\"
//                + saveFilename + ".txt");
////          use ObjectOutputStream
//
//        try ( ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
//
////            player status
//            for (Map.Entry<String, Item> itemEntry : currentPlayer.getPlayerInventory().entrySet()){
//                objectOutputStream.writeObject(itemEntry.getKey());
//                objectOutputStream.writeObject(itemEntry.getValue());
//            }

//            for (Map.Entry<String, Room> roomEntry : playerLocation.getRoomMap().entrySet()){
//                objectOutputStream.writeObject(roomEntry.getKey());
//                objectOutputStream.writeObject(roomEntry.getValue());
//            }
//            objectOutputStream.writeObject(playerLocation);

//            Map<String, Room> ROOMS_MAPS= gameMap.getROOMS_MAPS();
//
//            for (Map.Entry <String,Room> roomEntry : ROOMS_MAPS.entrySet()){
//                objectOutputStream.writeObject(roomEntry);
//            }
//        }

    }

    public GameMap getGameMap() {
        return gameMap;
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
