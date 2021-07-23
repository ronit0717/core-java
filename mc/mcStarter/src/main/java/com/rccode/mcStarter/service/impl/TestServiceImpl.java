package com.rccode.mcStarter.service.impl;

import com.rccode.mcStarter.service.TestService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class TestServiceImpl implements TestService {

    private final String INVALID_COMMAND = "Invalid Command...";

    @Override
    public String testService(String command) {
        if (StringUtils.isEmpty(command)) {
            return INVALID_COMMAND;
        }
        String[] commandSplit = command.split("\\s+");
        if (commandSplit[0].equals("CREATE")) {
            return "Create called";
        } else if (commandSplit[0].equals("UPDATE")) {
            return "Update called";
        } else {
            return INVALID_COMMAND;
        }
    }
}
