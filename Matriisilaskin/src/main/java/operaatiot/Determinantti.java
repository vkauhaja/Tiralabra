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
public class Determinantti {
    private int i;
    
    private double[][] A;
    
    private double d;
    
    public Determinantti(double[][] A, int i ){
        this.i=i;
        this.A = A;
        this.d = determinantti(this.A, this.i);
        
        

    }
    public double determinantti(double A[][], int i) {
        double d = 0;
        if(i == 1) {
            d = A[0][0];
        } else if (i == 2) {
            d = A[0][0]*A[1][1] - A[1][0]*A[0][1];
        } else {
            d = 0;
            for(int j=0; j<i; j++) {
                double[][] B = new double[i-1][];
                for(int k=0; k < (i-1);  k++) {
                    B[k] = new double[i-1];
                }
                for(int l=1; l < i; l++) {
                    int x = 0;
                    for(int n=0; n<i; n++) {
                        if(n == j)
                            continue;
                        B[l-1][x] = A[l][n];
                        x++;
                    }
                }
                d += Math.pow(-1.0, 1.0 + j+1.0)* A[0][j] * determinantti(B, i-1);
            }
        }
        return d;
    }
    
    public double getd(){
        return this.d;
    }
}
