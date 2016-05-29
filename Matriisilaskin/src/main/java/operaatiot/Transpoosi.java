/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaatiot;

/**
 *
 * @author Vesa
 */
public class Transpoosi {
    
    private int i;
    private int j;
    private int[][] A;
    private int[][] C;
    
    public Transpoosi(int[][] A, int i, int j){
        this.i = i;
        this.j = j;
        this.A = A;
        this.C = new int[this.j][this.i];
        for (int k = 0; k < this.j; k++) {
            for (int l = 0; l < this.i; l++) {
                
                C[k][l] = A[l][k];
            }
        }
    }
    public int[][] getC(){
        return C;
    }
}
