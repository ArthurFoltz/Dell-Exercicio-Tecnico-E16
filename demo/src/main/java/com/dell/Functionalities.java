package com.dell;


import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
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

	public ArrayList<Medications> searchBarcode(Long barcode){

		String barcodeToString = Long.toString(barcode);
		ArrayList<Medications> matchBarcode = new ArrayList<>();

		for (int i = 0; i < read.returnMedicationList().size(); i++) {
			if (read.returnMedicationList().get(i).getEan1().equals(barcodeToString) || read.returnMedicationList().get(i).getEan2().equals(barcodeToString) || read.returnMedicationList().get(i).getEan3().equals(barcodeToString)){
				matchBarcode.add(read.returnMedicationList().get(i));
			}
		}
		if(matchBarcode.isEmpty()){
			return matchBarcode;
		}
		Collections.sort(matchBarcode);

		String lowerPmc0Medication = matchBarcode.get(0).toString();
		String higherPmc0Medication = matchBarcode.get(matchBarcode.size()-1).toString();

		String onlyLowerPmc = matchBarcode.get(0).getPmc0().toString();
		String onlyHigherPmc0 = matchBarcode.get(matchBarcode.size()-1).getPmc0().toString();

		String a = onlyLowerPmc.replace(',', '.');
		String b = onlyHigherPmc0.replace(',', '.');

		Double diferenca = Double.parseDouble(b) - Double.parseDouble(a);

		System.out.println("Menor pmc: " + lowerPmc0Medication + "\nMaior pmc: " + higherPmc0Medication + "\nDiferenca: " + diferenca);
		System.out.println();
		System.out.println("Produtos encontrados:");
		return matchBarcode;
	}

	public String taxConcessionComparative(){

		double negative = 0;
		double neutral = 0;
		double positive = 0;
		double total = 0;

		for (int i = 0; i < read.returnMedicationList().size(); i++) {
			if(read.returnMedicationList().get(i).getComercializacao2020().equals("Sim")){
				if(read.returnMedicationList().get(i).getListaConcessaoCreditoTributario().equals("Negativa")){
					negative++;
				}
				else if(read.returnMedicationList().get(i).getListaConcessaoCreditoTributario().equals("Positiva")){
					positive++;
				}
				else neutral++;
			}
		}

		total = negative + positive + neutral;

		String negativePercentage = calculatePercentage(negative, total);
		String positivePercentage = calculatePercentage(positive, total);
		String neutralPercentage = calculatePercentage(neutral, total);
		String negativeStars = "";
		String positiveStars = "";
		String neutralStars = "";

		for(int i = 0; i < Double.parseDouble(negativePercentage); i++){
			String star = "*";
			negativeStars = star + negativeStars;
		}
		for(int i = 0; i < Double.parseDouble(positivePercentage); i++){
			String star = "*";
			positiveStars = star + positiveStars;
		}
		for(int i = 0; i < Double.parseDouble(neutralPercentage); i++){
			String star = "*";
			neutralStars = star + neutralStars;
		}

		BigDecimal negat = new BigDecimal(negativePercentage).setScale(2, RoundingMode.HALF_UP);
		BigDecimal neutr = new BigDecimal(neutralPercentage).setScale(2, RoundingMode.HALF_UP);
		BigDecimal positi = new BigDecimal(positivePercentage).setScale(2, RoundingMode.HALF_UP);
      	String negativePercentage2 = negat.toString();
		String neutralPercentage2 = neutr.toString();
		String positivePercentage2 = positi.toString();

		String[][] matrizDraw = {
							{"CLASSIFICACAO", "PERCENTUAL", "GRAFICO"}, 
							{"Negativa", negativePercentage2, "   "+negativeStars},
							{"Neutra", neutralPercentage2, neutralStars},
							{"Positiva", positivePercentage2, "   "+positiveStars},
							{"Total", "100%", ""} 
		  				};

		String  retorno = "";
		for(int i=0; i<5; i++){
        	for(int j=0; j<3; j++){
            	retorno = retorno + String.format("%20s", matrizDraw[i][j]);
        	}
			retorno = retorno + "\n";
    }			  
		return retorno;

	}

	private String calculatePercentage(double obtained, double total) {
		Double getPercentage = obtained * 100 / total;
		String obtainedToString = Double.toString(getPercentage);
        return obtainedToString;
    }


    public void execute() throws IllegalStateException, IOException {


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
					if(read.ProcessCsv(caminho)){
						System.out.println("Sucesso ! / Success");
					}
					else System.out.println("Erro ! / Error");
					break;
					
			case 2: System.out.println("Por favor, digite o nome do medicamento:");
					System.out.println("Please, type the medication name:");
					in.nextLine();
					String nome = in.nextLine();
					System.out.println(searchMedicationName(nome.toUpperCase()));
					break;
					
			case 3: try{
						System.out.println("Por favor, digite o codigo de barras: ");
						System.out.println("Please, type the barcode: ");
						long barcode = in.nextLong();
						if(searchBarcode(barcode).isEmpty()){
							System.out.println("Nenhum registro encontrado");
							System.out.println("No record found ");
						} else System.out.println(searchBarcode(barcode));
						break;
				} catch (InputMismatchException entradaInvalidaNumero) {
					System.err.println("Não é permitido inserir letras, informe apenas números inteiros!");
					System.err.println("Letters not allowed, please use only whole numbers");
					in.nextLine(); //descarta a entrada
					break;
				}
				
			case 4: System.out.println(taxConcessionComparative());
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
