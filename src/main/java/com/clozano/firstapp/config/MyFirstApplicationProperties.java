package com.clozano.firstapp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("firstapp")
public class MyFirstApplicationProperties {
    /**
     * This is a welcome message.
     */
    private String welcomeMessage = "Hello world!";

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    } 
}
