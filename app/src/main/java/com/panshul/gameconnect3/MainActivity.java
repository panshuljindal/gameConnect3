package com.panshul.gameconnect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class xMainActivity extends AppCompatActivity {
    // 0 : red , 1 : yellow , 2 : Empty
    int activePlayer = 0;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    boolean gameActive = true;
    int[][] winningPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {1, 4, 7}, {0, 3, 6}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    public void dropIn(View view) {

        ImageView counter = (ImageView) view;
        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        if (gameState[tappedCounter] == 2 && gameActive) {
            gameState[tappedCounter] = activePlayer;
            counter.setTranslationY(-1500);
            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.red);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.yellow);
                activePlayer = 0;
            }
            counter.animate().translationYBy(1500).rotation(3600).setDuration(300);
            for (int[] winningPosition : winningPositions) {
                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2) {
                    //Someone has won
                    gameActive = false;
                    String winner = "";
                    if (activePlayer == 1) {
                        winner = "Red";
                    } else {
                        winner = "Yellow";
                    }
                    Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
                    TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);
                    winnerTextView.setText(winner + " has won");
                    winnerTextView.setVisibility(View.VISIBLE);
                    playAgainButton.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    public void playAgain(View view) {
        Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
        TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);
        playAgainButton.setVisibility(View.INVISIBLE);
        winnerTextView.setVisibility(View.INVISIBLE);
        ImageView one = (ImageView) findViewById(R.id.imageView1);
        one.setImageDrawable(null);
        ImageView two = (ImageView) findViewById(R.id.imageView2);
        two.setImageDrawable(null);
        ImageView three = (ImageView) findViewById(R.id.imageView3);
        three.setImageDrawable(null);
        ImageView four = (ImageView) findViewById(R.id.imageView4);
        four.setImageDrawable(null);
        ImageView five = (ImageView) findViewById(R.id.imageView5);
        five.setImageDrawable(null);
        ImageView six = (ImageView) findViewById(R.id.imageView6);
        six.setImageDrawable(null);
        ImageView seven = (ImageView) findViewById(R.id.imageView7);
        seven.setImageDrawable(null);
        ImageView eight = (ImageView) findViewById(R.id.imageView8);
        eight.setImageDrawable(null);
        ImageView nine = (ImageView) findViewById(R.id.imageView9);
        nine.setImageDrawable(null);
        for(int i=0;i<gameState.length;i++){
            gameState[i]=2;
        }
        gameActive = true;
        activePlayer = 0;
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
