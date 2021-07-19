package io.muic.ssc.zork.Command;

import io.muic.ssc.zork.Game;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface Command {

    int gameState();

    int numArgs();

    String getCommand();

    void execute(Game game, List<String> args) throws IOException;

}
