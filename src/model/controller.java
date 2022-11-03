package model;
import java.lang.reflect.Array;
import java.util.ArrayList;


public class Controller {
    private ArrayList<Consumers>consumers;
    private ArrayList<Producers>producers;
    
    public Controller(){
        consumers=new ArrayList<Consumers>();
        producers=new ArrayList<Producers>();
    }

    public boolean addConsumer(Consumers consumer){
        return consumers.add(consumer); 
    }
    
    public boolean addProducers(Producers producer){
        return producers.add(producer);
    }

    public boolean validateNickName(String nickName){
        boolean exist=false;
        boolean isFound=false;
        for(int i=0;i<consumers.size() & !isFound;i++){
            if(consumers.get(i).getNickName().equals(nickName)){
                exist=true;
                isFound=true;
            }
        }
        return exist;
    }
}
