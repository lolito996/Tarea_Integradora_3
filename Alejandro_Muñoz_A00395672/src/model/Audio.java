package model;

public abstract class Audio {
    private String name;
    private String url;

    public Audio(String name,String url){
        this.name=name;
        this.url=url;
    }
    public String getName(){
        return this.name;
    }
    
}
