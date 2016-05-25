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
 */
public class Maarittely {
    
    private Scanner lukija;
    private int operaatio;
    private int syotto;
    
    
    public Maarittely(Scanner lukija){
        this.lukija = lukija;
        this.operaatio = -1;
        this.syotto = -1;
        kysy();
    }
    private void kysy(){
        this.operaatio = operaatio();
        this.syotto = syotto();
        
        
    }
    public int operaatio(){
        int o = -1;
        while(true){
            System.out.println("Minkä operaation haluat suorittaa? Valitse jokin seuraavista:");
            System.out.println("1 transpoosi, S summa, X tulo, D determinantti, K käänteismatriisin laskeminen.");
            o = Integer.parseInt( lukija.nextLine());
            if(o == 1) {
                
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
   public int getOperaatio(){
       return this.operaatio;
   } 
   public int getSyotto(){
       return this.syotto;
   }
}
