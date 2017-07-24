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

    public String[] adidas_models = {"NMD Human Race","NMD R1","NMD R2","UltraBoost 1.0","UltraBoost 2.0","UltraBoost 3.0",
            "Yeezy 350 Boost","Yeezy 350 Boost v2","Yeezy 750 Boost","Yeezy Powerphase"};
    public String[] adidas_colorways = {"Friends and Family","OG","Cargo Green","Triple White","Multicolor","Reigning Champ",
            "Triple Black","Chinese New Year","Oreo","Moonrock","Oxford Tan","Pirate Black","Turtle Dove","Beluga","Black/ Green",
            "Black/ Infrared","Bred","Cream","Zebra","Grey","Gum","Calabasas"};


    public String[] jordan_models = {"Air Jordan 1","Air Jordan 2","Air Jordan 3","Air Jordan 4","Air Jordan 5","Air Jordan 6",
            "Air Jordan 7","Air Jordan 8","Air Jordan 9","Air Jordan 10","Air Jordan 11","Air Jordan 12","Air Jordan 13",
            "Air Jordan 14"};
    public String[] jordan_colorways = {"Bred","Royal","Chicago","Black Cement","True Blue","White Cement","Black Metallic",
            "Fire Red","Black Infrared","Olympic","Aqua","Cool Grey","Concord","Space Jam","Flu Game","Last Shot"};


    public String[] nike_models = {"Air Max 1","Air Max 90","Air Max 95","Dunk High","Dunk Low","Foamposite One","KD 4",
            "KD 6","Kobe 9","Kobe 11","Lebron 8","Lebron 9","Vapormax","Air Yeezy 1","Air Yeezy 2"};
    public String[] nike_colorways = {"Atmos","University Red","Duck Camo","Infrared","Neon","Supreme(Blue)","Tiffany",
            "Cali","Heineken","Paris","Pigeon","Supreme(Red)","Galaxy","Royal Blue","Aunt Pearl","Fade to Black","Beethoven",
            "South Beach","Asphalt","Triple Black","Net","Red October"};


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
        if (id == R.drawable.adidas_nmdhmnrace_ff){
            this.id = id;
            brand = "Adidas";
            model = "NMD Human Race";
            colorway = "Friends and Family";
        }
        else if (id == R.drawable.adidas_nmdr1_og){
            this.id = id;
            brand = "Adidas";
            model = "NMD R1";
            colorway = "OG";
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
        else if (id == R.drawable.adidas_ub2_tb){
            this.id = id;
            brand = "Adidas";
            model = "UltraBoost 2.0";
            colorway = "Triple Black";
        }
        else if (id == R.drawable.adidas_ub3_cny){
            this.id = id;
            brand = "Adidas";
            model = "UltraBoost 3.0";
            colorway = "Chinese New Year";
        }
        else if (id == R.drawable.adidas_ub3_oreo){
            this.id = id;
            brand = "Adidas";
            model = "UltraBoost 3.0";
            colorway = "Oreo";
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
            colorway = "Black/ Green";
        }
        else if (id == R.drawable.adidas_yzy350v2_blkinfrared){
            this.id = id;
            brand = "Adidas";
            model = "Yeezy 350 Boost v2";
            colorway = "Black/ Infrared";
        }
        else if (id == R.drawable.adidas_yzy350v2_bred){
            this.id = id;
            brand = "Adidas";
            model = "Yeezy 350 Boost v2";
            colorway = "Bred";
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
        else if (id == R.drawable.adidas_yzypowerphase_calabasas){
            this.id = id;
            brand = "Adidas";
            model = "Yeezy Powerphase";
            colorway = "Calabasas";
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
        else if (id == R.drawable.aj6_blackinfrared){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 6";
            colorway = "Black Infrared";
        }
        else if (id == R.drawable.aj6_carmine){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 6";
            colorway = "Carmine";
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
        else if (id == R.drawable.aj11_spacejam){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 11";
            colorway = "Space Jam";
        }
        else if (id == R.drawable.aj12_flugame){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 12";
            colorway = "Flu Game";
        }
        else if (id == R.drawable.aj13_bred){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 13";
            colorway = "Bred";
        }
        else if (id == R.drawable.aj14_lastshot){
            this.id = id;
            brand = "Jordan";
            model = "Air Jordan 14";
            colorway = "Last Shot";
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
        else if (id == R.drawable.nike_am95_neon){
            this.id = id;
            brand = "Nike";
            model = "Air Max 95";
            colorway = "Neon";
        }
        else if (id == R.drawable.nike_dunkhi_supremeblue){
            this.id = id;
            brand = "Nike";
            model = "Dunk High";
            colorway = "Supreme(Blue)";
        }
        else if (id == R.drawable.nike_dunkhi_tiffany){
            this.id = id;
            brand = "Nike";
            model = "Dunk High";
            colorway = "Tiffany";
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
        else if (id == R.drawable.nike_dunklo_supremered){
            this.id = id;
            brand = "Nike";
            model = "Dunk Low";
            colorway = "Supreme(Red)";
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