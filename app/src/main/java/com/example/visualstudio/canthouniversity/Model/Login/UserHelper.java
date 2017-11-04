//package com.example.visualstudio.canthouniversity.Model.Login;
//
//import android.content.Context;
//import android.content.DialogInterface;
//import android.util.Log;
//import android.widget.Toast;
//
//import com.android.volley.AuthFailureError;
//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.JsonArrayRequest;
//import com.android.volley.toolbox.StringRequest;
//import com.android.volley.toolbox.Volley;
//import com.example.visualstudio.canthouniversity.rateMark.activity.MauChamDiemRenLuyen;
//import com.example.visualstudio.canthouniversity.rateMark.models.CauTrucBangDiem;
//import com.gc.materialdesign.widgets.ProgressDialog;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Created by Visual Studio on 10/1/2017.
// */
//
//public class UserHelper{
//    private String url;
//    private User user;
//    private Context mContext;
//    private OnLoadUserResult onLoadUserResult;
//
//    public UserHelper(String url, OnLoadUserResult onLoadUserResult, Context context) {
//        this.url = url;
//        this.mContext = context;
//        this.onLoadUserResult = onLoadUserResult;
//    }
//
//    public void getUserFromDB(){
//        RequestQueue requestQueue = Volley.newRequestQueue(mContext);
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                Log.e("TAG",response.toString());
//                if(response != null){
//                    try {
//                        JSONObject jsonObject = response.getJSONObject(0);
//                        user = new User(jsonObject.getString("idAccount")
//                                ,jsonObject.getString("accountName")
//                                ,jsonObject.getString("birthday")
//                                ,jsonObject.getString("address")
//                                ,jsonObject.getString("sex")
//                                ,jsonObject.getString("phone")
//                                ,jsonObject.getString("email")
//                                ,jsonObject.getString("password")
//                                ,jsonObject.getString("Permission_position"));
//
//                        onLoadUserResult.onSuccess(user);
//                    } catch (JSONException e) {
//                        onLoadUserResult.onFail(e.getMessage());
//                    }
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                onLoadUserResult.onFail(error.getMessage());
//            }
//        });
//        requestQueue.add(jsonArrayRequest);
//    }
//}
