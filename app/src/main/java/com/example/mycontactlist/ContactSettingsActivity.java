package com.example.mycontactlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;

public class ContactSettingsActivity extends AppCompatActivity {

    private Object view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_settings);

        initListButton();
        initMapButton();
        initSettingsButton();
    }

    private void initListButton() {
        ImageButton ibList = findViewById(R.id.imageButtonList);
        ibList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(ContactSettingsActivity.this, ContactListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    private void initMapButton() {
        ImageButton ibList = findViewById(R.id.imageButtonMap);
        ibList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(ContactSettingsActivity.this, ContactMapActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    private void initSettingsButton() {
        ImageButton ibSettings=(ImageButton)findViewById(R.id.imageButtonSettings);
        ibSettings.setEnabled(false);


        }
    private void initSettings(){
        String sortBy=getSharedPreferences("MyContactListPreferences", Context.MODE_PRIVATE).getString("sortfield","contactname");
        String sortOrder=getSharedPreferences("MyContactListPrefences",Context.MODE_PRIVATE).getString("sortorder","ASC");

        RadioButton rbName=(RadioButton) findViewById(R.id.radioName);
        RadioButton rbCity=(RadioButton) findViewById(R.id.radioCity);
        RadioButton rbBirthday=(RadioButton) findViewById(R.id.radioBirthday);
        if(sortBy.equalsIgnoreCase("contactname")){
            rbName.setChecked(true);
        }
        else if (sortBy.equalsIgnoreCase("City")){
            rbCity.setChecked(true);
        }
        else{
            rbBirthday.setChecked(true);
        }
        RadioButton rbAscending=(RadioButton) findViewById(R.id.radioAscending);
        RadioButton rbDescending=(RadioButton) findViewById(R.id.radioDescending);
        if(sortOrder.equalsIgnoreCase("ASC")){
            rbAscending.setChecked(true);
        }
        else{
            rbDescending.setChecked(true);
        }
    }

}
