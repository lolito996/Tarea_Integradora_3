package model;
import model.ICanción;
import java.util.ArrayList;
import model.Playlist;

public class Premium extends Consumers {
    public static final int accesPremiun=1000000000;
    private ICanción cancion;
    private int totalCanciones;
    private int totalListReproduction;
    private ArrayList<Playlist>playlists;
    
    public Premium(String nickName,String id,String dateVinculation){
        super(nickName, id,dateVinculation); 
        playlists=new ArrayList<Playlist>();
    }
    public ArrayList<Playlist> getPlaylists(){
        return playlists;
    }
    public void setPlaylist(ArrayList<Playlist> newPlaylists){
        this.playlists=newPlaylists;
    }
  
   
    
}
