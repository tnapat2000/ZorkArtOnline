package io.muic.ssc.zork.Command;

import io.muic.ssc.zork.Game;

import java.util.List;

public interface Command {

    int numArgs();

    String getCommand();

    void execute(Game game, List<String> args);

}
