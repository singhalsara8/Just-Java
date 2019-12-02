/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;



import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int numberOfCoffees=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        display(numberOfCoffees);
        EditText nameField=findViewById(R.id.name_field);
        String name=nameField.getText().toString();

        CheckBox addChocolate= findViewById(R.id.chocolateCheckBox);
        boolean hasChocolate=addChocolate.isChecked();

        CheckBox addCream= findViewById(R.id.whippedCreamCheckBox);
        boolean hasCream=addCream.isChecked();

        int price = numberOfCoffees*5;

        String priceMessage=createOrderSummary(name, price, hasChocolate, hasCream);
        displayMessage(priceMessage);
    }

    /**
     * this method is called when the increment button is clicked
     */
    public void increment(View view){
        numberOfCoffees+=1;
        display(numberOfCoffees);
    }

    /**
     * this method is called when the decrement button is clicked
     */
    public void decrement(View view){
        numberOfCoffees-=1;
        display(numberOfCoffees);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    @SuppressLint("SetTextI18n")
    private void display(int number) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
   /* private void displayPrice(int number){
        TextView priceTextView = findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }*/
    private void displayMessage(String message){
        TextView priceTextView= findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
    private String createOrderSummary(String name, int price, boolean hasChocolate, boolean hasCream){
        String priceMeassage = "NAME: "+name;
        priceMeassage+="\nAdd Whipped Cream? "+ hasCream;
        priceMeassage+="\nAdd chocolate? "+hasChocolate;
        priceMeassage+="\nQuantity: "+numberOfCoffees;
        priceMeassage+="\nTotal: "+ price;
        priceMeassage+="\nthanks!";
        return priceMeassage;
    }
}