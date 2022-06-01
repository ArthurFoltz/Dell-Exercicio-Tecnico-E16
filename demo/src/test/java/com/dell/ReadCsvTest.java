package com.dell;

import static org.junit.Assert.assertTrue;
import java.io.FileNotFoundException;
import java.nio.file.NoSuchFileException;
import org.junit.Before;
import org.junit.Test;



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
