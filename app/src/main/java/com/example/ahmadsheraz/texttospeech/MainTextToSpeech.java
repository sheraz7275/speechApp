package com.example.ahmadsheraz.texttospeech;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class MainTextToSpeech extends AppCompatActivity implements TextToSpeech.OnInitListener {



    EditText edit;
    FloatingActionButton ftb;
    private TextToSpeech tts;
    TextView txtselected;
    CircularImageView circularImageView;

    private ListView mainListView ;

    String[] Langu;
    private ArrayAdapter<String> listAdapter ;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_text_to_speech);


        MobileAds.initialize(this,
                "ca-app-pub-9785413832036333~9139735801");
        mAdView = (AdView)findViewById(R.id.myadd);
        AdRequest adRequest = new AdRequest.Builder()

               . build();

        mAdView.loadAd(adRequest);





        tts = new TextToSpeech(this, this);
        txtselected=findViewById(R.id.txt);

        mainListView = (ListView) findViewById( R.id.listv );

        circularImageView=findViewById(R.id.cimage);


        String[] Langu = {"United States"
                , "UK",
                "CANADA",
                "CANADA_FRENCH",
                "CHINA",
                "CHINESE",
                "ENGLISH",
                "FRANCE",
                "GERMAN",
                "GERMANY",
                "ITALIAN",
                "ITALY",
                "JAPAN",
                "JAPANESE",
                "SIMPLIFIED_CHINESE",
                "KOREA",
                "TRADITIONAL_CHINESE",
                "TAIWAN",
                "KOREAN"


        };



        ftb=(FloatingActionButton) findViewById(R.id.btnn);
        edit=(EditText)findViewById(R.id.txt1);










    }


    int result;
    String lang=null;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {



        getMenuInflater().inflate(R.menu.option_menu, menu);//Menu Resource, Menu
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.select:

                launch();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public void onInit(int i ) {

        if(lang== "United States"){

            int result = tts.setLanguage(Locale.US);
            circularImageView.setImageResource(R.mipmap.unitedstates);


        }

         if(lang== "UK"){

            int result = tts.setLanguage(Locale.UK);
            circularImageView.setImageResource(R.mipmap.unitedkingdom);


        }
        else if(lang== "CANADA"){

            int result = tts.setLanguage(Locale.CANADA);
             circularImageView.setImageResource(R.mipmap.canada);



         }
        else if(lang== "CANADA FRENCH"){


            int result = tts.setLanguage(Locale.CANADA_FRENCH);
             circularImageView.setImageResource(R.mipmap.france);

         }
        else if(lang== "CHINESE"){


            int result = tts.setLanguage(Locale.CHINESE);
             circularImageView.setImageResource(R.mipmap.china);

         }
        else if(lang== "ENGLISH"){

            int result = tts.setLanguage(Locale.ENGLISH);
             circularImageView.setImageResource(R.mipmap.unitedstates);



         }
        else if(lang== "FRANCE"){

            int result = tts.setLanguage(Locale.FRENCH);
             circularImageView.setImageResource(R.mipmap.france);



         }
        else if(lang== "GERMAN"){

            int result = tts.setLanguage(Locale.GERMANY);
             circularImageView.setImageResource(R.mipmap.germany);



         }
        else if(lang== "ITALIAN"){

            int result = tts.setLanguage(Locale.ITALIAN);
             circularImageView.setImageResource(R.mipmap.italy);



         }
        else if(lang== "ITALY"){

            int result = tts.setLanguage(Locale.ITALY);
             circularImageView.setImageResource(R.mipmap.italy);



         }
        else if(lang== "JAPAN"){

            int result = tts.setLanguage(Locale.JAPAN);
             circularImageView.setImageResource(R.mipmap.japan);



         }
        else if(lang== "JAPANESE"){

            int result = tts.setLanguage(Locale.JAPANESE);
             circularImageView.setImageResource(R.mipmap.japan);



         }
        else if(lang== "SIMPLIFIED CHINESE"){

            int result = tts.setLanguage(Locale.SIMPLIFIED_CHINESE);
             circularImageView.setImageResource(R.mipmap.china);



         } else if(lang== "KOREA"){

            int result = tts.setLanguage(Locale.KOREA);
             circularImageView.setImageResource(R.mipmap.southkorea);



         } else if(lang== "TRADITIONAL CHINESE"){

            int result = tts.setLanguage(Locale.TRADITIONAL_CHINESE);
             circularImageView.setImageResource(R.mipmap.china);



         }
        else if(lang== "TAIWAN") {

             int result = tts.setLanguage(Locale.TAIWAN);
             circularImageView.setImageResource(R.mipmap.taiwan);



         }
        else if(lang== "KOREAN"){

              int result = tts.setLanguage(Locale.KOREAN);
             circularImageView.setImageResource(R.mipmap.southkorea);


         }

         else if(lang== null){

            int result = tts.setLanguage(Locale.US);
             circularImageView.setImageResource(R.mipmap.unitedstates);


           txtselected.setText("United States");



        }







        if (i == TextToSpeech.SUCCESS) {






            tts.setSpeechRate(1);

            tts.setPitch(1);

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
                ftb.setEnabled(true);
                speakOut();
            }

        } else {
            Log.e("TTS", "Initialization Failed!");
        }


    }

    public void pronunciation(View view) {
        speakOut();

    }

    private void speakOut() {

        String text = edit.getText().toString();


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null,"hello");
        }
    }





    ListView listView=null;

    public void launch() {


        List<String> country = new ArrayList<String>();


     country.add( "United States");
        country.add("UK");

                country.add("CANADA");
                country.add("CANADA FRENCH");


                country.add("CHINESE");
                country.add("ENGLISH");
                country.add("FRANCE");
                country.add("GERMAN");


                country.add("ITALIAN");
                country.add("ITALY");

                country.add("JAPANESE");
                country.add("SIMPLIFIED CHINESE");

                country.add("TRADITIONAL CHINESE");
                country.add("TAIWAN");
                country.add("KOREAN");

        //Create sequence of items
        final CharSequence[]cntry = country.toArray(new String[country.size()]);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Major countries Languages ");
        dialogBuilder.setItems(cntry, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                String selectedText = cntry[item].toString();  //Selected item in listview

                lang=selectedText;


               // Toast.makeText(getApplication(),selectedText,Toast.LENGTH_LONG).show();

                onInit(0);
                txtselected.setText(lang);

            }
        });

        AlertDialog alertDialogObject = dialogBuilder.create();

        alertDialogObject.show();

    }


    public void onImage(View view) {

        launch();


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        this.finish();
    }
}
