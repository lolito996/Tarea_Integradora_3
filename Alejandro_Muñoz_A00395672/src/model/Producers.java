package model;

public abstract class Producers {
    private String name;
    private String dateVinculation;
    private String url;
    public Producers(String name,String datevinculation,String url){
        this.name=name;
        this.dateVinculation=datevinculation;
        this.url=url;
    }

}
