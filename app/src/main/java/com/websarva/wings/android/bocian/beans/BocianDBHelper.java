package com.websarva.wings.android.bocian.beans;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.websarva.wings.android.bocian.R;
import com.websarva.wings.android.bocian.beans.Constants;
import com.websarva.wings.android.bocian.data.AdministratorData;
import com.websarva.wings.android.bocian.data.CompanyData;
import com.websarva.wings.android.bocian.data.ConferenceEquipmentData;
import com.websarva.wings.android.bocian.data.ConferenceRoomData;
import com.websarva.wings.android.bocian.data.DepartmentData;
import com.websarva.wings.android.bocian.data.EmployeeData;
import com.websarva.wings.android.bocian.data.EquipmentData;
import com.websarva.wings.android.bocian.data.ExternalParticipantData;
import com.websarva.wings.android.bocian.data.InParticipantData;
import com.websarva.wings.android.bocian.data.PositionData;
import com.websarva.wings.android.bocian.data.PurposeData;
import com.websarva.wings.android.bocian.data.ReserveData;
import com.websarva.wings.android.bocian.data.RgularMeetingData;
import com.websarva.wings.android.bocian.data.TemporaryReserveData;
import com.websarva.wings.android.bocian.data.TerminalData;


import java.util.ArrayList;
import java.util.List;

public class BocianDBHelper extends SQLiteOpenHelper {


    public BocianDBHelper(Context context) {
        super(context, Constants.DB.DBName, null, Constants.DB.VERSION);
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

    // 社員データを取得するメソッド
    // selection = 検索条件

    /**
     * @param db データベース
     * @param table テーブル名
     * @param selection 条件
     * @param orderBy 順
     * @return list<T> 指定したテーブルに対応するクラスのリスト
     */
    public static <T> List<T> getDataList(SQLiteDatabase db, String table, String selection, String orderBy) {
        List<T> list = new ArrayList<>();

        Cursor cursor = db.query(table, null, selection, null, null, null, orderBy);

        // cursorオブジェクトにtry with resourcesを使うとメモリリークが発生するとか
        try {
            switch (table){
                case Constants.DB.tableAdministrator:
                    while (cursor.moveToNext()) list.add((T) (new AdministratorData(cursor, 0)));
                case Constants.DB.tableCompany:
                    while (cursor.moveToNext()) list.add((T) (new CompanyData(cursor, 0)));
                case Constants.DB.tableConferenceEquipment:
                    while (cursor.moveToNext()) list.add((T) (new ConferenceEquipmentData(cursor, 0)));
                case Constants.DB.tableConferenceRoom:
                    while (cursor.moveToNext()) list.add((T) (new ConferenceRoomData(cursor, 0)));
                case Constants.DB.tableDepartment:
                    while (cursor.moveToNext()) list.add((T) (new DepartmentData(cursor, 0)));
                case Constants.DB.tableEmployee:
                    while (cursor.moveToNext()) list.add((T) (new EmployeeData(cursor, 0)));
                case Constants.DB.tableEquipment:
                    while (cursor.moveToNext()) list.add((T) (new EquipmentData(cursor, 0)));
                case Constants.DB.tableExternalParticipant:
                    while (cursor.moveToNext()) list.add((T) (new ExternalParticipantData(cursor, 0)));
                case Constants.DB.tableInParticipant:
                    while (cursor.moveToNext()) list.add((T) (new InParticipantData(cursor, 0)));
                case Constants.DB.tablePosition:
                    while (cursor.moveToNext()) list.add((T) (new PositionData(cursor, 0)));
                case Constants.DB.tablePurpose:
                    while (cursor.moveToNext()) list.add((T) (new PurposeData(cursor, 0)));
                case Constants.DB.tableReserve:
                    while (cursor.moveToNext()) list.add((T) (new ReserveData(cursor, 0)));
                case Constants.DB.tableRgularMeeting:
                    while (cursor.moveToNext()) list.add((T) (new RgularMeetingData(cursor, 0)));
                case Constants.DB.tableTemporaryReserve:
                    while (cursor.moveToNext()) list.add((T) (new TemporaryReserveData(cursor, 0)));
                case Constants.DB.tableTerminal:
                    while (cursor.moveToNext()) list.add((T) (new TerminalData(cursor, 0)));
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
    /**
     * @param db データベース
     * @param table テーブル名
     * @param list<T> 更新するリスト
     * @return List<T> 指定したテーブルに対応するクラスのリスト
     */
    public static <T> List<T> setDataList(SQLiteDatabase db, String table, List<T> list) {

        return list;
    }
}
