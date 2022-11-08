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
    private Consumers consumer;
    private ArrayList<Cancion> canciones;
    private ArrayList<Podcast> podcasts;
    
    public Controller(){
        consumers =new ArrayList<Consumers>();
        producers =new ArrayList<Producers>();
        canciones=new ArrayList<Cancion>();
        podcasts=new ArrayList<Podcast>();        
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
    public String addCancion(String name,String album,int genero,String url,double duration,double price){
        String msj="";
        Gender gender=defineTypeGender(genero);
        boolean create=false;
        Cancion cancion=new Cancion(name,album,gender, url, duration, price);
        create= canciones.add(cancion);
        if(create==true ){
            msj="Se creo la canción";
        }else{
            msj="No se pudo crea nada ";
        }
        return  msj;
    }
    public String addPodcast(String name,String description,int genero,String url,double duration){
        String msj="";
        Type typePodcast=defineTypePodcast(genero);
        boolean create=false;
        Podcast podcas=new Podcast(name,description,typePodcast, url, duration);
        create= podcasts.add(podcas);
        if(create==true ){
            msj="Se creo la canción";
        }else{
            msj="No se pudo crea nada ";
        }
        return  msj;
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
}
