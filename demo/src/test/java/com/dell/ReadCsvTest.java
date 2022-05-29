package com.dell;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;


public class ReadCsvTest 
{
    
    ReadCsv read = null;
   

    @Before
    public void setUp(){
        read = new ReadCsv();
    }

    @Test
    public void testProcessCsvWithExistingFile() throws NoSuchFileException, FileNotFoundException
    {
        assertTrue( read.ProcessCsv("C:\\Users\\arthu\\OneDrive\\Documents\\medc\\TA_PRECO_MEDICAMENTO.csv") );
    }

    

    @Test
    public void checkMedicationListItem55() throws NoSuchFileException, FileNotFoundException
    {
        read.ProcessCsv("C:\\Users\\arthu\\OneDrive\\Documents\\medc\\TA_PRECO_MEDICAMENTO.csv");
        ArrayList<Medications> spy = new ArrayList<>();
        ArrayList<Medications> spyedList = Mockito.spy(read.returnMedicationList());
        String expected = "EZETIMIBA;45.987.013/0001-34;ORGANON FARMACÊUTICA LTDA.;525500901111216;1002900760011;7897337701549;    -     ;    -     ;EZETROL;10 MG COM CT BL AL PLAS TRANS X 10 ;C10A9 - TODOS OUTROS REGULADORES DE COLESTEROL E TRIGLICERÍDEOS;Novo;Regulado;36,74;36,74;41,75;44,27;44,27;44,53;44,53;44,80;44,80;45,93;50,79;57,72;61,20;61,20;61,56;61,56;61,93;61,93;63,50;Não;Não;Não;Não;;Positiva;Não;Tarja  Vermelha";
        doReturn(expected).when(spy).get(55);
    }

    
}
