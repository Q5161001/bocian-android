package com.websarva.wings.android.bocian.data;

import android.database.Cursor;

// 予約テーブル
public class ReserveData {
    private int resId; // 予約ID （主キー）
    private int resTerminalNumber; // 予約者端末番号（外部キー）
    private int pupId; // 目的ID（外部キー）
    private int confRoomId; // 会議室ID（外部キー）
    private int regId; // 定期会議ID（外部キー）
    private String useDay; // 利用日
    private String startTime; // 開始時刻
    private String endTime; // 終了時刻
    private int numExPersons; // 社外者人数
    private int flg; // 予約状態フラグ
    private String remarks; // 備考

    public ReserveData(int resId, int resTerminalNumber, int pupId, int confRoomId, int regId, String useDay, String startTime, String endTime, int numExPersons, int flg, String remarks) {
        this.resId = resId;
        this.resTerminalNumber = resTerminalNumber;
        this.pupId = pupId;
        this.confRoomId = confRoomId;
        this.regId = regId;
        this.useDay = useDay;
        this.startTime = startTime;
        this.endTime = endTime;
        this.numExPersons = numExPersons;
        this.flg = flg;
        this.remarks = remarks;
    }

    public ReserveData(Cursor c, int offset) {
        /* open済みのCursorからインスタンスを生成するコンストラクタ。Cursorのcloseの責務は持たない */
        this.resId = c.getInt(offset);
        this.resTerminalNumber = c.getInt(offset + 1);
        this.pupId = c.getInt(offset + 2);
        this.confRoomId = c.getInt(offset + 3);
        this.regId = c.getInt(offset + 4);
        this.useDay = c.getString(offset + 5);
        this.startTime = c.getString(offset + 6);
        this.endTime = c.getString(offset + 7);
        this.numExPersons = c.getInt(offset + 8);
        this.flg = c.getInt(offset + 9);
        this.remarks = c.getString(offset + 10);
    }

}
