package io.muic.ssc.zork.GameMap;

import io.muic.ssc.zork.Entity.Item;
import io.muic.ssc.zork.Entity.Monster;
import io.muic.ssc.zork.Entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {

    String roomDescription;

    String roomName;

    private Map<String, Room> roomMap = new HashMap<>();

    private Map<String, Item> itemMap = new HashMap<>();

    private Player player;

    private Map<String, Monster> monsterMap = new HashMap<>();

    public Room(String roomName, String roomDescription){
        this.roomDescription = roomDescription;
        this.roomName = roomName;
    }

    public void setRoomDescription(String roomName,String roomDescription){
        this.roomDescription = roomDescription;
        this.roomName = roomName;
    }

    public void setAdjacentRooms(Room north, Room east, Room south, Room west){
        roomMap.put("north", north);
        roomMap.put("east", east);
        roomMap.put("south", south);
        roomMap.put("west", west);
    }

    public String printAdjacentRoomString(){
        List<String> ret = new ArrayList<>();
        StringBuilder sb;
        for (Map.Entry<String, Room> entry: roomMap.entrySet()){
            if (entry.getValue() != null) {
                sb = new StringBuilder();
                sb.append(entry.getValue().roomName).append("(").append(entry.getKey()).append(")");
                ret.add(sb.toString());
            }
        }
        return ret.toString();
    }

    public Room getDirectionRoom(String direction){
        return roomMap.get(direction);
    }

    public void updateRoom(Room nextRoom){
        this.roomName = nextRoom.roomName;
        this.roomDescription = nextRoom.roomDescription;
        this.roomMap = nextRoom.roomMap;
        this.monsterMap = nextRoom.monsterMap;
        this.itemMap = nextRoom.itemMap;
    }

    public List<String> getItemsString(){
        return new ArrayList<>(itemMap.keySet());
    }

    public void setItems(List<Item> items) {
        for (Item item: items){
            this.itemMap.put(item.getItemName(), item);
        }
    }

    public Item retrieveItem(String itemName){
        return itemMap.get(itemName);
    }

    public void setMonsters(List<Monster> monsters) {
        for (Monster monster : monsters){
            this.monsterMap.put(monster.getMonsterName(), monster);
        }
    }

    public Map<String, Item> getItemMap() {
        return itemMap;
    }

    public Map<String, Monster> getMonsterMap() {
        return monsterMap;
    }

    public List<String> getMonstersList(){
        return new ArrayList<>(monsterMap.keySet());
    }

    public int getMonstersNumber(){
        return monsterMap.size();
    }

    public String getRoomName() {
        return roomName;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public Map<String, Room> getRoomMap() {
        return roomMap;
    }
}
