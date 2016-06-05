
// Tällä luokalla luetaan tekstitiedosto, ja luodaan matriisiolio ohjelmaa varten. 
// Vaihtoehtoisesti käyttäjä voi syöttää matriisin käsin.

package matriisilaskin.lukija;

/**
 *
 * @author Vesa
 */
public class Tiedostoluku {
    private int i;
    private int j;
    
    private double[][] C;
    
    public Tiedostoluku(int i, int j){
        this.i = i;
        this.j = j;
    }
    public double[][] getC(){
        return this.C;
    }
}
