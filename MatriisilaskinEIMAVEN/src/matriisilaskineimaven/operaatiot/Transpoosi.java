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
public class Transpoosi {
    
    private int i;
    private int j;
    private double[][] A;
    private double[][] C;
    
    private long start;
    private long end;
    private long dur;
    /**
     *
     * @param A operoitava matriisi
     * @param i korkeus
     * @param j leveys
     */
    public Transpoosi(double[][] A, int i, int j){
        this.i = i;
        this.j = j;
        this.A = A;
        this.C = new double[this.j][this.i];
        this.start = System.nanoTime();
        this.C = transponoi(A);
        this.end = System.nanoTime();
        this.dur = (this.end - this.start) / 1000000;
    }

    /**
     *
     * @param A
     * @return luodaan uusi matriisi kääntäen i ja j toisinpäin, ja laitetaan arvo kerrallaan oikeaan paikkaan
     */
    public double[][] transponoi(double[][] A){
        double[][] C = new double[this.j][this.i];
        for (int k = 0; k < this.j; k++) {
            for (int l = 0; l < this.i; l++) {
                
                C[k][l] = A[l][k];
            }
        }
        return C;
    }
    
    /**
     *
     * @return
     */
    public double[][] getC(){
        return C;
    }
    public long getDur(){
        return this.dur;
    }
}
