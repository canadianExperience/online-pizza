package com.example.lena.elenamelnikova_mapd711_onlinepizza;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;


public class CustomerInformationActivity extends AppCompatActivity {
    //Declare EditText fields
    private EditText editText_firstName,
            editText_lastName,
            editText_address,
            editText_postalCode,
            editText_telephoneNumber,
            editText_cardNumber,
            editText_expiryDate;

    //Declare Spinner
    private Spinner types_spinner;

    //Declare intent customer_info
    private Intent intent_customer_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_information);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //Define editText fields by id
        editText_firstName = findViewById(R.id.editText_firstName_id);
        editText_lastName = findViewById(R.id.editText_lastName_id);
        editText_address = findViewById(R.id.editText_address_id);
        editText_postalCode = findViewById(R.id.editText_postalCode_id);
        editText_telephoneNumber = findViewById(R.id.editText_telephoneNumber_id);
        editText_cardNumber = findViewById(R.id.editText_cardNumber_id);
        editText_expiryDate = findViewById(R.id.editText_expiryDate_id);

        types_spinner = findViewById(R.id.types_spinner);

        // Create new intent_customer_info
        intent_customer_info = new Intent(CustomerInformationActivity.this, FinalPageActivity.class);

        // Get incoming intent:
        final Intent intent_pizzaToppings = getIntent();

        //Extract strings "pizza_name" from intent_PizzaToppings Extra:
        String pizza_name = intent_pizzaToppings.getStringExtra("pizza_name");

        //Extract strings "pizza_size" from intent_PizzaToppings Extra:
        String pizza_size = intent_pizzaToppings.getStringExtra("pizza_size");

        //Extract string "pizza_toppings" from intent_PizzaToppings Extra:
        String pizza_toppings = intent_pizzaToppings.getStringExtra("pizza_toppings");

        //Set pizza name into intent_customer_info Extra:
        intent_customer_info.putExtra("pizza_name", pizza_name);

        //Set pizza size into intent_customer_info Extra:
        intent_customer_info.putExtra("pizza_size", pizza_size);

        //Set pizza toppings into intent_customer_info Extra:
        intent_customer_info.putExtra("pizza_toppings", pizza_toppings);
    }

    //Button click event
    public void onOrderPizza(View view) {

        //Put customer information into intent Extra
        intent_customer_info.putExtra("first_name", editText_firstName.getText().toString());
        intent_customer_info.putExtra("last_name", editText_lastName.getText().toString());
        intent_customer_info.putExtra("address", editText_address.getText().toString());
        intent_customer_info.putExtra("postalCode", editText_postalCode.getText().toString());
        intent_customer_info.putExtra("telephoneNumber", editText_telephoneNumber.getText().toString());
        intent_customer_info.putExtra("cardType", types_spinner.getSelectedItem().toString());
        intent_customer_info.putExtra("cardNumber", editText_cardNumber.getText().toString());
        intent_customer_info.putExtra("expiryDate", editText_expiryDate.getText().toString());

        // Start new activity
        CustomerInformationActivity.this.startActivity(intent_customer_info);
    }

}
