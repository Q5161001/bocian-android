package com.websarva.wings.android.bocian.beans;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.websarva.wings.android.bocian.data.DepartmentData;
import com.websarva.wings.android.bocian.data.EmployeeData;

import java.util.ArrayList;
import java.util.List;

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
        /*
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CREATE TABLE cocktailmemo(");
        stringBuilder.append("_id INTEGER PRIMARY KEY,");
        stringBuilder.append("name TEXT,");
        stringBuilder.append("note TEXT");
        stringBuilder.append(");");
        String sql = stringBuilder.toString();

        db.execSQL(sql);
        */
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

    // 社員データを取得するメソッド
    // selection = 検索条件
    public static List<EmployeeData> getEmployee(SQLiteDatabase db, String selection, String orderBy) {

        String table = "Employee";
        List<EmployeeData> list = new ArrayList<>();

        Cursor cursor = db.query(table, null, selection, null, null, null, orderBy);

        // cursorオブジェクトにtry with resourcesを使うとメモリリークが発生するとか
        try {
            while (cursor.moveToNext()) {
                 list.add(new EmployeeData(cursor, 0));
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        } finally {
            try {
                cursor.close();
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }

        return list;
    }
    // 社員データを取得するメソッド
    // selection = 検索条件
    public static List<DepartmentData> getDepartment(SQLiteDatabase db, String selection, String orderBy) {

        String table = "Department";
        List<DepartmentData> list = new ArrayList<>();

        Cursor cursor = db.query(table, null, selection, null, null, null, orderBy);

        // cursorオブジェクトにtry with resourcesを使うとメモリリークが発生するとか
        try {
            while (cursor.moveToNext()) {
                list.add(new DepartmentData(cursor, 0));
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        } finally {
            try {
                cursor.close();
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }

        return list;
    }
}
