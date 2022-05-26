package com.dell;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Functionalities {
    
    ReadCsv read = new ReadCsv();

    public ArrayList<Medications> searchMedicationName(String name){

        ArrayList<Medications> matchNameList = new ArrayList<>();

        for (int i = 0; i < read.returnMedicationList().size(); i++) {
			if (read.returnMedicationList().get(i).getSubstancia().equals(name) || read.returnMedicationList().get(i).getSubstancia().contains(name)) { // verifica se o nome é igual ou se contem parte do mesmo
                matchNameList.add(read.returnMedicationList().get(i));
			}
		}
        return matchNameList;
    }


    public void execute() {


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
					
			case 2: try{
						System.out.println("Digite o ano ");
						int anoConsulta = in.nextInt();
						//if(consultaAno(anoConsulta) == null) {
							System.out.println("Nenhum bolsista encontrado no ano escolhido");
						//}else System.out.println(consultaAno(anoConsulta));
						break;
			} catch (InputMismatchException entradaInvalidaNumero) {
					System.err.println("Não é permitido inserir letras, informe apenas números inteiros!");
					in.nextLine(); //descarta a entrada
					break;
				}
					
			case 3: System.out.println("Digite o nome ");
					String nome1 = in.nextLine();
					String nome = in.nextLine();
					//System.out.println(consultaNome(nome.toUpperCase()));
					break;
					
			case 4: try{
						System.out.println("Digite o ano ");
						int anoMedia = in.nextInt();
						//System.out.println(consultaMediaValoresAnual(anoMedia));
						break;
				} catch (InputMismatchException entradaInvalidaNumero) {
					System.err.println("Não é permitido inserir letras, informe apenas números inteiros!");
					in.nextLine(); //descarta a entrada
					break;
				}
				
			case 5: //System.out.println(consultaValoresBolsa());
					break;
			
			case 6: System.out.println("Programa finalizado !");
					chose2 = 6;
					break;
			}
		}
	
	
 }
}
