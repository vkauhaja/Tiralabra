/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaatiot;

import matriisilaskineimaven.operaatiot.Transpoosi;
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
public class TranspoosiTest {
    
    public TranspoosiTest() {
    }
    Transpoosi transpoosi;
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        double[][] A = new double[100][300];
        
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 300; j++) {
                A[i][j] = i+j*2;
                
            }
        }
        transpoosi = new Transpoosi(A, 100, 300);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void transpoosiToimii(){
        boolean lol = true;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 300; j++) {
                if(transpoosi.getC()[j][i] != i+j*2 ){
                    lol = false;
                }
            }
        }
        assertTrue(lol);
    }
}
