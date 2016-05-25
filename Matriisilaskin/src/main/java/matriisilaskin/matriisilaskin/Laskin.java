/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriisilaskin.matriisilaskin;

import java.util.Scanner;

/**
 *
 * @author Vesa
 */
public class Laskin {
    private Scanner lukija;
    private int operaatio;
    private int syotto;
    
    public Laskin(int operaatio, int syotto, Scanner lukija){
        this.operaatio = operaatio;
        this.syotto = syotto;
        this.lukija = lukija;
    }
}
