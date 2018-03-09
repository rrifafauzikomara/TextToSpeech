package com.example.rifafauzi6.texttospeech;

import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button buttonSpeak;
    EditText editText;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSpeak = findViewById(R.id.buttonSpeak);
        editText = findViewById(R.id.editText);
        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                //method untuk mendeteksi suara dari text
                if(status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(new Locale("id", "ID"));
                    //menggunakan bahasa indonesia
                }
            }
        });

        buttonSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mengambil nilai value dari inputan edittext
                String text = editText.getText().toString();
                //untuk penanganan masalah deprecated pada saat memanggil suara
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null,null);
                } else {
                    textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
                }
            }
        });
    }
}