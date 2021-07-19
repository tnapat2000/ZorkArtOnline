package io.muic.ssc.zork.Command;

import io.muic.ssc.zork.Game;

import java.util.List;

public class HelpCommand implements Command{

    @Override
    public int gameState() {
        return 2;
    }

    @Override
    public int numArgs() {
        return 0;
    }

    @Override
    public String getCommand() {
        return "help";
    }

    @Override
    public void execute(Game game, List<String> args) {
        game.help();
    }
}
