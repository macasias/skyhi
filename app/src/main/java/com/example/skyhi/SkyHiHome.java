package com.example.skyhi;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static java.net.Proxy.Type.HTTP;

public class SkyHiHome extends AppCompatActivity {
    //public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sky_hi_home);
        setTitle("Welcome!");
        EditText Ed1 = (EditText)findViewById(R.id.contact_message);
        EditText Ed2 = (EditText)findViewById(R.id.login_message);
        disableEditText(Ed1);
        disableEditText(Ed2);
    }

    public void goToLogin(View view) {
        Intent intent = new Intent(this, LoginScreen.class);
        startActivity(intent);
    }

    public void goToTroubleshootScreen(View view) {
        Intent intent = new Intent(this, TroubleshootScreen.class);
        startActivity(intent);
    }

    public void callSkyHi(View view) {
        Uri number = Uri.parse("tel:5555555555");
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
        startActivity(callIntent);
    }

    public void emailSkyhi(View view) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("message/rfc822");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"admin@skyhibroadband.com"}); // recipients
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Trouble Shooting");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "I don't fucking know what to put here");
        startActivity(emailIntent);
    }

    private void disableEditText(EditText editText) {
        editText.setFocusable(false);
        editText.setEnabled(false);
        editText.setCursorVisible(false);
        editText.setKeyListener(null);
        editText.setBackgroundColor(Color.TRANSPARENT);
    }
}
