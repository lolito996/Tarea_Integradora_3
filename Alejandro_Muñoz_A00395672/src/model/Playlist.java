package model;
import java.util.ArrayList;
import java.util.Random;


public  class Playlist {
    public static final int ROWS=6;
    public static final int COLUMNS=6;
    
    private String name;
    private String id;
    private TypePlaylist type;
    private ArrayList<Audio> audios;
    Random random=new Random();
    private ArrayList<Audio>playlist;
    int [] [] matrix;

    

    public Playlist(String name,TypePlaylist type){
        this.name=name;
        this.audios =new ArrayList<Audio>();
        this.matrix=new int[ROWS][COLUMNS];
        this.type=type;
        generateMatrix();
        playlist=new ArrayList<Audio>();

    }
    public void generateMatrix(){
        for (int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                matrix [i][j]=random.nextInt(9);
            }
        }
    }
    public String getName(){
        return this.name;
    }

    public String calculateId(TypePlaylist type){
        String msj= "";

        switch(type){

        case AUDIO:

            for(int i = 5;i>=0;i--){
            msj += matrix[i][0];
            }
            for(int i = 1;i<ROWS;i++){
                for(int j = 1; j <COLUMNS; j++){
                    if(i==j){
                        msj += matrix[i][j];
                    }
                }
            }
            for(int i = 4;i>=0;i--){
                 msj += matrix[i][5];
            }
        break;

        case PODCAST:
            for(int i=0;i<=2;i++){
                msj += matrix[0][i];
            }
            for(int i=1;i<ROWS;i++){
                msj += matrix[i][2];
            }
            for(int i=5;i>=0;i--){
                msj += matrix[i][3];
            }
            for(int i=4;i<=5;i++){
                msj += matrix[0][i];
            }

        break;
        case BOTH:
            for(int i = 4;i>=0;i--){
                if(i%2==0){
                    msj += matrix[5][i];
                }
            }
            for(int i = 5;i>=0;i--){
                if(i%2!=0){
                    msj += matrix[4][i];
                }
            }
            for(int i = 4;i>=0;i--){
                if(i%2==0){
                    msj += matrix[3][i];
                }
            }
            for(int i = 5;i>=0;i--){
                if(i%2!=0){
                    msj += matrix[2][i];
                }
            }
            for(int i = 4;i>=1;i--){
                if(i%2==0){
                    msj += matrix[1][i];
                }
            }
            for(int i = 5;i>=3;i--){
                if(i%2!=0){
                    msj += matrix[0][i];
                }
            }
        break;
        
        }
        return msj;
    }
    public String addAudio(Audio newAudio){
        String msj = "";
        if(type == TypePlaylist.AUDIO){
            if(newAudio instanceof Cancion){
                playlist.add(newAudio);
                msj = "cancion agregada";
            }else{
                msj = "Esta playlist solo es de canciones";
            }
        }else if(type == TypePlaylist.PODCAST){
            if(newAudio instanceof Podcast){
                playlist.add(newAudio);
                msj = "podcast añadido";
            }else{
                msj = "Esta playlist solo es de podcast";
            }
        }else if(type == TypePlaylist.BOTH){
            playlist.add(newAudio);
            msj = "audio anadido";
        }
        return msj;
    }
    public ArrayList<Audio> getAudios(){
        return audios;
    }


}
