package edu.uoregon.ecaluya.sneaker_game;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Random;

public class MainMenu extends AppCompatActivity implements View.OnClickListener {

    int[] adidasShoes = {R.drawable.adidas_alphabounce_rc,R.drawable.adidas_dame3_roots,R.drawable.adidas_iniki_blkgum,R.drawable.adidas_js_batman,
            R.drawable.adidas_js_panda,R.drawable.adidas_js_zebra,R.drawable.adidas_nmdhmnrace_ff, R.drawable.adidas_nmdhmnrace_tangerine,
            R.drawable.adidas_nmdr1_bape,R.drawable.adidas_nmdr1_datamosh,R.drawable.adidas_nmdr1_linen,R.drawable.adidas_nmdr1_nicekicks,
            R.drawable.adidas_nmdr1_og,R.drawable.adidas_nmdr1_redapple, R.drawable.adidas_nmdr1_solar,R.drawable.adidas_nmdr1_stripes,
            R.drawable.adidas_nmdr2_cargogreen,R.drawable.adidas_pboost_jellyfish,R.drawable.adidas_ub1_creamchalk,R.drawable.adidas_ub1_solaryellow,
            R.drawable.adidas_ub1_tw,R.drawable.adidas_ub2_3m,R.drawable.adidas_ub2_goldmedal,R.drawable.adidas_ub2_multi,
            R.drawable.adidas_ub2_rc, R.drawable.adidas_ub2_wood,R.drawable.adidas_ub3_bronze,R.drawable.adidas_ub3_tb,R.drawable.adidas_ub3_kolor,
            R.drawable.adidas_ub3_pride,R.drawable.adidas_ub3_cny,R.drawable.adidas_ub3_tracecargo,R.drawable.adidas_ub3_oreo,R.drawable.adidas_yzy350_moonrock,
            R.drawable.adidas_yzy350_oxfordtan,R.drawable.adidas_yzy350_pb, R.drawable.adidas_yzy350_td, R.drawable.adidas_yzy350v2_beluga,
            R.drawable.adidas_yzy350v2_blkgreen,R.drawable.adidas_yzy350v2_blkinfrared,R.drawable.adidas_yzy350v2_blkwhite,R.drawable.adidas_yzy350v2_bred,
            R.drawable.adidas_yzy350v2_copper,R.drawable.adidas_yzy350v2_cream,R.drawable.adidas_yzy350v2_zebra,R.drawable.adidas_yzy750_choco,
            R.drawable.adidas_yzy750_grey,R.drawable.adidas_yzy750_gum,R.drawable.adidas_yzy750_tb,R.drawable.adidas_yzypowerphase_calabasas};

    int[] jordanShoes = {R.drawable.aj1_blktoe,R.drawable.aj1_bred,R.drawable.aj1_chicago,R.drawable.aj1_newlove,R.drawable.aj1_royal,R.drawable.aj2_chicago,
            R.drawable.aj2_justdon_arctic_orange,R.drawable.aj2_justdon_beach,R.drawable.aj2_justdon_blue,R.drawable.aj3_bc,
            R.drawable.aj3_tb,R.drawable.aj3_wc,R.drawable.aj4_bc,R.drawable.aj4_kaws,R.drawable.aj4_milblu,R.drawable.aj4_wc,
            R.drawable.aj5_belair,R.drawable.aj5_blkgrape,R.drawable.aj5_bm,R.drawable.aj5_firered, R.drawable.aj5_grape,R.drawable.aj5_laney,
            R.drawable.aj5_oreo,R.drawable.aj5_supremedc,R.drawable.aj5_tokyo,R.drawable.aj6_blackinfrared,R.drawable.aj6_carmine,R.drawable.aj6_white_infrared,R.drawable.aj7_olympic,
            R.drawable.aj7_bordeaux,R.drawable.aj7_hare,R.drawable.aj8_aqua,R.drawable.aj8_bugsbunny,R.drawable.aj9_coolgrey,R.drawable.aj10_chicago,
            R.drawable.aj11_bred,R.drawable.aj11_concord,R.drawable.aj11_columbia,R.drawable.aj11_spacejam,R.drawable.aj11lo_cherry,R.drawable.aj12_flugame,
            R.drawable.aj12_fb,R.drawable.aj12_taxi,R.drawable.aj13_blackcat,R.drawable.aj13_bred,R.drawable.aj13_chicago,R.drawable.aj13lo_chutney,
            R.drawable.aj14_blktoe,R.drawable.aj14_ferrari,R.drawable.aj14_lastshot};

