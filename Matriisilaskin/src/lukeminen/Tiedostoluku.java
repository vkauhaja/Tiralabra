/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lukeminen;

/**
 *
 * @author Vesa
 */
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
    
    /**
     *
     * @param lukija
     * @param i luettavan matriisin ulottuvuudet, taas kerran
     * @param j
     * @throws FileNotFoundException
     * @throws IOException
     */
    public Tiedostoluku(Scanner lukija, int i, int j) throws FileNotFoundException, IOException{
        this.i = i;
        this.j = j;
        this.lukija = lukija;
        this.C = new double[i][j];
        lue(this.i, this.j);
        
    }

    /**
     *
     * @param i
     * @param j
     * @throws FileNotFoundException
     * @throws IOException
     * Varmaan tämän olisi voinut siistimminkin tehdä MUTTA nyt tämä lukee minkä tahansa tekstitiedoston joka sisältää numeroita. Ei väliä ovatko rivit eri mittaisia tms. Se lukee KAIKEN. Matriisi saa olla yhdellä rivillä, yksi alkio / rivi, ja ohjelma muodostaa oikeasti halutun kokoisen matriisin.
     */
    public void lue(int i, int j) throws FileNotFoundException, IOException{
        System.out.println("Anna haluamasi matriisin tiedostonnimi.");
        String nimi = lukija.nextLine();
        File matrix = new File(nimi);
        int a = 0;
        int b = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(matrix))) {
            String l;
            while (((l = br.readLine()) != null) && (a < i) ) {
                String[] spl = l.split("\\s+");
                for (int k = 0; k < spl.length; k++) {
                    if(!spl[k].isEmpty()){
                        this.C[a][b] = Double.parseDouble(spl[k]);
                    }
                    
                    System.out.println("");
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
    }

    /**
     *  Tavallinen palautusmetodi
     * @return
     */
    public double[][] getC(){
        return this.C;
    }
    
}