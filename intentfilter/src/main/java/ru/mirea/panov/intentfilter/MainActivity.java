package ru.mirea.panov.intentfilter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonOpenBrowser = findViewById(R.id.buttonOpenBrowser);
        Button buttonShareData = findViewById(R.id.buttonShareData);

        buttonOpenBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri address = Uri.parse("https://www.mirea.ru/");
                Intent openLinkIntent = new Intent(Intent.ACTION_VIEW, address);
                startActivity(openLinkIntent);
            }
        });

        buttonShareData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "MIREA");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Панов Александр Денисович");
                startActivity(Intent.createChooser(shareIntent, "Мои ФИО"));
            }
        });
    }

}