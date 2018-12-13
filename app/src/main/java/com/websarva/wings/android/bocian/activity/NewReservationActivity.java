package com.websarva.wings.android.bocian.activity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.websarva.wings.android.bocian.R;
import com.websarva.wings.android.bocian.beans.BocianDBHelper;
import com.websarva.wings.android.bocian.fragment.AddFixturesDialogFragment;

// 新規予約画面
public class NewReservationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_reservation);
        // setTitle(R.string.edit_reservation);

        // 備品確認画面を起動
        findViewById(R.id.newReservation_bt_fixturesConfirmation).setOnClickListener(view -> {
            Intent intent = new Intent(NewReservationActivity.this, FixturesActivity.class);
            startActivity(intent);
        });

        // 備品追加ダイアログの出現
        findViewById(R.id.newReservation_bt_fixturesAdd).setOnClickListener(view -> {
            AddFixturesDialogFragment dialog = new AddFixturesDialogFragment();
            getSupportFragmentManager();
            dialog.show(getFragmentManager(), "AddFixturesDialogFragment");
        });

        // 参加者確認画面を起動
        findViewById(R.id.newReservation_bt_paticipantConfirmation).setOnClickListener(view -> {
            Intent intent = new Intent(NewReservationActivity.this, ParticipantsActivity.class);
            startActivity(intent);
        });

        // 参加者追加画面を起動
        findViewById(R.id.newReservation_bt_paticipantAdd).setOnClickListener(view -> {
            Intent intent = new Intent(NewReservationActivity.this, AddMemberActivity.class);
            startActivity(intent);
        });


        // この画面の終了（キャンセル）
        findViewById(R.id.newReservation_bt_Cancel).setOnClickListener(view -> { finish(); });

        // この画面の終了（確定）
        findViewById(R.id.newReservation_bt_Confirm).setOnClickListener(view -> { finish(); });

        BocianDBHelper helper = new BocianDBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

    }
}
