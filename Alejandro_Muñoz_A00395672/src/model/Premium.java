package model;
import java.util.ArrayList;
import model.Playlist;
import model.Audio;

public class Premium extends Consumers {
    private ArrayList<Playlist>playlists;
    private ArrayList<Audio>audios;
    
    public Premium(String nickName,String id,String dateVinculation){
        super(nickName, id,dateVinculation); 
        playlists=new ArrayList<Playlist>();
        audios =new ArrayList<Audio>();
    }
    public ArrayList<Playlist> getPlaylists(){
        return playlists;
    }
    public ArrayList<Audio> getaudios(){
        return audios;

    }
    public void setPlaylist(ArrayList<Playlist> newPlaylists){
        this.playlists=newPlaylists;
    }
    public String playAudio(String name, ArrayList<Audio> audiosPrincipal) {
        String msg = "";
        for(Audio audio : audiosPrincipal){
            if(audio.getName().equalsIgnoreCase(name)){
                msg = "Reproduciendo\n" + audio.getName();
            }else {
                msg = "Audio no encontrado";
            }
        }
        return msg;
    }

  
   
    
}
