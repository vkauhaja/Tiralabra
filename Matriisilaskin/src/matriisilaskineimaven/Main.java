/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriisilaskineimaven;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Vesa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner lukija = new Scanner(System.in);
        Maarittely maarittely = new Maarittely(lukija);
     
        Laskin laskin = new Laskin(maarittely.getOperaatio(), maarittely.getSyotto(), maarittely.getMaara() , lukija,  maarittely.geti(),maarittely.getj(), maarittely.getk(), maarittely.getl(), maarittely.gets());
    }
    
}
