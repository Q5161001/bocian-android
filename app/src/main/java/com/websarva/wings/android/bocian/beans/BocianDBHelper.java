package com.websarva.wings.android.bocian.beans;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BocianDBHelper extends SQLiteOpenHelper {

    // データベース名
    static final private String DBName = "Bocian.db";
    // データベースバージョン
    static final private int VERSION = 1;

    public BocianDBHelper(Context context) {
        super(context, DBName, null, VERSION);
    }

    // データベースが作成された時に実行される処理
    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CREATE TABLE cocktailmemo(");
        stringBuilder.append("_id INTEGER PRIMARY KEY,");
        stringBuilder.append("name TEXT,");
        stringBuilder.append("note TEXT");
        stringBuilder.append(");");
        String sql = stringBuilder.toString();

        db.execSQL(sql);
    }

    // データベースをバージョンアップした時に実行される処理
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    // データベースが開かれた時に実行される処理
    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }
}
