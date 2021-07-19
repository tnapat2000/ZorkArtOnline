package io.muic.ssc.zork.Command;

import io.muic.ssc.zork.Game;

import java.io.IOException;
import java.util.List;

public class QuitCommand implements Command{

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
        return "quit";
    }

    @Override
    public void execute(Game game, List<String> args) throws IOException {
        game.quit();
    }
}
