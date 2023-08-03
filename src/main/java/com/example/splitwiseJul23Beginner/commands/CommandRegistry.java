package com.example.splitwiseJul23Beginner.commands;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CommandRegistry {
    private Map<String, Command> map;
    private static CommandRegistry INSTANCE = null;

    private CommandRegistry() {
        this.map = new HashMap<>();
    }

    public synchronized static CommandRegistry getInstance(){
        if(INSTANCE == null){
            INSTANCE = new CommandRegistry();
        }
        return INSTANCE;
    }

    public Command getCommand(String input){
        for (Map.Entry<String, Command> entry : map.entrySet()) {
            String key = entry.getKey();
            if(input.contains(key)){
                return entry.getValue();
            }
        }
        throw new UnsupportedOperationException("Operation " + input + " is not supported");
    }

    public void addCommand(String key, Command command){
        map.put(key, command);
    }
}
