
// Tällä luokalla luetaan tekstitiedosto, ja luodaan matriisiolio ohjelmaa varten. 
// Vaihtoehtoisesti käyttäjä voi syöttää matriisin käsin.

package matriisilaskin.lukija;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Vesa
 */
public class Tiedostoluku {
    private int i;
    private int j;
    private Scanner lukija;
    private double[][] C;
    
    public Tiedostoluku(Scanner lukija, int i, int j) throws FileNotFoundException, IOException{
        this.i = i;
        this.j = j;
        this.lukija = lukija;
        this.C = new double[i][j];
        lue(this.i, this.j);
        
    }
    public void lue(int i, int j) throws FileNotFoundException, IOException{
        System.out.println("Anna haluamasi matriisin tiedostonnimi.");
        String nimi = lukija.nextLine();
        File matrix = new File(nimi);
        int a = 0;
        int b = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(matrix))) {
            String l;
            while ((l = br.readLine()) != null) {
                this.C[a][b] = Double.parseDouble(l);
                b++;
                if(b == j){
                    a++;
                    b = 0;
                    
                }
                if(a == i){
                    break;
                }
            }
        }
    }
    public double[][] getC(){
        return this.C;
    }
}
