/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tac.toe;

import java.util.Arrays;


public class GameApp {
    
    
    private final Match game;
    
    private Player currentPlayer;
    private Player enemyPlayer;
    
    
    public enum Status{
        CHOOSE,
        pXTurn,
        pOTrun,
        pXWIN,
        pOWIN,
        TIE
    }
    public Status status;

    public GameApp(Player currentPlayer, Player enemyPlayer,Board Brd) {
        game=new Match(currentPlayer,enemyPlayer,Brd);
        this.currentPlayer=currentPlayer;
        this.enemyPlayer=enemyPlayer;
        
        status=Status.CHOOSE;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setEnemyPlayer(Player enemyPlayer) {
        this.enemyPlayer = enemyPlayer;
    }
    
    //function to choose between the 2 modes: player against player or player against A.I.
    public int chooseMode(char ch){
        if(ch=='1'){
            
            currentPlayer=(HumanPlayer)game.getp1();
            enemyPlayer=(HumanPlayer)game.getp2();
            return 1;
        }
        else if(ch=='2'){
            currentPlayer=(HumanPlayer)game.getp1();
            enemyPlayer=(ComputerPlayer)game.getp2();
            return 2;
        }
        return 0;
    }
    
    //function to choose player's character ('X' or 'O')
    public void choosePlayer(String ch){
        if("X".equals(ch)){
            currentPlayer.setCharacter("X");
            enemyPlayer.setCharacter("O");
        }
        else if("O".equals(ch)){
            currentPlayer.setCharacter("O");
            enemyPlayer.setCharacter("X");
        }
        status=Status.pXTurn;
    }
    
    

    
    //function to check the result
    public int checkResult(){//pXWIN = 1 ; pOWIN= 2; tie = 3 ; keepGoing=4
        String[][] row=game.getBrd().getRow();
        
        
        String []chRow = new String[game.getBrd().getBoardDimensions()];
        String []rX = new String[game.getBrd().getBoardDimensions()];
        String []rO = new String[game.getBrd().getBoardDimensions()];
        
        String[][] column=game.getBrd().getColumn();
        
        String []chColumn = new String[game.getBrd().getBoardDimensions()];
        String []cX = new String[game.getBrd().getBoardDimensions()];
        String []cO = new String[game.getBrd().getBoardDimensions()];
        
        String[] diagonal1=game.getBrd().getDiagonal1();
        String[] dX=new String[game.getBrd().getBoardDimensions()];
        String[] dO=new String[game.getBrd().getBoardDimensions()];
        /////////////////////////
        String[] diagonal2=game.getBrd().getDiagonal2();
        
        //////////////// check rows if winner
        for(int i=0;i<game.getBrd().getBoardDimensions();i++){
            for(int j=0;j<game.getBrd().getBoardDimensions();j++){
                chRow[j]=row[i][j];
            }
            
            for(int f=0;f<chRow.length;f++){
                rX[f]="X";
                rO[f]="O";
            }
            if(Arrays.equals(rX, chRow)){
                status=Status.pXWIN;
                return 1;
            }
            if(Arrays.equals(rO, chRow)){
                status=Status.pOWIN;
                return 2;
            }
        }
        /////////////////////////////////check column
        for(int i=0;i<game.getBrd().getBoardDimensions();i++){
            for(int j=0;j<game.getBrd().getBoardDimensions();j++){
                chColumn[j]=column[i][j];
            }
            for(int f=0;f<chColumn.length;f++){
                cX[f]="X";
                cO[f]="O";
            }
            if(Arrays.equals(cX, chColumn)){
                status=Status.pXWIN;
                return 1;
            }
            if(Arrays.equals(cO, chColumn)){
                status=Status.pOWIN;
                return 2;
            }
        }
        //////////////////////////////
        for(int i=0;i<diagonal1.length;i++){
            dX[i]="X";
            dO[i]="O";
        }
        if(Arrays.equals(dX,diagonal1) || Arrays.equals(dX,diagonal2)){
            status=Status.pXWIN;
            return 1;
        }
        if(Arrays.equals(dO,diagonal1) || Arrays.equals(dO,diagonal2)){
            status=Status.pOWIN;
            return 2;
        }
        
        if(game.getBrd().fullBoard()){
            status=Status.TIE;
            
            return 3;
        }
        
        return 4;//keep going
    }
    
    //return player 1
    public Player getP1(){
        return currentPlayer;
    }
    public Player getP2(){
        return enemyPlayer;
    }
    
    //function for selecting and fill a specific cell, and drawing the board
    public int selectCell(Player p,int IDchoice){// return 1 for success; 0 for fail
        if(game.getBrd().getCell(IDchoice).getEmpty()){
            game.getBrd().getCell(IDchoice).setCharacter(p.getCharacter());
            drawBoard();
            return 1;
        }
        else
            return 0;
    }
    
    //function to draw the board in it's current state
    public void drawBoard(){
        int s=0;
        for(int i=0;i<game.getBrd().getBoardDimensions();i++){
            for(int j=0;j<game.getBrd().getBoardDimensions();j++){
                System.out.print(game.getBrd().getCell(s).getCharacter()+"\t");
                s++;
            }
            System.out.println("\n\n");
        }
    }
    
    
}