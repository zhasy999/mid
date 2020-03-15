package com.example.mid.events.handler;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class AppContextRefreshHandler implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("AppContextRefreshHandler.onApplicationEvent");
        System.out.println("System starts");
    }
}
