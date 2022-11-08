package model;

public  abstract class Consumers  {
    private String dateVinculation;
    private String nickName;
    private String id;
    public Consumers(String nickName,String id,String dateVinculation){
        this.nickName=nickName;
        this.id=id;
        this.dateVinculation=dateVinculation;
    }
    public String getDateVinculation(){
        return this.dateVinculation;
    }
    public void setDateVinculation(String dateVinculation){
        this.dateVinculation=dateVinculation;
    }
    public String getNickName(){
        return this.nickName;
    }
    
}
