package edu.uoregon.ecaluya.sneaker_game;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;



/**
 * Created by elijahcaluya on 7/13/17.
 */

public class gameplayFragment extends Fragment{

    TextView brandName;
    String brand;
    ImageView shoeImage;
    Button nextButton;



    public void setBrandName(String name, int id){
        brandName.setText(name);
        brand = name;
        shoeImage.setImageResource(id);

    }

    public void pickRandShoe(View view, int max, int[] array){
        Random rand = new Random();
        int i = rand.nextInt(max);
        int id = array[i];
        shoeImage.setImageResource(id);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gameplay, container, false);


        brandName = (TextView)view.findViewById(R.id.brand);
        shoeImage = (ImageView)view.findViewById(R.id.shoe_image);
        nextButton = (Button)view.findViewById(R.id.next_button);

        return view;
    }

}
