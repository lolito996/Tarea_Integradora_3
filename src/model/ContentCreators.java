package model;

public class ContentCreators extends Producers {

    private double totalReproduction;
    public ContentCreators(String name,String datevinculation,String url){
        super(name, datevinculation, url);
    }

    public double getTotalReproduction(){
        return this.totalReproduction;
    }
}
