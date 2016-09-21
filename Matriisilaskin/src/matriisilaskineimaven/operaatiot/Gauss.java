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
public class Gauss {
    private int i;
    private int j;
    
    private double[][] A;
    
    private double[][] C;
    
    private long start;
    private long end;
    private long dur;
    
    public Gauss(double[][] A, int i, int j){
        this.i = i;
        this.j = j;
        this.A = A;
        this.start = System.nanoTime();
        this.C = Gauss(this.A);
        this.end = System.nanoTime();
        this.dur = (this.end - this.start) / 1000000;
    }
    public double[][] Gauss(double[][] m){
        
        int lead = 0;
    int rowCount = this.i;
    int colCount = this.j;
    int i;
    boolean quit = false;

    for(int row = 0; row < rowCount && !quit; row++)
    {
        

        if(colCount <= lead)
        {
            quit = true;
            break;
        }

        i=row;

        while(!quit && m[i][lead] == 0)
        {
            i++;
            if(rowCount == i)
            {
                i=row;
                lead++;

                if(colCount == lead)
                {
                    quit = true;
                    break;
                }
            }
        }

        if(!quit)
        {
            swapRows(m, i, row);

            if(m[row][lead] != 0)
                multiplyRow(m, row, 1.0f / m[row][lead]);

            for(i = 0; i < rowCount; i++)
            {
                if(i != row)
                    subtractRows(m, m[i][lead], row, i);
            }
        }
    }
        
        return m;
    }
    static void swapRows(double [][] m, int row1, int row2)
{
    double [] swap = new double[m[0].length];

    for(int c1 = 0; c1 < m[0].length; c1++)
        swap[c1] = m[row1][c1];

    for(int c1 = 0; c1 < m[0].length; c1++)
    {
        m[row1][c1] = m[row2][c1];
        m[row2][c1] = swap[c1];
    }
}

static void multiplyRow(double [][] m, int row, double scalar)
{
    for(int c1 = 0; c1 < m[0].length; c1++)
        m[row][c1] *= scalar;
}

static void subtractRows(double [][] m, double scalar, int subtract_scalar_times_this_row, int from_this_row)
{
    for(int c1 = 0; c1 < m[0].length; c1++)
        m[from_this_row][c1] -= scalar * m[subtract_scalar_times_this_row][c1];
}
    public double[][] getC(){
        return this.C;
    }
    //Kaikkialla samanlainen ajanpalautusmetodi.
    public long getDur(){ 
        return this.dur;
    }
}
