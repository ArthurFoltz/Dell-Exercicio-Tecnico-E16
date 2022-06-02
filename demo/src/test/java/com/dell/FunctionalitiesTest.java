package com.dell;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.nio.file.NoSuchFileException;
import org.junit.Before;
import org.junit.Test;

public class FunctionalitiesTest {

    
    Functionalities func;

    @Before
    public void setUp() throws NoSuchFileException, FileNotFoundException{
        func = new Functionalities();
        func.csvToBeRead();
    }

    @Test
    public void searchMedicationNameRightTest(){
        Medications tempMed = new Medications("BENZOATO DE RIZATRIPTANA","45.987.013/0001-34","ORGANON FARMACÊUTICA LTDA.","525501401110219","1002900140064","7897337702089","   -     ","    -     ","MAXALT","10 MG COM CT BL AL AL X 2","N2C1 - ANTIENXAQUECOSOS TRIPTÂNICOS","Novo","Regulado","18,02","18,02","20,48","21,71","21,71","21,84","21,84","21,98","21,98","22,53","24,91","28,31","30,01","30,01","30,19","30,19","30,39","30,39","31,15","Não","Não","Não","Não","","Positiva","Sim","Tarja Vermelha(*)");
        String geraDescricao = tempMed.returnMedicineBasicInfo();
        String tempStringGot = func.searchMedicationName("LOSARTA").toString();
        
        assertEquals(geraDescricao, tempStringGot);
    }
}
