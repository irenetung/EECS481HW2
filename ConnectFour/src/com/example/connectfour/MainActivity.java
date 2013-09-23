package com.example.connectfour;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private ConnectFourGame mGame;
	
	private Button mBoardButtons[][];
	
	private TextView mInfoTextView;
	private TextView mPlayer1Count;
	private TextView mTieCount;
	private TextView mPlayer2Count;
	
	private int mPlayer1Counter = 0;
	private int mTieCounter = 0;
	private int mPlayer2Counter = 0;
	
	private boolean mPlayer1First = true;
	private boolean mPlayer1Turn = true;
	private boolean mGameOver = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mBoardButtons = new Button[mGame.getBOARD_SIZE()][mGame.getBOARD_SIZE()];
		mBoardButtons[0][0] = (Button) findViewById(R.id.zero0);
		mBoardButtons[1][0] = (Button) findViewById(R.id.one0);
		mBoardButtons[2][0] = (Button) findViewById(R.id.two0);
		mBoardButtons[3][0] = (Button) findViewById(R.id.three0);
		mBoardButtons[4][0] = (Button) findViewById(R.id.four0);
		mBoardButtons[5][0] = (Button) findViewById(R.id.five0);
		mBoardButtons[6][0] = (Button) findViewById(R.id.six0);
		
		mBoardButtons[0][1] = (Button) findViewById(R.id.zero1);
		mBoardButtons[1][1] = (Button) findViewById(R.id.one1);
		mBoardButtons[2][1] = (Button) findViewById(R.id.two1);
		mBoardButtons[3][1] = (Button) findViewById(R.id.three1);
		mBoardButtons[4][1] = (Button) findViewById(R.id.four1);
		mBoardButtons[5][1] = (Button) findViewById(R.id.five1);
		mBoardButtons[6][1] = (Button) findViewById(R.id.six1);
		
		mBoardButtons[0][2] = (Button) findViewById(R.id.zero2);
		mBoardButtons[1][2] = (Button) findViewById(R.id.one2);
		mBoardButtons[2][2] = (Button) findViewById(R.id.two2);
		mBoardButtons[3][2] = (Button) findViewById(R.id.three2);
		mBoardButtons[4][2] = (Button) findViewById(R.id.four2);
		mBoardButtons[5][2] = (Button) findViewById(R.id.five2);
		mBoardButtons[6][2] = (Button) findViewById(R.id.six2);
		
		mBoardButtons[0][3] = (Button) findViewById(R.id.zero3);
		mBoardButtons[1][3] = (Button) findViewById(R.id.one3);
		mBoardButtons[2][3] = (Button) findViewById(R.id.two3);
		mBoardButtons[3][3] = (Button) findViewById(R.id.three3);
		mBoardButtons[4][3] = (Button) findViewById(R.id.four3);
		mBoardButtons[5][3] = (Button) findViewById(R.id.five3);
		mBoardButtons[6][3] = (Button) findViewById(R.id.six3);
		
		mBoardButtons[0][4] = (Button) findViewById(R.id.zero4);
		mBoardButtons[1][4] = (Button) findViewById(R.id.one4);
		mBoardButtons[2][4] = (Button) findViewById(R.id.two4);
		mBoardButtons[3][4] = (Button) findViewById(R.id.three4);
		mBoardButtons[4][4] = (Button) findViewById(R.id.four4);
		mBoardButtons[5][4] = (Button) findViewById(R.id.five4);
		mBoardButtons[6][4] = (Button) findViewById(R.id.six4);
		
		mBoardButtons[0][5] = (Button) findViewById(R.id.zero5);
		mBoardButtons[1][5] = (Button) findViewById(R.id.one5);
		mBoardButtons[2][5] = (Button) findViewById(R.id.two5);
		mBoardButtons[3][5] = (Button) findViewById(R.id.three5);
		mBoardButtons[4][5] = (Button) findViewById(R.id.four5);
		mBoardButtons[5][5] = (Button) findViewById(R.id.five5);
		mBoardButtons[6][5] = (Button) findViewById(R.id.six5);
		
		mBoardButtons[0][6] = (Button) findViewById(R.id.zero6);
		mBoardButtons[1][6] = (Button) findViewById(R.id.one6);
		mBoardButtons[2][6] = (Button) findViewById(R.id.two6);
		mBoardButtons[3][6] = (Button) findViewById(R.id.three6);
		mBoardButtons[4][6] = (Button) findViewById(R.id.four6);
		mBoardButtons[5][6] = (Button) findViewById(R.id.five6);
		mBoardButtons[6][6] = (Button) findViewById(R.id.six6);
		
		
		mInfoTextView = (TextView) findViewById(R.id.information);
		mPlayer1Count = (TextView) findViewById(R.id.player1Count);
		mTieCount = (TextView) findViewById(R.id.tieCount);
		mPlayer2Count = (TextView) findViewById(R.id.player2Count);
		
		mPlayer1Count.setText(Integer.toString(mPlayer1Counter));
		mTieCount.setText(Integer.toString(mTieCounter));
		mPlayer2Count.setText(Integer.toString(mPlayer2Counter));
		
		mGame = new ConnectFourGame();
		
		startNewGame();
	}

	private void startNewGame() {
		mGameOver = false;
		mGame.clearBoard();
		for(int i=0; i<mBoardButtons.length; i++) {
			for(int j=0; j<mBoardButtons.length; j++) {
				mBoardButtons[i][j].setText("");
				mBoardButtons[i][j].setEnabled(false);
				mBoardButtons[i][j].setOnClickListener(new ButtonClickListener(i, j));
				if(j==mBoardButtons.length-1) {
					//enable only bottom row of buttons
					mBoardButtons[i][j].setEnabled(true);
				}
			}
		}
		
		if(mPlayer1First) {
			mInfoTextView.setText(R.string.first_player_one);
			mPlayer1First = false;
			mPlayer1Turn = true;
		} else {
			mInfoTextView.setText(R.string.first_player_two);
			mPlayer1First = true;
			mPlayer1Turn = false;
		}
	}
	
	private class ButtonClickListener implements View.OnClickListener {
		int locationx, locationy;
		public ButtonClickListener(int locationx, int locationy) {
			this.locationx = locationx;
			this.locationy = locationy;
		}
		public void onClick(View view) {
			if(!mGameOver) {
				if(mBoardButtons[locationx][locationy].isEnabled()) {
					if(mPlayer1Turn) {
						setMove(mGame.PLAYER1, locationx, locationy);
					} else {
						setMove(mGame.PLAYER2, locationx, locationy);
					}
					
					mPlayer1Turn = !mPlayer1Turn;
					int winner = mGame.checkForWinner();
					
					if(winner == 0) {
						if(mPlayer1Turn) {
							mInfoTextView.setText(R.string.turn_player_one);
						} else {
							mInfoTextView.setText(R.string.turn_player_two);
						}
					} else if (winner == 3) {
						mInfoTextView.setText(R.string.result_tie);
						mTieCounter++;
						mTieCount.setText(Integer.toString(mTieCounter));
						mGameOver = true;
					} else if (winner == 1) {
						mInfoTextView.setText(R.string.result_player_one_wins);
						mPlayer1Counter++;
						mPlayer1Count.setText(Integer.toString(mPlayer1Counter));
						mGameOver = true;
					} else if(winner == 2) {
						mInfoTextView.setText(R.string.result_player_two_wins);
						mPlayer2Counter++;
						mPlayer2Count.setText(Integer.toString(mPlayer2Counter));
						mGameOver = true;
					}
				}
			}
		}
	};
	
	private void setMove(char player, int locationx, int locationy) {
		mGame.setMove(player, locationx, locationy);
		mBoardButtons[locationx][locationy].setEnabled(false);
		if(locationy > 0) {
			mBoardButtons[locationx][locationy-1].setEnabled(true);
		}
		mBoardButtons[locationx][locationy].setText(String.valueOf(player));
		if(player == mGame.PLAYER1) {
			mBoardButtons[locationx][locationy].setTextColor(Color.YELLOW);
		} else {
			mBoardButtons[locationx][locationy].setTextColor(Color.RED);
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.game_menu, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
		case R.id.newGame:
			startNewGame();
			break;
		case R.id.exitGame:
			MainActivity.this.finish();
			break;
		}
		return true;
		
	}

}
