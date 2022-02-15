/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tac.toe;

import java.util.ArrayList;

public class Board {
    private final Cell[][] cell;
    private final int boardDimensions;
    private final ArrayList<Cell> boardTable=new ArrayList();
    
    public Board(int boardDimensions){
        this.boardDimensions=boardDimensions;
        cell=new Cell[boardDimensions][boardDimensions];
        
        for(int i=0;i<boardDimensions;i++){
            for(int j=0;j<boardDimensions;j++){
             cell[i][j]=new Cell(i,j);
             boardTable.add(cell[i][j]);
            }
        }
        
    }
    
    public Cell getCell(int i){
        return boardTable.get(i);
    }
    public Cell getCell(int i,int j){
        return cell[i][j];
    }
    
    public String[][] getRow(){
        String[][] ch = new String[boardDimensions][boardDimensions];
        for(int i=0;i<boardDimensions;i++){
            for(int j=0;j<boardDimensions;j++){
                ch[i][j]=getCell(i,j).getCharacter();
            }
        }
        return ch;
    }
    public String[][] getColumn(){
        String[][] ch = new String[boardDimensions][boardDimensions];
        for(int i=0;i<boardDimensions;i++){
            for(int j=0;j<boardDimensions;j++){
                ch[i][j]=getCell(j,i).getCharacter();
            }
        }
        return ch;
    }
    public String[] getDiagonal1(){
        String[] ch = new String[boardDimensions];
        int s=0;
        for(int i=0;i<boardDimensions;i++){
            for(int j=0;j<boardDimensions;j++){
                if(i==j){
                    ch[s]=getCell(i,j).getCharacter();
                    s++;
                }
                
            }
        }
        return ch;
    }
    public String[] getDiagonal2(){
        String[] ch = new String[boardDimensions];
        int s=0;
        int limit=boardDimensions;
        for(int i=0;i<boardDimensions;i++){
            for(int j=0;j<limit;j++){
                if(j==(limit-1)){
                    ch[s]=getCell(i,j).getCharacter();
                    s++;
                    limit--;
                }
            }
        }
        return ch;
    }
    
    public int getBoardSize(){
        return boardTable.size();
    }
    public int getBoardDimensions(){
        return boardDimensions;
    }
    public ArrayList getArrList(){
        return boardTable;
    }
    public boolean fullBoard(){
        for(int i=0;i<getBoardSize();i++){
            if(!boardTable.get(i).getCharacter().equals("X") && !boardTable.get(i).getCharacter().equals("O")){
                
                return false;
            } 
        }
        
        return true;
    }
    
}