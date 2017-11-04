package com.example.visualstudio.canthouniversity.modules.main.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Visual Studio on 7/31/2017.
 */

public class Account extends SQLiteOpenHelper {
    public static final String DATABASE_CRETAE = "create table account(idAccount primary key" +
            ",accountName text not null" +
            ",brithday text not null" +
            ",address text" +
            ",sex text" +
            ",phone text" +
            ",email" +
            ",position text" +
            ",passWord text";

    //Hàm này dùng để cung cấp thông số cần thiêt để SQLiteOpenHelper hoạt động
    public Account(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //hàm này dùng để taoj tập tinh lưu trữ CSDL, tạo các bảng, cột ,...
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    //Hàm này dùng để cập nhật lại các bảng trong CSDL
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
