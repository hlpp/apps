package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {
    private int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayQuantity(quantity);
    }

    public void increment(View view) {
        quantity++;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        if (quantity == 1)
            return;
        quantity--;
        displayQuantity(quantity);
    }

    public void submitOrder(View view) {
        CheckBox whippedcreamCheckBox = (CheckBox)findViewById(R.id.whippedcream_checkbox);
        CheckBox chocolateCheckBox = (CheckBox)findViewById(R.id.chocolate_checkbox);

        float price = 5;
        if (whippedcreamCheckBox.isChecked())
            price += 1;
        if (chocolateCheckBox.isChecked())
            price += 2;
        float total = price * quantity;

        String customerName = ((EditText)findViewById(R.id.customer_name_edit_text)).getText().toString();

        String orderSummary = createOrderSummary(customerName, whippedcreamCheckBox.isChecked(), chocolateCheckBox.isChecked(), total);

        displayOrderSummary(orderSummary);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"1013644379@qq.com"});
        intent.putExtra(Intent.EXTRA_CC, new String[]{"1013644379@qq.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.order_summary_email_subject, customerName));
        intent.putExtra(Intent.EXTRA_TEXT, orderSummary);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private String createOrderSummary(String customerName, boolean addWhippedcream, boolean addChocolate, float total) {
        String message = "";
        message += getString(R.string.order_summary_name, customerName)  + "\n";
        message += getString(R.string.order_summary_add_whipped_cream, addWhippedcream ? getString(R.string.yes) : getString(R.string.no)) + "\n";
        message += getString(R.string.order_summary_add_chocolate, addChocolate ? getString(R.string.yes) : getString(R.string.no)) + "\n";
        message += getString(R.string.order_summary_quantity, quantity) + "\n";
        message += getString(R.string.order_summary_total, NumberFormat.getCurrencyInstance().format(total)) + "\n";
        message += getString(R.string.than_you);
        return message;
    }

    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView)findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayOrderSummary(String str) {
        TextView quantityTextView = (TextView)findViewById(R.id.order_summary);
        quantityTextView.setText(str);
    }
}
