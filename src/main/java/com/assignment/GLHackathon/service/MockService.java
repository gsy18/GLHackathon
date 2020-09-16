package com.assignment.GLHackathon.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MockService {
    private String randomOutputs[] = {"first","second","third"};
    public String getOutput(String sourceCode,List<String> arguments){
        int randomIndex = (int )(Math.random() * 3);
        return randomOutputs[randomIndex];
    }
}
