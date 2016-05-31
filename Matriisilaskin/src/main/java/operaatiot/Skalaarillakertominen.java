/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaatiot;

import java.util.Scanner;

/**
 *
 * @author Vesa
 * Jokainen alkio on pakko kertoa erikseen, sama periaate kun summassa.
 */
public class Skalaarillakertominen {
    private double[][] A;
    private double[][] C;
    private int i;
    private int j;
    private double s;
    
    public Skalaarillakertominen(double[][] A, int i, int j, double s){
        this.A = A;
        this.i = i;
        this.j = j;
        this.s = s;
        this.C = new double[i][j];
        for (int k = 0; k < i; k++) {
            for (int l = 0; l < j; l++) {
                C[k][l] = s* A[k][l];
            }
        }
    }
    public double[][] getC(){
        return this.C;
    }
}
