/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaatiot;

/**
 *
 * @author Vesa
 * Strassen-tulo. Mallia otettu wikipediasta
 */
public class TuloStrassen {
    private int i;
   
    private int strassenRaja = 4;
    
    private double[][] A;
    private double[][] B;
    private double[][] C;
    
    private long start;
    private long end;
    private long dur;
    
    /**
     *
     * @param A kerrottavat matriisit
     * @param B
     * @param i neliömatriisin koko
     */
    public TuloStrassen(double[][] A, double[][] B, int i){
        this.i = i;
        
        this.A = A;
        this.B = B;
        this.start = System.nanoTime();
        this.C = tuloStrassen(this.A, this.B, this.i);
        this.end = System.nanoTime();
        this.dur = (this.end - this.start) / 1000000;
        
        
       
    }

    /**
     *
     * @param A kerrottavat matriisit
     * @param B
     * @param i neliömatriisin sivun pituus
     * @return
     */
    
    // Alustusmetodi. Muokataan matriisi sopivan kokoiseksi (sivu 2 potenssiksi)
    public double[][] tuloStrassen(double[][] A, double[][] B, int i){
        double[][] C = new double[i][i];
        int k = kakkosenPotenssi(i);
        
        double[][] AStra = new double[k][k];
        double[][] BStra = new double[k][k];
        
        for (int j = 0; j < i; j++) {
            for (int l = 0; l < i; l++) {
                AStra[j][l] = A[j][l];
                BStra[j][l] = B[j][l];
            }
        }
        double[][] CStra = tuloStrassenLaske(AStra, BStra);
        for (int j = 0; j < i; j++) {
            for (int l = 0; l < i; l++) {
                C[j][l] = CStra[j][l];
            }
        }
        return C;
     
    }

    /**
     *
     * @param A
     * @param B
     * @return
     * Homman ydin. Jaetaan matriisi osiin, ja suoritetaan kertolasku tehokkaammin. Wikipedia selittää paremmin kuin minä.
     */
    public double[][] tuloStrassenLaske(double[][] A, double[][] B){
        int i = A.length;
        if(i < strassenRaja){
            return tuloNaiivi(A, B);
        }
        int uusikoko = i / 2;
        double[][] A11 = new double[uusikoko][uusikoko];
        double[][] A12 = new double[uusikoko][uusikoko];
        double[][] A21 = new double[uusikoko][uusikoko];
        double[][] A22 = new double[uusikoko][uusikoko];
        
        double[][] B11 = new double[uusikoko][uusikoko];
        double[][] B12 = new double[uusikoko][uusikoko];
        double[][] B21 = new double[uusikoko][uusikoko];
        double[][] B22 = new double[uusikoko][uusikoko];
               
        for (int j = 0; j < uusikoko; j++) {
            for (int k = 0; k < uusikoko; k++) {
                    A11[j][k] = A[j][k]; 
                    A12[j][k] = A[j][k + uusikoko]; 
                    A21[j][k] = A[j + uusikoko][k]; 
                    A22[j][k] = A[j + uusikoko][k + uusikoko]; 

                    B11[j][k] = B[j][k]; 
                    B12[j][k] = B[j][k + uusikoko]; 
                    B21[j][k] = B[j + uusikoko][k]; 
                    B22[j][k] = B[j + uusikoko][k + uusikoko]; 
            }
        }
        
        double[][] M1 = tuloStrassenLaske(summa(A11, A22) , summa(B11, B22));
        double[][] M2 = tuloStrassenLaske(summa(A21, A22) , B11);
        double[][] M3 = tuloStrassenLaske(A11, miinus(B12, B22));
        double[][] M4 = tuloStrassenLaske(A22, miinus(B21, B11));
        double[][] M5 = tuloStrassenLaske(summa(A11, A12), B22);
        double[][] M6 = tuloStrassenLaske(miinus(A21, A11) , summa(B11, B12));
        double[][] M7 = tuloStrassenLaske(miinus(A12, A22) , summa(B21, B22));
        
        double[][] C11 = summa (M7, summa( miinus(M4, M5), M1));
        double[][] C12 = summa(M3, M5);
        double[][] C21 = summa(M2, M4);
        double[][] C22 = summa (M6, summa( miinus(M1, M2), M3));
        
        double[][] C = new double[i][i];
        for (int j = 0; j < uusikoko; j++) {
            for (int k = 0; k < uusikoko; k++) {
                C[j][k] = C11[j][k];
                C[j][k + uusikoko] = C12[j][k];
                C[j + uusikoko][k] = C21[j][k];
                C[j + uusikoko][k + uusikoko] = C22[j][k]; 
            }
        }
        return C;
    }
    
    /**
     *
     * @param A
     * @param B
     * @return
     * Summametodi tarvitaan tännekin. Laskee summan ajassa n^2. 
     */
    public double[][] summa(double[][] A, double[][] B){
        int m = A.length;
        double[][] C = new double[m][m];
        for (int j = 0; j < m; j++) {
            for (int k = 0; k < m; k++) {
                C[j][k] = A[j][k] + B[j][k];
            }
        }
        return C;
    }

    /**
     *
     * @param A
     * @param B
     * @return
     * Tätäkin tarvitaan Strassenissa.
     */
    public double[][] miinus(double[][] A, double[][] B){
        int m = A.length;
        double[][] C = new double[m][m];
        for (int j = 0; j < m; j++) {
            for (int k = 0; k < m; k++) {
                C[j][k] = A[j][k] - B[j][k];
            }
        }
        return C;
    }

    /**
     *
     * @param i
     * @return
     * Strassen on (ainakin helpoiten) toteutettavissa matriiseille joiden sivun pituus on 2 potenssi. Tällä lasketaan seuraava 2 potenssi, jotta voidaan muokata matriisi sopivan kokoiseksi
     */
    public int kakkosenPotenssi(int i){
        double x =Math.pow(2, Math.ceil(Math.log(i) /Math.log(2) ));
        return (int) x;
    }

    /**
     *
     * @param A
     * @param B
     * @return
     * Normaali naiivi tulonlaskenta viimeistä rekursion vaihetta varten
     */
    public double[][] tuloNaiivi(double[][] A, double[][] B){
        int a = A.length;
        int x = 0;
        double[][] C = new double[a][a];
        for (int m = 0; m < a; m++) {
            for (int n = 0; n < a; n++) {
                for (int p = 0; p < a; p++) {
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
     * Samanlainen palautusmetodi kun muuallakin
     */
    public double[][] getC(){
        return this.C;
    }

    /**
     *
     * @return
     */
    public long getDur(){
        return this.dur;
    }
}
