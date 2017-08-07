package edu.uoregon.ecaluya.sneaker_game;

/**
 * Created by elijahcaluya on 7/19/17.
 */

public class Shoe {
    public String brand, model, colorway;
    public int id;

    public String getModel(){return this.model;}
    public String getColorway(){return this.colorway;}
    public String getBrand(){return this.brand;}
    public int getId(){return this.id;}

    public String[] adidas_models = {"Alphabounce","Dame 3","Iniki Runner","Jeremy Scott","Jeremy Scott Wings",
            "NMD Human Race","NMD R1","NMD R2","UltraBoost 1.0","UltraBoost 2.0","UltraBoost 3.0",
            "Yeezy 350 Boost","Yeezy 350 Boost v2","Yeezy 750 Boost","Yeezy Powerphase"};
    public String[] adidas_colorways = {"Roots","Black/Gum","Batman","Panda","Friends and Family","Tangerine","Bape","Datamosh",
            "Linen","Nice Kicks","OG","Red Apple","Solar Red","Three Stripes","Cargo Green",
            "Triple White","3M","Multicolor","Reigning Champ","Wood Wood","Bronze","Triple Black","Chinese New Year","Kolor","Oreo","Pride"
            ,"Moonrock","Oxford Tan","Pirate Black","Turtle Dove","Beluga","Black/Green","Black/Infrared","Black/White",
            "Bred","Copper","Cream","Zebra","Chocolate","Grey","Gum","Calabasas"};


    public String[] jordan_models = {"Air Jordan 1","Air Jordan 2","Air Jordan 3","Air Jordan 4","Air Jordan 5","Air Jordan 6",
            "Air Jordan 7","Air Jordan 8","Air Jordan 9","Air Jordan 10","Air Jordan 11","Air Jordan 11 Low","Air Jordan 12","Air Jordan 13",
            "Air Jordan 13 Low","Air Jordan 14"};
    public String[] jordan_colorways = {"Black Toe","Bred","Royal","Chicago","Just Don(Arctic Orange)","Just Don(Beach)","Just Don(Blue)","Black Cement",
            "True Blue","KAWS","Military Blue","White Cement","Black Metallic", "Fire Red","Grape","Black Infrared","Laney","Supreme(Desert Camo)",
            "White Infrared","Bordeaux","Olympic","Hare","Aqua","Bugs Bunny","Cool Grey","Columbia","Concord","Space Jam",
            "Cherry","Flu Game","French Blue","Taxi","Black Cat","Chutney","Ferrari","Last Shot"};


    public String[] nike_models = {"Air Mag","Air Presto","Air Presto Mid","Air Zoom Generation","Air Max 1","Air Max 90",
            "Air Max 95","Air Max 97","Air More Uptempo","Dunk High","Dunk Low","Flyknit Racer","Foamposite One",
            "Air Huarache","KD 4","KD 6","Kobe 9","Kobe 10","Kobe 11", "Lebron 8","Lebron 9","Lebron 9 Low","Lebron 11",
            "Lebron 12","Vapormax","Air Yeezy 1","Air Yeezy 2"};
    public String[] nike_colorways = {"Back to the Future","Lightning","Unholy Cumulus","Acronym","Atmos","University Red","Duck Camo",
            "Moon Landing","Warhawk","First Game","Infrared","Neon","Silver Bullet","Bulls","De La Soul","Supreme(Blue)","Skunk","Tiffany",
            "What The","Cali","Heineken","Paris","Pigeon","Pink Box","Supreme(Red)","Be True","Multicolor","Eggplant","Galaxy","Royal Blue","Hyperpunch",
            "Aunt Pearl","Fade to Black","Beethoven","Shark Jaw","South Beach","Lebronald Palmer","2K14","Asphalt","Triple Black","Net","Red October"};


    public String[] getBrandModels(){
        String[] array = null;
        if (this.brand == "Adidas")
            array = adidas_models;
        else if (this.brand == "Jordan")
            array = jordan_models;
        else if (this.brand == "Nike")
            array = nike_models;
        return array;
    }

    public String[] getBrandColorways(){
        String[] array = null;
        if (this.brand == "Adidas")
            array = adidas_colorways;
        else if (this.brand == "Jordan")
            array = jordan_colorways;
        else if (this.brand == "Nike")
            array = nike_colorways;
        return array;
    }

