package ui;

import java.time.Duration;
import java.util.Scanner;
import java.util.function.Consumer;

import model.Artists;
import model.ContentCreators;
import model.Controller;
import model.Premium;
import model.Producers;
import model.Standard;

public class Main {


	private Scanner reader;
	private Controller controller;

	public Main() {
		reader = new Scanner(System.in); 
		controller = new Controller();

	}

	public static void main(String[] args) {
			Main main = new Main(); 

			int option =-1; 
			do{

				option = main.getOptionShowMenu(); 
				main.executeOption(option);

			}while(option != 0);

		}

	public Scanner getReader() {
		return this.reader;
	}

	public void setReader(Scanner reader) {
		this.reader = reader;
	}

	public int getOptionShowMenu(){
			int option = 0; 
			System.out.println(printMenu());

			option = validateIntegerOption(); 

		return option; 
	}

	public String printMenu(){
		return 
		"\n" +
		"<< --------------------------------------------------------------------- >>\n" +
		"<< -                                Welcome                            - >>\n" +
		"<< --------------------------------------------------------------------- >>\n" +
		"1. Registrar usuarios productores, artistas y creadores de contenido.\n" +
		"2. Registrar usuarios consumidores, Estandar, Premium \n" + 
		"3. Reggistrar 	canciones y podcast\n" +
		"4. crear una playlist a un consummidor\n" +
		"0. Salir del programa.\n"; 
	}

