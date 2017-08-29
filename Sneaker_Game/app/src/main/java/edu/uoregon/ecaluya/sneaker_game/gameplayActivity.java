package edu.uoregon.ecaluya.sneaker_game;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by elijahcaluya on 7/12/17.
 */

public class gameplayActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    int max_elements;
    int[] brand_array;

    TextView brandName;
    String brand;
    ImageView shoeImage;
    Button nextButton;
    Button submitButton;
    Button resetButton;
    ImageView incorrectImage;
    ImageView correctImage;

    // Widgets for choosing the answer
    RadioGroup radioGroup;
    RadioButton choiceA;
    RadioButton choiceB;
    RadioButton choiceC;
    Spinner colorwaySpinner;

    // Choice selected
    String modelChoice = null;
    String colorwayChoice = null;
    String[] colorwayChoices = new String[3];


    // Statistical fields
    private int missed = 0;
    TextView numWrong;
    private int correct = 0;
    TextView numCorrect;
    Boolean isWin = false;
    Boolean isLose = false;
    int scoreLimit = 0;
    int strikes = 0;
    boolean isLowLimit = false;
    boolean isHighLimit = false;
    boolean isNormalLimit = false;
    boolean isEasyMode = false;
    boolean isHardMode = false;
    boolean isNormalMode = false;
    int lowScore = 7;
    int normScore = 10;
    int highScore = 15;
    int easyMode = 5;
    int hardMode = 1;
    int normMode = 3;

    // List for shoes displayed
    ArrayList<Integer> shoes = new ArrayList<Integer>();
    Shoe currentShoe;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameplay);

        // Intent information
        brand = getIntent().getExtras().getString("brand_name");
        int id = getIntent().getExtras().getInt("id");
        brand_array = getIntent().getExtras().getIntArray("array");
        max_elements = getIntent().getExtras().getInt("array_max");
        isLowLimit = getIntent().getExtras().getBoolean("lowLimit");
        isHighLimit = getIntent().getExtras().getBoolean("highLimit");
        isNormalLimit = getIntent().getExtras().getBoolean("normalLimit");
        isEasyMode = getIntent().getExtras().getBoolean("easyMode");
        isHardMode = getIntent().getExtras().getBoolean("hardMode");
        isNormalMode = getIntent().getExtras().getBoolean("normalMode");

        // Widgets for buttons and pictures
        brandName = (TextView)findViewById(R.id.brand);
        shoeImage = (ImageView)findViewById(R.id.shoe_image);
        nextButton = (Button)findViewById(R.id.next_button);
        submitButton = (Button)findViewById(R.id.submit_button);
        resetButton = (Button)findViewById(R.id.reset_button);

        // Status widgets
        numWrong = (TextView)findViewById(R.id.wrong_num);
        numCorrect = (TextView)findViewById(R.id.correct_num);
        incorrectImage = (ImageView) findViewById(R.id.incorrect_image);
        correctImage = (ImageView) findViewById(R.id.correct_image);

        // For choosing the answer
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        choiceA = (RadioButton)findViewById(R.id.choice_a);
        choiceB = (RadioButton)findViewById(R.id.choice_b);
        choiceC = (RadioButton)findViewById(R.id.choice_c);
        colorwaySpinner = (Spinner)findViewById(R.id.colorway_spinner);
        colorwaySpinner.setOnItemSelectedListener(this);

        incorrectImage.setVisibility(View.GONE);
        correctImage.setVisibility(View.GONE);
        nextButton.setVisibility(View.GONE);

        choiceA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modelChoice = choiceA.getText().toString();
            }
        });
        choiceB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modelChoice = choiceB.getText().toString();
            }
        });
        choiceC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modelChoice = choiceC.getText().toString();
            }
        });

        setUpGame(brand,id);
    }

    // Adapter for spinner if item selected
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                colorwayChoice = colorwayChoices[0];
                break;
            case 1:
                colorwayChoice = colorwayChoices[1];
                break;
            case 2:
                colorwayChoice = colorwayChoices[2];
                break;
        }
    }

    // Adapter for spinner if not selected
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        colorwayChoice = colorwayChoices[0];
    }

    // Set up game based on intent information
    public void setUpGame(String name, int id){
        brandName.setText(name);
        shoeImage.setImageResource(id);
        currentShoe = new Shoe(id);
        shoes.add(id);
        populateModelChoices(currentShoe);
        colorwayChoices = populateColorwayChoices(currentShoe);
        if (isNormalMode)
            strikes = 3;
        else if (isEasyMode)
            strikes = 5;
        else if (isHardMode)
            strikes = 1;
        if (isNormalLimit)
            scoreLimit = 10;
        else if (isHighLimit)
            scoreLimit = 15;
        else if (isLowLimit)
            scoreLimit = 7;
        numCorrect.setText(Integer.toString(correct) + "/"+Integer.toString(scoreLimit));
        numWrong.setText(Integer.toString(missed)+"/"+Integer.toString(strikes));
    }

    // Get next shoe
    public void nextShoe(View v){
        Random rand = new Random();
        int i = rand.nextInt(max_elements);
        int id = brand_array[i];

        while (shoes.contains(id)) {
            i = rand.nextInt(max_elements);
            id = brand_array[i];
        }
        shoeImage.setImageResource(id);
        currentShoe = new Shoe(id);
        shoes.add(id);
        populateModelChoices(currentShoe);
        radioGroup.clearCheck();
        colorwayChoices = populateColorwayChoices(currentShoe);
        submitButton.setVisibility(View.VISIBLE);
        nextButton.setVisibility(View.GONE);
        incorrectImage.setVisibility(View.GONE);
        correctImage.setVisibility(View.GONE);
    }

    // Submit answer
    public void submitAnswer(View v){
        checkAnswer();
        nextButton.setVisibility(View.VISIBLE);
        submitButton.setVisibility(View.GONE);
        if (checkEndGame()){
            if (isLose){
                Intent intent = new Intent(this, lose.class);
                intent.putExtra("scoreNum",correct);
                startActivity(intent);
            }

            else if (isWin) {
                Intent intent = new Intent(this,win.class);
                intent.putExtra("scoreNum",correct);
                startActivity(intent);
            }
        }
    }
    // Reset the game
    public void resetGame(View v){
        submitButton.setVisibility(View.VISIBLE);
        nextButton.setVisibility(View.VISIBLE);
        missed = 0;
        correct = 0;
        numCorrect.setText(Integer.toString(correct) + "/"+Integer.toString(scoreLimit));
        numWrong.setText(Integer.toString(missed)+"/"+Integer.toString(strikes));
        isLose = false;
        isWin = false;
        shoes.clear();

        Random rand = new Random();
        int i = rand.nextInt(max_elements);
        int id = brand_array[i];
        shoeImage.setImageResource(id);
        currentShoe = new Shoe(id);
        shoes.add(id);
        populateModelChoices(currentShoe);
        radioGroup.clearCheck();
        colorwayChoices = populateColorwayChoices(currentShoe);

        submitButton.setVisibility(View.VISIBLE);
        nextButton.setVisibility(View.GONE);
        correctImage.setVisibility(View.GONE);
        incorrectImage.setVisibility(View.GONE);
    }

    // Setting the radio buttons up for the correct answer and wrong answers
    public void populateModelChoices(Shoe shoe){
        Random rand = new Random();
        String answer = shoe.getModel();
        int i = rand.nextInt(3);
        String[] wrongModels = getWrongChoices(shoe,shoe.getBrandModels(),true);
        if (i == 0) {
            choiceA.setText(answer);
            choiceB.setText(wrongModels[0]);
            choiceC.setText(wrongModels[1]);
        }
        else if (i == 1) {
            choiceA.setText(wrongModels[0]);
            choiceB.setText(answer);
            choiceC.setText(wrongModels[1]);
        }
        else if (i == 2) {
            choiceA.setText(wrongModels[0]);
            choiceB.setText(wrongModels[1]);
            choiceC.setText(answer);
        }
    }

    // populate choices for colorways
    public String[] populateColorwayChoices(Shoe shoe){
        Random rand = new Random();
        String answer = shoe.getColorway();
        String[] choices = new String[3];
        int i = rand.nextInt(3);
        String[] wrongColorways = getWrongChoices(shoe,shoe.getBrandColorways(),false);
        if (i == 0){
            choices[0] = answer;
            choices[1] = wrongColorways[0];
            choices[2] = wrongColorways[1];
        }
        else if (i == 1){
            choices[0] = wrongColorways[0];
            choices[1] = answer;
            choices[2] = wrongColorways[1];
        }
        else if (i == 2){
            choices[0] = wrongColorways[0];
            choices[1] = wrongColorways[1];
            choices[2] = answer;
        }
        colorwaySpinner.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,choices));
        return choices;
    }

    // Get wrong choices for models or colorways
    public String[] getWrongChoices(Shoe shoe,String[] array, Boolean isModel){
        Random rand = new Random();
        int i;
        String[] choices = new String[2];
        ArrayList<String> list = new ArrayList<String>();

        for (i = 0; i < array.length-1;i++){
            if (isModel) {
                if (shoe.getModel() != array[i])
                    list.add(array[i]);
            } else {
                if (shoe.getColorway() != array[i])
                    list.add(array[i]);
            }
        }
        Collections.shuffle(list);
        for (i = 0; i < 2; i++){
            choices[i] = list.get(i);
        }
        list.clear();
        return choices;
    }

    // Check answer to see if correct
    public void checkAnswer(){
        if (modelChoice == null)
            modelChoice = "";
        if (modelChoice.equals(currentShoe.getModel()) && colorwayChoice.equals(currentShoe.getColorway())) {
            Toast.makeText(this,"CORRECT! "+ modelChoice + " " + colorwayChoice,
                    Toast.LENGTH_LONG).show();
            correct++;
            numCorrect.setText(Integer.toString(correct) +"/"+Integer.toString(scoreLimit));
            correctImage.setVisibility(View.VISIBLE);
        }
        else{
            Toast.makeText(this,"WRONG! Answer: "+ currentShoe.getModel() + " " + currentShoe.getColorway(),
                    Toast.LENGTH_LONG).show();
            missed++;
            numWrong.setText(Integer.toString(missed) +"/"+Integer.toString(strikes));
            incorrectImage.setVisibility(View.VISIBLE);
        }
    }

    // Check if game is over
    public boolean checkEndGame(){
        // If the player misses the strike limit
        int score_limit = normScore;
        if (isLowLimit)
            score_limit = lowScore;
        else if (isHighLimit)
            score_limit = highScore;
        int num_strikes = normMode;
        if (isEasyMode)
            num_strikes = easyMode;
        else if (isHardMode)
            num_strikes = hardMode;

        if (missed == num_strikes){
            isLose = true;
            submitButton.setVisibility(View.GONE);
            nextButton.setVisibility(View.GONE);
            resetButton.setVisibility(View.VISIBLE);
            return true;
        }
        // If the player reaches the score limit
        else if (correct == score_limit){
            isWin = true;
            submitButton.setVisibility(View.GONE);
            nextButton.setVisibility(View.GONE);
            resetButton.setVisibility(View.VISIBLE);
            return true;
        }
        return false;
    }
}
