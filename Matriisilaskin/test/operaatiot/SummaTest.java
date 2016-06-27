/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaatiot;

import matriisilaskineimaven.operaatiot.Summa;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vesa
 */
public class SummaTest {
    
    public SummaTest() {
    }
    Summa summa;
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        double[][] A = new double[3][3];
        double[][] B = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                A[i][j] = i+j*2;
                B[i][j] = i*5-3*j;
            }
        }
        summa = new Summa(A, B, 3, 3);
    }
    
    @After
    public void tearDown() {
    }

   
    @Test
    public void summaOikein(){
        boolean lol = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if((i+j*2) +(i*5-3*j) != summa.getC()[i][j] ){
                    lol = false;
                }
            }
        }
        assertTrue(lol);
    }
}
