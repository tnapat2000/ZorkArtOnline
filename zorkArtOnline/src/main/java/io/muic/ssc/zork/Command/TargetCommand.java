package io.muic.ssc.zork.Command;

import io.muic.ssc.zork.Entity.Monster;
import io.muic.ssc.zork.Game;

import java.io.IOException;
import java.util.List;

public class TargetCommand implements Command{

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
        return "target";
    }

    @Override
    public void execute(Game game, List<String> args) throws IOException {
        Monster monster = game.getPlayerLocation().retrieveMonster(args.get(0).toLowerCase());
        game.target(monster);
    }
}
