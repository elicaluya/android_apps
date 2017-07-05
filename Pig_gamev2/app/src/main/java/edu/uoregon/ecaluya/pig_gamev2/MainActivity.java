package edu.uoregon.ecaluya.pig_gamev2;

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
    static final String player1Score = "player 1 score";
    int p1Score = 0;
    TextView p2_score;
    static final String player2Score = "player 2 score";
    int p2Score = 0;
    TextView player_turn;
    static final String turn = "player turn";
    int playerTurn = 0;
    TextView turn_points;
    static final String turnScore = "turn score";
    int turnPoints = 0;

    EditText p1_name;
    EditText p2_name;
    ImageView die;
    static final String dieNum = "die number";
    int die_num = 0;

    // Method for displaying the correct image according to the number given
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

    // Method for checking if there is a winner after each turn
    private void checkWinner(){
        // Checks if player 1 reached 100 first and responds accordingly after player 2's turn
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
        // Checks if player 2 reached 100 first and responds accordingly after player 1's turn
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

    // Method to change the text view in the center to display who's turn it is
    private void displayTurn(int i){
        if (i == 0)
            player_turn.setText(p1_name.getText().toString() + "'s turn");
        else
            player_turn.setText(p2_name.getText().toString()+ "'s turn");
    }

    // When saving the instance state
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt(player1Score,p1Score);
        savedInstanceState.putInt(player2Score,p2Score);
        savedInstanceState.putInt(turnScore,turnPoints);
        savedInstanceState.putInt(turn,playerTurn);
        savedInstanceState.putInt(dieNum,die_num);
        super.onSaveInstanceState(savedInstanceState);
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

        // For restoring the instance state when interrupted
        if (savedInstanceState != null){
            p1Score = savedInstanceState.getInt(player1Score);
            p1_score.setText(String.valueOf(p1Score));
            p2Score = savedInstanceState.getInt(player2Score);
            p2_score.setText(String.valueOf(p2Score));
            turnPoints = savedInstanceState.getInt(turnScore);
            turn_points.setText(String.valueOf(turnPoints));
            playerTurn = savedInstanceState.getInt(turn);
            if (playerTurn == 0)
                player_turn.setText("Player 1's turn");
            else
                player_turn.setText("Player 2's turn");
            die_num = savedInstanceState.getInt(dieNum);
            displayDie(die_num);

        }
        else {
            p1Score = Integer.parseInt(p1_score.getText().toString());
            p1_score.setText(String.valueOf(p1Score));
            p2Score = Integer.parseInt(p2_score.getText().toString());
            p2_score.setText(String.valueOf(p2Score));
            turnPoints = Integer.parseInt(turn_points.getText().toString());
            turn_points.setText(String.valueOf(turnPoints));
            playerTurn = 0;
            player_turn.setText("Player 1's turn");
            displayDie(1);
        }

        // Roll button to pick a random number and add it to the score depending on which number is rolled
        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rand = new Random();
                int point = rand.nextInt(6) + 1;
                die_num = point;
                displayDie(point);

                // If player one's turn
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
                        displayTurn(playerTurn);
                        checkWinner();
                    }
                }
                //If player two's turn
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
                        displayTurn(playerTurn);
                        checkWinner();
                    }
                }


            }
        });

        // Button for ending the turn for one player
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playerTurn == 0){
                    playerTurn = 1;
                    turnPoints = 0;
                    turn_points.setText(String.valueOf(turnPoints));
                    displayTurn(playerTurn);
                    checkWinner();
                }

                else {
                    playerTurn = 0;
                    turnPoints = 0;
                    turn_points.setText(String.valueOf(turnPoints));
                    displayTurn(playerTurn);
                    checkWinner();
                }
            }
        });

        // Button for starting a new game
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