//package com.example.visualstudio.canthouniversity.rateMark.activity;
//
//import android.os.Bundle;
//import android.support.design.widget.TabLayout;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentPagerAdapter;
//import android.support.v4.view.ViewPager;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ExpandableListView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.JsonArrayRequest;
//import com.android.volley.toolbox.Volley;
//import com.example.visualstudio.canthouniversity.R;
//import com.example.visualstudio.canthouniversity.main.fragments.FinalMarkFragment;
//import com.example.visualstudio.canthouniversity.rateMark.Adapters.ExpandableMark;
//import com.example.visualstudio.canthouniversity.rateMark.models.CauTrucBangDiem;
//import com.example.visualstudio.canthouniversity.rateMark.models.Mark;
//import com.gc.materialdesign.widgets.ProgressDialog;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//
//public class MauChamDiemRenLuyen extends AppCompatActivity {
//
//    private SectionsPagerAdapter mSectionsPagerAdapter;
//    private ViewPager mViewPager;
//    private static final String url = "https://rotatory-religions.000webhostapp.com/getJSONEC.php";
//
//    private ArrayList<CauTrucBangDiem> cauTrucBangDiemList;
//    private ArrayList<String> kyTuLaMa;
//    private ProgressDialog mProgressDialog;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        mProgressDialog = new ProgressDialog(this,"Đang tải bảng điểm...");
//        mProgressDialog.show();
//
//        cauTrucBangDiemList = new ArrayList<>();
//        kyTuLaMa = new ArrayList<>();
//
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                for(int  i = 0; i < response.length(); i++){
//                    try {
//                        JSONObject jsonObject = response.getJSONObject(i);
//                        cauTrucBangDiemList.add(new CauTrucBangDiem(jsonObject.getString("idItem")
//                                ,jsonObject.getString("itemName")
//                                ,jsonObject.getInt("scores")
//                                ,jsonObject.getString("describe")
//                                ,jsonObject.getString("IDParent")));
//
//                        if(jsonObject.getString("IDParent").equals("")){
//                            kyTuLaMa.add(jsonObject.getString("idItem"));
//                        }
//                    } catch (JSONException e) {
//                        Toast.makeText(MauChamDiemRenLuyen.this, "Không có kết nối mạng! vui lòng thử lại!" + e.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                }
//                mProgressDialog.dismiss();
//                init();
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//        requestQueue.add(jsonArrayRequest);
//    }
//
//    private void init(){
//        setContentView(R.layout.activity_tab_mark);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
//
//        // Set up the ViewPager with the sections adapter.
//        mViewPager = (ViewPager) findViewById(R.id.container);
//        mViewPager.setAdapter(mSectionsPagerAdapter);
//
//        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
//        tabLayout.setupWithViewPager(mViewPager);
//    }
//
//    /**
//     * Đây là một Fragment của e khi trả về
//     */
//    public static class PlaceholderFragment extends Fragment {
//        /**
//         * Fragment tab mark
//         *
//         */
//        private static final String ITEM_NAME = "titleOfIndex";
//        private static final String GROUP_ITEM_NAME_LIST = "GROUP";
//        private ArrayList<Mark> markList;
//        public PlaceholderFragment() {
//
//        }
//        public static PlaceholderFragment newInstance(String titleofIndex,ArrayList<Mark> markList) {
//            PlaceholderFragment fragment = new PlaceholderFragment();
//            Bundle args = new Bundle();
//            args.putString(ITEM_NAME,titleofIndex);
//            args.putSerializable(GROUP_ITEM_NAME_LIST, (Serializable) markList);
//            fragment.setArguments(args);
//            return fragment;
//        }
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                 Bundle savedInstanceState) {
////            View rootView = inflater.inflate(R.layout.fragment_tab_mark, container, false);
////            TextView tvTitle = (TextView) rootView.findViewById(R.id.textView_itemNameOfIndex);
////            tvTitle.setText(getArguments().getString(ITEM_NAME));
////            markList = (ArrayList<Mark>) getArguments().getSerializable(GROUP_ITEM_NAME_LIST);
////            ExpandableListView mExpandableListView = rootView.findViewById(R.id.ExpandableListViewMark);
////            ExpandableMark adapter = new ExpandableMark(this.getActivity(),markList);
////            mExpandableListView.setAdapter(adapter);
////            adapter.notifyDataSetChanged();
//            return null;//rootView;
//        }
//
//    }
//
//
//
//    /*
//    * FragmentPagerAdapter
//    * */
//    public class SectionsPagerAdapter extends FragmentPagerAdapter {
//        public SectionsPagerAdapter(FragmentManager fm) {
//            super(fm);
//        }
//        @Override
//        public Fragment getItem(int position) {
//            /*
//            * Lấy ra cac chỉ mục có IdItem mà không có IdParent để đặt tiêu đề cho Tab
//            * Lấy ra tất cả các con có IDParent tương ứng với mỗi mục cha vd: "I" => IDParent "I"
//            *   + Nếu tiêu đề con có thêm nhiều con nữa:
//            *
//            *   + Nếu tiêu đề con không có con nào nữa:
//            *
//            * */
//            String idItem = kyTuLaMa.get(position); //Vị trí 0 => "I"
//            String itemName = null;
//            ArrayList<Mark> group = new ArrayList<>();
//
//            if(position == kyTuLaMa.size() - 1){
//                return FinalMarkFragment.newIntance("Tổng điểm các điều");
//            }else {
//
//                for (int i = 0; i < cauTrucBangDiemList.size(); i++) {
//                    if (idItem.equals(cauTrucBangDiemList.get(i).getIdItem())) {
//                        itemName = cauTrucBangDiemList.get(i).getItemName();
//                        break;
//                    }
//                }
//                for (int i = 0; i < cauTrucBangDiemList.size(); i++) {
//                    //('I.a', 'a. Ý thức và thái độ trong học tập.',0, '', 'I'),
//                    if (cauTrucBangDiemList.get(i).getIDParent().equals(idItem)) {
//                        group.add(new Mark(cauTrucBangDiemList.get(i).getIdItem()
//                                ,cauTrucBangDiemList.get(i).getItemName()
//                                ,cauTrucBangDiemList.get(i).getScores()
//                                ,cauTrucBangDiemList.get(i).getDescribe()
//                                ,cauTrucBangDiemList.get(i).getIDParent()
//                                ,null));
//                    }
//                }
//
//                /*
//                * Duyệt qua từng chỉ mục I.a,I.b tìm  ra các con của nó.
//                * Nếu con của nó không có con nào khác thì thêm nó vào.
//                * Nếu con của nó có chứa nhiều đứa con khác thì duyệt qua các con nhỏ hơn vò thêm vào
//                * và set giá trị child bằng false
//                *   Tiếp tục tìm trong mỗi đứa con nó có bao nhiêu con khác thêm vào nó.
//                * */
//                for (int i = 0; i < group.size(); i++) {
//                    String idItemGroup = group.get(i).getIdItem();
//                    ArrayList<Mark> child = new ArrayList<>();
//
//                    for(int j = 0; j < cauTrucBangDiemList.size(); j++){
//                        if(cauTrucBangDiemList.get(j).getIDParent().equals(idItemGroup)){
//                            child.add(new Mark(cauTrucBangDiemList.get(j).getIdItem()
//                                    ,cauTrucBangDiemList.get(j).getItemName()
//                                    ,cauTrucBangDiemList.get(j).getScores()
//                                    ,cauTrucBangDiemList.get(j).getDescribe()
//                                    ,cauTrucBangDiemList.get(j).getIDParent()
//                                    ,null));
//                        }
//                        //di qua tung con kiem tra xem con danh sach con nao nua khong, neu con thi set
//                        //bang false;
//                        for(int x = 0; x < child.size() ; x++){
//                            ArrayList<Mark> secondChild = null;
//                            String idItemChild = child.get(x).getIdItem(); //I.a.1
//                            for(int y = 0; y < cauTrucBangDiemList.size(); y++){
//                                if(cauTrucBangDiemList.get(y).getIDParent().equals(idItemChild)){
//                                    child.get(x).setChild(false);
//                                }else {
//                                    //Tìm trong mỗi thằng con còn có bao nhiêu con khác nữa.
//                                    secondChild = new ArrayList<>();
//                                    for(int z = 0; z < cauTrucBangDiemList.size(); z++){
//                                        if(cauTrucBangDiemList.get(z).getIDParent().equals(idItemChild)){
//                                            secondChild.add(new Mark(cauTrucBangDiemList.get(z).getIdItem()
//                                                    ,cauTrucBangDiemList.get(z).getItemName()
//                                                    ,cauTrucBangDiemList.get(z).getScores()
//                                                    ,cauTrucBangDiemList.get(z).getDescribe()
//                                                    ,cauTrucBangDiemList.get(z).getIDParent()
//                                                    ,null));
//                                        }
//                                    }
//                                }
//                            }
//                            child.get(x).setMarkChildList(secondChild);
//                        }
//                    }
//                    group.get(i).setMarkChildList(child);
//                }
//            }
//            return PlaceholderFragment.newInstance(itemName,group);
//
//        }
//
//        @Override
//        public int getCount() {
//            return kyTuLaMa.size();
//        }
//
//        @Override
//        public CharSequence getPageTitle(int position) {
//            if(position == kyTuLaMa.size() - 1){
//                return "Tổng điểm các điều";
//            }
//            return "Mục :"+ kyTuLaMa.get(position);
//        }
//    }
//}
