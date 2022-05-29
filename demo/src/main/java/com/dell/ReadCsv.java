package com.dell;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class ReadCsv {
    
    private ArrayList<Medications> medicationsList = new ArrayList<>();

    public boolean ProcessCsv(String path) throws NoSuchFileException, FileNotFoundException{

        int cont = 0;
        Path pathToFile = Paths.get(path);
			try(BufferedReader br = Files.newBufferedReader(pathToFile,StandardCharsets.ISO_8859_1)){
				String row = br.readLine();
				while(row!=null) {
					String [] atributos = row.split(";(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
					Medications medicine = getMedicine(atributos);
					medicationsList.add(medicine);
					row = br.readLine();
                    cont++;
                    System.out.println(cont);
				}
			} catch (IOException FileNotFound) {
				System.err.println("Arquivo nao encontrado");
				System.err.println("File not found");
			}
		
		if(medicationsList.isEmpty()){
            return false;
        }
		
		return true;
        
    }

    private Medications getMedicine(String[] atributos) {
        String substancia = atributos[0];
        String cnpj = atributos[1];
        String laboratorio = atributos[2];
        String codigoGgrem = atributos[3];
        String registro = atributos[4];
        String ean1 = atributos[5];
        String ean2 = atributos[6];
        String ean3 = atributos[7];
        String produto = atributos[8];
        String apresentacao = atributos[9];
        String classeTerapeutica = atributos[10];
        String tipoProduto = atributos[11];
        String regimePreco = atributos[12];
        String pfSemImposto = atributos[13];
        String pf0 = atributos[14];
        String pf12 = atributos[15];
        String pf17 = atributos[16];
        String pf17Alc = atributos[17];
        String pf175 = atributos[18];
        String pf175Alc = atributos[19];
        String pf18 = atributos[20];
        String pf18Alc = atributos[21];
        String pf20 = atributos[22];
        String pmcZero = atributos[23];
        String pmc12 = atributos[24];
        String pmc17= atributos[25];
        String pmc17Alc= atributos[26];
        String pmc175 = atributos[27];
        String pmc175Alc = atributos[28];
        String pmc18 = atributos[29];
        String pmc18Alc = atributos[30];
        String pmc20 = atributos[31];
        String restricaoHospitalar = atributos[32];
        String cap = atributos[33];
        String confaz87 = atributos[34];
        String icms0 = atributos[35];
        String analiseRecursal = atributos[36];
        String listaConcessaoCreditoTributario = atributos[37];
        String comercializacao2020 = atributos[38];
        String tarja = atributos[39];


        
        Medications medicine = new Medications(substancia, cnpj, laboratorio, codigoGgrem, registro, ean1, ean2, ean3, produto, apresentacao, classeTerapeutica, tipoProduto, regimePreco, pfSemImposto, pf0, pf12, pf17, pf17Alc, pf175, pf175Alc, pf18, pf18Alc, pf20, pmcZero, pmc12, pmc17, pmc17Alc, pmc175, pmc175Alc, pmc18, pmc18Alc, pmc20, restricaoHospitalar, cap, confaz87, icms0, analiseRecursal, listaConcessaoCreditoTributario, comercializacao2020, tarja);
        
        return medicine;
    }

    public ArrayList<Medications> returnMedicationList(){
        return medicationsList;
    }

    
 }

