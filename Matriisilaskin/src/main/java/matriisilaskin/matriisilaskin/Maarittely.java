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
    
    public Maarittely(Scanner lukija){
        this.lukija = lukija;
        this.operaatio = -1;
        this.syotto = -1;
        this.maara = -1;
        kysy();
    }
    private void kysy(){
        while(true){
        this.operaatio = operaatio();
        this.syotto = syotto();
        if(this.operaatio == 1){
            this.maara = 1;
        } else {
            this.maara = 2;
        }
        this.i=i();
        this.j=j();
        this.k=k();
        this.l=l();
        if(tarkista()){
            break;
        }
        }
    }
    public int operaatio(){
        int o = -1;
        while(true){
            System.out.println("Minkä operaation haluat suorittaa? Valitse jokin seuraavista:");
            System.out.println("1 transpoosi, 2 summa, X tulo, D determinantti, K käänteismatriisin laskeminen.");
            o = Integer.parseInt( lukija.nextLine());
            if(o == 1 || o == 2) {
                
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
       int x = -1;
       
       while(true){
           System.out.println("Anna toisen matriisin rivien määrä.");
           x = Integer.parseInt(lukija.nextLine());
           if(x > 0){
               break;
               
           } else {
               System.out.println("Virheellinen arvo.");
           }
       }
       return x;
   }
   public int l(){
       int x = -1;
       
       while(true){
           System.out.println("Anna toisen matriisin sarakkeiden määrä.");
           x = Integer.parseInt(lukija.nextLine());
           if(x > 0){
               break;
               
           } else {
               System.out.println("Virheellinen arvo.");
           }
       }
       return x;
   }
   public boolean tarkista(){
       //Tänne kaikki mahdolliset tarkistukset matriisien kokojen suhteen. Esim determinantti onnistuu joss neliömatriisi, summa joss samankokoiset
       //Transpoosi onnistuu aina esim
       if(this.operaatio == 2 && ((this.i != this.k) || (this.j != this.l))){
           System.out.println("Summaa laskiessa matriisien tulee olla samankokoiset.");
           return false;
       }
       return true;
   } 
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
}
