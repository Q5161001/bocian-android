package com.websarva.wings.android.bocian.data;

import android.database.Cursor;

public class PositionData {
    private int posId; // 役職ID
    private String posName; // 役職名
    private String posScore; // 読み仮名

    public PositionData(int posId, String posName, String posScore) {
        this.posId = posId;
        this.posName = posName;
        this.posScore = posScore;
    }

    public PositionData(Cursor c, int offset) {
        /* open済みのCursorからインスタンスを生成するコンストラクタ。Cursorのcloseの責務は持たない */
        this.posId = c.getInt(offset);
        this.posName = c.getString(offset + 1);
        this.posScore = c.getString(offset + 2);
    }

    public int getPosId() {
        return posId;
    }

    public void setPosId(int posId) {
        this.posId = posId;
    }

    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName;
    }

    public String getPosScore() {
        return posScore;
    }

    public void setPosScore(String posScore) {
        this.posScore = posScore;
    }
}
