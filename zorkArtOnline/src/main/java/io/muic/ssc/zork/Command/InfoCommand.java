package io.muic.ssc.zork.Command;

import io.muic.ssc.zork.Game;

import java.util.List;

public class InfoCommand implements Command{

    @Override
    public int gameState() {
        return 0;
    }

    @Override
    public int numArgs() {
        return 0;
    }

    @Override
    public String getCommand() {
        return "info";
    }

    @Override
    public void execute(Game game, List<String> args) {
        game.info();
    }
}
