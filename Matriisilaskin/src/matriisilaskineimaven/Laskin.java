/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriisilaskineimaven;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import lukeminen.Kasinsyotto;
import lukeminen.Tiedostoluku;
import matriisilaskineimaven.operaatiot.Determinantti;
import matriisilaskineimaven.operaatiot.Kofaktorimatriisi;
import matriisilaskineimaven.operaatiot.Skalaarillakertominen;
import matriisilaskineimaven.operaatiot.Summa;
import matriisilaskineimaven.operaatiot.Transpoosi;
import matriisilaskineimaven.operaatiot.TuloNaiivi;
import matriisilaskineimaven.operaatiot.TuloStrassen;
import matriisilaskineimaven.operaatiot.Vahennys;

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
     * @param operaatio halutun operaation määrittely, määrittelyyn käytetään inttiä kuten kaikkiin muihinkin tietoihin
     * @param syotto kuinka syötetään matriisi (käsin, tiedostosta, arvotaan)
     * @param maara käsiteltävien matriisien määrä
     * @param lukija
     * @param i 1. matriisin rivit
     * @param j 1. matriisin sarakkeet
     * @param k 2. matriisin rivit
     * @param l 2. matriisin sarakkeet
     */
    public Laskin(int operaatio, int syotto, int maara, Scanner lukija, int i, int j,int k,int l, double s) throws IOException{
        
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
   
    private void lue() throws IOException{
        if(this.syotto == 0){
            Kasinsyotto kasinsyotto = new Kasinsyotto(lukija, this.i, this.j);
            this.A = kasinsyotto.getC();
            if(this.maara == 2){
                Kasinsyotto kasinsyotto2 = new Kasinsyotto(lukija, this.k, this.l);
                this.B = kasinsyotto2.getC();
            }
        } else if(this.syotto == 2) { // Testimatriisit kiva luoda esim. kun testaa algoritmien viemää aikaa.
            Random rand = new Random();
            for (int m = 0; m < this.i; m++) {
                for (int n = 0; n < this.j; n++) {
                    this.A[m][n] = rand.nextInt(10) - 5;
                }
            }
            
           
            for (int m = 0; m < this.k; m++) {
                for (int n = 0; n < this.l; n++) {
                    this.B[m][n] = rand.nextInt(10) - 5;
                }
            }
        } else {
            Tiedostoluku tiedostoluku = new Tiedostoluku(lukija, this.i, this.j);
            this.A = tiedostoluku.getC();
            if(this.maara == 2){
                Tiedostoluku tiedostoluku2 = new Tiedostoluku(lukija, this.k, this.l);
                this.B = tiedostoluku2.getC();
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
            System.out.println("Transpoosin laskeminen vei aikaa " + transpoosi.getDur() + " millisekuntia.");
        }
        //Determinantti
        if(o == 4){
            System.out.println("");
            Determinantti determinantti = new Determinantti(this.A, this.i);
            tulosta(A, this.i, this.i);
            System.out.print("Matriisin determinantti on ");
            System.out.println(determinantti.getd());
            System.out.println("Determinantin laskeminen vei aikaa " + determinantti.getDur() + " millisekuntia.");
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
                long dur = kofaktorimatriisi.getDur() + transpoosi.getDur() + skalaarillakertominen.getDur();
                System.out.println("Käänteismatriisin laskeminen vei aikaa " + dur + " millisekuntia.");
            }
        }
        //Kofaktorointi
        if(o == 6){
            System.out.println("");
            Kofaktorimatriisi kofaktorimatriisi = new Kofaktorimatriisi(this.A, this.i);
            tulosta(A, this.i, this.i);
            System.out.println("Matriisin kofaktorimatriisi on ");
            tulosta(kofaktorimatriisi.getC(), this.i, this.i);
            System.out.println("Kofaktorointi vei aikaa " + kofaktorimatriisi.getDur() + " millisekuntia.");
        }
        // Skalaarilla kertominen
        if(o == 7){
            System.out.println("");
            Skalaarillakertominen skalaarillakertominen = new Skalaarillakertominen(this.A, this.i, this.j, this.s);
            tulosta(A, this.i, this.i);
            System.out.println("kerrottuna vakiolla " + this.s);
            tulosta(skalaarillakertominen.getC(), this.i, this.j);
            System.out.println("Skalaarilla kertominen vei aikaa " + skalaarillakertominen.getDur() + " millisekuntia.");
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
            System.out.println("Summan laskeminen vei aikaa " + summa.getDur() + " millisekuntia.");
        }
        if(o == 8){
            System.out.println("");
            Vahennys vahennys = new Vahennys(this.A, this.B, this.i, this.j);
            tulosta(A, this.i, this.j);
            System.out.println(" + ");
            tulosta(B, this.i, this.j);
            System.out.println(" = ");
            tulosta(vahennys.getC(), this.i, this.j);
            System.out.println("Summan laskeminen vei aikaa " + vahennys.getDur() + " millisekuntia.");
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
            System.out.println("Tulon laskeminen vei aikaa " + tuloNaiivi.getDur() + " millisekuntia.");
            
        }
        //Neliömatriisien tulo, voi käyttää Strassenia
        if( o == 9){
            System.out.println("");
            TuloNaiivi tuloNaiivi = new TuloNaiivi(this.A, this.B, this.i, this.i, this.i);
            TuloStrassen tuloStrassen = new TuloStrassen(this.A, this.B, this.i);
            tulosta(A, this.i, this.i);
            System.out.println("*");
            tulosta(B, this.i, this.i);
            System.out.println("=");
            tulosta(tuloStrassen.getC(), this.i, this.i);
            System.out.println("Tulon laskeminen vei aikaa Strassenin algoritmilla " + tuloStrassen.getDur() + " millisekuntia.");
            System.out.println("");
            //tulosta(tuloNaiivi.getC(), this.i, this.l);
            //Vertailun vuoksi kauanko aikaa vei naiivi tapa. Lopuksi varmistetaan, että samat tulokset molemmilla algoritmeilla.
            System.out.println("Tulon laskeminen vei aikaa naiivilla algoritmilla " + tuloNaiivi.getDur() + " millisekuntia.");
            System.out.println(tarkistaTulo(tuloStrassen.getC() , tuloNaiivi.getC(), this.i)); // True jos sama tulos molemmista --> tod näk molemmat oikein.
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
    
    // Metodi Strassenin algoritmin oikeellisuuden testaamiseksi.
    private boolean tarkistaTulo(double[][] A, double[][] B, int i){
        for (int m = 0; m < i; m++) {
            for (int n = 0; n < i; n++) {
                if(A[m][n] !=B[m][n]){
                    return false;
                }
            }
        }
        return true;
    }
}

