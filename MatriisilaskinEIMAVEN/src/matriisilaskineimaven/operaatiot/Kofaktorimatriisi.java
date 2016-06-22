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
public class Kofaktorimatriisi {
    private double[][] A;
    private double[][] C;
    private int i;
    
    private long start;
    private long end;
    private long dur;
    /**
     *
     * @param A operoitava matriisi
     * @param i matriisin korkeus ja leveys
     */
    public Kofaktorimatriisi(double[][] A, int i){
        this.A = A;
        this.i = i;
        this.start = System.nanoTime();
        this.C = kofaktoroi(A, this.i);
        this.end = System.nanoTime();
        this.dur = (this.end - this.start) / 1000000;
        
    }

    /**
     *
     * @param A samat kuin yllä
     * @param i
     * @return
     */
    public double[][] kofaktoroi(double[][] A, int i){
        double[][] C = new double[i][i];
        double[][] D = new double[i-1][i-1];
        for (int j = 0; j < i; j++) {
            for (int k = 0; k < i; k++) {
                
                D= ali(this.A, this.i, j, k); 
                C[j][k] = determinantti(D, i-1);
                if(!((j - k)%2==0 )){
                    C[j][k] = -C[j][k]; //Uskoakseni helpoin tapa ottaa huomioon determinantin vaatimat joka toinen negaa jutut
                }
            }
        }
        return C;
    }
    
    /**
     *
     * @param A operoitava matriisi
     * @param x matriisin koko, epäloogisesti eri kirjain kun muualla
     * @param i i ja j ovat sen alkion paikka jonka suhteen alimatriisi luodaan
     * @param j
     * @return palautetaan pienempi matriisi, josta on yksi rivi ja sarake poissa.
     */
    public double[][] ali(double[][] A, int x, int i, int j){
        double[][] D = new double[x-1][x-1];
        int k = -1;
        for (int l = 0; l < x; l++) {
            if(l == i)
                continue;
                k++;
                int d = -1;
                for (int m = 0; m < x; m++) {
                    if(m == j)
                        continue;
                    D[k][++d] = A[l][m];
            }
        }
        return D;
    }

    /**
     *
     * @param A
     * @param i
     * @return sama determinanttimetodi kuin determinantti-luokassa.
     */
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
                // Asian voi tehdä myös yhdellä rivillä
                d += Math.pow(-1.0, 1.0 + j+1.0)* A[0][j] * determinantti(B, i-1);
            }
        }
        return d;
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
