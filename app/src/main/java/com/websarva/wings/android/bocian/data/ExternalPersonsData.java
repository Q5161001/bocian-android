package com.websarva.wings.android.bocian.data;

import android.database.Cursor;

// 社外者マスタテーブル
public class ExternalPersonsData {
    private int exPersonsId; // 社外者ID（主キー）
    private int companyId; // 会社ID （外部キー）
    private String exPersonsName; // 社外者名
    private String exPersonsKana; // 読み仮名
    private String exPersonsPosition; // 役職

    public ExternalPersonsData(int exPersonsId, int companyId, String exPersonsName, String exPersonsKana, String exPersonsPosition) {
        this.exPersonsId = exPersonsId;
        this.companyId = companyId;
        this.exPersonsName = exPersonsName;
        this.exPersonsKana = exPersonsKana;
        this.exPersonsPosition = exPersonsPosition;
    }

    public ExternalPersonsData(Cursor c, int offset) {
        /* open済みのCursorからインスタンスを生成するコンストラクタ。Cursorのcloseの責務は持たない */
        this.exPersonsId = c.getInt(offset);
        this.companyId = c.getInt(offset + 1);
        this.exPersonsName = c.getString(offset + 2);
        this.exPersonsKana = c.getString(offset + 3);
        this.exPersonsPosition = c.getString(offset + 4);
    }

}
