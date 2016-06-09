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
public class TuloStrassen {
     private int i;
   
    
    private double[][] A;
    private double[][] B;
    private double[][] C;
    
    private long start;
    private long end;
    private long dur;
    
    public TuloStrassen(double[][] A, double[][] B, int i){
        this.i = i;
        
        this.A = A;
        this.B = B;
        this.start = System.nanoTime();
        this.C = tuloStrassen(this.A, this.B);
        this.end = System.nanoTime();
        this.dur = (this.end - this.start) / 1000000;
        
        
       
    }
    public double[][] tuloStrassen(double[][] A, double[][] B){
        int k = A.length;
        double[][] C = new double[k][k];
        
        return C;
     
    }
    public double[][] summa(double[][] A, double[][] B, int i){
        double[][] C = new double[i][i];
        for (int j = 0; j < i; j++) {
            for (int k = 0; k < i; k++) {
                C[j][k] = A[j][k] + B[j][k];
            }
        }
        return C;
    }
    public double[][] miinus(double[][] A, double[][] B, int i){
        double[][] C = new double[i][i];
        for (int j = 0; j < i; j++) {
            for (int k = 0; k < i; k++) {
                C[j][k] = A[j][k] - B[j][k];
            }
        }
        return C;
    }
    public int kakkonen(int i){
        int x = (int) Math.ceil(Math.log(i) /Math.log(2) );
        return x;
    }
    public double[][] tuloNaiivi(double[][] A, double[][] B){
        int x = 0;
        double[][] C = new double[i][i];
        for (int m = 0; m < this.i; m++) {
            for (int n = 0; n < this.i; n++) {
                for (int p = 0; p < this.i; p++) {
                    x += A[m][p] * B[p][n];
                }
                C[m][n] = x;
                x = 0;
            }
        }
        return C;
    }
    public double[][] getC(){
        return this.C;
    }
    public long getDur(){
        return this.dur;
    }
}
