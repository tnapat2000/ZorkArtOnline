package io.muic.ssc.zork.Command;

import io.muic.ssc.zork.Game;

import java.io.IOException;
import java.util.List;

public class PlayCommand implements Command{

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
        return "play";
    }

    @Override
    public void execute(Game game, List<String> args) throws IOException {
        game.playMap(args.get(0).toLowerCase());
    }
}