    int[] nikeShoes = {R.drawable.nike_airmag_bttf,R.drawable.nike_airpresto_lightning,R.drawable.nike_airpresto_uncumulus,
            R.drawable.nike_huarache_hyperpunch,R.drawable.nike_airprestomid_acronym,R.drawable.nike_airzg_1stgame,R.drawable.nike_am1_airmaxday,
            R.drawable.nike_am1_atmos,R.drawable.nike_am1_master,R.drawable.nike_am1_safari,R.drawable.nike_am1_univred,R.drawable.nike_am90_duckcamo,
            R.drawable.nike_am90_infrared,R.drawable.nike_am90_japancamo,R.drawable.nike_am90_usared,R.drawable.nike_am90_moonland,R.drawable.nike_am90_warhawk,
            R.drawable.nike_am95_neon,R.drawable.nike_am97_silvrbullet, R.drawable.nike_amu_bulls,R.drawable.nike_dunkhi_dls,R.drawable.nike_dunkhi_skunk,
            R.drawable.nike_dunkhi_supremeblue,R.drawable.nike_dunkhi_whatthe,R.drawable.nike_dunkhi_tiffany,R.drawable.nike_dunklo_cali,
            R.drawable.nike_dunklo_heineken,R.drawable.nike_dunklo_paris,R.drawable.nike_dunklo_pigeon,R.drawable.nike_dunklo_pinkbox,
            R.drawable.nike_dunklo_supremered,R.drawable.nike_flyrcr_betrue,R.drawable.nike_flyrcr_multi,R.drawable.nike_foam_galaxy,R.drawable.nike_foam_royal,
            R.drawable.nike_foam_eggplant,R.drawable.nike_kd4_galaxy,R.drawable.nike_kd6_auntpearl,R.drawable.nike_kobe9_beethoven,
            R.drawable.nike_kobe10_sharkjaw,R.drawable.nike_kobe11_ftb,R.drawable.nike_lebron8_sb,R.drawable.nike_lebron9_galaxy,R.drawable.nike_lebron9lo_lebronald,
            R.drawable.nike_lebron11_2k14,R.drawable.nike_lebron12_whatthe,R.drawable.nike_vapormax_asphalt,R.drawable.nike_vapormax_tb,R.drawable.nike_yeezy1_net,R.drawable.nike_yeezy2_ro};

    boolean highLimit = false;
    boolean isHighLimit = false;
    boolean normalLimit = false;
    boolean isNormalLimit = false;
    boolean lowLimit = false;
    boolean isLowLimit = false;
    boolean hardMode = false;
    boolean isHardMode = false;
    boolean normalMode = false;
    boolean isNormalMode = false;
    boolean easyMode = false;
    boolean isEasyMode = false;

    SharedPreferences prefs;
    ArrayList<Integer> adidasIds = new ArrayList<Integer>();
    ArrayList<Integer> jordanIds = new ArrayList<Integer>();
    ArrayList<Integer> nikeIds = new ArrayList<Integer>();
    ArrayList<String> adidas_shoes = new ArrayList<String>();
    ArrayList<String> jordan_shoes = new ArrayList<String>();
    ArrayList<String> nike_shoes = new ArrayList<String>();

