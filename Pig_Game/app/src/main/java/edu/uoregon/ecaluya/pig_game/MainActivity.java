package edu.uoregon.ecaluya.pig_game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    Button btnRoll;
    Button btnEnd;
    Button btnNew;

    TextView player1;
    TextView player2;
    TextView p1_score;
    int p1Score = 0;
    TextView p2_score;
    int p2Score = 0;
    TextView player_turn;
    int playerTurn = 0;
    TextView turn_points;
    int turnPoints = 0;

    EditText p1_name;
    EditText p2_name;
    ImageView die;

    private void displayDie(int i){
        int id = 0;
        if (i == 1)
            id = R.drawable.die1;
        else if (i == 2)
            id = R.drawable.die2;
        else if (i == 3)
            id = R.drawable.die3;
        else if (i == 4)
            id = R.drawable.die4;
        else if (i == 5)
            id = R.drawable.die5;
        else if (i == 6)
            id = R.drawable.die6;

        die.setImageResource(id);
    }

    private void checkWinner(){
        if (p1Score >= 100){
            if (playerTurn == 0 && p1Score > p2Score){
                player_turn.setText(p1_name.getText().toString() + " is the Winner!");
                player1.setText("WINNER");
                player2.setText("LOSER");
                btnRoll.setEnabled(false);
                btnEnd.setEnabled(false);
            }

            else if (playerTurn == 0 && p1Score < p2Score) {
                player_turn.setText(p2_name.getText().toString() + " is the Winner!");
                player2.setText("WINNER");
                player1.setText("LOSER");
                btnRoll.setEnabled(false);
                btnEnd.setEnabled(false);
            }
            else if (playerTurn == 0 && p1Score == p2Score){
                player_turn.setText("Tie Game");
                btnRoll.setEnabled(false);
                btnEnd.setEnabled(false);
            }

        }
        else if (p2Score >= 100){
            if (playerTurn == 1 && p2Score > p1Score){
                player_turn.setText(p2_name.getText().toString() + " is the Winner!");
                player2.setText("WINNER");
                player1.setText("LOSER");
                btnRoll.setEnabled(false);
                btnEnd.setEnabled(false);
            }

            else if (playerTurn == 1 && p1Score < p2Score) {
                player_turn.setText(p1_name.getText().toString() + " is the Winner!");
                player1.setText("WINNER");
                player2.setText("LOSER");
                btnRoll.setEnabled(false);
                btnEnd.setEnabled(false);
            }
            else if (playerTurn == 1 && p1Score == p2Score) {
                player_turn.setText("Tie Game");
                btnRoll.setEnabled(false);
                btnEnd.setEnabled(false);
            }
        }
    }

    private void displayTurn(){
        if (playerTurn == 0)
            player_turn.setText(p1_name.getText().toString() + "'s turn");
        else
            player_turn.setText(p2_name.getText().toString()+ "'s turn");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRoll = (Button)findViewById(R.id.roll);
        btnEnd = (Button)findViewById(R.id.end);
        btnNew = (Button)findViewById(R.id.new_game);

        player1 = (TextView)findViewById(R.id.p1);
        player2 = (TextView)findViewById(R.id.p2);

        p1_score = (TextView)findViewById(R.id.p1_score_num);
        p2_score = (TextView)findViewById(R.id.p2_score_num);
        player_turn = (TextView)findViewById(R.id.turn);
        turn_points = (TextView)findViewById(R.id.turn_points_num);

        p1_name = (EditText)findViewById(R.id.p1_name);
        p2_name = (EditText)findViewById(R.id.p2_name);

        die = (ImageView)findViewById(R.id.die_image);

        player_turn.setText("Player 1's turn");

        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rand = new Random();
                int point = rand.nextInt(6) + 1;
                displayDie(point);

                if (playerTurn == 0){
                    if (point != 1){
                        turnPoints += point;
                        turn_points.setText(String.valueOf(turnPoints));
                    }
                    else{
                        p1Score += turnPoints;
                        p1_score.setText(String.valueOf(p1Score));
                        turnPoints = 0;
                        turn_points.setText(String.valueOf(turnPoints));
                        playerTurn = 1;
                        displayTurn();
                        checkWinner();
                    }
                }
                else{
                    if (point != 1){
                        turnPoints += point;
                        turn_points.setText(String.valueOf(turnPoints));
                    }
                    else{
                        p2Score += turnPoints;
                        p2_score.setText(String.valueOf(p2Score));
                        turnPoints = 0;
                        turn_points.setText(String.valueOf(turnPoints));
                        playerTurn = 0;
                        displayTurn();
                        checkWinner();
                    }
                }


            }
        });

        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playerTurn == 0){
                    playerTurn = 1;
                    turnPoints = 0;
                    turn_points.setText(String.valueOf(turnPoints));
                    displayTurn();
                    checkWinner();
                }

                else {
                    playerTurn = 0;
                    turnPoints = 0;
                    turn_points.setText(String.valueOf(turnPoints));
                    displayTurn();
                    checkWinner();
                }
            }
        });

        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p1Score = 0;
                p2Score = 0;
                turnPoints = 0;
                p1_score.setText(String.valueOf(p1Score));
                p2_score.setText(String.valueOf(p2Score));
                player1.setText("Player 1");
                player2.setText("Player 2");
                turn_points.setText(String.valueOf(turnPoints));
                displayDie(1);
                playerTurn = 0;
                player_turn.setText("Player 1's turn");
                btnRoll.setEnabled(true);
                btnEnd.setEnabled(true);
            }
        });

    }
}