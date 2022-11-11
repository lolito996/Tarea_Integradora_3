package model;

import javax.sound.sampled.AudioFileFormat;

public class Podcast extends Audio {
    private String description;
    private Type typePodcast;
    private double duration;
    private int numberReplay;
    
    public Podcast(String name,String description,Type typePodcast,String url,double duration){
        super(name,url);
        this.description=description;
        this.typePodcast=typePodcast;
        this.duration=duration;
    }
}


