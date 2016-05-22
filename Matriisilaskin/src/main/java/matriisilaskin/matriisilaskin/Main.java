/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriisilaskin.matriisilaskin;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Vesa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner lukija = new Scanner(System.in);
        
        int[][] A = new int[3][3]; // Testausmatriiseja
        int[][] B = new int[3][3];
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                A[i][j] = (i-1)*(j+2);
            }
        }
        
        System.out.println("");
        System.out.println(Arrays.deepToString(A));
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
    
}
