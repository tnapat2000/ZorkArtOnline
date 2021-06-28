package io.muic.ssc.zork.Command;

import io.muic.ssc.zork.Entity.Item;
import io.muic.ssc.zork.Game;

import java.util.List;

public class DropCommand implements Command{

    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public String getCommand() {
        return "drop";
    }

    @Override
    public void execute(Game game, List<String> args) {
        Item item = game.getCurrentPlayer().getPlayerInventory().get(args.get(0));
        game.drop(item, game.getPlayerLocation());
    }
}
