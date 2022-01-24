package com.example.connect2game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // 0:yellow, 1:red, 2: empty

    int activePlayer = 0;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winningPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 4, 8}, {2, 4, 6}, {0, 3, 6}, {2, 5, 8}, {1, 4, 7}};

    public void dropIn(View view) {
       ImageView counter = (ImageView) view;
       Log.i("tag", counter.getTag().toString());
       
        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        if (gameState[tappedCounter] == 2 ) {
            gameState[tappedCounter] = activePlayer;
            counter.setTranslationY(-1500);


            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.yellow);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                activePlayer = 0;
            }
            String winner = "";
            for (int[] winningPosition : winningPositions) {
                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2) {
                    // you have won
                    if (activePlayer == 1) {
                        winner = "yellow";
                    } else {

                        winner = "red";
                    }
                }
                Toast.makeText(this, winner + " have won", Toast.LENGTH_SHORT).show();
            }
            counter.animate().translationYBy(1500).rotationBy(360).setDuration(300);
        }


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}