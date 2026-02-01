package com.example.smartpocket;

import static java.security.AccessController.getContext;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Step2 extends AppCompatActivity {
    CardView needs, divided;
    Button continueBtn;
    LinearLayout needsLayout, dividedLayout;
    TextView title, title2, desc, desc2;
    boolean isRecommended = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_step2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        continueBtn = findViewById(R.id.continueBtn);
        needs = findViewById(R.id.needs);
        divided = findViewById(R.id.divided);
        needsLayout = findViewById(R.id.needsLayout);
        dividedLayout = findViewById(R.id.dividedLayout);
        title = findViewById(R.id.title);
        title2 = findViewById(R.id.title2);
        desc = findViewById(R.id.desc);
        desc2 = findViewById(R.id.desc2);

        divided.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dividedLayout.setBackground(ContextCompat.getDrawable(Step2.this, R.drawable.bg_selected));
                needsLayout.setBackgroundColor(Color.WHITE);
                title.setTextColor(Color.WHITE);
                title2.setTextColor(Color.BLACK);
                desc.setTextColor(Color.WHITE);
                desc2.setTextColor(Color.BLACK);
                isRecommended = true;
            }
        });

        needs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                needsLayout.setBackground(ContextCompat.getDrawable(Step2.this, R.drawable.bg_selected));
                dividedLayout.setBackgroundColor(Color.WHITE);
                title2.setTextColor(Color.WHITE);
                title.setTextColor(Color.BLACK);
                desc2.setTextColor(Color.WHITE);
                desc.setTextColor(Color.BLACK);
                isRecommended = false;
            }
        });
        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                if(isRecommended){
                    intent = new Intent(Step2.this, DividedBudget.class);
                }else {
                    intent = new Intent(Step2.this, NeedsWants.class);
                }

                startActivity(intent);
            }
        });
    }
}