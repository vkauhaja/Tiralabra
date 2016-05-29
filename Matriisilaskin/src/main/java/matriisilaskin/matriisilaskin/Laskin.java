/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriisilaskin.matriisilaskin;

import java.util.Scanner;
import operaatiot.Transpoosi;

/**
 *
 * @author Vesa
 */
public class Laskin {
    private Scanner lukija;
    private int operaatio;
    private int syotto;
    private int maara;
    
    private int i;
    private int j;
    private int k;
    private int l;
    
    private int[][] A;
    private int[][] B;
    
    /**
     *
     * @param operaatio
     * @param syotto
     * @param maara
     * @param lukija
     * @param i
     * @param j
     * @param k
     * @param l
     */
    public Laskin(int operaatio, int syotto, int maara, Scanner lukija, int i, int j,int k,int l){
        this.operaatio = operaatio;
        this.syotto = syotto;
        this.lukija = lukija;
        this.maara = maara;
        this.i=i;
        this.j=j;
        this.k=k;
        this.l=l;
        this.A = new int[i][j];
        this.B = new int[k][l];
        lue();
        if(this.maara == 1){
            suoritayksi(this.A, this.i, this.j, this.operaatio);
        }
        if(this.maara == 2){
            //suoritakaksi();
        }
        Transpoosi transpoosi = new Transpoosi(this.A, this.i, this.j);
        
    }
    // Toistaiseksi lukuominaisuudet eivät toimi, joten luon tässä testimatriisit.
    private void lue(){
        for (int m = 0; m < i; m++) {
            for (int n = 0; n < j; n++) {
                this.A[m][n] = 2+4*m-7*n;
            }
        }
        for (int m = 0; m < i; m++) {
            for (int n = 0; n < j; n++) {
                this.B[m][n] = -5-2*m+7*n;
            }
        }
        
    }
    //Metodi yhtä matriisia edellyttäviä operaatioita varten
    private void suoritayksi(int[][] A, int i, int j, int o){
        if(o == 1){
            Transpoosi transpoosi = new Transpoosi(this.A, this.i, this.j);
            tulosta(A, this.i, this.j);
            System.out.println("transponoituna");
            tulosta(transpoosi.getC(), this.j, this.i);
        }
    }
    //Metodi kahta matriisia edellyttäviä operaatioita varten
    private void suoritakaksi(int[][] A, int[][] B, int i, int j, int o){
        
    }
    // Huomaa, että tuloksena olevan matriisin koko on aina ennalta määritelty, joten tulostusmetodiin voi antaa ennalta tulostettavan matriisin koon.
    private void tulosta(int[][] C, int i, int j){
        
        for (int m = 0; m < i; m++) {
            for (int n = 0; n < j; n++) {
                System.out.print(C[m][n] + " ");
            }
            System.out.println("");
        }
    }
}
