package model;

import java.util.ArrayList;
import java.util.ArrayList;

public class Standard extends Consumers {
    private ICanción cancion;
    private int totalCanciones;
    private int totalListReproduction;
    private int getCounterPlaylist=0;
    private ArrayList<Playlist>playlists;

    
    public Standard(String nickName,String id,String dateVinculation){
        super(nickName, id,dateVinculation); 
    }
    public int getCounterPlaylist(){
        return this.getCounterPlaylist;
    }
    public void setCounterPlaylist(int newCounter){
        this.getCounterPlaylist=newCounter;
    }
    public void setPlaylist(ArrayList<Playlist> newPlaylist){
        this.playlists=newPlaylist;
    }
    public ArrayList<Playlist> getPlaylists(){
        return playlists;
    }

}
