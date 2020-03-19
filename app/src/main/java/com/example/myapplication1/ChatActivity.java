package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;

import java.net.URISyntaxException;

public class ChatActivity extends Activity implements Chat{

    EditText text;
    TextView zoneText;
    Button envoyer;
    ScrollView scroll;
    String surname;
    Preferences preferences;
    Switch aSwitch;
    Ecouteur ecouteur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_layout);

        text = findViewById(R.id.inputText);
        zoneText = findViewById(R.id.chat);
        envoyer = findViewById(R.id.envoyer);
        aSwitch = findViewById(R.id.connexion);
        scroll = findViewById(R.id.scroll);
        surname = "AZDOUZ : ";

        preferences = new Preferences("Azdouz");
        ecouteur = new Ecouteur(this, preferences);

        envoyer.setOnClickListener(ecouteur);
        aSwitch.setOnCheckedChangeListener(ecouteur);
    }

    @Override
    public String getWrittenText() {
        return text.getText().toString();
    }

    @Override
    public void addMessage(final String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                zoneText.append(msg+"\n");
                scroll.fullScroll(View.FOCUS_DOWN);
            }
        });

    }
}
