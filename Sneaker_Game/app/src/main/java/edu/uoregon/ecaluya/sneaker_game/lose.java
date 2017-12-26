package edu.uoregon.ecaluya.sneaker_game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by elijahcaluya on 7/19/17.
 */

public class lose extends Activity implements View.OnClickListener{

    int[] adidasShoes = {R.drawable.adidas_alphabounce_rc,R.drawable.adidas_dame3_roots,R.drawable.adidas_iniki_blkgum,R.drawable.adidas_js_batman,
            R.drawable.adidas_js_panda,R.drawable.adidas_js_zebra,R.drawable.adidas_nmdhmnrace_ff, R.drawable.adidas_nmdhmnrace_tangerine,
            R.drawable.adidas_nmdhmnracetr_bbc,R.drawable.adidas_nmdhmnracetr_chanel,R.drawable.adidas_nmdhmnracetr_multi,R.drawable.adidas_nmdhmnracetr_nerd,
            R.drawable.adidas_nmdhmnracetr_palenude,R.drawable.adidas_nmdr1_bape,R.drawable.adidas_nmdr1_datamosh,R.drawable.adidas_nmdr1_japanboost,
            R.drawable.adidas_nmdr1_linen,R.drawable.adidas_nmdr1_nicekicks,R.drawable.adidas_nmdr1_og,R.drawable.adidas_nmdr1_redapple,
            R.drawable.adidas_nmdr1_solar,R.drawable.adidas_nmdr1_stripes,R.drawable.adidas_nmdr2_cargogreen,R.drawable.adidas_pboost_jellyfish,
            R.drawable.adidas_ub1_creamchalk,R.drawable.adidas_ub1_solaryellow,R.drawable.adidas_ub1_tw,R.drawable.adidas_ub2_3m,
            R.drawable.adidas_ub2_goldmedal,R.drawable.adidas_ub2_multi,R.drawable.adidas_ub2_rc, R.drawable.adidas_ub2_wood,R.drawable.adidas_ub3_bronze,
            R.drawable.adidas_ub3_tb,R.drawable.adidas_ub3_kolor,R.drawable.adidas_ub3_pride,R.drawable.adidas_ub3_cny,R.drawable.adidas_ub3_tracecargo,
            R.drawable.adidas_ub3_oreo,R.drawable.adidas_yzy350_moonrock,R.drawable.adidas_yzy350_oxfordtan,R.drawable.adidas_yzy350_pb,
            R.drawable.adidas_yzy350_td, R.drawable.adidas_yzy350v2_beluga,R.drawable.adidas_yzy350v2_beluga2,R.drawable.adidas_yzy350v2_blkgreen,
            R.drawable.adidas_yzy350v2_blkinfrared,R.drawable.adidas_yzy350v2_blkwhite,R.drawable.adidas_yzy350v2_bluetint,R.drawable.adidas_yzy350v2_bred,
            R.drawable.adidas_yzy350v2_copper,R.drawable.adidas_yzy350v2_cream,R.drawable.adidas_yzy350v2_semifrozen,R.drawable.adidas_yzy350v2_zebra, R.drawable.adidas_yzy700_waverunner,
            R.drawable.adidas_yzy750_choco,R.drawable.adidas_yzy750_grey,R.drawable.adidas_yzy750_gum,R.drawable.adidas_yzy750_tb,R.drawable.adidas_yzypowerphase_calabasas};

    int[] jordanShoes = {R.drawable.aj1_blktoe,R.drawable.aj1_bred,R.drawable.aj1_chicago,R.drawable.aj1_goldtop3,R.drawable.aj1_newlove,R.drawable.aj1_offwhite,
            R.drawable.aj1_royal,R.drawable.aj1_sbb,R.drawable.aj1_shadow,R.drawable.aj2_chicago,R.drawable.aj2_justdon_arctic_orange,
            R.drawable.aj2_justdon_beach,R.drawable.aj2_justdon_blue,R.drawable.aj3_bc,R.drawable.aj3_grateful,R.drawable.aj3_oregon,
            R.drawable.aj3_tb,R.drawable.aj3_wc,R.drawable.aj4_bc,R.drawable.aj4_kaws,R.drawable.aj4_milblu,R.drawable.aj4_oregon,R.drawable.aj4_wc,
            R.drawable.aj5_belair,R.drawable.aj5_blkgrape,R.drawable.aj5_bm,R.drawable.aj5_firered, R.drawable.aj5_grape,R.drawable.aj5_laney,R.drawable.aj5_oregon,
            R.drawable.aj5_oreo,R.drawable.aj5_ragingbull_redsuede,R.drawable.aj5_supremedc,R.drawable.aj5_tokyo,R.drawable.aj6_blackinfrared,
            R.drawable.aj6_carmine,R.drawable.aj6_white_infrared,R.drawable.aj7_olympic,R.drawable.aj7_bordeaux,R.drawable.aj7_hare,R.drawable.aj8_aqua,
            R.drawable.aj8_bugsbunny,R.drawable.aj9_coolgrey,R.drawable.aj10_chicago,R.drawable.aj11_bred,R.drawable.aj11_concord,R.drawable.aj11_columbia,
            R.drawable.aj11_spacejam,R.drawable.aj11_winlike96,R.drawable.aj11lo_cherry,R.drawable.aj12_flugame,R.drawable.aj12_fb,
            R.drawable.aj12_taxi,R.drawable.aj13_blackcat,R.drawable.aj13_bred,R.drawable.aj13_chicago,R.drawable.aj13lo_chutney,
            R.drawable.aj14_blktoe,R.drawable.aj14_ferrari,R.drawable.aj14_lastshot};