    Shoe(int id){
        //
        // ---------------------------------Adidas Shoes---------------------------
        //
        if (id == R.drawable.adidas_alphabounce_rc){
            this.id = id;
            brand = "Adidas";
            model = "Alphabounce";
            colorway = "Reigning Champ";
        }
        else if (id == R.drawable.adidas_dame3_roots){
            this.id = id;
            brand = "Adidas";
            model = "Dame 3";
            colorway = "Roots";
        }
        else if (id == R.drawable.adidas_iniki_blkgum){
            this.id = id;
            brand = "Adidas";
            model = "Iniki Runner";
            colorway = "Black/Gum";
        }
        else if (id == R.drawable.adidas_js_batman){
            this.id = id;
            brand = "Adidas";
            model = "Jeremy Scott Wings";
            colorway = "Batman";
        }
        else if (id == R.drawable.adidas_js_panda){
            this.id = id;
            brand = "Adidas";
            model = "Jeremy Scott";
            colorway = "Panda";
        }
        else if (id == R.drawable.adidas_js_zebra){
            this.id = id;
            brand = "Adidas";
            model = "Jeremy Scott";
            colorway = "Zebra";
        }
        else if (id == R.drawable.adidas_nmdhmnrace_ff){
            this.id = id;
            brand = "Adidas";
            model = "NMD Human Race";
            colorway = "Friends and Family";
        }
        else if (id == R.drawable.adidas_nmdhmnrace_tangerine){
            this.id = id;
            brand = "Adidas";
            model = "NMD Human Race";
            colorway = "Tangerine";
        }
        else if (id == R.drawable.adidas_nmdr1_bape){
            this.id = id;
            brand = "Adidas";
            model = "NMD R1";
            colorway = "Bape";
        }
        else if (id == R.drawable.adidas_nmdr1_datamosh){
            this.id = id;
            brand = "Adidas";
            model = "NMD R1";
            colorway = "Datamosh";
        }
        else if (id == R.drawable.adidas_nmdr1_linen){
            this.id = id;
            brand = "Adidas";
            model = "NMD R1";
            colorway = "Linen";
        }
        else if (id == R.drawable.adidas_nmdr1_nicekicks){
            this.id = id;
            brand = "Adidas";
            model = "NMD R1";
            colorway = "Nice Kicks";
        }
        else if (id == R.drawable.adidas_nmdr1_og){
            this.id = id;
            brand = "Adidas";
            model = "NMD R1";
            colorway = "OG";
        }
        else if (id == R.drawable.adidas_nmdr1_redapple){
            this.id = id;
            brand = "Adidas";
            model = "NMD R1";
            colorway = "Red Apple";
        }
        else if (id == R.drawable.adidas_nmdr1_solar){
            this.id = id;
            brand = "Adidas";
            model = "NMD R1";
            colorway = "Solar Red";
        }
        else if (id == R.drawable.adidas_nmdr1_stripes){
            this.id = id;
            brand = "Adidas";
            model = "NMD R1";
            colorway = "Three Stripes";
        }
        else if (id == R.drawable.adidas_nmdr2_cargogreen){
            this.id = id;
            brand = "Adidas";
            model = "NMD R2";
            colorway = "Cargo Green";
        }
        else if (id == R.drawable.adidas_ub1_tw){
            this.id = id;
            brand = "Adidas";
            model = "UltraBoost 1.0";
            colorway = "Triple White";
        }
        else if (id == R.drawable.adidas_ub2_3m){
            this.id = id;
            brand = "Adidas";
            model = "UltraBoost 2.0";
            colorway = "3M";
        }
        else if (id == R.drawable.adidas_ub2_multi){
            this.id = id;
            brand = "Adidas";
            model = "UltraBoost 2.0";
            colorway = "Multicolor";
        }
        else if (id == R.drawable.adidas_ub2_rc){
            this.id = id;
            brand = "Adidas";
            model = "UltraBoost 2.0";
            colorway = "Reigning Champ";
        }
        else if (id == R.drawable.adidas_ub2_wood){
            this.id = id;
            brand = "Adidas";
            model = "UltraBoost 2.0";
            colorway = "Wood Wood";
        }
        else if (id == R.drawable.adidas_ub3_bronze){
            this.id = id;
            brand = "Adidas";
            model = "UltraBoost 3.0";
            colorway = "Bronze";
        }
        else if (id == R.drawable.adidas_ub3_cny){
            this.id = id;
            brand = "Adidas";
            model = "UltraBoost 3.0";
            colorway = "Chinese New Year";
        }
        else if (id == R.drawable.adidas_ub3_kolor){
            this.id = id;
            brand = "Adidas";
            model = "UltraBoost 3.0";
            colorway = "Kolor";
        }
        else if (id == R.drawable.adidas_ub3_oreo){
            this.id = id;
            brand = "Adidas";
            model = "UltraBoost 3.0";
            colorway = "Oreo";
        }
        else if (id == R.drawable.adidas_ub3_pride){
            this.id = id;
            brand = "Adidas";
            model = "UltraBoost 3.0";
            colorway = "Pride";
        }
        else if (id == R.drawable.adidas_ub3_tb){
            this.id = id;
            brand = "Adidas";
            model = "UltraBoost 3.0";
            colorway = "Triple Black";
        }
        else if (id == R.drawable.adidas_yzy350_moonrock){
            this.id = id;
            brand = "Adidas";
            model = "Yeezy 350 Boost";
            colorway = "Moonrock";
        }
        else if (id == R.drawable.adidas_yzy350_oxfordtan){
            this.id = id;
            brand = "Adidas";
            model = "Yeezy 350 Boost";
            colorway = "Oxford Tan";
        }
        else if (id == R.drawable.adidas_yzy350_pb){
            this.id = id;
            brand = "Adidas";
            model = "Yeezy 350 Boost";
            colorway = "Pirate Black";
        }
        else if (id == R.drawable.adidas_yzy350_td){
            this.id = id;
            brand = "Adidas";
            model = "Yeezy 350 Boost";
            colorway = "Turtle Dove";
        }
        else if (id == R.drawable.adidas_yzy350v2_beluga){
            this.id = id;
            brand = "Adidas";
            model = "Yeezy 350 Boost v2";
            colorway = "Beluga";
        }
        else if (id == R.drawable.adidas_yzy350v2_blkgreen){
            this.id = id;
            brand = "Adidas";
            model = "Yeezy 350 Boost v2";
            colorway = "Black/Green";
        }
        else if (id == R.drawable.adidas_yzy350v2_blkinfrared){
            this.id = id;
            brand = "Adidas";
            model = "Yeezy 350 Boost v2";
            colorway = "Black/Infrared";
        }
        else if (id == R.drawable.adidas_yzy350v2_blkwhite){
            this.id = id;
            brand = "Adidas";
            model = "Yeezy 350 Boost v2";
            colorway = "Black/White";
        }
        else if (id == R.drawable.adidas_yzy350v2_bred){
            this.id = id;
            brand = "Adidas";
            model = "Yeezy 350 Boost v2";
            colorway = "Bred";
        }
        else if (id == R.drawable.adidas_yzy350v2_copper){
            this.id = id;
            brand = "Adidas";
            model = "Yeezy 350 Boost v2";
            colorway = "Copper";
        }
        else if (id == R.drawable.adidas_yzy350v2_cream){
            this.id = id;
            brand = "Adidas";
            model = "Yeezy 350 Boost v2";
            colorway = "Cream";
        }
        else if (id == R.drawable.adidas_yzy350v2_zebra){
            this.id = id;
            brand = "Adidas";
            model = "Yeezy 350 Boost v2";
            colorway = "Zebra";
        }
        else if (id == R.drawable.adidas_yzy750_choco){
            this.id = id;
            brand = "Adidas";
            model = "Yeezy 750 Boost";
            colorway = "Chocolate";
        }
        else if (id == R.drawable.adidas_yzy750_grey){
            this.id = id;
            brand = "Adidas";
            model = "Yeezy 750 Boost";
            colorway = "Grey";
        }
        else if (id == R.drawable.adidas_yzy750_gum){
            this.id = id;
            brand = "Adidas";
            model = "Yeezy 750 Boost";
            colorway = "Gum";
        }
        else if (id == R.drawable.adidas_yzy750_tb){
            this.id = id;
            brand = "Adidas";
            model = "Yeezy 750 Boost";
            colorway = "Triple Black";
        }
        else if (id == R.drawable.adidas_yzypowerphase_calabasas){
            this.id = id;
            brand = "Adidas";
            model = "Yeezy Powerphase";
            colorway = "Calabasas";
        }

        //
        // ---------------------------------Air Jordan Shoes-------------------------
        //
        else if (id == R.drawable.aj1_blktoe){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 1";
            colorway = "Black Toe";
        }
        else if (id == R.drawable.aj1_bred){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 1";
            colorway = "Bred";
        }
        else if (id == R.drawable.aj1_chicago){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 1";
            colorway = "Chicago";
        }
        else if (id == R.drawable.aj1_royal){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 1";
            colorway = "Royal";
        }
        else if (id == R.drawable.aj2_chicago){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 2";
            colorway = "Chicago";
        }
        else if (id == R.drawable.aj2_justdon_arctic_orange){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 2";
            colorway = "Just Don(Arctic Orange)";
        }
        else if (id == R.drawable.aj2_justdon_beach){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 2";
            colorway = "Just Don(Beach)";
        }
        else if (id == R.drawable.aj2_justdon_blue){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 2";
            colorway = "Just Don(Blue)";
        }
        else if (id == R.drawable.aj3_bc){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 3";
            colorway = "Black Cement";
        }
        else if (id == R.drawable.aj3_tb){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 3";
            colorway = "True Blue";
        }
        else if (id == R.drawable.aj3_wc){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 3";
            colorway = "White Cement";
        }
        else if (id == R.drawable.aj4_bc){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 4";
            colorway = "Black Cement";
        }
        else if (id == R.drawable.aj4_kaws){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 4";
            colorway = "KAWS";
        }
        else if (id == R.drawable.aj4_milblu){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 4";
            colorway = "Military Blue";
        }
        else if (id == R.drawable.aj4_wc){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 4";
            colorway = "White Cement";
        }
        else if (id == R.drawable.aj5_bm){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 5";
            colorway = "Black Metallic";
        }
        else if (id == R.drawable.aj5_firered){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 5";
            colorway = "Fire Red";
        }
        else if (id == R.drawable.aj5_grape){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 5";
            colorway = "Grape";
        }
        else if (id == R.drawable.aj5_laney){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 5";
            colorway = "Laney";
        }
        else if (id == R.drawable.aj5_supremedc){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 5";
            colorway = "Supreme(Desert Camo)";
        }
        else if (id == R.drawable.aj6_blackinfrared){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 6";
            colorway = "Black Infrared";
        }
        else if (id == R.drawable.aj6_white_infrared){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 6";
            colorway = "White Infrared";
        }
        else if (id == R.drawable.aj6_carmine){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 6";
            colorway = "Carmine";
        }
        else if (id == R.drawable.aj7_bordeaux){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 7";
            colorway = "Bordeaux";
        }
        else if (id == R.drawable.aj7_hare){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 7";
            colorway = "Hare";
        }
        else if (id == R.drawable.aj7_olympic){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 7";
            colorway = "Olympic";
        }
        else if (id == R.drawable.aj8_aqua){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 8";
            colorway = "Aqua";
        }
        else if (id == R.drawable.aj8_bugsbunny){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 8";
            colorway = "Bugs Bunny";
        }
        else if (id == R.drawable.aj9_coolgrey){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 9";
            colorway = "Cool Grey";
        }
        else if (id == R.drawable.aj10_chicago){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 10";
            colorway = "Chicago";
        }
        else if (id == R.drawable.aj11_bred){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 11";
            colorway = "Bred";
        }
        else if (id == R.drawable.aj11_concord){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 11";
            colorway = "Concord";
        }
        else if (id == R.drawable.aj11_columbia){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 11";
            colorway = "Columbia";
        }
        else if (id == R.drawable.aj11_spacejam){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 11";
            colorway = "Space Jam";
        }
        else if (id == R.drawable.aj11lo_cherry){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 11 Low";
            colorway = "Cherry";
        }
        else if (id == R.drawable.aj12_flugame){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 12";
            colorway = "Flu Game";
        }
        else if (id == R.drawable.aj12_fb){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 12";
            colorway = "French Blue";
        }
        else if (id == R.drawable.aj12_taxi){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 12";
            colorway = "Taxi";
        }
        else if (id == R.drawable.aj13_blackcat){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 13";
            colorway = "Black Cat";
        }
        else if (id == R.drawable.aj13_bred){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 13";
            colorway = "Bred";
        }
        else if (id == R.drawable.aj13_chicago){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 13";
            colorway = "Chicago";
        }
        else if (id == R.drawable.aj13lo_chutney){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 13 Low";
            colorway = "Chutney";
        }
        else if (id == R.drawable.aj14_blktoe){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 14";
            colorway = "Black Toe";
        }
        else if (id == R.drawable.aj14_ferrari){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 14";
            colorway = "Ferrari";
        }
        else if (id == R.drawable.aj14_lastshot){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 14";
            colorway = "Last Shot";
        }

        //
        // -------------------------------Nike Shoes-------------------------------
        //

        else if (id == R.drawable.nike_airmag_bttf){
            this.id = id;
            brand = "Nike";
            model = "Air Mag";
            colorway = "Back to the Future";
        }
        else if (id == R.drawable.nike_airpresto_lightning){
            this.id = id;
            brand = "Nike";
            model = "Air Presto";
            colorway = "Lightning";
        }
        else if (id == R.drawable.nike_airpresto_uncumulus){
            this.id = id;
            brand = "Nike";
            model = "Air Presto";
            colorway = "Unholy Cumulus";
        }
        else if (id == R.drawable.nike_airprestomid_acronym){
            this.id = id;
            brand = "Nike";
            model = "Air Presto Mid";
            colorway = "Acronym";
        }
        else if (id == R.drawable.nike_airzg_1stgame){
            this.id = id;
            brand = "Nike";
            model = "Air Zoom Generation";
            colorway = "First Game";
        }
        else if (id == R.drawable.nike_am1_atmos){
            this.id = id;
            brand = "Nike";
            model = "Air Max 1";
            colorway = "Atmos";
        }
        else if (id == R.drawable.nike_am1_univred){
            this.id = id;
            brand = "Nike";
            model = "Air Max 1";
            colorway = "University Red";
        }
        else if (id == R.drawable.nike_am90_duckcamo){
            this.id = id;
            brand = "Nike";
            model = "Air Max 90";
            colorway = "Duck Camo";
        }
        else if (id == R.drawable.nike_am90_infrared){
            this.id = id;
            brand = "Nike";
            model = "Air Max 90";
            colorway = "Infrared";
        }
        else if (id == R.drawable.nike_am90_moonland){
            this.id = id;
            brand = "Nike";
            model = "Air Max 90";
            colorway = "Moon Landing";
        }
        else if (id == R.drawable.nike_am90_warhawk){
            this.id = id;
            brand = "Nike";
            model = "Air Max 90";
            colorway = "Warhawk";
        }
        else if (id == R.drawable.nike_am95_neon){
            this.id = id;
            brand = "Nike";
            model = "Air Max 95";
            colorway = "Neon";
        }
        else if (id == R.drawable.nike_am97_silvrbullet){
            this.id = id;
            brand = "Nike";
            model = "Air Max 97";
            colorway = "Silver Bullet";
        }
        else if (id == R.drawable.nike_amu_bulls){
            this.id = id;
            brand = "Nike";
            model = "Air More Uptempo";
            colorway = "Bulls";
        }
        else if (id == R.drawable.nike_dunkhi_dls){
            this.id = id;
            brand = "Nike";
            model = "Dunk High";
            colorway = "De La Soul";
        }
        else if (id == R.drawable.nike_dunkhi_supremeblue){
            this.id = id;
            brand = "Nike";
            model = "Dunk High";
            colorway = "Supreme(Blue)";
        }
        else if (id == R.drawable.nike_dunkhi_skunk){
            this.id = id;
            brand = "Nike";
            model = "Dunk High";
            colorway = "Skunk";
        }
        else if (id == R.drawable.nike_dunkhi_tiffany){
            this.id = id;
            brand = "Nike";
            model = "Dunk High";
            colorway = "Tiffany";
        }
        else if (id == R.drawable.nike_dunkhi_whatthe){
            this.id = id;
            brand = "Nike";
            model = "Dunk High";
            colorway = "What The";
        }
        else if (id == R.drawable.nike_dunklo_cali){
            this.id = id;
            brand = "Nike";
            model = "Dunk Low";
            colorway = "Cali";
        }
        else if (id == R.drawable.nike_dunklo_heineken){
            this.id = id;
            brand = "Nike";
            model = "Dunk Low";
            colorway = "Heineken";
        }
        else if (id == R.drawable.nike_dunklo_paris){
            this.id = id;
            brand = "Nike";
            model = "Dunk Low";
            colorway = "Paris";
        }
        else if (id == R.drawable.nike_dunklo_pigeon){
            this.id = id;
            brand = "Nike";
            model = "Dunk Low";
            colorway = "Pigeon";
        }
        else if (id == R.drawable.nike_dunklo_pinkbox){
            this.id = id;
            brand = "Nike";
            model = "Dunk Low";
            colorway = "Pink Box";
        }
        else if (id == R.drawable.nike_dunklo_supremered){
            this.id = id;
            brand = "Nike";
            model = "Dunk Low";
            colorway = "Supreme(Red)";
        }
        else if (id == R.drawable.nike_flyrcr_betrue){
            this.id = id;
            brand = "Nike";
            model = "Flyknit Racer";
            colorway = "Be True";
        }
        else if (id == R.drawable.nike_flyrcr_multi){
            this.id = id;
            brand = "Nike";
            model = "Flyknit Racer";
            colorway = "Multicolor";
        }
        else if (id == R.drawable.nike_foam_galaxy){
            this.id = id;
            brand = "Nike";
            model = "Foamposite One";
            colorway = "Galaxy";
        }
        else if (id == R.drawable.nike_foam_royal){
            this.id = id;
            brand = "Nike";
            model = "Foamposite One";
            colorway = "Royal Blue";
        }
        else if (id == R.drawable.nike_foam_eggplant){
            this.id = id;
            brand = "Nike";
            model = "Foamposite One";
            colorway = "Eggplant";
        }
        else if (id == R.drawable.nike_huarache_hyperpunch){
            this.id = id;
            brand = "Nike";
            model = "Air Huarache";
            colorway = "Hyperpunch";
        }
        else if (id == R.drawable.nike_kd4_galaxy){
            this.id = id;
            brand = "Nike";
            model = "KD 4";
            colorway = "Galaxy";
        }
        else if (id == R.drawable.nike_kd6_auntpearl){
            this.id = id;
            brand = "Nike";
            model = "KD 6";
            colorway = "Aunt Pearl";
        }
        else if (id == R.drawable.nike_kobe9_beethoven){
            this.id = id;
            brand = "Nike";
            model = "Kobe 9";
            colorway = "Beethoven";
        }
        else if (id == R.drawable.nike_kobe10_sharkjaw){
            this.id = id;
            brand = "Nike";
            model = "Kobe 10";
            colorway = "Shark Jaw";
        }
        else if (id == R.drawable.nike_kobe11_ftb){
            this.id = id;
            brand = "Nike";
            model = "Kobe 11";
            colorway = "Fade to Black";
        }
        else if (id == R.drawable.nike_lebron8_sb){
            this.id = id;
            brand = "Nike";
            model = "Lebron 8";
            colorway = "South Beach";
        }
        else if (id == R.drawable.nike_lebron9_galaxy){
            this.id = id;
            brand = "Nike";
            model = "Lebron 9";
            colorway = "Galaxy";
        }
        else if (id == R.drawable.nike_lebron9lo_lebronald){
            this.id = id;
            brand = "Nike";
            model = "Lebron 9 Low";
            colorway = "Lebronald Palmer";
        }
        else if (id == R.drawable.nike_lebron11_2k14){
            this.id = id;
            brand = "Nike";
            model = "Lebron 11";
            colorway = "2K14";
        }
        else if (id == R.drawable.nike_lebron12_whatthe){
            this.id = id;
            brand = "Nike";
            model = "Lebron 12";
            colorway = "What The";
        }
        else if (id == R.drawable.nike_vapormax_asphalt){
            this.id = id;
            brand = "Nike";
            model = "Vapormax";
            colorway = "Asphalt";
        }
        else if (id == R.drawable.nike_vapormax_tb){
            this.id = id;
            brand = "Nike";
            model = "Vapormax";
            colorway = "Triple Black";
        }
        else if (id == R.drawable.nike_yeezy1_net){
            this.id = id;
            brand = "Nike";
            model = "Air Yeezy 1";
            colorway = "Net";
        }
        else if (id == R.drawable.nike_yeezy2_ro){
            this.id = id;
            brand = "Nike";
            model = "Air Yeezy 2";
            colorway = "Red October";
        }
    }
}