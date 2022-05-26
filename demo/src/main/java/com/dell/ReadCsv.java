package com.dell;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ReadCsv {
    
    private ArrayList<Medications> medicationsList = new ArrayList<>();

    public ArrayList<Medications> ProcessCsv(String path){

        Path pathToFile = Paths.get(path);
			try(BufferedReader br = Files.newBufferedReader(pathToFile,StandardCharsets.ISO_8859_1)){
				String row = br.readLine();
				while(row!=null) {
					String [] atributos = row.split(";");
					Medications medicine = getMedicine(atributos);
					medicationsList.add(medicine);
					row = br.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		
		
		return medicationsList;
        
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
        String pmcZero = atributos[23];
        String restricaoHospitalar = atributos[32];
        String cap = atributos[33];
        String confaz87 = atributos[34];
        String icms0 = atributos[35];
        String analiseRecursal = atributos[36];
        String listaConcessaoCreditoTributario = atributos[37];
        String comercializacao2020 = atributos[38];
        String tarja = atributos[39];


        
        Medications medicine = new Medications(substancia, cnpj, laboratorio, codigoGgrem, registro, ean1, ean2, ean3, produto, apresentacao, classeTerapeutica, tipoProduto, regimePreco, pfSemImposto, pmcZero, restricaoHospitalar, cap, confaz87, icms0, analiseRecursal, listaConcessaoCreditoTributario, comercializacao2020, tarja);
        
        return medicine;
    }

    public ArrayList<Medications> returnMedicationList(){
        return medicationsList;
    }
}
