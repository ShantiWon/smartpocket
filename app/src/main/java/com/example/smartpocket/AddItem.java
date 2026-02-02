package com.example.smartpocket;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

public class AddItem extends AppCompatActivity {
    MaterialCardView needsBtn, wantsBtn;
    LinearLayout needsBg, wantsBg, needs, wants;
    TextView needsTxt, wantsTxt;
    MaterialButton logBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_item);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        needsBtn = findViewById(R.id.needsBtn);
        wantsBtn = findViewById(R.id.wantsBtn);
        needsBg = findViewById(R.id.needsBg);
        wantsBg = findViewById(R.id.wantsBg);
        needsTxt = findViewById(R.id.needsTxt);
        wantsTxt = findViewById(R.id.wantsTxt);
        needs = findViewById(R.id.needs);
        wants = findViewById(R.id.wants);
        logBtn = findViewById(R.id.logBtn);

        needsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetButton();
                needsBtn.setStrokeWidth(0);
                needsBg.setBackgroundResource(R.drawable.bg_card_needs);
                needsTxt.setTextColor(Color.WHITE);
                needs.setVisibility(View.VISIBLE);
                wants.setVisibility(View.GONE);
            }
        });
        wantsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetButton();
                wantsBtn.setStrokeWidth(0);
                wantsBg.setBackgroundResource(R.drawable.bg_card_wants);
                wantsTxt.setTextColor(Color.WHITE);
                wants.setVisibility(View.VISIBLE);
                needs.setVisibility(View.GONE);
            }
        });
        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void resetButton(){
        needsBg.setBackgroundColor(Color.WHITE);
        wantsBg.setBackgroundColor(Color.WHITE);
        needsBtn.setStrokeColor(Color.BLACK);
        wantsBtn.setStrokeColor(Color.BLACK);
        needsBtn.setStrokeWidth(6);
        wantsBtn.setStrokeWidth(6);
        needsBg.setBackgroundColor(Color.WHITE);
        wantsBg.setBackgroundColor(Color.WHITE);
        needsTxt.setTextColor(Color.BLACK);
        wantsTxt.setTextColor(Color.BLACK);
    }
}