package com.rccode.mcStarter.controller;

import com.rccode.mcStarter.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pofo/test")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping()
    private String clientTest(@RequestParam(value = "command") String command) {
        return testService.testService(command);
    }

}
