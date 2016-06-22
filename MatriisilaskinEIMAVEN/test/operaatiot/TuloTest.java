/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaatiot;

import matriisilaskineimaven.operaatiot.TuloNaiivi;
import matriisilaskineimaven.operaatiot.TuloStrassen;
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
public class TuloTest {
    
    public TuloTest() {
    }
    TuloNaiivi tuloNaiivi1;
    
    TuloStrassen tuloStrassen;
   
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        double[][] A = new double[10][10];
        double[][] B = new double[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                A[i][j] = i+j*2;
                B[i][j] = i*5-3*j;
            }
        }
        tuloNaiivi1 = new TuloNaiivi(A, B, 10, 10, 10);
        tuloStrassen = new TuloStrassen(A, B, 10);
        
        
        
        
        
                
        
    }
    
    @After
    public void tearDown() {
    }
    
    
    //Oletan, että ainakin toinen algoritmi toimii..
    @Test
    public void tuloOikein(){
        boolean lol = true;
        double x = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(tuloNaiivi1.getC()[i][j] != tuloStrassen.getC()[i][j]){
                    lol = false;
                }
            }
        }
        
        assertTrue(lol);
    }
   
}
