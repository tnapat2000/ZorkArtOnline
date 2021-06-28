package io.muic.ssc.zork;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandParserTest {
    @Test
    void testParser() {

        CommandParser commandParser = new CommandParser();
        commandParser.parse("exit");
    }
}