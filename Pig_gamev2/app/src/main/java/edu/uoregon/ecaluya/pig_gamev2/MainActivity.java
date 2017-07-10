package edu.uoregon.ecaluya.pig_gamev2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
    static final String win = "win";
    int state = 0;
    static final String winner = "winner";
    int winnerNum = 0;

    SharedPreferences prefs;
    int norm_score_limit = 100;
    int less_score_limit = 50;
    int more_score_limit = 150;
    int roll_limit = 4;
    int p1MaxRolls = 50;
    TextView p1_MaxRolls;
    int p2MaxRolls = 50;
    TextView p2_MaxRolls;
    boolean lessScore = false;
    boolean lessScoreOn = false;
    boolean moreScore = false;
    boolean moreScoreOn = false;
    boolean rollCount = false;
    boolean rollCountOn = false;
    boolean totalRoll = false;
    boolean totalRollOn = false;

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

    // Determining if a game ust ended and buttons do not need to be pressed
    private void winState(int i){
        if (i == 1){
            btnRoll.setEnabled(false);
            btnEnd.setEnabled(false);
        }
        else {
            btnRoll.setEnabled(true);
            btnEnd.setEnabled(true);
        }
    }

    // Correctly display the name of winner
    private void displayWinner(int i){
        if (i == 0){
            player_turn.setText(p1_name.getText().toString() + " is the Winner!");
            player1.setText("WINNER");
            player2.setText("LOSER");
        } else if (i == 1){
            player_turn.setText(p2_name.getText().toString() + " is the Winner!");
            player2.setText("WINNER");
            player1.setText("LOSER");
        }
        else
            player_turn.setText("Tie Game");

    }

    // Displays the winner and sets the win state of the game
    private void setWinState(int i){
        displayWinner(i);
        state = 1;
        winState(state);
    }

    // Method for checking if there is a winner after each turn
    private void checkWinner(){
        int score_limit = norm_score_limit;
        if (lessScoreOn)
            score_limit = less_score_limit;
        else if (moreScoreOn)
            score_limit = more_score_limit;

        // Checks if player 1 reached score_limit first and responds accordingly after player 2's turn
        if (p1Score >= score_limit){
            if (playerTurn == 0 && p1Score > p2Score){
                winnerNum = 0;
                setWinState(winnerNum);
            }
            else if (playerTurn == 0 && p1Score < p2Score) {
                winnerNum = 1;
                setWinState(winnerNum);
            }
            else if (playerTurn == 0 && p1Score == p2Score){
                winnerNum = 2;
                setWinState(winnerNum);
            }

        }
        // Checks if player 2 reached score_limit first and responds accordingly after player 1's turn
        else if (p2Score >= score_limit){
            if (playerTurn == 1 && p2Score > p1Score){
                winnerNum = 1;
                setWinState(winnerNum);
            }
            else if (playerTurn == 1 && p1Score > p2Score) {
                winnerNum = 0;
                setWinState(winnerNum);
            }
            else if (playerTurn == 1 && p1Score == p2Score) {
                winnerNum = 2;
                setWinState(winnerNum);
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

    // Roll button method to pick a random number and add it to the score depending on which number is rolled
    public void roll(View view){
        Random rand = new Random();
        int point = rand.nextInt(6) + 1;
        die_num = point;
        displayDie(point);

        // If player one's turn
        if (playerTurn == 0){
            if (point != 1){
                turnPoints += point;
                turn_points.setText(String.valueOf(turnPoints));
                if (rollCountOn)
                    roll_limit--;
                if (totalRollOn){
                    p1MaxRolls--;
                    p1_MaxRolls.setText(String.valueOf(p1MaxRolls));
                    if (p1MaxRolls == 0)
                        btnRoll.setEnabled(false);
                }
            }
            else if (point == 1 || roll_limit == 0){
                p1Score += turnPoints;
                p1_score.setText(String.valueOf(p1Score));
                turnPoints = 0;
                turn_points.setText(String.valueOf(turnPoints));
                playerTurn = 1;
                displayTurn(playerTurn);
                checkWinner();
                roll_limit = 4;
                btnRoll.setEnabled(true);
            }
        }
        //If player two's turn
        else{
            if (point != 1){
                turnPoints += point;
                turn_points.setText(String.valueOf(turnPoints));
                if (rollCountOn)
                    roll_limit--;
                if (totalRollOn){
                    p2MaxRolls--;
                    p2_MaxRolls.setText(String.valueOf(p2MaxRolls));
                    if (p2MaxRolls == 0)
                        btnRoll.setEnabled(false);
                }

            }
            else if (point == 1 || roll_limit == 0){
                p2Score += turnPoints;
                p2_score.setText(String.valueOf(p2Score));
                turnPoints = 0;
                turn_points.setText(String.valueOf(turnPoints));
                playerTurn = 0;
                displayTurn(playerTurn);
                checkWinner();
                roll_limit = 4;
                btnRoll.setEnabled(true);
            }
        }
    }

    // Display Menu in action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    // Actions for items in the menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_settings:
                startActivity(new Intent(getApplicationContext(),SettingsActivity.class));
                return true;
            case R.id.menu_about:
                Toast.makeText(this, "Pig Game v2 by Elijah Caluya",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onResume(){
        super.onResume();

        lessScore = prefs.getBoolean(getResources().getString(R.string.less_score),true);
        if (lessScore)
            lessScoreOn = true;
        else
            lessScoreOn = false;

        moreScore = prefs.getBoolean(getResources().getString(R.string.more_score),true);
        if(moreScore)
            moreScoreOn = true;
        else
            moreScoreOn = false;

        rollCount = prefs.getBoolean(getResources().getString(R.string.roll_count),true);
        if (rollCount)
            rollCountOn = true;
        else
            rollCountOn = false;

        totalRoll = prefs.getBoolean(getResources().getString(R.string.total_roll),true);
        if (totalRoll)
            totalRollOn = true;
        else
            totalRollOn = false;
    }

    // When saving the instance state
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt(player1Score,p1Score);
        savedInstanceState.putInt(player2Score,p2Score);
        savedInstanceState.putInt(turnScore,turnPoints);
        savedInstanceState.putInt(turn,playerTurn);
        savedInstanceState.putInt(dieNum,die_num);
        savedInstanceState.putInt(win,state);
        savedInstanceState.putInt(winner,winnerNum);
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
        p1_MaxRolls = (TextView)findViewById(R.id.p1_total_roll_num);
        p2_MaxRolls = (TextView)findViewById(R.id.p2_total_roll_num);

        // Starting player's turn
        player_turn.setText("Player 1's turn");

        PreferenceManager.setDefaultValues(this,R.xml.preferences,false);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);

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
            state = savedInstanceState.getInt(win);
            winState(state);
            winnerNum = savedInstanceState.getInt(winner);
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
            state = 0;
            winState(state);
            winnerNum = 0;
        }

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
                state = 0;
                winState(state);
                winnerNum = 0;
            }
        });

    }
}