	public void executeOption(int option){
		int typeCreator =0;
		boolean create=false;
		int pos=-1;
		int totalObjects=-1;
		String nickName="";
		boolean exist=false;
		String msj="";
		String namePlaylist="";
		String name="";
		String date="";
		String url="";
		String id= "";
		String album="";
		String description="";
		int validate=0 ;
		int type=0;
		int count=0;
		double duration=0;
		double price=0;
		boolean control=false;
		switch(option){

				case 1: 

					System.out.println("Deseas registrar 1) ARTISTA o  2) CREADOR DE CONTENIDO");
					do{	
							if(reader.hasNextInt()){
							typeCreator=reader.nextInt();
							if(typeCreator!=1 && typeCreator!=2){
								System.out.println("Opcion invalida");
							}
							}else{
								reader.next();
								System.out.println("OPTION INVALID ");

							}
						}while(typeCreator!=1 && typeCreator!=2);
						if(typeCreator==1){
							System.out.println("cual es el nombre ");
							name=reader.next();
							System.out.println("cual es  la fecha de vinculación");
							date=reader.next();
							System.out.println("cual es la url de tu imagen ");
							url=reader.next();
							validate=0;
							control=controller.addProducers(name,date,url,validate);
							if(control==true){
								msj="Se creo el artista";

							}else{
								msj="No se creo nadie ";
							}
							}
						else{
							System.out.println("cual es el nombre ");
							name=reader.next();
							System.out.println("cual es  la fecha de vinculación");
							date=reader.next();
							System.out.println("cual es la url de tu imagen ");
							url=reader.next();
							control=controller.addProducers(name,date,url,validate);
								if(control==true){
								msj="Se creo el creador de contenido ";

							}else{
								msj="No se creo a nadie ";
							}

						}
						System.out.println(msj);
						
				break;

				case 2: 
					System.out.println("Deseas registrar 1) PREMIUM  o  2) STANDAR");
					do{	
						if(reader.hasNextInt()){
						typeCreator=reader.nextInt();
							if(typeCreator!=1 && typeCreator!=2){
								System.out.println("Opcion invalida");
							}
						}
						else{
							reader.next();
							System.out.println("Opcion invalida ");
						}
					}while(typeCreator!=1 && typeCreator!=2);
					if(typeCreator==1){
						System.out.println("Crea un nickName");
						nickName=reader.next();
						exist=controller.validateNickName(nickName);
						if(exist==true){
							msj="Ya existe este nickName";
						}	
						else{
							System.out.println("cual es  su cedula");
							id=reader.next();
							System.out.println("cual es su fecha de vinculación");
							date=reader.next();
							validate=0;
							control=controller.addConsumer(nickName,id,date,validate);
							if(control==true){
								msj="Se creo el usuario Premium";

							}
							else{
								msj="No se pudo crear el usuario Premium ";
							}
						}
					}
					else{
						System.out.println("Crea un nickName");
						nickName=reader.next();
						exist=controller.validateNickName(nickName);
						if(exist==true){
							msj="Ya existe este nickName";
						}	
						else{
							System.out.println("cual es  su cedula");
							id=reader.next();
							System.out.println("cual es su fecha de vinculación");
							date=reader.next();
							control=controller.addConsumer(nickName,id,date,validate);
							if(control==true){
								msj="Se creo el usuario Standar";

							}
							else{
								msj="No se pudo crear el usuario Standar ";
							}
						}
					}

					System.out.println(msj);	
					
		
				break; 

				case 3: 
					System.out.println("Deseas registrar 1) CANCIÓN  o  2) PODCAST");
					do{	
						if(reader.hasNextInt()){
						typeCreator=reader.nextInt();
							if(typeCreator!=1 && typeCreator!=2){
								System.out.println("Opcion invalida");
							}
						}
						else{
							reader.next();
							System.out.println("Opcion invalida ");
						}
					}while(typeCreator!=1 && typeCreator!=2);
					if(typeCreator==1){
						System.out.println("cual es el nombre ");
							name=reader.next();
							System.out.println("cual es  el Album");
							album=reader.next();
							msj=controller.printTypeCancion();
							System.out.println(msj);
							
							do{
								type=reader.nextInt();
								if(type != 1 | type !=2 | type!=3 |type!=4 ){
									System.out.println("Opcion invalida");
								}
							}while(type == 1 | type ==2 | type==3 |type==4 );
							System.out.println("cual es la url ");
							url=reader.next();
							System.out.println("cual es la duracion ");
							duration=reader.nextDouble();
							System.out.println("cual es el precio ");
							price=reader.nextDouble();
							msj=controller.addCancion(name, album, type, url, duration,price);
					}else{
						System.out.println("cual es el nombre ");
							name=reader.next();
							System.out.println("cual es la descripcion");
							description=reader.next();
							msj=controller.printTypePodcast();
							System.out.println(msj);
							type=reader.nextInt();
							System.out.println("cual es la url ");
							url=reader.next();
							System.out.println("cual es la duracion ");
							duration=reader.nextDouble();
							msj=controller.addPodcast(name, album, type, url, duration);
						}
						System.out.println(msj);

				break;

				case 4: 
				System.out.println("Escribe el nickname");
				nickName = reader.next();
				pos =controller.searchUserByNickName(nickName);
				if(pos!=-1){
					System.out.println("Escribe el nombre de la playlist");
					namePlaylist = reader.next();
					System.out.println("Escribe la url de la playlist ");
					url=reader.next();
					System.out.println("Elige el tipo de playlist\n");
					msj=controller.printTypePLayList();
					System.out.println(msj);
					do{typeCreator=reader.nextInt();
						if(typeCreator>3 | typeCreator<1){
							System.out.println("Ese  tipo de playlist no existe");
							typeCreator=-1;
						}
					}while(typeCreator!=-1);	
					controller.addPLaylist(namePlaylist, url, typeCreator);			
					if(typeCreator==1){
						System.out.println("Cuantos canciones deseas almacenar ");
						totalObjects=reader.nextInt();
						do{
							count=0;
							System.out.println(controller.printCanciones());
							System.out.println("Escribe el nombre de la cancion ");
							name = reader.next();
							exist=controller.validateNameCancion(name);
							if(exist==true){
								count ++;
								msj=controller.addPlaylistConsumer(nickName,namePlaylist,typeCreator,name);
							}
							else{
							System.out.println("No existe la cancion");
							}
						}while(count==totalObjects);
					}if(typeCreator==2){
						System.out.println("Cuantos canciones deseas almacenar ");
						totalObjects=reader.nextInt();
						do{
							count=0;
							System.out.println(controller.printPodcast());
							System.out.println("Escribe el nombre de el podcast ");
							name = reader.next();
							exist=controller.validateNamePodcast(name);
							if(exist==true){
								count++;
								msj=controller.addPlaylistConsumer(nickName,namePlaylist,typeCreator,name);
							}
							else{
							System.out.println("No existe el podcast");
							}
						}while(count==totalObjects);
						if(typeCreator==3){
							System.out.println("Cuantos audios  deseas almacenar ");
							totalObjects=reader.nextInt();
						do{
							count=0;
							System.out.println(controller.printAllAudio());
							System.out.println("Escribe el nombre de el audio que deseas almacenar ");
							name = reader.next();
							exist=controller.validateAudio(name);
							if(exist==true){
								count++;
								msj=controller.addPlaylistConsumer(nickName,namePlaylist,typeCreator,name);
							}
							else{
								System.out.println("No existe el audio");
							}
						}
							while(count==totalObjects);
						}
					}		
				}
				else{
					msj=" No se encontro el usuario ";
					}
				System.out.println(msj);
			    break;
				case 5:

				case 0: 
					System.out.println("Exit program.");
				break; 

				default: 
					System.out.println("Invalid Option");
				break; 
		}
	}

	public int validateIntegerOption(){
			int option = 0; 

		if(reader.hasNextInt()){
			option = reader.nextInt(); 
		}
		else{
			// clear reader. 
			reader.nextLine(); 
			option = -1; 
		}

		return option; 
	}

}