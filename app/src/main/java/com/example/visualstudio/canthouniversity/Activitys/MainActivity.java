package com.example.visualstudio.canthouniversity.Activitys;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.visualstudio.canthouniversity.Fragments.AccountInfoFragment;
import com.example.visualstudio.canthouniversity.Fragments.IndexStructureFragment;
import com.example.visualstudio.canthouniversity.Fragments.NotificationFragment;
import com.example.visualstudio.canthouniversity.Model.Notification;
import com.example.visualstudio.canthouniversity.R;
import com.example.visualstudio.canthouniversity.View.HomeView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,HomeView{
    private NavigationView navigationView;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;

    private ArrayList<Notification> notificationArrayList = new ArrayList<>();
    private RecyclerView recyclerView;
    //private NotificationAdapter mAdapter;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            mFragmentManager = getSupportFragmentManager();
            mFragmentTransaction = mFragmentManager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_AccountInfo:
                    onClickPerson();
                    return true;
                case R.id.navigation_Notification:
                    onClickNotification();
                    return true;
                case R.id.navigation_RateScore:
                    onClickRateScore();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
////                        .setAction("Action", null).show();
//                startActivity(new Intent(MainActivity.this, IndexStructureActivity.class));
//            }
//        });
//        //initialzation();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content2, AccountInfoFragment.newInstance("")).commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //init();
       // prepareNotificationData();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            startActivity(new Intent(this,LoginActivity.class));
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if(id ==  R.id.nav_logOut){
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
        /*
        * else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        }*/
    }

    private void initialzation(){

//        String arr[]={
//                "Kế hoạch học tập", "Đăng kí học phần",
//                "Kết quả học tập", "Kết quả tốt nghiệp",
//                "Nghiên cứu khoa học", "Ký túc xá","Đánh giá điểm rèn luyện"
//        };
//
//        int[] gridViewImageId = {
//                R.drawable.ic_khtt, R.drawable.ic_dkhp,
//                R.drawable.ic_kqht, R.drawable.ic_kqtn,
//                R.drawable.ic_nckh, R.drawable.ic_ktx,
//                R.drawable.ic_drl
//        };
//
//        GridView gridView = (GridView) findViewById(R.id.gridview);
//        ItemHome itemHome = new ItemHome(this,arr,gridViewImageId);
//        gridView.setAdapter(itemHome);
//
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                switch (i){
//                    case 0:
//                        break;
//                    case 1:
//                        break;
//                    case 2:
//                        break;
//                    case 3:
//                        break;
//                    case 4:
//                        break;
//                    case 5:
//                        break;
//                    case 6:
//                        createDialogChooserRateMark();
//                        break;
//                }
//            }
//        });
//
//        gallery=(TextView) MenuItemCompat.getActionView(navigationView.getMenu().
//                findItem(R.id.nav_notification));
//        gallery.setGravity(Gravity.CENTER_VERTICAL);
//        gallery.setTypeface(null, Typeface.BOLD);
//        gallery.setTextColor(getResources().getColor(R.color.colorAccent));
//        gallery.setText("99+");
//
//        tvVersion = (TextView) MenuItemCompat.getActionView(navigationView.getMenu().
//                findItem(R.id.nav_appVersion));
//        tvVersion.setGravity(Gravity.CENTER_VERTICAL);
//        tvVersion.setTypeface(null, Typeface.BOLD);
//        tvVersion.setText("1.0.1");
    }

    private void createDialogChooserRateMark(){
        String[] arr = {"Kê khai chứng chỉ ngoại ngữ, tin học"
                ,"Kê khai bài báo khoa học"
                ,"Đánh giá điểm rèn luyện cá nhân"};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Danh sách chỉ mục:")
                .setItems(arr, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int i) {
                        switch (i){
                            case 0:
                                break;
                                //startActivity(new Intent(MainActivity.this,DeclareScientificPaperActivity.class));
                            case 1:
                                //startActivity(new Intent(MainActivity.this,DeclareScientificPaperActivity.class));
                                break;
                            case 2:
                                ///startActivity(new Intent(MainActivity.this,rateMarkMainActivity.class));
                                //asfas
                                break;

                        }
                    }
                });
        builder.show();
    }

    @Override
    public void onClickPerson() {
        mFragmentTransaction.replace(R.id.content2, AccountInfoFragment.newInstance("")).commit();
    }

    @Override
    public void onClickNotification() {
        mFragmentTransaction.replace(R.id.content2, new NotificationFragment()).commit();
    }

    @Override
    public void onClickRateScore() {
        mFragmentTransaction.replace(R.id.content2, IndexStructureFragment.newInstance("","")).commit();
    }
}
