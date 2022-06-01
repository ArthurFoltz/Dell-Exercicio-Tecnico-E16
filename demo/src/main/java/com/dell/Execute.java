package com.dell;

import java.io.FileNotFoundException;
import java.nio.file.NoSuchFileException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Execute {

    Functionalities grabAppFunctions = new Functionalities();
    
	/**
	 * [PT-BR] Cria a interface textual/console para o usuario com as funcionalidades exigidas pelo exercicio
	 * tecnico da Dell
	 * [ENG] Create the textual/console user interface with the functionalities requires by the dell technical exam
	 * @throws IllegalStateException
	 * @throws NoSuchFileException Caso nao exista tal arquivo / If the file does not exist
	 * @throws FileNotFoundException Caso nao encontre tal arquivo / If the file was not found
	 */
    public void executeApp() throws IllegalStateException, NoSuchFileException, FileNotFoundException{

		int chose2 = 0;
	try{
		while(chose2 != 5) {
			Scanner in = new Scanner(System.in);
			System.out.println("");
			System.out.println("Digitar 1, digite o caminho do arquivo CSV / Write the CSV file path"); 
			System.out.println("Digitar 2, consultar medicamento pelo nome / search for medication name");
			System.out.println("Digitar 3, buscar pelo codigo de barras / search for medication barcode "); 
			System.out.println("Digitar 4, comparativo da lista de concessao de credito tributario / tax concession comparative list"); 
			System.out.println("Digitar 5, Finalizar programa / end program");  
			System.out.println("");
			int chose = in.nextInt();
			
		
			switch(chose) {
			case 1: 
					System.out.println("Digite o caminho do arquivo CSV / Write the CSV file path:");
					System.out.println("For example / por exemplo: ");
					System.out.println("C:\\Users\\Arthur\\Desktop\\lista\\listabolsas.csv ");
					in.nextLine();
					String caminho = in.nextLine();
					if(grabAppFunctions.csvToBeRead(caminho)){
						System.out.println("Sucesso ! / Success");
					}
					else System.out.println("Erro ! / Error");
					break;
					
			case 2: System.out.println("Por favor, digite o nome do medicamento:");
					System.out.println("Please, type the medication name:");
					in.nextLine();
					String nome = in.nextLine();
					System.out.println(grabAppFunctions.searchMedicationName(nome.toUpperCase()));
					break;
					
			case 3: try{
						System.out.println("Por favor, digite o codigo de barras: ");
						System.out.println("Please, type the barcode: ");
						long barcode = in.nextLong();
						System.out.println(grabAppFunctions.searchBarcode(barcode));
						break;
				} catch (InputMismatchException entradaInvalidaNumero) {
					System.err.println("Não é permitido inserir letras, informe apenas números inteiros!");
					System.err.println("Letters not allowed, please use only whole numbers");
					in.nextLine(); //descarta a entrada
					break;
				}
				
			case 4: System.out.println(grabAppFunctions.taxConcessionComparative());
					break;
			
			case 5: System.out.println("Programa finalizado !");
					System.out.println("End of program !");
					chose2 = 5;
					in.close();
					break;

			default: System.out.println("Opcao invalida !");
					 System.out.println("Invalid  option!");
			}
		}	 
	} catch (InputMismatchException InvalidAssign){
		System.err.println("Não é permitido inserir letras, informe apenas números inteiros!");
		System.err.println("Letters not allowed, please use only whole numbers");
	}
 }



}
