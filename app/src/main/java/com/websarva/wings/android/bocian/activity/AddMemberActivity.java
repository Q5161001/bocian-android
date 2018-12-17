package com.websarva.wings.android.bocian.activity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;

import com.websarva.wings.android.bocian.R;
import com.websarva.wings.android.bocian.adapter.AddCompanyListAdapter;
import com.websarva.wings.android.bocian.adapter.AddEmployeeListAdapter;
import com.websarva.wings.android.bocian.beans.BocianDBHelper;
import com.websarva.wings.android.bocian.data.DepartmentData;
import com.websarva.wings.android.bocian.data.EmployeeData;
import com.websarva.wings.android.bocian.listItem.AddCompanyListItem;
import com.websarva.wings.android.bocian.listItem.AddEmployeeListItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

// 社外者追加画面
public class AddMemberActivity extends AppCompatActivity {

    public static final int ZERO = 0;
    private boolean allCheck = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);

        // DBヘルパークラスの生成
        BocianDBHelper helper = new BocianDBHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();

        List<EmployeeData> empList = helper.getEmployee(db, null, null);
        List<DepartmentData> depList = helper.getDepartment(db, null,null);

        String hoge = depList.parallelStream().filter(d -> d.getDepId() == 1).findAny().orElse(null).getDepName();

        // ここは繰り返しに利用しているだけ
        String names[]      = getResources().getStringArray(R.array.nameList);
        String divisions[]  = getResources().getStringArray(R.array.divisionList);
        String sections[]   = getResources().getStringArray(R.array.sectionList);
        String posts[]      = getResources().getStringArray(R.array.postList);

        List<AddEmployeeListItem> data = new ArrayList<>(); // アダプタのdata部分のリストを作成
        // インスタンス生成してセットしている
        for (EmployeeData emp : empList) {
            AddEmployeeListItem item = new AddEmployeeListItem();
            item.setId(emp.getEmpId());
            item.setName(emp.getEmpName());
            //item.setDivision(emp.getDepId());
            //item.setPost(emp.getPosId());
            data.add(item); // インスタンスをリストに挿入
        }
        // ここは繰り返しに利用しているだけ
        String names2[]      = getResources().getStringArray(R.array.companyList);
        String counts2[]       = getResources().getStringArray(R.array.countList);

        List<AddCompanyListItem> data2 = new ArrayList<>(); // アダプタのdata部分のリストを作成
        // インスタンス生成してセットしている
        for (int i = ZERO; i < names2.length; i++) {
            AddCompanyListItem item2 = new AddCompanyListItem();
            item2.setId((new Random()).nextLong());  // 別に乱数にしなくてもよい
            item2.setName(names2[i]);
            item2.setCount(counts2[i]);
            data2.add(item2); // インスタンスをリストに挿入
        }

            // 自身のアクティビティ、データ、レイアウトを指定
        AddEmployeeListAdapter empAdapter = new AddEmployeeListAdapter(AddMemberActivity.this, data, R.layout.add_employee_list_item);
        ListView listView = findViewById(R.id.addMemberActivity_list_vi_person); // レイアウト

        AddCompanyListAdapter companyAdapter = new AddCompanyListAdapter(AddMemberActivity.this, data2, R.layout.company_list_item);
        listView.setAdapter(empAdapter);


        Spinner sp1 = findViewById(R.id.addMemberActivity_spinar_inside_outside);
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //　アイテムが選択された時
            @Override
            public void onItemSelected(AdapterView<?> parent,
                                       View view, int position, long id) {
                EditText et = findViewById(R.id.addMemberActivity_ed_tv_name);
                ImageButton bt = findViewById(R.id.addMemberActivity_img_bt_plus);
                Button bt2 = findViewById(R.id.addMemberActivity_bt_choice);
                Spinner sp = findViewById(R.id.addMemberActivity_spinar_division);
                Spinner sp2 = findViewById(R.id.addMemberActivity_spinar_section);

                switch (position){
                    case 0:
                        // 検索テキストボックスのヒントを変更
                        et.setHint("なまえ");

                        // 企業登録ボタンを不可視化
                        bt.setVisibility(View.INVISIBLE);

                        // 全選択ボタンを可視化
                        bt2.setVisibility(View.VISIBLE);

                        // スピナーを可視化
                        sp.setVisibility(View.VISIBLE);

                        sp2.setVisibility(View.VISIBLE);

                        listView.setAdapter(empAdapter);

                        break;
                    case 1:
                        // 検索テキストボックスのヒントを変更
                        et.setHint("企業名");

                        // 企業登録ボタンを可視化
                        bt.setVisibility(View.VISIBLE);

                        // 全選択ボタンを不可視化
                        bt2.setVisibility(View.INVISIBLE);

                        // スピナーを不可視化
                        sp.setVisibility(View.INVISIBLE);

                        sp2.setVisibility(View.INVISIBLE);

                        listView.setAdapter(companyAdapter);

                        break;
                }
            }

            //　アイテムが選択されなかった
            public void onNothingSelected(AdapterView<?> parent) {
                //
            }
        });

        // クリックリスナーをセット
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 企業が表示されているときに限定する
                if (listView.getAdapter().equals(companyAdapter)) {
                    Intent intent = new Intent(AddMemberActivity.this, AddCustomerActivity.class);
                    startActivity(intent);
                }
            }
        });
        // 企業登録画面の起動
        findViewById(R.id.addMemberActivity_img_bt_plus).setOnClickListener(view -> {
            Intent intent = new Intent(AddMemberActivity.this, EditCompanyActivity.class);
            startActivity(intent);
        });
        // この画面の終了（キャンセル）
        /*findViewById(R.id.addMemberActivity_bt_cancel).setOnClickListener(view -> {
            Intent intent = new Intent(AddMemberActivity.this, MenuActivity.class);
            startActivity(intent);
        });*/
        findViewById(R.id.addMemberActivity_bt_cancel).setOnClickListener(view -> { finish(); });

        // この画面の終了（確定）
        findViewById(R.id.addMemberActivity_bt_confirm).setOnClickListener(view -> { finish(); });

        // 全選択
        findViewById(R.id.addMemberActivity_bt_choice).setOnClickListener(view -> {
            for (int i = 0; i < empAdapter.getCount(); i++) {
                View c_listView = empAdapter.getView(i, null, null);
                CheckBox check = (CheckBox) c_listView.findViewById(R.id.checkbox);
                check.setChecked(!allCheck); // 反転させる
                empAdapter.notifyDataSetChanged();
            }
            allCheck = !allCheck; // フラグを反転
            Button btn = findViewById(R.id.addMemberActivity_bt_choice);
            btn.setText(allCheck ? "全解除" : "全選択");
        });
    }
}
