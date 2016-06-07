/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaatiot;

/**
 *
 * @author Vesa
 * Summaa on nähdäkseni mahdoton laskea tehokkaammin. Pitää molemmissa yhteenlaskettavissa matriiseissa käydä läpi aina jokainen kohta erikseen.
 */
public class Summa {
    
    private int i;
    private int j;
    
    private double[][] A;
    private double[][] B;
    private double[][] C;
    
    private long start;
    private long end;
    private long dur;
    /**
     *
     * @param A summattavat matriisit
     * @param B 
     * @param i matriisien korkeus
     * @param j ja leveys
     */
    public Summa(double[][] A, double[][] B, int i, int j){
        this.i=i;
        this.j=j;
        this.A=A;
        this.B=B;
        this.start = System.nanoTime();
        this.C = summaa(this.A, this.B);
        this.end = System.nanoTime();
        this.dur = (this.end - this.start) / 1000000;
    }

    /**
     *
     * @param A
     * @param B
     * @return lasketaan naiivisti yhteen. Aikavaativuus O^(2*i*j), mutta muutenkaan ei voi
     */
    public double[][] summaa(double[][] A, double[][] B){
        double[][] C = new double[this.i][this.j];
        for (int k = 0; k < this.i; k++) {
            for (int l = 0; l < this.j; l++) {
                C[k][l] = A[k][l] + B[k][l];
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
