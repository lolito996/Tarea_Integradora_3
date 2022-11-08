package model;

public class podcast {
    private String name;
    private String description;
    private Type typePodcast;
    private String url;
    private double duration;
    private int numberReplay;
    
    public podcast(String name,String description,Type typePodcast,String url,double duration){
        this.name=name;
        this.description=description;
        this.typePodcast=typePodcast;
        this.url=url;
        this.duration=duration;
    }
}


