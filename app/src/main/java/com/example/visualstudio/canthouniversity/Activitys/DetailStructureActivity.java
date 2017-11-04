package com.example.visualstudio.canthouniversity.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.example.visualstudio.canthouniversity.Fragments.detail_structure;
import com.example.visualstudio.canthouniversity.R;
import com.gc.materialdesign.views.ButtonRectangle;

/**
 * Created by Visual Studio on 10/3/2017.
 */

public class DetailStructureActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_previous:
                    transaction.replace(R.id.content,detail_structure.newInstance("","","previous")).commit();
                    return true;
                case R.id.navigation_dashboard:
                    startActivity(new Intent(DetailStructureActivity.this, IndexStructureActivity.class));
                    finish();
                    return true;
                case R.id.navigation_next:
                    transaction.replace(R.id.content,detail_structure.newInstance("","","next")).commit();
                    return true;

            }
//            switch (item.getItemId()) {
//                case R.id.navigation_previous:
//                    transaction.replace(R.id.content,detail_structure.newInstance("","","previous")).commit();
//                    return true;
//                case R.id.navigation_dashboard:
//                    startActivity(new Intent(DetailStructureActivity.this, IndexStructureActivity.class));
//                    finish();
//                    return true;
//                case R.id.navigation_next:
//                    transaction.replace(R.id.content,detail_structure.newInstance("","","Next")).commit();
//                    return true;
//            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_structure);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content,detail_structure.newInstance("","","previous")).commit();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }


}
