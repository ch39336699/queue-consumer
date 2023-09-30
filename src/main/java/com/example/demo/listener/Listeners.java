package com.example.demo.listener;

import com.example.demo.api.SpaceShip;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.stereotype.Service;

import javax.jms.ConnectionFactory;


//import javax.jms.ConnectionFactory;

@Service("bean1")
@Slf4j
public class Listeners {
    @JmsListener(destination = "myqueue2")
    public void receiveMessage(String message) {
        log.info("Received text message: {}", message);
    }

    @JmsListener(destination = "spaceships", containerFactory = "shipFactory")
    public void receiveShip(SpaceShip ship) {
        log.info("Received: {}", ship);
    }

}
