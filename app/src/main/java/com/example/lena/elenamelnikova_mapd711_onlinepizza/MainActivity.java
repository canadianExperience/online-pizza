package com.example.lena.elenamelnikova_mapd711_onlinepizza;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    //Initialize the contents of the Activity's standard options menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Show the menu
        getMenuInflater().inflate(R.menu.pizza,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Create Intent object for Pizza_SizeActivity:
        Intent intent_pizzaName = new Intent(MainActivity.this, PizzaSizeActivity.class);

        //Handle menu items  by their id
        switch (item.getItemId())
        {
            case R.id.meat_supreme_id:
                //Get pizza name from string resource and put it into Extra:
                intent_pizzaName.putExtra("pizza_name",getResources().getString(R.string.meat_supreme));
                // Start intent process:
                MainActivity.this.startActivity(intent_pizzaName);
                break;
            case R.id.super_hawaiian_id:
                //Get pizza name from string resource and put it into Extra:
                intent_pizzaName.putExtra("pizza_name",getResources().getString(R.string.super_hawaiian));
                // Start intent process:
                MainActivity.this.startActivity(intent_pizzaName);
                break;
            case R.id.veggie_id:
                //Get pizza name from string resource and put it into Extra:
                intent_pizzaName.putExtra("pizza_name",getResources().getString(R.string.veggie));
                // Start intent process:
                MainActivity.this.startActivity(intent_pizzaName);
                break;
            case R.id.mediterranean_id:
                //Get pizza name from string resource and put it into Extra:
                intent_pizzaName.putExtra("pizza_name",getResources().getString(R.string.mediterranean));
                // Start intent process:
                MainActivity.this.startActivity(intent_pizzaName);
                break;
            case R.id.cheddar_supreme_id:
                //Get pizza name from string resource and put it into Extra:
                intent_pizzaName.putExtra("pizza_name",getResources().getString(R.string.cheddar_supreme));
                // Start intent process:
                MainActivity.this.startActivity(intent_pizzaName);
                break;
        }


        return super.onOptionsItemSelected(item);
    }
}
