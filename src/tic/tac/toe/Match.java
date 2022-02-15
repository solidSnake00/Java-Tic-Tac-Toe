/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tac.toe;

public class Match {
    private final Player p1;
    private final Player p2;
    private final Board Brd;
    
    private boolean turn;
    
    
    
    public Match(Player p1,Player p2,Board Brd){
        
        this.p1=p1;
        this.p2=p2;
        this.Brd=Brd;
        
        
    }
    
    public int getBoardDimensions(){
        return Brd.getBoardDimensions();
    }

    public Player getp1() {
        return p1;
    }

    public Player getp2() {
        return p2;
    }

    public Board getBrd() {
        return Brd;
    }

    public boolean isTurn() {
        return turn;
    }    
}
