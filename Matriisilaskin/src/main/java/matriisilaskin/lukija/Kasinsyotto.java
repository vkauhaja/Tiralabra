/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriisilaskin.lukija;

import java.util.Scanner;

/**
 *
 * @author Vesa
 */
public class Kasinsyotto {
    
    private Scanner lukija;
    private int m;
    private int n;
    
    public Kasinsyotto(Scanner lukija){
        System.out.println("Minkä kokoisen matriisin haluat syöttää? Anna ensin rivien määrä.");
        m = Integer.parseInt(lukija.nextLine());
        System.out.println("Sarakkeiden määrä?");
        n = Integer.parseInt(lukija.nextLine());
        
        int[][] A = new int[m][n];
    }
}
