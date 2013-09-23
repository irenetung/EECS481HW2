package com.example.connectfour;

public class ConnectFourGame {
	private char mBoard[][];
	private final static int BOARD_SIZE = 7;
	public static final char PLAYER1='X';
	public static final char PLAYER2 = 'O';
	public static final char EMPTY_SPACE =' ';
	
	
	public static int getBOARD_SIZE() {
		return BOARD_SIZE;
	}
	
	public ConnectFourGame() {
		mBoard = new char[BOARD_SIZE][BOARD_SIZE];
		
		for(int i=0; i<BOARD_SIZE; i++) {
			for(int j=0; j<BOARD_SIZE; j++) {
				mBoard[i][j] = EMPTY_SPACE;
			}
		}
	}
	
	public void clearBoard() {
		for(int i=0; i<BOARD_SIZE; i++) {
			for(int j=0; j<BOARD_SIZE; j++) {
				mBoard[i][j] = EMPTY_SPACE;
			}
		}
	}
	
	public void setMove(char player, int locationx, int locationy) {
		mBoard[locationx][locationy] = player;
	}
	
	public int checkForWinner() {
		int count = 0;
		boolean prevPlayer1 = true;
		
		//4 IN A ROW VERTICAL CHECK
		for(int i=0; i<BOARD_SIZE; i++) {
			for(int j=0; j<BOARD_SIZE; j++) {
				if(mBoard[i][j]==PLAYER1) {
					if(prevPlayer1) {
						count++;
					} else {
						count=1;
						prevPlayer1 = true;
					}
				} else if (mBoard[i][j]==PLAYER2) {
					if(!prevPlayer1) {
						count++;
					} else {
						count=1;
						prevPlayer1 = false;
					}
				} else {
					count = 0;
				}
				if(count==4) {
					if(prevPlayer1) {
						//PLAYER 1 WON
						return 1;
					} else {
						//PLAYER 1 WON
						return 2;
					}
				}

			}
			count = 0;
			prevPlayer1 = true;
		}
		
		//4 IN A ROW HORIZONTAL CHECK
		count = 0;
		prevPlayer1 = true;
		for(int i=0; i<BOARD_SIZE; i++) {
			for(int j=0; j<BOARD_SIZE; j++) {
				if(mBoard[j][i]==PLAYER1) {
					if(prevPlayer1) {
						count++;
					} else {
						count=1;
						prevPlayer1 = true;
					}
				} else if (mBoard[j][i]==PLAYER2) {
					if(!prevPlayer1) {
						count++;
					} else {
						count=1;
						prevPlayer1 = false;
					}
				} else {
					count = 0;
				}
				if(count==4) {
					if(prevPlayer1) {
						//PLAYER 1 WON
						return 1;
					} else {
						//PLAYER 1 WON
						return 2;
					}
				}
			}
			count = 0;
			prevPlayer1 = true;
		}
		
		int count1 = 0;
		boolean prevPlayer11 = true;
		int count2 = 0;
		boolean prevPlayer12 = true;
		
		//4 IN A ROW DIAGONAL \ CHECK
		for(int a=0; a<(BOARD_SIZE-3); a++) {
			for(int i=a; i<BOARD_SIZE; i++) {
				//Top half of grid
				if(mBoard[i][i-a]==PLAYER1) {
					if(prevPlayer11) {
						count1++;
					} else {
						count1 = 1;
						prevPlayer11 = true;
					} 
				} else if (mBoard[i][i-a]==PLAYER2) {
					if(!prevPlayer11) {
						count1++;
					} else {
						count1 = 1;
						prevPlayer11 = false;
					} 
				} else {
					count1 = 0;
				}
				if(count1==4) {
					if(prevPlayer11) {
						//PLAYER 1 WON
						return 1;
					} else {
						//PLAYER 1 WON
						return 2;
					}
				}
			
				if(mBoard[i-a][i]==PLAYER1) {		
					if(prevPlayer12) {
						count2++;
					} else {
						count2 = 1;
						prevPlayer12 = true;
					}
				} else if (mBoard[i-a][i]==PLAYER2) {
					if(!prevPlayer12) {
						count2++;
					} else {
						count2 = 1;
						prevPlayer12 = false;
					}
				} else {
					count2 = 0;
				}
				if(count2==4) {
					if(prevPlayer12) {
						//PLAYER 1 WON
						return 1;
					} else {
						//PLAYER 1 WON
						return 2;
					}
				}
				
			}
			
			count1 = 0;
			prevPlayer11 = true;
			count2 = 0;
			prevPlayer12 = true;
		}
		
		count1 = 0;
		prevPlayer11 = true;
		count2 = 0;
		prevPlayer12 = true;
		//4 IN A ROW DIAGONAL / CHECK
		for(int a=0; a<(BOARD_SIZE-3); a++) {
			for(int i=(BOARD_SIZE-1-a); i>=0; i--) {
				//Top half of grid
				if(mBoard[i][BOARD_SIZE-1-a-i]==PLAYER1) {
					if(prevPlayer11) {
						count1++;
					} else {
						count1=1;
						prevPlayer11 = true;
					} 
				} else if (mBoard[i][BOARD_SIZE-1-a-i]==PLAYER2) {
					if(!prevPlayer11) {
						count1++;
					} else {
						count1=1;
						prevPlayer11 = false;
					} 
				} else {
					count1 = 0;
				}
				if(count1==4) {
					if(prevPlayer11) {
						//PLAYER 1 WON
						return 1;
					} else {
						//PLAYER 1 WON
						return 2;
					}
				}
			
				if(mBoard[i+a][BOARD_SIZE-1-i]==PLAYER1) {
					if(prevPlayer12) {
						count2++;
					} else {
						count2=1;
						prevPlayer12 = true;
					} 
				} else if (mBoard[i+a][BOARD_SIZE-1-i]==PLAYER2) {
					if(!prevPlayer12) {
						count2++;
					} else {
						count2=1;
						prevPlayer12 = false;
					} 
				} else {
					count2 = 0;
				}
				if(count2==4) {
					if(prevPlayer12) {
						//PLAYER 1 WON
						return 1;
					} else {
						//PLAYER 1 WON
						return 2;
					}
				}
			}
	

			count1 = 0;
			prevPlayer11 = true;
			count2 = 0;
			prevPlayer12 = true;
		}
		
		for(int i=0; i<BOARD_SIZE; i++) {
			for(int j=0; j<BOARD_SIZE; j++) {
				if(mBoard[i][j]!=PLAYER1 && mBoard[i][j]!=PLAYER2) {
					//NO ONE HAS WON YET
					return 0;
				}
			}
		}
		//IT'S A TIE
		return 3;
	}
	
}
