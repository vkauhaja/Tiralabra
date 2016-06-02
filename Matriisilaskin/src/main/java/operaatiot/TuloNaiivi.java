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
public class TuloNaiivi {
    private int i;
    private int j;
   
    private int l;
    
    private double[][] A;
    private double[][] B;
    private double[][] C;
    
    /**
     *
     * @param A kerrottavat matriisit
     * @param B
     * @param i 1. matriisin korkeus
     * @param j 1. matriisin leveys ja 2. matriisin korkeus
     
     * @param l 2. matriisin leveys
     */
    public TuloNaiivi(double[][] A, double[][] B, int i, int j,  int l){
        this.i = i;
        this.j = j;
       
        this.l = l;
        this.A = A;
        this.B = B;
        
        this.C = tulo(this.A, this.B);
        
        
        
       
    }

    /**
     *
     * @param A
     * @param B
     * @return tämä toimii naiivisti, aikavaativuus O(n^3). Strassen tulee toimimaan nopeammin.
     */
    public double[][] tulo(double[][] A, double[][] B){
        int x = 0;
        double[][] C = new double[i][l];
        for (int m = 0; m < this.i; m++) {
            for (int n = 0; n < this.l; n++) {
                for (int p = 0; p < this.j; p++) {
                    x += A[m][p] * B[p][n];
                }
                C[m][n] = x;
                x = 0;
            }
        }
        return C;
    }

    /**
     *
     * @return
     */
    public double[][] getC(){
        return this.C;
    }
}
