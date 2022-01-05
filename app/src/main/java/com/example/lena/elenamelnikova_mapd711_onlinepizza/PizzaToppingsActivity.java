package com.example.lena.elenamelnikova_mapd711_onlinepizza;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;

public class PizzaToppingsActivity extends AppCompatActivity {
    //Declare checkboxes
    private CheckBox checkBox_cheese;
    private CheckBox checkBox_greenPepper;
    private CheckBox checkBox_smokedHam;
    private CheckBox checkBox_spinach;
    private CheckBox checkBox_blackOlives;
    private CheckBox checkBox_spanishOnions;

    //Declare checkOut button
    private Button button_checkOut;

    // Declare new intent_pizzaToppings
    private Intent intent_pizzaToppings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_toppings);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Create new intent_pizzaToppings
        intent_pizzaToppings = new Intent(PizzaToppingsActivity.this, CustomerInformationActivity.class);

        // Get incoming intent:
        final Intent intent_pizzaSize = getIntent();

        //Extract strings "pizza_name" from intent_PizzaSize Extra:
        String pizza_name = intent_pizzaSize.getStringExtra("pizza_name");

        //Extract strings "pizza_size" from intent_PizzaSize Extra:
        String pizza_size = intent_pizzaSize.getStringExtra("pizza_size");

        //Set pizza name into intent_pizzaToppings Extra:
        intent_pizzaToppings.putExtra("pizza_name", pizza_name);

        //Set pizza size into intent_pizzaToppings Extra:
        intent_pizzaToppings.putExtra("pizza_size", pizza_size);

        //Define checkboxes by id
        checkBox_cheese = findViewById(R.id.checkBox_cheese_id);
        checkBox_greenPepper = findViewById(R.id.checkBox_greenPepper_id);
        checkBox_smokedHam = findViewById(R.id.checkBox_smokedHam_id);
        checkBox_spinach = findViewById(R.id.checkBox_spinach_id);
        checkBox_blackOlives = findViewById(R.id.checkBox_blackOlives_id);
        checkBox_spanishOnions = findViewById(R.id.checkBox_spanishOnions_id);

        //Define checkOut button by id
        button_checkOut = findViewById(R.id.button_checkOut_id);
    }

    // Button click event
    public void onCheckOut(View view) {
        // ArrayList of toppings
        ArrayList<String> toppingsList = new ArrayList<>();
        String toppings = "";
        // Cheese topping selected
        if(checkBox_cheese.isChecked()){
            toppingsList.add("Cheese");
        }
        // Green Pepper topping selected
        if(checkBox_greenPepper.isChecked()){
            toppingsList.add("Green Pepper");
        }
        // Smoked Ham topping selected
        if(checkBox_smokedHam.isChecked()){
            toppingsList.add("Smoked Ham");
        }
        // Spinach topping selected
        if(checkBox_spinach.isChecked()){
            toppingsList.add("Spinach");
        }
        // Black Olives topping selected
        if(checkBox_blackOlives.isChecked()){
            toppingsList.add("Black Olives");
        }
        // Spanish Onions topping selected
        if(checkBox_spanishOnions.isChecked()){
            toppingsList.add("Spanish Onions");
        }

        // Populate string of toppings from ArrayList
        for(int i = 0; i < toppingsList.size(); i++){
            if(toppings.length() > 0) {
                toppings = toppings + ", " + toppingsList.get(i);
            } else{
                toppings = toppingsList.get(i);
            }
        }
        // Put toppings into intent Extra
        intent_pizzaToppings.putExtra("pizza_toppings",toppings);

        //Start new activity
        PizzaToppingsActivity.this.startActivity(intent_pizzaToppings);

    }
}
