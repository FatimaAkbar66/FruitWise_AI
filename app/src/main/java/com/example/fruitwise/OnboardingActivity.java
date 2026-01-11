package com.example.fruitwise;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide; // Glide library use karein images load karne ke liye

public class OnboardingActivity extends AppCompatActivity {

    private int step = 1;
    private TextView title, desc;
    private ImageView illustration;
    private Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        title = findViewById(R.id.onboardTitle);
        desc = findViewById(R.id.onboardDesc);
        illustration = findViewById(R.id.onboardIllustration);
        nextBtn = findViewById(R.id.nextBtn);

        // Initial Image (Step 1)
        loadIllustration("https://cdn-icons-png.flaticon.com/512/415/415733.png"); // Fresh Fruit Icon

        nextBtn.setOnClickListener(v -> {
            if (step == 1) {
                title.setText("AI Smart Scan");
                desc.setText("Our advanced AI model analyzes textures to distinguish between fresh and rotten fruits.");
                loadIllustration("https://cdn-icons-png.flaticon.com/512/2164/2164832.png"); // Scanning Icon
                step = 2;
            } else if (step == 2) {
                title.setText("Stay Healthy");
                desc.setText("Make informed decisions and ensure only the best quality food for your family.");
                loadIllustration("https://cdn-icons-png.flaticon.com/512/2965/2965313.png"); // Health Icon
                nextBtn.setText("Get Started");
                step = 3;
            } else {
                startActivity(new Intent(OnboardingActivity.this, MainActivity.class));
                finish();
            }
        });
    }

    // Function to load internet images easily
    private void loadIllustration(String url) {
        Glide.with(this).load(url).into(illustration);
    }
}