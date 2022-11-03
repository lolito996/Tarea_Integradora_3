package model;
import model.ICanción;

public class Premium extends Consumers {
    public static final int accesPremiun=1000000000;
    private ICanción cancion;
    private int totalCanciones;
    private int totalListReproduction;
    
    public Premium(String nickName,String id,String dateVinculation){
        super(nickName, id,dateVinculation); 
    }
}
