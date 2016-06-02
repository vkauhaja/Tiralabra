/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriisilaskin.matriisilaskin;

import java.util.Scanner;
import matriisilaskin.lukija.Kasinsyotto;
import operaatiot.Determinantti;

import operaatiot.Kofaktorimatriisi;
import operaatiot.Skalaarillakertominen;
import operaatiot.Summa;
import operaatiot.Transpoosi;
import operaatiot.TuloNaiivi;
import operaatiot.TuloStrassen;

/**
 *
 * @author Vesa
 * Eli tällä luokalla kutsutaan haluttua operaatiota. Luokka saa operaatio-määritelmän inttinä.
 * Laskin suorittaa joko 1- tai 2-matriisin suoritusoperaatiolla halutun operaation.
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
     * @param operaatio halutun operaation määrittely
     * @param syotto kuinka syötetään matriisi (käsin, tiedostosta)
     * @param maara käsiteltävien matriisien määrä
     * @param lukija
     * @param i 1. matriisin rivit
     * @param j 1. matriisin sarakkeet
     * @param k 2. matriisin rivit
     * @param l 2. matriisin sarakkeet
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
        //Yhdelläkin suorita-metodilla olisi varmasti pärjännyt, mutta koodin hallinta oli mielestäni helpompaa näin.
        if(this.maara == 1){
            suoritayksi(this.A, this.i, this.j, this.operaatio);
        }
        if(this.maara == 2){
            suoritakaksi(this.A, this.B, this.i, this.j, this.k, this.l, this.operaatio);
        }
        
        
    }
    // Toistaiseksi lukuominaisuudet eivät toimi, joten luon tässä testimatriisit.
    private void lue(){
        if(this.syotto == 0){
            Kasinsyotto kasinsyotto = new Kasinsyotto(lukija, this.i, this.j);
            this.A = kasinsyotto.getC();
            if(this.maara == 2){
                Kasinsyotto kasinsyotto2 = new Kasinsyotto(lukija, this.k, this.l);
                this.B = kasinsyotto2.getC();
            }
        } else { // Eipähän bugaa jos haluaa tiedostosta lukea.
            for (int m = 0; m < this.i; m++) {
                for (int n = 0; n < this.j; n++) {
                    this.A[m][n] = 1+m-n;
                }
            }
            
           
            for (int m = 0; m < this.k; m++) {
                for (int n = 0; n < this.l; n++) {
                    this.B[m][n] = -5+m-3*n;
                }
            }
        }
        
       
       
        
    }
    //Metodi yhtä matriisia edellyttäviä operaatioita varten. Haluttu luokka on määritelty operaatio-arvolla (o).
    private void suoritayksi(double[][] A, int i, int j, int o){
        if(o == 1){
            //Transpoosi
            //Tulostukset tulevat olemaan yksilöllisiä joka operaatiota ajatellen. Niitä voi muokata siistimmiksikin.
            System.out.println("");
            Transpoosi transpoosi = new Transpoosi(this.A, this.i, this.j);
            tulosta(A, this.i, this.j);
            System.out.println("transponoituna");
            tulosta(transpoosi.getC(), this.j, this.i);
        }
        //Determinantti
        if(o == 4){
            System.out.println("");
            Determinantti determinantti = new Determinantti(this.A, this.i);
            tulosta(A, this.i, this.i);
            System.out.print("Matriisin determinantti on ");
            System.out.println(determinantti.getd());
        }
        //Käänteismatriisi
        if(o == 5){
            System.out.println("");
            Determinantti determinantti = new Determinantti(this.A, this.i);
            if(determinantti.getd() == 0){
                System.out.println("Matriisin determinantti on 0, eli se ei ole kääntyvä eikä sille ole käänteismatriisia.");
            } else {
                // Sen voi tehdä näinkin. Törmäsin kaavaan jossain. Uskoakseni helpoin keino toteuttaa tämä ohjelmoiden. Erillistä käänteismatriisi-luokkaa ei siis tarvita.
                Kofaktorimatriisi kofaktorimatriisi = new Kofaktorimatriisi(this.A, this.i);
                Transpoosi transpoosi = new Transpoosi(kofaktorimatriisi.getC(), this.i, this.i);
                Skalaarillakertominen skalaarillakertominen = new Skalaarillakertominen(transpoosi.getC(), this.i, this.i, (1 / determinantti.getd()));
                tulosta(this.A, this.i, this.i);
                System.out.println("käänteismatriisi on");
                tulosta(skalaarillakertominen.getC(), this.i, this.i);
            }
        }
        //Kofaktorointi
        if(o == 6){
            System.out.println("");
            Kofaktorimatriisi kofaktorimatriisi = new Kofaktorimatriisi(this.A, this.i);
            tulosta(A, this.i, this.i);
            System.out.println("Matriisin kofaktorimatriisi on ");
            tulosta(kofaktorimatriisi.getC(), this.i, this.i);
        }
        // Skalaarilla kertominen
        if(o == 7){
            System.out.println("");
            Skalaarillakertominen skalaarillakertominen = new Skalaarillakertominen(this.A, this.i, this.j, this.s);
            tulosta(A, this.i, this.i);
            System.out.println("kerrottuna vakiolla " + this.s);
            tulosta(skalaarillakertominen.getC(), this.i, this.j);
        }
    }
    //Metodi kahta matriisia edellyttäviä operaatioita varten
    private void suoritakaksi(double[][] A, double[][] B, int i, int j, int k ,int l,int o){
        // Summa
        if(o == 2){
            System.out.println("");
            Summa summa = new Summa(this.A, this.B, this.i, this.j);
            tulosta(A, this.i, this.j);
            System.out.println(" + ");
            tulosta(B, this.i, this.j);
            System.out.println(" = ");
            tulosta(summa.getC(), this.i, this.j);
        }
        // Tulo, jos kyseessä ei ole kaksi samankokoista neliömatriisia
        if(o == 3){
            System.out.println("");
            TuloNaiivi tuloNaiivi = new TuloNaiivi(this.A, this.B, this.i, this.j, this.l);
            tulosta(A, this.i, this.j);
            System.out.println("*");
            tulosta(B, this.k, this.l);
            System.out.println("=");
            tulosta(tuloNaiivi.getC(), this.i, this.l);
            
            
        }
        //Neliömatriisien tulo, voi käyttää Strassenia
        if( o == 8){
            System.out.println("");
            TuloNaiivi tuloNaiivi = new TuloNaiivi(this.A, this.B, this.i, this.i, this.i);
            TuloStrassen tuloStrassen = new TuloStrassen(this.A, this.B, this.i);
            tulosta(A, this.i, this.j);
            System.out.println("*");
            tulosta(B, this.k, this.l);
            System.out.println("=");
            tulosta(tuloStrassen.getC(), this.i, this.l);
            System.out.println("");
            tulosta(tuloNaiivi.getC(), this.i, this.l);
        }
    }
    // Huomaa, että tuloksena olevan matriisin koko on aina ennalta määritelty (jokaisessa tapauksessa), joten tulostusmetodiin voi antaa ennalta tulostettavan matriisin koon.
    private void tulosta(double[][] C, int i, int j){
        
        for (int m = 0; m < i; m++) {
            for (int n = 0; n < j; n++) {
                System.out.print(C[m][n] + "\t");
            }
            System.out.println("");
        }
    }
}
