package model;
import java.lang.reflect.Array;
import java.util.ArrayList;
import model.*;


public class Controller {
    public static final int TOTAL_CANCIONES=100000;


    private ArrayList<Consumers>consumers;
    private Gender gender;
    private Type typePodcast;
    private ArrayList<Producers>producers;
    private ArrayList <Consumers> consumer;
    private ArrayList<Audio>audios;
    private ArrayList<Playlist>playlists;
    
    public Controller(){
        consumers =new ArrayList<Consumers>();
        producers =new ArrayList<Producers>();
        audios =new ArrayList<Audio>(); 
        playlists=new ArrayList<Playlist>();
    }
    public boolean addProducers(String name,String date,String url,int validate){
        boolean create=false;
        if(validate==0){
            Artists artist=new Artists(name,date,url);
           create= producers.add(artist);
        }else{
            ContentCreators content=new ContentCreators(name, url, date);
           create=producers.add(content);
        }
        return create;
    }
    public boolean addConsumer(String nickName,String date,String url,int validate){
        boolean create=false;
        if(validate==0){
            Standard standar=new Standard(nickName,date,url);
           create= consumers.add(standar);
        }else{
            Premium premium=new Premium(nickName, url, date);
           create=consumers.add(premium);
        }
        return  create;
    }
    public boolean addPLaylist(String name,String url){
        boolean exist=false;
        for (int i =0;i<playlists.size();i++){
            if(playlists.get(i)==null){
                playlists.get(i)=new Playlist(name,url);
            }
        }
        
    }
    public String addCancion(String name,String album,int genero,String url,double duration,double price){
        String msj="";
        Gender gender=defineTypeGender(genero);
        boolean create=false;

            Cancion cancion=new Cancion(name,album,gender, url, duration, price);
            create=audios.add(cancion);
        if(create==true){
            msj="Se agrego la cancion";
        }else{
            msj="No se pudo crear la cancion";
        }
        return msj;

    }
    public String addPodcast(String name,String description,int genero,String url,double duration){
        String msj="";
        Type typePodcast=defineTypePodcast(genero);
        boolean create=false;
        Podcast podcas=new Podcast(name,description,typePodcast, url, duration);
        create= audios.add(podcas);
        if(create==true){
            msj="Se creo el podcas";
        }
        else{
            msj="No se pudo crear el podcast";
        }
        return  msj;
    }
    public boolean validateNameCancion(String name){
        boolean exist=false;
        boolean isFound=false;
        for(int i=0;i<audios.size() & !isFound;i++){
            if(audios.get(i)!=null && audios.get(i) instanceof Cancion){
                if(audios.get(i).getName().equals(name)){
                    isFound=true;
                    exist=true;
                }
            }
        }
        return exist;
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
    public Gender defineTypeGender(int option){
        switch(option){
            case 1:
                gender=Gender.Rock;
            break;

            case 2:
                gender=Gender.Pop;
            break;

            case 3:
                gender=Gender.Trap;
            break;

            case 4:
                gender=Gender.House;
            break;

        }
        return gender;
    }
    public Type defineTypePodcast(int option){
        switch(option){
            case 1:
                typePodcast=Type.Politica;
            break;

            case 2:
            typePodcast=Type.Entrenimiento;
            break;

            case 3:
            typePodcast=Type.VideoJuegos;
            break;

            case 4:
            typePodcast=Type.Moda;
            break;

        }
        return typePodcast;
    }
    public String printTypePodcast(){
        return "1) Política\n"+
        "2)Entretenimiento\n"+
        "3)Videojuegos\n"+
        "4)Moda";
    }
    public String printTypeCancion(){
        return
        "1)Rock\n"+
        "2)Pop\n"+
        "3)Trap\n"+
        "4)House";
    }
    public String printTypePLayList(){
        return 
        "Canciones "+
        "Podcast"+
        "Canciones y Podcast";
    }
    public String printCanciones(){
        String msj= "";
        for(int i=0;i<audios.size();i++){
            if(audios.get(i)!=null && audios.get(i) instanceof Cancion){
                msj+=audios.get(i).getName()+"\n";
            }
        }
        return msj;
    }
    public String printPodcast(){

        String msj="";
        for(int i=0;i<audios.size();i++){
            if(audios.get(i)!=null && audios.get(i) instanceof Podcast){
                msj+=audios.get(i).getName()+"\n";
            }
        }

        return msj;
    }

    public String printAllAudio(){
        String msj="";
        for(int i=0;i<audios.size();i++){
            if(audios.get(i)!=null){
                msj+=audios.get(i).getName();
            }
        }
        return msj;
    }
    
    public int searchUserByNickName(String nickName){
        int pos = -1;
        boolean isFound = false;
        for(int i = 0;i<consumers.size() && !isFound;i++){
            if(consumers.get(i).getNickName().equalsIgnoreCase(nickName)){
                pos = i;
                isFound = true;
            }  
        }
        return pos;
    }
   
}
