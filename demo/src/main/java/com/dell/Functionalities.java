package com.dell;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Functionalities {
    
    ReadCsv read = new ReadCsv();

    public ArrayList<String> searchMedicationName(String name){

        ArrayList<String> matchNameList = new ArrayList<>();
		String match = null;

        for (int i = 0; i < read.returnMedicationList().size(); i++) {
			if (read.returnMedicationList().get(i).getSubstancia().equals(name) || read.returnMedicationList().get(i).getSubstancia().contains(name)) { // verifica se o nome é igual ou se contem parte do mesmo
				if(read.returnMedicationList().get(i).getComercializacao2020().equals("Sim")){
					match = read.returnMedicationList().get(i).returnMedicineBasicInfo();
					matchNameList.add(match);		   
				}
			}
		}
        return matchNameList;
    }

	public ArrayList<Medications> searBarcode(int barcode){

		ArrayList<Medications> matchBarcode = new ArrayList<>();

		for (int i = 0; i < read.returnMedicationList().size(); i++) {
			if (read.returnMedicationList().get(i).getEan1().equals(Integer.toString(barcode)) || read.returnMedicationList().get(i).getEan2().equals(Integer.toString(barcode)) || read.returnMedicationList().get(i).getEan3().equals(Integer.toString(barcode))){
				matchBarcode.add(read.returnMedicationList().get(i));
			}
		}
		
		return matchBarcode;
	}


    public void execute() throws IllegalStateException, IOException {


		int chose2 = 0;

		while(chose2 != 6) {
			Scanner in = new Scanner(System.in);
			System.out.println("");
			System.out.println("Digitar 1, digite o caminho do arquivo CSV"); 
			System.out.println("Digitar 2, consultar medicamento pelo nome");
			System.out.println("Digitar 3, buscar pelo codigo de barras "); 
			System.out.println("Digitar 4, comparativo da lista de concessao de credito tributario "); 
			System.out.println("Digitar 5, pensar em algo a mais "); 
			System.out.println("Digitar 6, Finalizar programa "); 
			System.out.println("");
			int chose = in.nextInt();
			boolean auxi = false;

			switch(chose) {
			case 1: System.out.println("Digite o caminho do arquivo CSV ");
					System.out.println("Por exemplo C:\\Users\\Arthur\\Desktop\\lista\\listabolsas.csv ");
					String caminho1 = in.nextLine();
					String caminho = in.nextLine();
					read.ProcessCsv(caminho);
					System.out.println("Sucesso ! ");
					break;
					
			case 2: System.out.println("Por favor, digite o nome do medicamento");
					System.out.println("Please, type the medication name");
					String nome1 = in.nextLine();
					String nome = in.nextLine();
					System.out.println(searchMedicationName(nome.toUpperCase()));
					break;
					
			case 3: try{
						System.out.println("Por favor, digite o codigo de barras ");
						System.out.println("Please, type the barcode ");
						int barcode = in.nextInt();
						//System.out.println(consultaMediaValoresAnual(anoMedia));
						break;
				} catch (InputMismatchException entradaInvalidaNumero) {
					System.err.println("Não é permitido inserir letras, informe apenas números inteiros!");
					in.nextLine(); //descarta a entrada
					break;
				}
				
			case 4: //System.out.println(consultaValoresBolsa());
					break;
			
			case 5: System.out.println("Programa finalizado !");
					chose2 = 6;
					break;
			}
		}
	
	
 }
}
