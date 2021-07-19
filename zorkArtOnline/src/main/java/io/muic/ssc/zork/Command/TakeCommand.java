package io.muic.ssc.zork.Command;

import io.muic.ssc.zork.Entity.Item;
import io.muic.ssc.zork.Game;

import java.util.List;

public class TakeCommand implements Command{

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
        return "take";
    }

    @Override
    public void execute(Game game, List<String> args) {
        Item item = game.getPlayerLocation().retrieveItem(args.get(0).toLowerCase());
        game.take(item);
    }
}
