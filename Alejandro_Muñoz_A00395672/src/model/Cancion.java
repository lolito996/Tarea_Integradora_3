package model;

public class Cancion extends Audio {
    private String album;
    private Gender gender;
    private double duration;
    private double price;
    private int numberReplay;
    private double numberSeller;
    
    
    public Cancion(String name,String album,Gender gender,String url,double duration,double price){
         super(name, url);
        this.album=album;
        this.gender=gender;
        this.duration=duration;
        this.price=price;
    }
}
