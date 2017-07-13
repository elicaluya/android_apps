package edu.uoregon.ecaluya.pig_gamev3;

import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.*;
import android.view.Menu;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by elijahcaluya on 7/11/17.
 */

public class MainActivityFragment extends Fragment{

    String p1Name;
    String p2Name;

    TextView player1;
    TextView player2;

    Button btnRoll;
    Button btnEnd;
    Button btnNew;
    CheckBox less_score;
    CheckBox more_score;
    CheckBox roll_count;

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

    ImageView die;
    static final String dieNum = "die number";
    int die_num = 0;
    static final String win = "win";
    int state = 0;
    static final String winner = "winner";
    int winnerNum = 0;

    int norm_score_limit = 100;
    int less_score_limit = 50;
    int more_score_limit = 150;
    int roll_limit = 4;
    int p1MaxRolls = 40;
    TextView p1_MaxRolls;
    TextView p1_RollMax;
    int p2MaxRolls = 40;
    TextView p2_MaxRolls;
    TextView p2_RollMax;

    boolean lessScoreOn = false;
    boolean moreScoreOn = false;
    boolean rollCountOn = false;
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
            btnRoll.setVisibility(View.GONE);
            btnEnd.setVisibility(View.GONE);
        }
        else {
            btnRoll.setVisibility(View.VISIBLE);
            btnEnd.setVisibility(View.VISIBLE);
        }
    }

    // Correctly display the name of winner
    private void displayWinner(int i){
        if (i == 0){
            player_turn.setText(p1Name + " is the Winner!");
            player1.setText("WINNER");
            player2.setText("LOSER");
        } else if (i == 1){
            player_turn.setText(p2Name + " is the Winner!");
            player2.setText("WINNER");
            player1.setText("LOSER");
        }
        else
            player_turn.setText("Tie Game");
    }

    // Displays the winner and sets the win state of the game
    private void setWinState(int i){
        state = 1;
        winState(state);
        displayWinner(i);
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
            player_turn.setText(player1.getText().toString() + "'s turn");
        else
            player_turn.setText(player2.getText().toString()+ "'s turn");
    }


    // Set names for player 1 and 2 when the main activity starts
    public void setLayout(String p1_name, String p2_name, Boolean totalRoll){
        player1.setText(p1_name);
        player2.setText(p2_name);
        player_turn.setText(p1_name + "'s turn");
        p1Name = p1_name;
        p2Name = p2_name;

        if(totalRoll){
            p1_MaxRolls.setVisibility(View.VISIBLE);
            p2_MaxRolls.setVisibility(View.VISIBLE);
            p1_RollMax.setVisibility(View.VISIBLE);
            p2_RollMax.setVisibility(View.VISIBLE);
        }
        else{
            p1_MaxRolls.setVisibility(View.GONE);
            p2_MaxRolls.setVisibility(View.GONE);
            p1_RollMax.setVisibility(View.GONE);
            p2_RollMax.setVisibility(View.GONE);
        }
    }

    // Roll button method to pick a random number and add it to the score depending on which number is rolled
    public void roll_die(View view){
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
                    if (p1MaxRolls == 0){
                        turnPoints = turnPoints - 15;
                        turn_points.setText(String.valueOf(turnPoints));
                        p1MaxRolls = 40;
                    }
                }
            }
            else if (point == 1 || roll_limit == 0){
                turnPoints = 0;
                turn_points.setText(String.valueOf(turnPoints));
                playerTurn = 1;
                displayTurn(playerTurn);
                checkWinner();
                roll_limit = 4;
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
                    if (p2MaxRolls == 0) {
                        turnPoints = turnPoints - 15;
                        turn_points.setText(String.valueOf(turnPoints));
                        p2MaxRolls = 40;
                    }
                }

            }
            else if (point == 1 || roll_limit == 0){
                turnPoints = 0;
                turn_points.setText(String.valueOf(turnPoints));
                playerTurn = 0;
                displayTurn(playerTurn);
                checkWinner();
                roll_limit = 4;
            }
        }
    }

    // Set up rules based on preferences
    public void setRules(Boolean lScore, Boolean mScore, Boolean rCount, Boolean tRoll){
        if (lScore) {
            lessScoreOn = true;
            less_score.setChecked(true);
        }
        else{
            lessScoreOn = false;
            less_score.setChecked(false);
        }
        if (mScore){
            moreScoreOn = true;
            more_score.setChecked(true);
        }
        else{
            moreScoreOn = false;
            more_score.setChecked(false);
        }
        if (rCount){
            rollCountOn = true;
            roll_count.setChecked(true);
        }
        else{
            rollCountOn = false;
            roll_count.setChecked(false);
        }
        if (tRoll)
            totalRollOn = true;
        else
            totalRollOn = false;
    }


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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_main_fragment, container, false);
        setHasOptionsMenu(true);

        player1 = (TextView)view.findViewById(R.id.p1);
        player2 = (TextView)view.findViewById(R.id.p2);
        btnRoll = (Button)view.findViewById(R.id.roll);
        btnEnd = (Button)view.findViewById(R.id.end);
        btnNew = (Button)view.findViewById(R.id.new_game);
        less_score = (CheckBox)view.findViewById(R.id.less_score_box) ;
        more_score = (CheckBox)view.findViewById(R.id.more_score_box);
        roll_count = (CheckBox)view.findViewById(R.id.roll_count_box);
        p1_score = (TextView)view.findViewById(R.id.p1_score_num);
        p2_score = (TextView)view.findViewById(R.id.p2_score_num);
        player_turn = (TextView)view.findViewById(R.id.turn);
        turn_points = (TextView)view.findViewById(R.id.turn_points_num);
        die = (ImageView)view.findViewById(R.id.die_image);
        p1_MaxRolls = (TextView)view.findViewById(R.id.p1_total_roll_num);
        p2_MaxRolls = (TextView)view.findViewById(R.id.p2_total_roll_num);
        p1_RollMax = (TextView)view.findViewById(R.id.p1_total_roll);
        p2_RollMax = (TextView)view.findViewById(R.id.p2_total_roll);


        if (savedInstanceState != null){
            p1Score = savedInstanceState.getInt(player1Score);
            p1_score.setText(String.valueOf(p1Score));
            p2Score = savedInstanceState.getInt(player2Score);
            p2_score.setText(String.valueOf(p2Score));
            turnPoints = savedInstanceState.getInt(turnScore);
            turn_points.setText(String.valueOf(turnPoints));
            playerTurn = savedInstanceState.getInt(turn);
            if (playerTurn == 0)
                player_turn.setText(p1Name+ "'s turn");
            else
                player_turn.setText(p2Name + "'s turn");
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
            player_turn.setText(p1Name + "'s turn");
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
                    p1Score += turnPoints;
                    p1_score.setText(String.valueOf(p1Score));
                    turnPoints = 0;
                    turn_points.setText(String.valueOf(turnPoints));
                    displayTurn(playerTurn);
                    checkWinner();
                }

                else {
                    playerTurn = 0;
                    p2Score += turnPoints;
                    p2_score.setText(String.valueOf(p2Score));
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
                player1.setText(p1Name);
                player2.setText(p2Name);
                turn_points.setText(String.valueOf(turnPoints));
                displayDie(1);
                playerTurn = 0;
                player_turn.setText(p1Name + "'s turn");
                state = 0;
                winState(state);
                winnerNum = 0;
            }
        });

        return view;
    }
}
