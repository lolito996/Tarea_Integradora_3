package model;

public class Cancion {
    private String name;
    private String album;
    private Gender gender;
    private String url;
    private double duration;
    private double price;
    private int numberReplay;
    private double numberSeller;
    
    
    public Cancion(String name,String album,Gender gender,String url,double duration,double price){
        this.name=name;
        this.album=album;
        this.gender=gender;
        this.url=url;
        this.duration=duration;
        this.price=price;
    }
}
