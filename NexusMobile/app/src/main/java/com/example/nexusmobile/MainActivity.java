package com.example.nexusmobile;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnFetch = findViewById(R.id.btnFetch);
        TextView txtResult = findViewById(R.id.txtResult);

        btnFetch.setOnClickListener(v -> {
            new Thread(() -> {
                try {
                    URL url = new URL("http://192.168.246.39:8080/Nexus/api/coins");
                    HttpURLConnection conn =
                            (HttpURLConnection) url.openConnection();

                    conn.setRequestMethod("GET");
                    conn.connect();

                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(conn.getInputStream())
                    );

                    StringBuilder response = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }

                    runOnUiThread(() ->
                            txtResult.setText(response.toString())
                    );

                } catch (Exception e) {
                    runOnUiThread(() ->
                            txtResult.setText("Error fetching data")
                    );
                }
            }).start();
        });
    }
}