    int[] nikeShoes = {R.drawable.nike_af1lo_offwhite,R.drawable.nike_airmag_bttf,R.drawable.nike_airpresto_lightning,R.drawable.nike_airpresto_offwhite,
            R.drawable.nike_airpresto_uncumulus,R.drawable.nike_huarache_hyperpunch,R.drawable.nike_airprestomid_acronym,R.drawable.nike_airzg_1stgame,R.drawable.nike_am1_airmaxday,
            R.drawable.nike_am1_atmos,R.drawable.nike_am1_master,R.drawable.nike_am1_safari,R.drawable.nike_am1_univred,R.drawable.nike_am90_duckcamo,R.drawable.nike_am90_doernbecher,
            R.drawable.nike_am90_infrared,R.drawable.nike_am90_japancamo,R.drawable.nike_am90_usared,R.drawable.nike_am90_moonland,R.drawable.nike_am90_offwhite,
            R.drawable.nike_am90_warhawk,R.drawable.nike_am95_neon,R.drawable.nike_am97_offwhite,R.drawable.nike_am97_silvrbullet, R.drawable.nike_amu_bulls,R.drawable.nike_blazermid_offwhite,
            R.drawable.nike_dunkhi_dls,R.drawable.nike_dunkhi_skunk,R.drawable.nike_dunkhi_supremeblue,R.drawable.nike_dunkhi_whatthe,
            R.drawable.nike_dunkhi_tiffany,R.drawable.nike_dunklo_cali,R.drawable.nike_dunklo_heineken,R.drawable.nike_dunklo_paris,R.drawable.nike_dunklo_pigeon,
            R.drawable.nike_dunklo_pinkbox,R.drawable.nike_dunklo_supremered,R.drawable.nike_flyrcr_betrue,R.drawable.nike_flyrcr_multi,R.drawable.nike_foam_galaxy,
            R.drawable.nike_foam_royal,R.drawable.nike_foam_eggplant,R.drawable.nike_foam_wutang,R.drawable.nike_kd4_galaxy,R.drawable.nike_kd6_auntpearl,R.drawable.nike_kobe9_beethoven,
            R.drawable.nike_hyperdunkflyknit_offwhite,R.drawable.nike_kobe10_sharkjaw,R.drawable.nike_kobe11_ftb,R.drawable.nike_lebron8_sb,R.drawable.nike_lebron9_galaxy,
            R.drawable.nike_lebron9lo_lebronald,R.drawable.nike_lebron11_2k14,R.drawable.nike_lebron12_whatthe,R.drawable.nike_vapormax_asphalt,R.drawable.nike_vapormax_offwhite,
            R.drawable.nike_vapormax_tb,R.drawable.nike_yeezy1_net,R.drawable.nike_yeezy2_ro,R.drawable.nike_zoomfly_offwhite};

    ArrayList<Integer> adidasIds = new ArrayList<Integer>();
    ArrayList<Integer> jordanIds = new ArrayList<Integer>();
    ArrayList<Integer> nikeIds = new ArrayList<Integer>();
    ArrayList<String> adidas_shoes = new ArrayList<String>();
    ArrayList<String> jordan_shoes = new ArrayList<String>();
    ArrayList<String> nike_shoes = new ArrayList<String>();

    TextView scoreNum;
    Button view_answers;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lose_popup);

        scoreNum = (TextView)findViewById(R.id.score_num);
        view_answers = (Button)findViewById(R.id.answers);
        score = getIntent().getExtras().getInt("scoreNum");
        scoreNum.setText(Integer.toString(score));

        // Adding all shoe information for answers
        Shoe shoe;
        for (int i = 0; i < adidasShoes.length;i++) {
            shoe = new Shoe(adidasShoes[i]);
            adidasIds.add(adidasShoes[i]);
            adidas_shoes.add(shoe.getModel() + " "+ shoe.getColorway());

        }
        for(int i = 0; i < jordanShoes.length;i++) {
            shoe = new Shoe(jordanShoes[i]);
            jordanIds.add(jordanShoes[i]);
            jordan_shoes.add(shoe.getModel() + " "+ shoe.getColorway());
        }
        for (int i = 0; i < nikeShoes.length;i++){
            shoe = new Shoe(nikeShoes[i]);
            nikeIds.add(nikeShoes[i]);
            nike_shoes.add(shoe.getModel() + " "+ shoe.getColorway());
        }

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*.7),(int)(height*.7));
    }

    @Override
    public void onClick(View v){
        if (v.getId() == R.id.answers){
            Intent intent = new Intent(this,AnswersActivity.class);
            intent.putExtra("adidas ids",adidasIds);
            intent.putExtra("jordan ids",jordanIds);
            intent.putExtra("nike ids",nikeIds);
            intent.putExtra("adidas shoes",adidas_shoes);
            intent.putExtra("jordan shoes",jordan_shoes);
            intent.putExtra("nike shoes",nike_shoes);
            startActivity(intent);
        }
    }
}
