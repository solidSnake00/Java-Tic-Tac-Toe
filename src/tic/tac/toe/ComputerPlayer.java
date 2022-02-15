/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tac.toe;

import java.util.Random;

public class ComputerPlayer extends Player{
    
    public ComputerPlayer(){
        super();
    }
    
    public int randomSelect(int x){
        Random r = new Random();
        int result = r.nextInt(x);
        return result;
    }
    
}
