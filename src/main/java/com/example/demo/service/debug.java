package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class debug {

    private static final Logger logger = LoggerFactory.getLogger(debug.class);

    public void generateDebugLog() {
        String message = "This is a debug message.";
        logger.debug(message);
    }
}