package com.websarva.wings.android.bocian.data;

import android.database.Cursor;

// 端末テーブル
public class TerminalData {
    private int terminalNumber; // 端末番号
    private int empId; // 社員ID

    public TerminalData(Cursor c, int offset) {
        /* open済みのCursorからインスタンスを生成するコンストラクタ。Cursorのcloseの責務は持たない */
        this.terminalNumber = c.getInt(offset);
        this.empId = c.getInt(offset + 1);
    }
}
