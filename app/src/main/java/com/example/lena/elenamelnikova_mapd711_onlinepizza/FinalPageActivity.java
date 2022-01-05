package com.example.lena.elenamelnikova_mapd711_onlinepizza;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FinalPageActivity extends AppCompatActivity {
    //Declare textView
    private TextView textView_order_details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_page);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Get incoming intent:
        final Intent intent_customer_info = getIntent();

        //Extract strings "pizza_name" from intent_customer_info Extra:
        String pizza_name = intent_customer_info.getStringExtra("pizza_name");

        //Extract strings "pizza_size" from iintent_customer_info Extra:
        String pizza_size = intent_customer_info.getStringExtra("pizza_size");

        //Extract string "pizza_toppings" from intent_customer_info Extra:
        String pizza_toppings = intent_customer_info.getStringExtra("pizza_toppings");

        //Extract strings "customer_info" from intent_customer_info Extra:
        String first_name = intent_customer_info.getStringExtra("first_name");
        String last_name = intent_customer_info.getStringExtra("last_name");
        String address = intent_customer_info.getStringExtra("address");
        String postalCode = intent_customer_info.getStringExtra("postalCode");
        String telephoneNumber = intent_customer_info.getStringExtra("telephoneNumber");
        // Credit card info is not currently used
        String cardType = intent_customer_info.getStringExtra("cardType");
        String cardNumber = intent_customer_info.getStringExtra("cardNumber");
//        String expiryDate = intent_customer_info.getStringExtra("expiryDate");

        //Define textView field
        textView_order_details = findViewById(R.id.textView_order_details);

        String str = "";
        if(!cardType.equals("Select card type")) {
            str = "Order paid by (" + cardType + ": " + cardNumber + ")";
        }

        String text =
                "Pizza: " + pizza_size + " " + pizza_name +
                "\n" +
                "Toppings: " + pizza_toppings +
                "\n" +
                "Delivery address: " + address + " " + postalCode +
                "\n" +
                "Phone: " + telephoneNumber +
                "\n" +
                "Contact name: " + first_name + " " + last_name +
                "\n" +
                "\n" +
                str;

        textView_order_details.setText(text);
    }
}
