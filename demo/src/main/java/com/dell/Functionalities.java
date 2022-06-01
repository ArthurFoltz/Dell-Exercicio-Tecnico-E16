package com.dell;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * [PT-BR]Esta classe realiza as funcoes requeridas pelo exercicio tecnico dell edicao 16
 * [ENG]This class realizes the functions required by the 16th dell technical exam
 * @author Arthur Mariano Foltz Barroso
 * @version 1.0
 */

public class Functionalities {
    
    ReadCsv read = new ReadCsv();

	/** 
	 *[PT-BR]Procura na lista um ou mais medicamentos pelo nome(ou parte dele) especificado pelo usuario
	 *[ENG]Search for medications with the same name(or part of it) especified by the user
	 * @see ReadCsv Classe que faz a leitura do CSV e cria a lista de medicamentos // Class that reads the CSV file and creates the medication list
	 * @param name para o nome do medicamento / for the medication name
	 * @return {@code ArrayList} - uma lista com os medicamentos encontrados / a list with the found medications
	*/
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

	/**
	 * [PT-BR]Procura na lista um medicamento pelo codigo de barras especificado pelo usuario
	 * e o seu atributo "produto" entao localiza todos os medicamentos do mesmo produto, tambem
	 * calcula o maior e menor atributo pmc 0% e a sua diferenca
	 * [ENG]Search for a medication with the same barcode especified by the user and its "product"
	 * attribute, then find all the medications wich are the same product, also calculate the highest
	 * and lowest pmc 0% attribute and its diference
	 * @param barcode para o codigo de barras do medicamento / for the barcode of the medication
	 * @return {@code String} - dos medicamento encontrados / Of found medication
	 */
	public String searchBarcode(Long barcode){

		String barcodeToString = Long.toString(barcode);
		String medicationProductType = "";
		ArrayList<Medications> matchBarcode = new ArrayList<>();

		for (int i = 0; i < read.returnMedicationList().size(); i++) {
			if (read.returnMedicationList().get(i).getEan1().equals(barcodeToString) || read.returnMedicationList().get(i).getEan2().equals(barcodeToString) || read.returnMedicationList().get(i).getEan3().equals(barcodeToString)){
				medicationProductType = read.returnMedicationList().get(i).getProduto();
				break;
			}
		}
		for (int i = 0; i < read.returnMedicationList().size(); i++) {
			if (read.returnMedicationList().get(i).getProduto().equals(medicationProductType)){
				matchBarcode.add(read.returnMedicationList().get(i));
			}
		}
		if(matchBarcode.isEmpty()){
			return ("Nenhum registro encontrado / No record found ");
		}
		//Expressao lambda / lambda expression
		matchBarcode.forEach(med -> med.setPmc0(med.getPmc0().replace(",",".")));
		Collections.sort(matchBarcode);

		// Pega a descricao dos medicamentos com o maior e menor pmc 0%
		// Get the description of the highest and lower pmc 0% medications
		String lowerPmc0Medication = matchBarcode.get(0).toString();
		String higherPmc0Medication = matchBarcode.get(matchBarcode.size()-1).toString();

		// Pega somente o numero do pmc 0% para poder fazer o calculo da diferenca
		// Get only the pmc 0% number to calculate the diference
		String onlyLowerPmc = matchBarcode.get(0).getPmc0().toString();
		String onlyHigherPmc0 = matchBarcode.get(matchBarcode.size()-1).getPmc0().toString();

		Double diference = Double.parseDouble(onlyHigherPmc0) - Double.parseDouble(onlyLowerPmc);

		String r3 = "<<<<<<<<<<<<";
		String r1 = ("Menor pmc/Lower pmc: " + lowerPmc0Medication + "\nMaior pmc/Higher pmc: " + higherPmc0Medication + "\nDiferenca/Diference: " + diference);
		String r2 = ("Produtos encontrados/Found products: ") + r3;
		String retorno = r1 + "\n" + r2 + "\n" + matchBarcode;
		return retorno;
	}

	/**
	 * [PT-BR] Pega os medicamento que foram comercializados em 2020 e consulta o atributo 
	 * "listaConcessaoCreditoTributario" e determina o percentual de medicamentos classificados como "Negativa",
	 * "Neutra" ou "Positiva"
	 * [ENG] Get the medications which was commercialized in 2020 and checks the attribute "listaConcessaoCreditoTributario"
	 * and determine the percentage of the medications classified as "Negativa", "Neutra" ou "Positiva"
	 * @return {@code String} da tabela dos percentuais / Percentage chart
	 */
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
		String star = "*";

		for(int i = 0; i < Double.parseDouble(negativePercentage); i++){
			negativeStars = star + negativeStars;
		}
		for(int i = 0; i < Double.parseDouble(positivePercentage); i++){
			positiveStars = star + positiveStars;
		}
		for(int i = 0; i < Double.parseDouble(neutralPercentage); i++){
			neutralStars = star + neutralStars;
		}

		// Arredonda a porcentagem para duas casas apos a virgula / Format the decimal places to two
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

	/**
	 * [PT-BR] Calcula a porcentagem
	 * [ENG] Calculates de percentage
	 * @param obtained O numero base para realizar o calculo / the base number to realize the math
	 * @param total O numero total de itens (100%) / the total number of itens (100%)
	 * @return {@code String} - Da porcentagem calculada / Of found percentage
	 */
	private String calculatePercentage(double obtained, double total) {
		Double getPercentage = obtained * 100 / total;
		String obtainedToString = Double.toString(getPercentage);
        return obtainedToString;
    }

	/**
	 * [PT-BR] Recebe o caminho do arquivo csv para ser lido
	 * [ENG] Receives the path for the csv file to be read
	 * @param pathToFile O caminho do arquivo csv / the csv file path
	 * @return {@code boolean} - True se leu com sucesso, false se nao / True if read witch sucess, false if not
	 * @throws NoSuchFileException
	 * @throws FileNotFoundException
	 */
	public boolean csvToBeRead() throws NoSuchFileException, FileNotFoundException{
		boolean readOrNot;
		readOrNot = read.ProcessCsv();
		return readOrNot;
	}

}
