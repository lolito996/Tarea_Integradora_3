package model;

public class Standard extends Consumers {
    public static final int accesCancionStandar=20;
    public static final int accesListStandar=100;
    private ICanción cancion;
    private int totalCanciones;
    private int totalListReproduction;
    
    public Standard(String nickName,String id,String dateVinculation){
        super(nickName, id,dateVinculation); 
    }
}
