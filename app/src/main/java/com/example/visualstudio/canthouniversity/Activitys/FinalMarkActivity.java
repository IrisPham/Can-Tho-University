package com.example.visualstudio.canthouniversity.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.visualstudio.canthouniversity.R;
import com.gc.materialdesign.views.ButtonRectangle;

public class FinalMarkActivity extends AppCompatActivity {
    private ButtonRectangle btnNavigationHome;
    private ButtonRectangle btnReRateMark;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_mark);
        btnNavigationHome = (ButtonRectangle) findViewById(R.id.Button_backHome);
        btnNavigationHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FinalMarkActivity.this, MainActivity.class));
            }
        });
        btnReRateMark = (ButtonRectangle) findViewById(R.id.Button_reRateMark);
        btnReRateMark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FinalMarkActivity.this, IndexStructureActivity.class));
            }
        });
    }

}
