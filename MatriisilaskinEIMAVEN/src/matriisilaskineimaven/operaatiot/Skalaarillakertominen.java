/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriisilaskineimaven.operaatiot;

/**
 *
 * @author Vesa
 */
public class Skalaarillakertominen {
    private double[][] A;
    private double[][] C;
    private int i;
    private int j;
    private double s;
    
    private long start;
    private long end;
    private long dur;
    /**
     *
     * @param A operoitava matriisi
     * @param i matriisin koko
     * @param j
     * @param s skalaari
     */
    public Skalaarillakertominen(double[][] A, int i, int j, double s){
        this.A = A;
        this.i = i;
        this.j = j;
        this.s = s;
        this.start = System.nanoTime();
        this.C = kerro(this.A, s); 
        this.end = System.nanoTime();
        this.dur = (this.end - this.start) / 1000000;
    }

    /**
     *
     * @param A 
     * @param s
     * @return ludaan samankokoinen matriisi, kerrotaan joka alkio skalaarilla, ja palautetaan
     */
    public double[][] kerro(double[][] A, double s){
        double[][] C = new double[i][j];
        for (int k = 0; k < this.i; k++) {
            for (int l = 0; l < this.j; l++) {
                C[k][l] = s* A[k][l];
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
    public long getDur(){
        return this.dur;
    }
}

