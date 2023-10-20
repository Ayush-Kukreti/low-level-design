package com.driver;

import java.util.Scanner;

import com.model.Board;
import com.model.Player;

public class App {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		
		System.out.println("enter the board size:");
		int boardSize=sc.nextInt();
		
		// take snakes 
		int numberOfSnakes=sc.nextInt();
		int snakes[][]=new int[numberOfSnakes][2];
		for(int i=0;i<numberOfSnakes;i++) {
			snakes[i][0]=sc.nextInt();
			snakes[i][1]=sc.nextInt();
			
		}
		
		// take ladders
		int numberOfLadders=sc.nextInt();
		int ladders[][]=new int[numberOfLadders][2];
		for(int i=0;i<numberOfLadders;i++) {
			ladders[i][0]=sc.nextInt();
			ladders[i][1]=sc.nextInt();
			
		}
		
		// create a board
		Board board=new Board(boardSize, snakes, ladders);
		
		
		// assigning players
		int numberOfPlayers=sc.nextInt();
		Player players[]=new Player[numberOfPlayers];
		for(int i=0;i<numberOfPlayers;i++) {
			players[i]=new Player(sc.next());
		}
		
		// start game
		int playerTurn=0; // turn start from 0th player
		while(true) {
			int rollDice=(int) (Math.random()*6) +1;
			
			//if there are two dices
			rollDice+=(int) (Math.random()*6) +1;
			
			//System.out.println(rollDice);
			
			// player turn
			int playerCurrentPosition=players[playerTurn].getPosition();
			int playerNewPosition=playerCurrentPosition+rollDice;
			
			if(playerNewPosition > boardSize ) {
				playerNewPosition=playerCurrentPosition;
			}
//			System.out.println(playerCurrentPosition);
//			System.out.println(playerNewPosition);
			
			if(playerCurrentPosition!=playerNewPosition && playerNewPosition!=boardSize) {
				
				// check the new position is special position or not
				int currBoard[][]=board.getBoard();
				
				int specialpostion=currBoard[playerNewPosition][1];
				
				if(specialpostion!=0) {
					playerNewPosition=specialpostion;
				}
				players[playerTurn].setPosition(playerNewPosition);
			}
			
			System.out.println(players[playerTurn].getPlayerName()+ " rolled a "+rollDice+" and moved from "+
								playerCurrentPosition+" to " + playerNewPosition);
			
			if(playerNewPosition==boardSize) {
				System.out.println(players[playerTurn].getPlayerName()+ " wins the game");
				System.exit(0);
			}
			
			playerTurn++;
			if(playerTurn==numberOfPlayers)playerTurn=0;
		}
		
		
	}

}