    public int getRandShoe(int x, int[] array){
        Random rand = new Random();
        int i;
        int id = 0;
        i = rand.nextInt(x);
        id = array[i];

        return id;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    // Actions for items in the menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_settings:
                startActivity(new Intent(this,SettingsActivity.class));
                return true;
            case R.id.menu_answers:
                Intent intent = new Intent(this,AnswersActivity.class);
                intent.putExtra("adidas ids",adidasIds);
                intent.putExtra("jordan ids",jordanIds);
                intent.putExtra("nike ids",nikeIds);
                intent.putExtra("adidas shoes",adidas_shoes);
                intent.putExtra("jordan shoes",jordan_shoes);
                intent.putExtra("nike shoes",nike_shoes);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onResume(){
        super.onResume();

        lowLimit = prefs.getBoolean(getResources().getString(R.string.low_limit),true);
        if (lowLimit){
            isLowLimit = true;
        }
        else
            isLowLimit = false;


        highLimit = prefs.getBoolean(getResources().getString(R.string.high_limit),true);
        if(highLimit) {
            isHighLimit = true;

        }
        else
            isHighLimit = false;


        normalLimit = prefs.getBoolean(getResources().getString(R.string.normal_limit),true);
        if (normalLimit){
            isNormalLimit = true;
        }
        else
            isNormalLimit = false;

        easyMode = prefs.getBoolean(getResources().getString(R.string.easy_mode),true);
        if (easyMode){
            isEasyMode = true;

        }
        else
            isEasyMode = false;


        hardMode = prefs.getBoolean(getResources().getString(R.string.hard_mode),true);
        if (hardMode){
            isHardMode = true;

        }
        else
            isHardMode = false;

        normalMode = prefs.getBoolean(getResources().getString(R.string.normal_mode),true);
        if (normalMode){
            isNormalMode = true;
        }
        else
            isNormalMode = false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        PreferenceManager.setDefaultValues(this,R.xml.preferences,false);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);

        ImageButton adidasButton = (ImageButton)findViewById(R.id.adidas_button);
        ImageButton ajButton = (ImageButton)findViewById(R.id.aj_button);
        ImageButton nikeButton = (ImageButton)findViewById(R.id.nike_button);
        adidasButton.setOnClickListener(this);
        ajButton.setOnClickListener(this);
        nikeButton.setOnClickListener(this);

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

    }

    @Override
    public void onClick(View v){
        if (v.getId() == R.id.adidas_button){
            String adidas = "Adidas";
            int id = getRandShoe(adidasShoes.length,adidasShoes);
            Intent intent = new Intent(this,gameplayActivity.class);
            intent.putExtra("brand_name",adidas);
            intent.putExtra("id",id);
            intent.putExtra("array",adidasShoes);
            intent.putExtra("array_max",adidasShoes.length);
            intent.putExtra("lowLimit",isLowLimit);
            intent.putExtra("highLimit",isHighLimit);
            intent.putExtra("normalLimit",isNormalLimit);
            intent.putExtra("easyMode",isEasyMode);
            intent.putExtra("hardMode",isHardMode);
            intent.putExtra("normalMode",isNormalMode);
            startActivity(intent);
        }
        else if (v.getId() == R.id.aj_button){
            String aj = "Air Jordan";
            int id = getRandShoe(jordanShoes.length,jordanShoes);
            Intent intent = new Intent(this,gameplayActivity.class);
            intent.putExtra("brand_name",aj);
            intent.putExtra("id",id);
            intent.putExtra("array",jordanShoes);
            intent.putExtra("array_max",jordanShoes.length);
            intent.putExtra("lowLimit",isLowLimit);
            intent.putExtra("highLimit",isHighLimit);
            intent.putExtra("normalLimit",isNormalLimit);
            intent.putExtra("easyMode",isEasyMode);
            intent.putExtra("hardMode",isHardMode);
            intent.putExtra("normalMode",isNormalMode);
            startActivity(intent);
        }
        else if (v.getId() == R.id.nike_button){
            String nike = "Nike";
            int id = getRandShoe(nikeShoes.length,nikeShoes);
            Intent intent = new Intent(this,gameplayActivity.class);
            intent.putExtra("brand_name",nike);
            intent.putExtra("id",id);
            intent.putExtra("array",nikeShoes);
            intent.putExtra("array_max",nikeShoes.length);
            intent.putExtra("lowLimit",isLowLimit);
            intent.putExtra("highLimit",isHighLimit);
            intent.putExtra("normalLimit",isNormalLimit);
            intent.putExtra("easyMode",isEasyMode);
            intent.putExtra("hardMode",isHardMode);
            intent.putExtra("normalMode",isNormalMode);
            startActivity(intent);
        }
    }
}
