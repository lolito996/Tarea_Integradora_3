package model;
import java.util.ArrayList;

public class Standard extends Consumers {
    public static final int TOTAL_ADVERSITING=3;
    
    private int counterSongs =0;
    private String [] advertising;
    private int getCounterPlaylist=0;
    private ArrayList<Playlist>playlists;

    
    public Standard(String nickName,String id,String dateVinculation){
        super(nickName, id,dateVinculation);
        playlists=new ArrayList<Playlist>(); 
        advertising=new String[TOTAL_ADVERSITING];
        inicialitedPublicitary();
    }
    public int getCounterPlaylist(){
        return this.getCounterPlaylist;
    }
    public void setCounterPlaylist(int newCounter){
        this.getCounterPlaylist=newCounter;
    }
    public void inicialitedPublicitary(){
        advertising[0]=new String("Nike - Just Do It.");
        advertising[1]=new String ("Coca-Cola - Open Happiness.");
        advertising[2]=new String("M&Ms - Melts in Your Mouth, Not in Your Hands");
    }
    public void setPlaylist(ArrayList<Playlist> newPlaylist){
        this.playlists=newPlaylist;
    }
    public ArrayList<Playlist> getPlaylists(){
        return playlists;
    }
    public String playAudio(String name, ArrayList<Audio> audiosPrincipal) {
        String msg = "";
        boolean flag = false;
        for(int i=0; i<audiosPrincipal.size() && !flag; i++){
            if(audiosPrincipal.get(i).getName().equalsIgnoreCase(name)){
                flag = true;
                int index = (int)(Math.random()*(3-1))+1;
                if(audiosPrincipal.get(i) instanceof Audio){
                    counterSongs++;
                    if(counterSongs%2==0){
                        msg = "Reproduciendo\n" + audiosPrincipal.get(i).getName() + "\n" + "Sponsored by: " + advertising[index];
                    }else {
                        msg = "Reproduciendo\n" + audiosPrincipal.get(i).getName();
                    }
                }else {
                    msg = "Sponsored by: " + advertising[index] + "\n" + "Reproduciendo\n" + audiosPrincipal.get(i).getName() ;
                }
            }else {
                msg = "Audio no encontrado";
            }
        }
        return msg;
    }

}
