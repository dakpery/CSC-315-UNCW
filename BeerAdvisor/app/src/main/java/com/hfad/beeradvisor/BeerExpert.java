package com.hfad.beeradvisor;
import android.app.Activity;
import android.view.View;
import java.util.Random;

import java.util.ArrayList;
import java.util.List;
import android.content.Context;


public class BeerExpert {


	// update
	
    List<String> getBrands(String color) {
        List<String> brands = new ArrayList<>();
        if (color.equals("amber")) {
            brands.add("Jack Amber");
            brands.add("Red Moose");
        } else {
            brands.add("Jail Pale Ale");
            brands.add("Gout Stout");
        }

        return brands;
    }

    String getRandomBeer(Context a) {
        Random rand = new Random();
        String myVal = "";
        int num;
        String carArr[] = a.getResources().getStringArray(R.array.randomBeers);
        for(int i = 0; i < carArr.length; i++){
            num = rand.nextInt(4);
            myVal = carArr[num];
        }
        return myVal;
    }

}
