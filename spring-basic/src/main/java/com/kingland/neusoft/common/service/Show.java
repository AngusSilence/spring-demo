package com.kingland.neusoft.common.service;

import com.kingland.neusoft.common.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The Show component which can call the Artist to play a show.
 */
@Component
public class Show {
//    @Autowired
//    private Artist artist;

    @Autowired
    private List<Artist> artists;
    public void show(){
//        artist.play();
        for(Artist artist:artists){
            artist.play();
        }
    }

}
