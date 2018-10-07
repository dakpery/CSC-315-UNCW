package com.hfad.beeradvisor;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.View.OnClickListener;
import java.util.List;

public class FindBeerActivity extends Activity {

    private int a = 1;
    private BeerExpert expert = new BeerExpert();
    private CheckBox myChk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);

        addListenerMyChkBox();

    }

    public void onClickFindBeer(View view){
        //Get a reference to the TextView
        TextView brands = (TextView) findViewById(R.id.brands);
        // Get a reference to the Spinner
        Spinner color = (Spinner) findViewById(R.id.color);
        // Get the selected item in the Spinner
        String beerType = String.valueOf(color.getSelectedItem());
        // Display the selected item
        brands.setText(beerType);

        List<String> brandsList = expert.getBrands(beerType);
        StringBuilder brandsFormatted = new StringBuilder();
        for (String brand : brandsList) {
            brandsFormatted.append(brand).append('\n');
        }
        //Display the beers
        brands.setText(brandsFormatted);
    }

    public void onClickFeelingLucky(View view){
        TextView brands = (TextView) findViewById(R.id.brands);
        String a = expert.getRandomBeer(this);
        brands.setText(a);
    }



    public void addListenerMyChkBox() {

        myChk = (CheckBox) findViewById(R.id.myCheckBox);

        myChk.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                //is chkIos checked?
                if (((CheckBox) v).isChecked()) {
                    ((TextView) findViewById(R.id.brands)).setTextSize(25);
                } else {
                    ((TextView) findViewById(R.id.brands)).setTextSize(12);
                }

            }
        });
    }

    public void onClickImageButton(View view){
        a += 1;
        if(a % 2 == 0){
            ImageButton btn = (ImageButton)findViewById((R.id.myImageButton));
            btn.setImageResource(R.drawable.uncw);
        } else{
            ImageButton btn = (ImageButton)findViewById((R.id.myImageButton));
            btn.setImageResource(R.drawable.btc);
        }
    }
}
