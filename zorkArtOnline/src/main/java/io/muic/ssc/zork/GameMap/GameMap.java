package io.muic.ssc.zork.GameMap;

import io.muic.ssc.zork.Game;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public interface GameMap {

    String getMapName();

    void generateMap(Game game, String path) throws IOException;

    void printMapInfo();

    Map<String, Room> getROOMS_MAPS();

}
