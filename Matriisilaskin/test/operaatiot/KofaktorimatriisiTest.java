/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaatiot;

import matriisilaskineimaven.operaatiot.Kofaktorimatriisi;
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
public class KofaktorimatriisiTest {
    
    public KofaktorimatriisiTest() {
    }
    Kofaktorimatriisi kofaktorimatriisi;
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        double[][] A = new double[3][3];
        A[0][0] = 1;
        A[0][1] = 2;
        A[0][2] = 3;
        A[1][0] = 0;
        A[1][1] = 4;
        A[1][2] = 5;
        A[2][0] = 1;
        A[2][1] = 0;
        A[2][2] = 6;
        kofaktorimatriisi = new Kofaktorimatriisi(A, 3);         
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void kofaktoriToimii(){
        boolean lol = true;
        if(kofaktorimatriisi.getC()[0][0] != 24){
            lol = false;
        }
        if(kofaktorimatriisi.getC()[0][1] != 5){
            lol = false;
        }
        if(kofaktorimatriisi.getC()[0][2] != -4){
            lol = false;
        }
        if(kofaktorimatriisi.getC()[1][0] != -12){
            lol = false;
        }
        if(kofaktorimatriisi.getC()[1][1] != 3){
            lol = false;
        }
        if(kofaktorimatriisi.getC()[1][2] != 2){
            lol = false;
        }
        if(kofaktorimatriisi.getC()[2][0] != -2){
            lol = false;
        }
        if(kofaktorimatriisi.getC()[2][1] != -5){
            lol = false;
        }
        if(kofaktorimatriisi.getC()[2][2] != 4){
            lol = false;
        }
        assertTrue(lol);
    }
}
