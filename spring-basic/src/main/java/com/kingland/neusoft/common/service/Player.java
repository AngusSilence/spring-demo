package com.kingland.neusoft.common.service;

import com.kingland.neusoft.common.Artist;
import org.springframework.stereotype.Component;

/**
 * The Player.
 * @author Levin Zhang
 */
@Component
public class Player implements Artist {
    @Override
    public void play() {
        System.out.println("This is a show from a Player.");
    }
}
