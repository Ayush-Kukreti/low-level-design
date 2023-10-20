package com.model;

public class Board {
	private int boardSize;
	private int board[][];
	
	
	public int[][] getBoard() {
		return board;
	}

	public int getBoardSize() {
		return boardSize;
	}

	public void setBoardSize(int boardSize) {
		this.boardSize = boardSize;
	}

	public void setBoard(int[][] board) {
		this.board = board;
	}

	public Board(int boardSze,int snakes[][],int ladders[][]) {
		this.boardSize=boardSze;
		initializeBoard();
		createBoard(snakes,ladders);
		
//		 printBoard();
	}
	
	
	private void initializeBoard() {
		board=new int[boardSize][2];
		for(int i=0;i<boardSize;i++) {
			board[i][0]=i;
		}
	}


	public void createBoard(int snakes[][],int ladders[][]) {
		addSnakes(snakes);
		addLadders(ladders);
	}

	private void addSnakes(int snakes[][]) {
		
		for(int i=0;i<snakes.length;i++) {
			int index=snakes[i][0];
			board[index][1]=snakes[i][1];
		}
		
	}
	
	private void addLadders(int ladders[][]) {
		
		for(int i=0;i<ladders.length;i++) {
			int index=ladders[i][0];
			board[index][1]=ladders[i][1];
		}
	}
	
	private void printBoard() {
		for(int i=0;i<boardSize;i++) {
			System.out.print(board[i][0]+" "+ board[i][1]);
			System.out.println();
		}
	}
}










