package model;
import java.util.ArrayList;
import model.*;


public class Controller {

    private ArrayList<Consumers>consumers;
    private Gender gender;
    private Type typePodcast;
    private TypePlaylist typePlaylist;
    private ArrayList<Producers>producers;
    private ArrayList<Audio>audios;
    private ArrayList<Playlist>playlists;
    
    /**
     * 
     */
    public Controller(){
        consumers =new ArrayList<Consumers>();
        producers =new ArrayList<Producers>();
        audios =new ArrayList<Audio>(); 
        playlists=new ArrayList<Playlist>();
    }
    /**
     * @param name
     * @param date
     * @param url
     * @param validate
     * @return create
     * in this method add producers in the arraylist whit name producers
     */
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
    /**
     * @param nickName
     * @param date
     * @param url
     * @param validate
     * @return.
     * in this method add consumer in the arraylist whit name consumers
     */
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
  
    /**
     * @param name
     * @param album
     * @param genero
     * @param url
     * @param duration
     * @param price
     * @return
     * int this method add cancion in the arraylist with name audios
     */ 
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
    /**
     * @param name
     * @param url
     * @param type
     * create the playlist but don't have the return because first create the playlist and  after the playlist exist send  the consuers
     */
    public void addPLaylist(String name,String url,int type){
        boolean exist=false;
        typePlaylist=selecType(type);
        for(int i=0;i<playlists.size();i++){
            if(playlists.get(i)==null){
                Playlist playlis=new Playlist(name,url,typePlaylist);
                exist=playlists.add(playlis);
            }
        }
    }

    /**
     * @param name
     * @param description
     * @param genero
     * @param url
     * @param duration
     * @return
     */
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
    /**
     * @param namePlaylist
     * @param url
     * @param type
     * @param nickName
     * @return
     */
    public String addPlaylistConsumer(String namePlaylist,String url,int type,String nickName){
        String msj="";
        Consumers consumer=searchUser(nickName);
        typePlaylist=selecType(type);
        if(consumer==null){
            msj = "El usuario no está creado, no se puede añadir playlist";
        }else{
            if(consumer instanceof Standard){//Consumidor estándar
                Standard objUser = (Standard) searchUser(nickName);
                if(objUser.getCounterPlaylist()<=20){
                    Playlist playlist = new Playlist(namePlaylist, url, typePlaylist);
                    objUser.getPlaylists().add(playlist);
                    objUser.setCounterPlaylist(+1);
                    msj="Se creo el playlist con exito";
                }else
                    msj = "El usuario " + nickName + " ya tiene el total de playlists creadas";
            }else{
                Premium objUser = (Premium) searchUser(nickName);
                Playlist playlist = new Playlist(namePlaylist, url, typePlaylist);
                objUser.getPlaylists().add(playlist);
                msj="Se creo el playlist con exito";
            }
        }

        return msj;
    }
    /**
     * @param name
     * @return
     */
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
    /**
     * @param name
     * @return
     */
    public boolean validateAudio(String name){
        boolean exist=false;
        boolean isFound=false;
        for(int i =0;i<audios.size() &! isFound;i++){
            if(audios.get(i).getName().equalsIgnoreCase(name)){
                isFound=true;
                exist=true;
            }
        }
        return exist;
    }
    public boolean validateNamePodcast(String name){
        boolean exist=false;
        boolean isFound=false;
        for(int i=0;i<audios.size() & !isFound;i++){
            if(audios.get(i)!=null && audios.get(i) instanceof Podcast){
                if(audios.get(i).getName().equals(name)){
                    isFound=true;
                    exist=true;
                }
            }
        }
        return exist;
    }

    /**
     * @param nikName
     * @return
     */
    public Consumers searchUser(String nikName){
        boolean isFound=false;
        Consumers consumer=null;
        for (int i=0;i<consumers.size()& !isFound;i++){
            if(consumers.get(i)!=null && consumers.get(i).getNickName().equalsIgnoreCase(nikName)){
                consumer=consumers.get(i);
                isFound=true;
            }
        }
        return consumer;
    }
    /**
     * @param nickName
     * @return
     */
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
    /**
     * @param option
     * @return
     */
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
    /**
     * @param option
     * @return
     */
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
    /**
     * @param option
     * @return
     */
    public TypePlaylist selecType(int option){
        switch(option){
            case 1:
            typePlaylist=TypePlaylist.AUDIO;
            break;

            case 2:
            typePlaylist=TypePlaylist.PODCAST;
            break;

            case 3:
            typePlaylist=TypePlaylist.BOTH;
            break;
        }
        return typePlaylist;
    }
    /**
     * @return
     */
    public String printTypePodcast(){
        return "1) Política\n"+
        "2)Entretenimiento\n"+
        "3)Videojuegos\n"+
        "4)Moda";
    }
    /**
     * @return
     */
    public String printTypeCancion(){
        return
        "1)Rock\n"+
        "2)Pop\n"+
        "3)Trap\n"+
        "4)House";
    }
    /**
     * @return
     */
    public String printTypePLayList(){
        return 
        "1)Canciones \n"+
        "2)Podcast\n"+
        "3)Canciones y Podcast";
    }
    /**
     * @return
     */
    public String printCanciones(){
        String msj= "";
        for(int i=0;i<audios.size();i++){
            if(audios.get(i)!=null && audios.get(i) instanceof Cancion){
                msj+=audios.get(i).getName()+"\n";
            }
        }
        return msj;
    }
    /**
     * @return
     */
    public String printPodcast(){

        String msj="";
        for(int i=0;i<audios.size();i++){
            if(audios.get(i)!=null && audios.get(i) instanceof Podcast){
                msj+=audios.get(i).getName()+"\n";
            }
        }

        return msj;
    }

    /**
     * @return
     */
    public String printAllAudio(){
        String msj="";
        for(int i=0;i<audios.size();i++){
            if(audios.get(i)!=null){
                msj+=audios.get(i).getName();
            }
        }
        return msj;
    }
    
    /**
     * @param nickName
     * @return
     */
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
