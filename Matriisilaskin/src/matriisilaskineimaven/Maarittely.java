/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriisilaskineimaven;

/**
 *
 * @author Vesa
 */
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

    /**
     * JOKAISESSA tapauksessa i = ekan matriisin korkeus, j = ekan leveys, k= tokan korkeus, l = tokan leveys
     * Tapauksissa, jossa jotkin ovat samat, pyrin luopumaan turhista kirjaimista.
     * Esim kertolaskussa j = k, determinantissa i = j
     */
    public int maara;
    
    private int i;
    private int j;
    private int k;
    private int l;
    private double s;
    
    /**
     *
     * @param lukija
     * 
     */
    public Maarittely(Scanner lukija){
        this.lukija = lukija;
        this.operaatio = -1;
        this.syotto = -1;
        this.maara = -1;
        kysy();
    }
    //Jokainen attribuutti kysytään erikseen. Aloitetaan operaatiosta, koska se vaikuttaa tarvitaanko toista matriisia.
    private void kysy(){
        
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
        //Strassenia voi käyttää neliömatriisien tapauksessa. Muutetaan eri operaatioarvo sitä varten.
        if((this.i == this.j && this.j == this.k && this.k == this.l) && this.operaatio == 3){
            this.operaatio = 9;
        }
        this.s=s();
        
        
    }

    /**
     *
     * @return
     */
    public int operaatio(){
        int o = -1;
        while(true){
            System.out.println("Minkä operaation haluat suorittaa? Valitse jokin seuraavista:");
            System.out.println("1 transpoosi, 2 summa, 3 tulo, 4 determinantti, 5 käänteismatriisin laskeminen, 6 kofaktorimatriisin laskeminen, 7 skalaarilla kertominen, 8 matriisien vähennyslasku");
            
            o = Integer.parseInt( lukija.nextLine());
            // Näitä on lisäilty yksi kerrallaan, ei numerojärjestyksessä. 
            if(o == 1 || o == 2 || o == 3 || o == 4 || o == 5 || o ==6 || o == 7 || o == 8) {
                
                break;
            } else {
                System.out.println("Virheellinen syöte.");
            }
        }
        
        return o;
    }

    /**
     *
     * @return
     * Selvitetään matriisn syöttötapa. 
     *
     */
    public int syotto(){
        int x = -1;
        
        while(true){
            System.out.println("Haluatko syöttää matriisin käsin vai lukea tiedostosta?");
            System.out.println("0: käsin, 1: tiedostosta, 2: arvottu matriisi");
            x = Integer.parseInt(lukija.nextLine());
            if(x == 0){
                break;
            } else if(x == 1){
                break;
             } else if(x == 2){
                break;    
            } else {
                System.out.println("Virheellinen syöte.");
            }
        }
        return x;
    }

    /**
     * Nämä seuraavat 4 metodia kysyvät matriisi(e)n korkeudet ja leveydet. Toisen matriisin kokoa kysytään joss sitä tarvitaan.
     * @return
     */
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

    /**
     *
     * @return
     */
    public int j(){
       int x = -1;
       // Jos kyseessä on vain neliömatriiseille määritelty operaatio, turha kysyä tätä erikseen.
       if(this.operaatio == 4 || this.operaatio == 5 || this.operaatio == 6){
           return this.i;
       }
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

    /**
     *
     * @return
     */
    public int k(){
       int x = 1;
       
       // Kysytään toisen matriisin detaljeja vain jos sitä tarvitaan. Joka tapauksessa softa luo sen kummittelemaan, mutta sitä ei käytetä missään. Tässä oletusarvona on 1, sillä -1 aiheuttaa bugin, semmoista taulukkoa jonka koko on -1 ei luoda helposti.
       if(this.maara == 2){
       while(true){
           if(this.operaatio == 3){
           return this.j;
       }
       if(this.operaatio == 2 || this.operaatio == 8){
           return this.i;
       }
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

    /**
     *
     * @return
     */
    public int l(){
       int x = 1;
       
       if(this.maara == 2){
       while(true){
           if(this.operaatio == 2 || this.operaatio == 8){
           return this.j;
       }
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
   
    /**
     *Skalaaria kysellään vain kun operaatio on skalaarilla kertominen.
     * @return
     */
    public double s(){
       double x = 0;
       
       if(this.operaatio == 7){
       
           System.out.println("Anna skalaari.");
           x = Double.parseDouble(lukija.nextLine());
           
              }
       return x;
   }

    /**
     *
     * @return
     * Tänne kaikki mahdolliset tarkistukset matriisien kokojen suhteen. Esim determinantti onnistuu joss neliömatriisi, summa joss samankokoiset
     * Transpoosi onnistuu aina. Erilliset virheilmoitukset aina operaation mukaan.
     */
    
   

    /**
     * Seuraavat 8 metodia palauttavat aina tietyn attribuutin ohjelmalle tulevaa käyttöä ajatellen. 
     * @return
     */
       public int getOperaatio(){
       return this.operaatio;
   } 

    /**
     *
     * @return
     */
    public int getSyotto(){
       return this.syotto;
   }

    /**
     *
     * @return
     */
    public int getMaara(){
       return this.maara;
   }

    /**
     *
     * @return
     */
    public int geti(){
       return this.i;
   }

    /**
     *
     * @return
     */
    public int getj(){
       return this.j;
   }

    /**
     *
     * @return
     */
    public int getk(){
       return this.k;
   }

    /**
     *
     * @return
     */
    public int getl(){
       return this.l;
   }

    /**
     *skalaari
     * @return
     */
    public double gets(){
       return this.s;
   }
}

