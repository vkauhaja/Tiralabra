/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaatiot;

import matriisilaskineimaven.operaatiot.Determinantti;
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
public class DeterminanttiTest {
    
    public DeterminanttiTest() {
    }
    Determinantti determinantti;
    
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
        determinantti = new Determinantti(A, 3);
    }
    
    @After
    public void tearDown() {
    }

   @Test
   public void determinanttiToimii(){
       assertTrue(determinantti.getd() == 22);
   }
}
