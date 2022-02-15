/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tac.toe;

import java.util.concurrent.atomic.AtomicInteger;

public class Cell {
    private final int x;
    private final int y;
    private String character;
    private final int ID;
    
    
    private static final AtomicInteger count = new AtomicInteger(0);
    
    public Cell(int x,int y){
        this.x=x;
        this.y=y;
        
        ID=count.incrementAndGet()-1; 
        character=String.valueOf(ID);
    }
    
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    
    public int getID(){
        return ID;
    }
    public String getCharacter(){
        return character;
    }
    public void setCharacter(String ch){
        character=ch;
    }
    public boolean getEmpty(){
        return !character.equals("X") && !character.equals("O");
    }
    
}
