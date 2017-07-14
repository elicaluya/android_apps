package edu.uoregon.ecaluya.sneaker_game;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.Random;

/**
 * Created by elijahcaluya on 7/13/17.
 */

public class MainMenuFragment extends Fragment implements OnClickListener {

    int[] adidasShoes = {R.drawable.adidas_nmdhmnrace_ff, R.drawable.adidas_nmdr1_og, R.drawable.adidas_nmdr2_cargogreen,
            R.drawable.adidas_ub1_tw, R.drawable.adidas_ub2_multi, R.drawable.adidas_ub2_rc, R.drawable.adidas_ub2_tb,
            R.drawable.adidas_ub3_cny, R.drawable.adidas_ub3_oreo,R.drawable.adidas_yzy350_moonrock, R.drawable.adidas_yzy350_oxfordtan,
            R.drawable.adidas_yzy350_pb, R.drawable.adidas_yzy350_td, R.drawable.adidas_yzy350v2_beluga,R.drawable.adidas_yzy350v2_blkgreen,
            R.drawable.adidas_yzy350v2_blkinfrared,R.drawable.adidas_yzy350v2_bred,R.drawable.adidas_yzy350v2_cream,
            R.drawable.adidas_yzy350v2_zebra,R.drawable.adidas_yzy750_grey,R.drawable.adidas_yzy750_gum,R.drawable.adidas_yzypowerphase_calabasas};

    int[] jordanShoes = {R.drawable.aj1_bred,R.drawable.aj1_chicago,R.drawable.aj1_royal,R.drawable.aj2_chicago,R.drawable.aj3_bc,
            R.drawable.aj3_tb,R.drawable.aj3_wc,R.drawable.aj4_bc,R.drawable.aj4_wc,R.drawable.aj5_bm,R.drawable.aj5_firered,
            R.drawable.aj6_blackinfrared,R.drawable.aj6_carmine,R.drawable.aj7_olympic,R.drawable.aj8_aqua,R.drawable.aj9_coolgrey,
            R.drawable.aj10_chicago,R.drawable.aj11_bred,R.drawable.aj11_concord,R.drawable.aj11_spacejam,R.drawable.aj12_flugame,
            R.drawable.aj13_bred,R.drawable.aj14_lastshot};

    int[] nikeShoes = {R.drawable.nike_am1_atmos,R.drawable.nike_am1_univred,R.drawable.nike_am90_duckcamo,R.drawable.nike_am90_infrared,
            R.drawable.nike_am95_neon,R.drawable.nike_dunkhi_supremeblue,R.drawable.nike_dunkhi_tiffany,R.drawable.nike_dunklo_cali,
            R.drawable.nike_dunklo_heineken,R.drawable.nike_dunklo_paris,R.drawable.nike_dunklo_pigeon,R.drawable.nike_dunklo_supremered,
            R.drawable.nike_foam_galaxy,R.drawable.nike_foam_royal,R.drawable.nike_kd4_galaxy,R.drawable.nike_kd6_auntpearl,
            R.drawable.nike_kobe9_beethoven,R.drawable.nike_kobe11_ftb,R.drawable.nike_lebron8_sb,R.drawable.nike_lebron9_galaxy,
            R.drawable.nike_vapormax_asphalt,R.drawable.nike_vapormax_tb,R.drawable.nike_yeezy1_net,R.drawable.nike_yeezy2_ro};

    public int getRandShoe(int x, int[] array){
        Random rand = new Random();
        int i;
        int id = 0;
        i = rand.nextInt(x);
        id = array[i];

        return id;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_main_menu,container,false);

        ImageButton adidasButton = (ImageButton)view.findViewById(R.id.adidas_button);
        ImageButton ajButton = (ImageButton)view.findViewById(R.id.aj_button);
        ImageButton nikeButton = (ImageButton)view.findViewById(R.id.nike_button);
        adidasButton.setOnClickListener(this);
        ajButton.setOnClickListener(this);
        nikeButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v){
        if (v.getId() == R.id.adidas_button){
            String adidas = "Adidas";
            int id = getRandShoe(21,adidasShoes);
            Intent intent = new Intent(getActivity(),gameplayActivity.class);
            intent.putExtra("brand_name",adidas);
            intent.putExtra("id",id);
            intent.putExtra("array",adidasShoes);
            intent.putExtra("array_max",21);
            startActivity(intent);
        }
        else if (v.getId() == R.id.aj_button){
            String aj = "Air Jordan";
            int id = getRandShoe(22,jordanShoes);
            Intent intent = new Intent(getActivity(),gameplayActivity.class);
            intent.putExtra("brand_name",aj);
            intent.putExtra("id",id);
            intent.putExtra("array",jordanShoes);
            intent.putExtra("array_max",22);
            startActivity(intent);
        }
        else if (v.getId() == R.id.nike_button){
            String nike = "Nike";
            int id = getRandShoe(23,nikeShoes);
            Intent intent = new Intent(getActivity(),gameplayActivity.class);
            intent.putExtra("brand_name",nike);
            intent.putExtra("id",id);
            intent.putExtra("array",nikeShoes);
            intent.putExtra("array_max",23);
            startActivity(intent);
        }
    }
}
