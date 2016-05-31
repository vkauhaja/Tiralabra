/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaatiot;

/**
 *
 * @author Vesa
 * Koodi on uskoakseni niin tehokasta kun olla ja voi. Jokaista alkiota käsitellään vain kerran.
 */
public class Transpoosi {
    
    private int i;
    private int j;
    private double[][] A;
    private double[][] C;
    
    public Transpoosi(double[][] A, int i, int j){
        this.i = i;
        this.j = j;
        this.A = A;
        this.C = new double[this.j][this.i];
        for (int k = 0; k < this.j; k++) {
            for (int l = 0; l < this.i; l++) {
                
                C[k][l] = A[l][k];
            }
        }
    }
    public double[][] getC(){
        return C;
    }
}
