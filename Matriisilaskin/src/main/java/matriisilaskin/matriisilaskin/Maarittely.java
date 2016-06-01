/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriisilaskin.matriisilaskin;

import java.util.Scanner;


/**
 *
 * @author Vesa
 * Tässä luokassa määritellään kaikki oleellinen, matriisi(e)n koko, mitä halutaan tehdä yms
 * On olemassa myös tarkistusmetodi joka ei anna laskea erikokoisia yhteen yms.
 * Toistaiseksi ainakin ohjelma kysyy kahden matriisin kokoa, vaikka tehtäisiin operaatio vain yhdelle.
 */
public class Maarittely {
    
    private Scanner lukija;
    private int operaatio;
    private int syotto;
    public int maara;
    
    private int i;
    private int j;
    private int k;
    private int l;
    private double s;
    
    public Maarittely(Scanner lukija){
        this.lukija = lukija;
        this.operaatio = -1;
        this.syotto = -1;
        this.maara = -1;
        kysy();
    }
    //Jokainen attribuutti kysytään erikseen. Aloitetaan operaatiosta, koska se vaikuttaa tarvitaanko toista matriisia.
    private void kysy(){
        while(true){
        this.operaatio = operaatio();
        this.syotto = syotto();
        if(this.operaatio == 1 || this.operaatio == 4 || this.operaatio == 5 || this.operaatio == 6 || this.operaatio == 7){
            this.maara = 1;
        } else {
            this.maara = 2;
        }
        this.i=i();
        this.j=j();
        this.k=k();
        this.l=l();
        this.s=s();
        if(tarkista()){
            break;
        }
        }
    }
    public int operaatio(){
        int o = -1;
        while(true){
            System.out.println("Minkä operaation haluat suorittaa? Valitse jokin seuraavista:");
            System.out.println("1 transpoosi, 2 summa, 3 tulo, 4 determinantti, 5 käänteismatriisin laskeminen, 6 kofaktorimatriisin laskeminen, 7 skalaarilla kertominen");
            o = Integer.parseInt( lukija.nextLine());
            // Näitä on lisäilty yksi kerrallaan, ei numerojärjestyksessä.
            if(o == 1 || o == 2 || o == 3 || o == 4 || o == 5 || o ==6 || o == 7) {
                
                break;
            } else {
                System.out.println("Virheellinen syöte.");
            }
        }
        
        return o;
    }
    public int syotto(){
        int x = -1;
        
        while(true){
            System.out.println("Haluatko syöttää matriisin käsin vai lukea tiedostosta?");
            System.out.println("0: käsin, 1: tiedostosta");
            x = Integer.parseInt(lukija.nextLine());
            if(x == 0){
                break;
            } else if(x == 1){
                break;
            } else {
                System.out.println("Virheellinen syöte.");
            }
        }
        return x;
    }
   public int i(){
       int x = -1;
       
       while(true){
           System.out.println("Anna ensimmäisen matriisin rivien määrä.");
           x = Integer.parseInt(lukija.nextLine());
           if(x > 0){
               break;
               
           } else {
               System.out.println("Virheellinen arvo.");
           }
       }
       return x;
       
        
   } 
   public int j(){
       int x = -1;
       
       while(true){
           System.out.println("Anna ensimmäisen matriisin sarakkeiden määrä.");
           x = Integer.parseInt(lukija.nextLine());
           if(x > 0){
               break;
               
           } else {
               System.out.println("Virheellinen arvo.");
           }
       }
       return x;
   }
   public int k(){
       int x = 1;
       // Kysytään toisen matriisin detaljeja vain jos sitä tarvitaan. Joka tapauksessa softa luo sen kummittelemaan, mutta sitä ei käytetä missään. Tässä oletusarvona on 1, sillä -1 aiheuttaa bugin, semmoista taulukkoa jonka koko on -1 ei luoda helposti.
       if(this.maara == 2){
       while(true){
           System.out.println("Anna toisen matriisin rivien määrä.");
           x = Integer.parseInt(lukija.nextLine());
           if(x > 0){
               break;
               
           } else {
               System.out.println("Virheellinen arvo.");
           }
       }
       }
       return x;
   }
   public int l(){
       int x = 1;
       if(this.maara == 2){
       while(true){
           System.out.println("Anna toisen matriisin sarakkeiden määrä.");
           x = Integer.parseInt(lukija.nextLine());
           if(x > 0){
               break;
               
           } else {
               System.out.println("Virheellinen arvo.");
           }
       }
       }
       return x;
   }
   
   public double s(){
       double x = 0;
       //Skalaaria kysellään vain kun operaatio on skalaarilla kertominen.
       if(this.operaatio == 7){
       
           System.out.println("Anna skalaari.");
           x = Double.parseDouble(lukija.nextLine());
           
              }
       return x;
   }
   public boolean tarkista(){
       //Tänne kaikki mahdolliset tarkistukset matriisien kokojen suhteen. Esim determinantti onnistuu joss neliömatriisi, summa joss samankokoiset
       //Transpoosi onnistuu aina.
       if(this.operaatio == 2 && ((this.i != this.k) || (this.j != this.l))){
           System.out.println("Summaa laskiessa matriisien tulee olla samankokoiset.");
           return false;
        
       }
       if(this.operaatio == 3 && (this.j != this.k )){
           System.out.println("Matriisien kertolaskussa tulee ensimmäisen matriisin sarakkeiden määrä olla sama kuin toisen rivien määrä.");
           return false;
       }
       if(this.operaatio == 4 && (this.i != this.j)){
           System.out.println("Determinantti on määritelty vain neliömatriiseille.");
           return false;
       }
       if(this.operaatio == 5 && (this.i != this.j)){
           System.out.println("Käänteismatriisin voi laskea vain neliömatriisista.");
           return false;
       }
       if(this.operaatio == 6 && (this.i != this.j)){
           System.out.println("Kofaktorimatriisin voi laskea vain neliömatriisista.");
           return false;
       }
       return true;
   } 
   //Attribuuttien hakumetodit
   public int getOperaatio(){
       return this.operaatio;
   } 
   public int getSyotto(){
       return this.syotto;
   }
   public int getMaara(){
       return this.maara;
   }
   public int geti(){
       return this.i;
   }
   public int getj(){
       return this.j;
   }
   public int getk(){
       return this.k;
   }
   public int getl(){
       return this.l;
   }
   public double gets(){
       return this.s;
   }
}
