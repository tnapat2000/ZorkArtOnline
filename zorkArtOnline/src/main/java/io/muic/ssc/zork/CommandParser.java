package io.muic.ssc.zork;


import io.muic.ssc.zork.Command.Command;

import java.util.*;

public class CommandParser {

    private final List<String> allCommandSortedByLength = new ArrayList<>();
    {
        allCommandSortedByLength.addAll(CommandFactory.getAllCommands());
        allCommandSortedByLength.sort( ((o1, o2) -> o2.length() - o1.length()));
    }

    private String matchInputToCommand(String input){
        for (String command : allCommandSortedByLength){
            if (input.toLowerCase().startsWith(command)){
                return command;
            }
        }
        return null;
    }
//    "attack with weapon" - > "attack with", "weapon" ?
    public List<String> parse(String input){

        String cleanedInput = input.trim();
        String cmd = matchInputToCommand(cleanedInput);
        Command command = CommandFactory.get(cmd);

        if (command != null){
            if (command.numArgs() > 0){
                assert cmd != null;
                String argString = cleanedInput.substring(cmd.length()+1);
                return Arrays.asList(cmd, argString);
            }else{
                String[] strings = input.trim().split(" ");
                return Collections.singletonList(cmd);
            }
        }else {
//            System.out.println("Please enter a command");
            return new ArrayList<>();
        }
    }
}
