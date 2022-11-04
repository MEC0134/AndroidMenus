package com.example.menus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    // Declare
    EditText editTxt1;
    EditText editTxt2;
    TextView txtVwResults;
    TextView txtVwActTwo;
    Button btnSave;
    Button btnDelete;
    SharedPreferences sharedPreferences;
    String fName;
    String lName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize
        editTxt1 = findViewById(R.id.editTxt1);
        editTxt2 = findViewById(R.id.editTxt2);
        btnSave = findViewById(R.id.btnSave);
        btnDelete = findViewById(R.id.btnDelete);
        txtVwActTwo = findViewById(R.id.txtVwActTwo);


        // Show results during onCreate
        sharedPreferences = this.getSharedPreferences("com.example.menus", Context.MODE_PRIVATE);
        fName = sharedPreferences.getString("firstName", "No First Name");
        lName = sharedPreferences.getString("lastName", "No Last Name");



    } // OnCreate Ends


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.example_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        String firstName = editTxt1.getText().toString();
        String lastName = editTxt2.getText().toString();

        if (item.getItemId() == R.id.page_one)
        {
            // Intent 1
            Intent pageTwoIntent = new Intent(this, pageTwoActivity.class);
            pageTwoIntent.putExtra("fName", firstName);
            pageTwoIntent.putExtra("lName", lastName);
            startActivity(pageTwoIntent);
        }
        return super.onOptionsItemSelected(item);
    }





    // On Click of Save Button
    public void save(View view) {

        String firstName = editTxt1.getText().toString();
        String lastName = editTxt2.getText().toString();


            // Store firstName and lastName inside SharedPreferences
            sharedPreferences.edit().putString("firstName", firstName).apply();
            sharedPreferences.edit().putString("lastName", lastName).apply();
    }


    // On Click of Delete Button
    public void delete(View view) {


        sharedPreferences.edit().remove("firstName").apply();
        sharedPreferences.edit().remove("lastName").apply();

    }
}