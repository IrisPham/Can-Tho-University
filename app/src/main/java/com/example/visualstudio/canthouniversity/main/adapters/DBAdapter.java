package com.example.visualstudio.canthouniversity.modules.main.adapters;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Visual Studio on 7/31/2017.
 */

public class DBAdapter {
    public static final String TAG = "DBAdapter";
    public static final String DATABASE_NAME = "CTUDB";
    public static final String DATABASE_TABLE = "account";
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_CRETAE = "create table account(idAccount primary key" +
            ",accountName text not null" +
            ",brithday text not null" +
            ",address text" +
            ",sex text" +
            ",phone text" +
            ",email" +
            ",position text" +
            ",passWord text";
    private Context context;
    private DatabaseHelper DBHelper;
    public  SQLiteDatabase db;

    public DBAdapter(Context context){
        this.context = context;
        DBHelper = new DatabaseHelper(context);
    }

    public static class DatabaseHelper extends SQLiteOpenHelper{

        public DatabaseHelper(Context context){
            super(context,DATABASE_NAME,null,DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            try{
                sqLiteDatabase.execSQL(DATABASE_CRETAE);
            }catch (SQLException e){
                Toast.makeText(null, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            Toast.makeText(null, "Upgrading database from version "+DATABASE_VERSION
                    , Toast.LENGTH_LONG).show();
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + DATABASE_TABLE);
            onCreate(sqLiteDatabase);
        }
    }

    //Connect SQL
    public DBAdapter open() throws SQLException{
        db = DBHelper.getWritableDatabase();
        return this;
    }

    //Close SQL
    public void close(){
        DBHelper.close();
    }

    //insert data into table account
    public long insertAccount(String idAccount,String accountName, String birthday, String address,
                              String sex, String phone, String email, String positon, String passWord){
        ContentValues contentValue = new ContentValues();
        contentValue.put("idAccount",idAccount);
        contentValue.put("accountName",accountName);
        contentValue.put("birthday",birthday);
        contentValue.put("address",address);
        contentValue.put("sex",sex);
        contentValue.put("phone",phone);
        contentValue.put("email",email);
        contentValue.put("positon",positon);
        contentValue.put("passWord",passWord);
        return db.insert(DATABASE_TABLE,null,contentValue);
    }

    //delete data table account
    public boolean deleteAccount(long rowId){
        return db.delete(DATABASE_TABLE,"idAccount = N'"+ rowId+ "'",null) > 0;
    }

    //update data table
    public boolean update(String idAccount){
        ContentValues contentValues = new ContentValues();
        contentValues.put("idAccount",idAccount);
        return db.update(DATABASE_TABLE,contentValues,null,null) > 0;
    }

    //get all data AccountObj
    public Cursor getAllDataAccount(){
        return db.query(DATABASE_TABLE,new String[]{"idAccount","accountNAme","birthday"},null,null,null,null,null);
    }

    //get data with where query
    public Cursor getDataWithWehreQuery(String idAccount){
        Cursor mCursor = db.query(true,DATABASE_TABLE,new String[]{"idAccount","accountNAme","birthday"}
                ,"idAccount = N'"+ idAccount,null,null,null,null,null);
        if(mCursor == null){
            mCursor.moveToFirst();
        }
        return  mCursor;
    }



}
