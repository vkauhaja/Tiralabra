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
 * Eli käsinsyöttöluokka. Tämä lukee käyttäjän antamat arvot 1 kerrallaan ja sijoittaa ne matriisiin. Riveittäin, eli ensinrivi 1, sitten rivi 2. 
 */
public class Kasinsyotto {
    
    private Scanner lukija;
    private int i;
    private int j;
    
    private double[][] C;
    
    /**
     *
     * @param lukija
     * @param i Matriisin, jota muodostetaan, korkeus
     * @param j ja leveys
     */
    public Kasinsyotto(Scanner lukija, int i, int j){
        this.lukija = lukija;
        this.i = i;
        this.j = j;
        
        this.C = syota(this.i, this.j);
    }

    /**
     *
     * @param i
     * @param j
     * @return Arvot käydään yksitellen läpi. Melko selvää että tämän tehokkaammin tätä ei voi toteuttaa.
     */
    public double[][] syota(int i, int j){
        double[][] C = new double[i][j];
        System.out.println("Syotä matriisin arvot rivi kerrallaan.");
        for (int k = 0; k < i; k++) {
            for (int l = 0; l < j; l++) {
                
                C[k][l] = Double.parseDouble(lukija.nextLine());
            }
        }
        return C;
    }
    
    /**
     *
     * @return
     * Palautusmetodi tuttuun tyyliin.
     */
    public double[][] getC(){
        return C;
    }
}
