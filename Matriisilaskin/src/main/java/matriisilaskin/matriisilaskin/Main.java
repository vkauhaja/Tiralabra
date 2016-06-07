/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriisilaskin.matriisilaskin;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


/**
 *
 * @author Vesa
 */
public class Main {

    /**
     * @param args the command line arguments
     * Täällä ei ole mitään ylimääräistä. Luodaan skanneri, luodaan määrittely, ja sitten lasketaan.
     * Olen pyrkinyt pitämään muuuttujien nimissä tiettyä linjaa. Ensimmäisen käsiteltävän matriisin korkeus oni, leveys j
     * Lisäksi matriisi, mitä luodaan ja mikä palautetaan, on kaikkialla nimetty C:ksi. Operaatio saa syötteenä aina matriisin A, ja summan ja tulon tapauksessa myös B:n.
     */
    
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
       
        Scanner lukija = new Scanner(System.in);
        Maarittely maarittely = new Maarittely(lukija);
     
        Laskin laskin = new Laskin(maarittely.getOperaatio(), maarittely.getSyotto(), maarittely.getMaara() , lukija,  maarittely.geti(),maarittely.getj(), maarittely.getk(), maarittely.getl(), maarittely.gets());
    }
    
}
