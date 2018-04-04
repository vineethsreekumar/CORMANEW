package com.example.vineeth.corma;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SubActivity extends Activity {
    Context mContext;
    Button next;
    EditText shopname,contactperson,contacnumber,email,website;
    public static final String MyPREFERENCES = "MyPrefs" ;

    SharedPreferences sharedpreferences;
    SharedPreferences  mPrefs;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_sub);
        next = (Button) findViewById(R.id.NEXT);
        shopname= (EditText)findViewById(R.id.shopname);
        contactperson= (EditText)findViewById(R.id.contactperson);
        contacnumber= (EditText)findViewById(R.id.contactnumber);
        email= (EditText)findViewById(R.id.Email);
        website= (EditText)findViewById(R.id.Website);
        mPrefs = getPreferences(MODE_PRIVATE);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        String shopnamesaved = mPrefs.getString("shopname", "");
        String contactpersonsaved = mPrefs.getString("contactperson", "");
        String contacnumbersaved = mPrefs.getString("contacnumber", "");
        String emailsaved = mPrefs.getString("email", "");
        String websitesaved = mPrefs.getString("website", "");
        shopname.setText(shopnamesaved);
        contactperson.setText(contactpersonsaved);
        contacnumber.setText(contacnumbersaved);
        email.setText(emailsaved);
        website.setText(websitesaved);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor prefsEditor = mPrefs.edit();
                prefsEditor.putString("shopname", shopname.getText().toString().trim());
                prefsEditor.putString("contactperson", contactperson.getText().toString().trim());
                prefsEditor.putString("contacnumber", contacnumber.getText().toString().trim());
                prefsEditor.putString("email", email.getText().toString().trim());
                prefsEditor.putString("website", website.getText().toString().trim());

                prefsEditor.commit();
                Intent myIntent = new Intent(mContext, uploadpicActivity.class);
               // myIntent.putExtra("key", value); //Optional parameters
                mContext.startActivity(myIntent);


            }
        });
    }
}
