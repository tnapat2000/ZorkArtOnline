package io.muic.ssc.zork.Command;

import io.muic.ssc.zork.Game;

import java.io.IOException;
import java.util.List;

public class LoadCommand implements Command{
    @Override
    public int gameState() {
        return 1;
    }

    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public String getCommand() {
        return "load";
    }

    @Override
    public void execute(Game game, List<String> args) throws IOException {
        game.load(args.get(0));
    }
}
