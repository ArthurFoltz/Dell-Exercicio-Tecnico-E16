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

    
}
