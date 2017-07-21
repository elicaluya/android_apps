package edu.uoregon.ecaluya.sneaker_game;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;



/**
 * Created by elijahcaluya on 7/13/17.
 */

public class gameplayFragment extends Fragment{

    TextView brandName;
    String brand;
    ImageView shoeImage;
    Button nextButton;
    Button submitButton;
    Button resetButton;

    // Testing to be removed later
    EditText entry;
    TextView shoeName;


    private int missed = 0;
    TextView numWrong;
    private int correct = 0;
    TextView numCorrect;
    Boolean isWin = false;
    Boolean isLose = false;

    // List for shoes displayed
    ArrayList<Shoe> shoes = new ArrayList<Shoe>();
    Shoe currentShoe;

    // Set up game with first shoe displayed
    public void setBrandName(String name, int id){
        brandName.setText(name);
        brand = name;
        shoeImage.setImageResource(id);
        currentShoe = new Shoe(id);
        shoes.add(currentShoe);
        displayShoe(currentShoe);
    }

    // Pick next random shoe
    public void pickRandShoe(View view, int max, int[] array){
        Random rand = new Random();
        int i = rand.nextInt(max);
        int id = array[i];
        Shoe new_shoe = new Shoe(id);
        for (Shoe shoe : shoes){
            while (shoe.getModel() == new_shoe.getModel() && shoe.getColorway() == new_shoe.getColorway()){
                i = rand.nextInt(max);
                id = array[i];
                new_shoe = new Shoe(id);
            }
        }
        shoeImage.setImageResource(id);
        currentShoe = new_shoe;
        shoes.add(currentShoe);
        displayShoe(currentShoe);

        submitButton.setVisibility(View.VISIBLE);
        nextButton.setVisibility(View.GONE);
    }

    // Display shoe picked
    public void displayShoe(Shoe shoe){
        String string = shoe.getModel() + " " + shoe .getColorway();
        shoeName.setText(string);
    }

    // Submit answer to be checked and respond if game over
    public void submit(View view){
        checkAnswer();
        nextButton.setVisibility(View.VISIBLE);
        submitButton.setVisibility(View.GONE);
        if (checkEndGame()){
            if (isLose)
                startActivity(new Intent(getActivity(),lose.class));
            else if (isWin)
                startActivity(new Intent(getActivity(),win.class));
        }
    }

    // Check answer to see if correct
    public void checkAnswer(){
        String answer = entry.getText().toString();
        String name = currentShoe.getModel() + " " + currentShoe.getColorway();
        if (name.equals(answer)) {
            Toast.makeText(getActivity(),"CORRECT! "+ name,Toast.LENGTH_LONG).show();
            correct++;
            numCorrect.setText(Integer.toString(correct));
        }
        else{
            Toast.makeText(getActivity(),"WRONG! Answer: "+ name,Toast.LENGTH_LONG).show();
            missed++;
            numWrong.setText(Integer.toString(missed));
        }
    }

    // Check if game is over
    public boolean checkEndGame(){
        // If the player gets three wrong
        if (missed == 3){
            isLose = true;
            submitButton.setVisibility(View.GONE);
            nextButton.setVisibility(View.GONE);
            resetButton.setVisibility(View.VISIBLE);
            return true;
        }
        // If the player gets 10 right
        else if (correct == 10){
            isWin = true;
            submitButton.setVisibility(View.GONE);
            nextButton.setVisibility(View.GONE);
            resetButton.setVisibility(View.VISIBLE);
            return true;
        }
        return false;
    }

    // Reset Game
    public void reset(View view, int max, int[] array){
        submitButton.setVisibility(View.VISIBLE);
        nextButton.setVisibility(View.VISIBLE);
        missed = 0;
        correct = 0;
        numCorrect.setText(Integer.toString(correct));
        numWrong.setText(Integer.toString(missed));
        isLose = false;
        isWin = false;
        shoes.clear();

        Random rand = new Random();
        int i = rand.nextInt(max);
        int id = array[i];
        shoeImage.setImageResource(id);
        currentShoe = new Shoe(id);
        shoes.add(currentShoe);
        displayShoe(currentShoe);

        submitButton.setVisibility(View.VISIBLE);
        nextButton.setVisibility(View.GONE);
        resetButton.setVisibility(View.GONE);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gameplay, container, false);


        brandName = (TextView)view.findViewById(R.id.brand);
        shoeImage = (ImageView)view.findViewById(R.id.shoe_image);
        nextButton = (Button)view.findViewById(R.id.next_button);
        submitButton = (Button)view.findViewById(R.id.submit_button);
        resetButton = (Button)view.findViewById(R.id.reset_button);
        numWrong = (TextView)view.findViewById(R.id.wrong_num);
        numCorrect = (TextView)view.findViewById(R.id.correct_num);

        // Testing to be removed later
        entry = (EditText)view.findViewById(R.id.entry_text);
        shoeName = (TextView)view.findViewById(R.id.shoe_name);

        nextButton.setVisibility(View.GONE);
        resetButton.setVisibility(View.GONE);

        return view;
    }

}
