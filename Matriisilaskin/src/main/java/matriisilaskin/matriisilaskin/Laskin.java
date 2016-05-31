/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriisilaskin.matriisilaskin;

import java.util.Scanner;
import operaatiot.Determinantti;

import operaatiot.Kofaktorimatriisi;
import operaatiot.Skalaarillakertominen;
import operaatiot.Summa;
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
    private double s;
    
    private double[][] A;
    private double[][] B;
    
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
    public Laskin(int operaatio, int syotto, int maara, Scanner lukija, int i, int j,int k,int l, double s){
        this.operaatio = operaatio;
        this.syotto = syotto;
        this.lukija = lukija;
        this.maara = maara;
        this.i=i;
        this.j=j;
        this.k=k;
        this.l=l;
        this.s=s;
        this.A = new double[i][j];
        this.B = new double[k][l];
        lue();
        if(this.maara == 1){
            suoritayksi(this.A, this.i, this.j, this.operaatio);
        }
        if(this.maara == 2){
            suoritakaksi(this.A, this.B, this.i, this.j, this.k, this.l, this.operaatio);
        }
        
        
    }
    // Toistaiseksi lukuominaisuudet eivät toimi, joten luon tässä testimatriisit.
    private void lue(){
        for (int m = 0; m < this.i; m++) {
            for (int n = 0; n < this.j; n++) {
                this.A[m][n] = 2+4*m-7*n;
            }
        }
        this.A[0][0] = 4; //Testikamaa
        this.A[0][1] = 3;
        this.A[1][0] = 3;
        this.A[1][1] = 2;
        for (int m = 0; m < this.k; m++) {
            for (int n = 0; n < this.l; n++) {
                this.B[m][n] = -5-2*m+7*n;
            }
        }
        
    }
    //Metodi yhtä matriisia edellyttäviä operaatioita varten. Haluttu luokka on määritelty operaatio-arvolla (o).
    private void suoritayksi(double[][] A, int i, int j, int o){
        if(o == 1){
            //Tulostukset tulevat olemaan yksilöllisiä joka operaatiota ajatellen. 
            Transpoosi transpoosi = new Transpoosi(this.A, this.i, this.j);
            tulosta(A, this.i, this.j);
            System.out.println("transponoituna");
            tulosta(transpoosi.getC(), this.j, this.i);
        }
        
        if(o == 4){
            
            Determinantti determinantti = new Determinantti(this.A, this.i);
            tulosta(A, this.i, this.i);
            System.out.print("Matriisin determinantti on ");
            System.out.println(determinantti.getd());
        }
        if(o == 5){
           
            Determinantti determinantti = new Determinantti(this.A, this.i);
            if(determinantti.getd() == 0){
                System.out.println("Matriisin determinantti on 0, eli se ei ole kääntyvä eikä sille ole käänteismatriisia.");
            } else {
                // Sen voi tehdä näinkin. Törmäsin kaavaan jossain. Uskoakseni helpoin keino toteuttaa tämä ohjelmoiden.
                Kofaktorimatriisi kofaktorimatriisi = new Kofaktorimatriisi(this.A, this.i);
                Transpoosi transpoosi = new Transpoosi(kofaktorimatriisi.getC(), this.i, this.i);
                Skalaarillakertominen skalaarillakertominen = new Skalaarillakertominen(transpoosi.getC(), this.i, this.i, (1 / determinantti.getd()));
                tulosta(this.A, this.i, this.i);
                System.out.println("käänteismatriisi on");
                tulosta(skalaarillakertominen.getC(), this.i, this.i);
            }
        }
        if(o == 6){
            Kofaktorimatriisi kofaktorimatriisi = new Kofaktorimatriisi(this.A, this.i);
            tulosta(A, this.i, this.i);
            System.out.println("Matriisin kofaktorimatriisi on ");
            tulosta(kofaktorimatriisi.getC(), this.i, this.i);
        }
        if(o == 7){
            Skalaarillakertominen skalaarillakertominen = new Skalaarillakertominen(this.A, this.i, this.j, this.s);
            tulosta(A, this.i, this.i);
            System.out.println("kerrottuna vakiolla " + this.s);
            tulosta(skalaarillakertominen.getC(), this.i, this.j);
        }
    }
    //Metodi kahta matriisia edellyttäviä operaatioita varten
    private void suoritakaksi(double[][] A, double[][] B, int i, int j, int k ,int l,int o){
        if(o == 2){
            Summa summa = new Summa(this.A, this.B, this.i, this.j);
            tulosta(A, this.i, this.j);
            System.out.println(" + ");
            tulosta(B, this.i, this.j);
            System.out.println(" = ");
            tulosta(summa.getC(), this.i, this.j);
        }
    }
    // Huomaa, että tuloksena olevan matriisin koko on aina ennalta määritelty (jokaisessa tapauksessa), joten tulostusmetodiin voi antaa ennalta tulostettavan matriisin koon.
    private void tulosta(double[][] C, int i, int j){
        
        for (int m = 0; m < i; m++) {
            for (int n = 0; n < j; n++) {
                System.out.print(C[m][n] + "  ");
            }
            System.out.println("");
        }
    }
}
