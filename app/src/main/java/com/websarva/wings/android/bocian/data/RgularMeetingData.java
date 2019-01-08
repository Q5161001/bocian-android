package com.websarva.wings.android.bocian.data;

import android.database.Cursor;

// 定期会議テーブル
public class RgularMeeting {
    private int regId; // 定期会議ID
    private String regDay; // 曜日

    public RgularMeeting(int regId, String regDay) {
        this.regId = regId;
        this.regDay = regDay;
    }

    public RgularMeeting(Cursor c, int offset) {
        /* open済みのCursorからインスタンスを生成するコンストラクタ。Cursorのcloseの責務は持たない */
        this.regId = c.getInt(offset);
        this.regDay = c.getString(offset + 1);
    }
}
