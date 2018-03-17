package dz.esi.facereco.activities;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.Locale;

import dz.esi.facereco.preference.AppPreference;

public class MainActivity extends AppCompatActivity {

    private TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(dz.esi.facereco.R.layout.activity_main);

        if (getString(dz.esi.facereco.R.string.subscription_key).startsWith("Please")) {
            new AlertDialog.Builder(this)
                    .setTitle(getString(dz.esi.facereco.R.string.add_subscription_key_tip_title))
                    .setMessage(getString(dz.esi.facereco.R.string.add_subscription_key_tip))
                    .setCancelable(false)
                    .show();
        }
    }

    public void detection(View view) {
        Intent intent = new Intent(this, DetectionActivity.class);
        startActivity(intent);
    }

    public void verification(View view) {
        Intent intent = new Intent(this, VerificationMenuActivity.class);
        startActivity(intent);
    }

    public void grouping(View view) {
        Intent intent = new Intent(this, GroupingActivity.class);
        startActivity(intent);
    }

    public void findSimilarFace(View view) {
        Intent intent = new Intent(this, FindSimilarFaceActivity.class);
        startActivity(intent);
    }

    public void identification(View view) {
        Intent intent = new Intent(this, IdentificationActivity.class);
        startActivity(intent);
    }

    public void lecture(View view) {
        final String personne = AppPreference.getLastPerson(this);
        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(final int status) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if (status != TextToSpeech.ERROR) {
                            textToSpeech.setLanguage(Locale.FRANCE);
                            textToSpeech.speak(personne, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }
                }).start();
            }
        });
        Toast.makeText(this, personne, Toast.LENGTH_LONG).show();
    }
}
