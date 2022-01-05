package com.example.lena.elenamelnikova_mapd711_onlinepizza;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class PizzaSizeActivity extends AppCompatActivity {
    //Declare radio buttons
    private RadioButton rButton_small;
    private RadioButton rButton_medium;
    private RadioButton rButton_large;
    private RadioButton rButton_extraLarge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_size);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Define radio buttons by id
        rButton_small = findViewById(R.id.rButton_small_id);
        rButton_medium = findViewById(R.id.rButton_medium_id);
        rButton_large = findViewById(R.id.rButton_large_id);
        rButton_extraLarge = findViewById(R.id.rButton_extraLarge_id);

        // Create new intent_pizzaSize
        final Intent intent_pizzaSize = new Intent(PizzaSizeActivity.this, PizzaToppingsActivity.class);

        // Get incoming intent:
        final Intent intent_pizzaName = getIntent();

        //Extract strings "pizza_name" from intent_PizzaName Extra:
        String pizza_name = intent_pizzaName.getStringExtra("pizza_name");

        //Set pizza name into intent_pizzaSize Extra:
        intent_pizzaSize.putExtra("pizza_name", pizza_name);

        //Get radio group by id
        RadioGroup radioGroup = findViewById(R.id.radio_group_id);

        //Define onCheckedChangeListener and check which button is checked
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(rButton_small.isChecked()){
                    intent_pizzaSize.putExtra("pizza_size",getResources().getString(R.string.small_size));
                }
                else if(rButton_medium.isChecked()){
                    intent_pizzaSize.putExtra("pizza_size",getResources().getString(R.string.medium_size));
                }
                else if(rButton_large.isChecked()){
                    intent_pizzaSize.putExtra("pizza_size",getResources().getString(R.string.large_size));
                }
                else if(rButton_extraLarge.isChecked()){
                    intent_pizzaSize.putExtra("pizza_size",getResources().getString(R.string.extra_large_size));
                }
                PizzaSizeActivity.this.startActivity(intent_pizzaSize);
            }
        });

    }
}
