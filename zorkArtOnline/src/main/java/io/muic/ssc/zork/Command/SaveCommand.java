package io.muic.ssc.zork.Command;

import io.muic.ssc.zork.Game;

import java.io.IOException;
import java.util.List;

public class SaveCommand implements Command{

    @Override
    public int gameState() {
        return 0;
    }

    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public String getCommand() {
        return "save";
    }

    @Override
    public void execute(Game game, List<String> args) throws IOException {
        game.save(args.get(0));
    }
}
