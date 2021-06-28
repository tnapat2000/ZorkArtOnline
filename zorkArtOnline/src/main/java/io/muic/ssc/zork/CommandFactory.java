package io.muic.ssc.zork;

import io.muic.ssc.zork.Command.*;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class CommandFactory {

    private static final List<Class<? extends Command>> REGISTERED_COMMANDS = Arrays.asList(
            ExitCommand.class, InfoCommand.class, TakeCommand.class, DropCommand.class,
            GoCommand.class
    );

    private static final Map<String , Command> COMMANDS_MAP = new HashMap<>();

    static {{
        for (Class<? extends Command> commandClass : REGISTERED_COMMANDS){
            try {
                Command command = commandClass.getDeclaredConstructor().newInstance();
                COMMANDS_MAP.put(command.getCommand(), command);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }}

    public static Command get(String commandName){
        return COMMANDS_MAP.get(commandName);
    }

    public static List<String> getAllCommands(){
        return new ArrayList<>(COMMANDS_MAP.keySet());
    }

}
