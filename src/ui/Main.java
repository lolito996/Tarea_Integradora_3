package ui;

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
		"4. Bajar a una persona del carro autonomo\n" +
		"0. Salir del programa.\n"; 
	}

	public void executeOption(int option){
		int typeCreator =0;
		String nickName="";
		boolean exist=false;
		String msj="";
		String name="";
		String date="";
		String url="";
		String id= "";
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
							Producers producer=new Artists(name,date,url);
							control=controller.addProducers(producer);
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
							ContentCreators contentCreator=new ContentCreators(name,date,url);
							control=controller.addProducers(contentCreator);
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
					}else{
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
							Premium premium=new Premium(name,date,url);
							control=controller.addConsumer(premium);
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
							Standard standar=new Standard(name,date,url);
							control=controller.addConsumer(standar);
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
						

						break;

					case 4: 

						break;

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