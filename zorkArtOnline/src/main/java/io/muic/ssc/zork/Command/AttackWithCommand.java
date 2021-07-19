package io.muic.ssc.zork.Command;

import io.muic.ssc.zork.Entity.Weapon;
import io.muic.ssc.zork.Game;

import java.io.IOException;
import java.util.List;

public class AttackWithCommand implements Command{

    @Override
    public int gameState(){
        return 0;
    }

    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public String getCommand() {
        return "attack with";
    }

    @Override
    public void execute(Game game, List<String> args) throws IOException {
        Weapon weapon = (Weapon) game.getCurrentPlayer().getPlayerInventory().get(args.get(0));
        game.attackWith(weapon);
    }
}
