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
        this.C = tulo(this.A, this.B);
        this.end = System.nanoTime();
        this.dur = (this.end - this.start) / 1000000;
        
        
       
    }
    public double[][] tulo(double[][] A, double[][] B){
        double[][] C = new double[i][i];
        
        return C;
     
    }
     public double[][] getC(){
        return this.C;
    }
    public long getDur(){
        return this.dur;
    }
}
