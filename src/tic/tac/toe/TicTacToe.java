/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tac.toe;

import java.util.Scanner;

public class TicTacToe {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in=new Scanner(System.in);
        
        int dimensions;
        char mode;
        int playerMode;
        GameApp game;
        
        int IDchoice1;
        int IDchoice2;
        int select;
        int result1;
        int result2;
        String choose;
        
        Player p1=new HumanPlayer();
        Player p2=new HumanPlayer();
        
        ComputerPlayer p2_c=new ComputerPlayer();
        
        
        do{
            System.out.print("Enter board dimensions(odd number required): ");
            dimensions=in.nextInt();
        }while(dimensions%2==0);
        
        Board board=new Board(dimensions);
        
        
        do{
            System.out.print("1. Player against Player\n2. Player against CPU\nEnter mode(\'1\' or \'2\'): ");
            mode=in.next().charAt(0);
        }while(mode!='1' && mode!='2');
        
        game=new GameApp(p1,p2,board);
        if(mode==1){
            game=new GameApp(p1,p2,board);
            playerMode=game.chooseMode(mode);
        }
        if(mode==2){
            game=new GameApp(p1,p2_c,board);
            playerMode=game.chooseMode(mode);
        }
        
        do{
            System.out.print("Choose character, X or O: ");
            choose=in.next();
        }while(!choose.equals("X") && !choose.equals("O"));
        
        game.choosePlayer(choose);
        game.drawBoard();
        
        
        do{
            
            do{
                do{
                    System.out.print("Enter a number("+game.getP1().getCharacter()+" Turn): ");
                    IDchoice1=in.nextInt();
                }while(IDchoice1<0 || IDchoice1>board.getBoardSize());
                
                select=game.selectCell(game.getP1(),IDchoice1);
            }while(select==0);
            
            result1=game.checkResult();
            if(result1==3)
                break;
            if(result1!=4){
                break;
            }
            
            if(mode=='1'){
                do{
                    do{
                        System.out.print("Enter a number("+game.getP2().getCharacter()+" Turn): ");
                        IDchoice2=in.nextInt();
                    }while(IDchoice2<0 || IDchoice2>board.getBoardSize());
                    
                    select=game.selectCell(game.getP2(),IDchoice2);
                }while(select==0);
                
                result1=game.checkResult();
                
                if(result1!=4){
                    break;
                }
            }
            if(mode=='2'){
                do{
                    select=game.selectCell(game.getP2(), p2_c.randomSelect(board.getBoardSize()));
                }while(select==0);
                
                result1=game.checkResult();
                
                
                if(result1!=4){
                    break;
                }
            }
            if(result1==3)
                break;
            
        }while(true);
        
        switch (result1) {
            case 1:
                System.out.println("'X' Won!");
                break;
            case 2:
                System.out.println("'O' Won!");
                break;
            default:
                System.out.println("TIE!");
                break;
        }
        
    }
    
}
