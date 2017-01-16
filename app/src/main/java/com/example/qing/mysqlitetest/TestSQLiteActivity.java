package com.example.qing.mysqlitetest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class TestSQLiteActivity extends Activity implements View.OnClickListener {
    private MySQLiteOpenHelper mySQLiteOpenHelper;
    private SQLiteDatabase mSQLiteDatabase;
    private TextView info_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button btn_db, btn_table, btn_insert, btn_query, btn_update, btn_del, btn_view;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_sqlite);

        btn_db = (Button) findViewById(R.id.btn_create_db);
        btn_table = (Button) findViewById(R.id.btn_create_table);
        btn_insert = (Button) findViewById(R.id.btn_insert);
        btn_query = (Button) findViewById(R.id.btn_query);
        btn_update = (Button) findViewById(R.id.btn_update);
        btn_del = (Button) findViewById(R.id.btn_delete);
        btn_view = (Button) findViewById(R.id.btn_view);
        info_view = (TextView) findViewById(R.id.txt_show);

        btn_db.setOnClickListener(this);
        btn_table.setOnClickListener(this);
        btn_insert.setOnClickListener(this);
        btn_query.setOnClickListener(this);
        btn_update.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_view.setOnClickListener(this);

        //mySQLiteOpenHelper = new MySQLiteOpenHelper(this,"zhangq.db",null,2);

        //mSQLiteDatabase = mySQLiteOpenHelper.getWritableDatabase();

    }


    private void dialog_db() {
        final EditText myedittext = new EditText(this);
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                try {
                    mSQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(myedittext.getText().toString(),null);
                } catch ( Exception e){

                }

                Toast.makeText(TestSQLiteActivity.this, "创建或者打开数据库"+myedittext.getText()+"成功", Toast.LENGTH_LONG).show();
            }
        });

        dlg.setTitle("创建数据库");
        dlg.setView(myedittext);
        dlg.create().show();
    }

    private void dialog_table() {
        final View v = View.inflate(this, R.layout.view_create_table, null);

        AlertDialog.Builder dlg = new AlertDialog.Builder(this);

        //实例化一个带"DialogInterface.OnClickListener"接口的类，实现"onClick"方法，然后传递给setPositiveButton作为参数
        //接口可以作为参数传入方法中，使用的时候可以将实现该接口的类的一个实例传入，利用这个特性，实现接口的各种方法。
        dlg.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //以下变量放在内部
                EditText ed_table_name,ed_item1,ed_item2,ed_item3,ed_item4;
                String crete_table_string ,item1 ,item2 ,item3, item4 ,cmd;
                ed_table_name = (EditText) v.findViewById(R.id.ed_create_table);
                ed_item1 = (EditText) v.findViewById(R.id.ed_table_item1);
                ed_item2 = (EditText) v.findViewById(R.id.ed_table_item2);
                ed_item3 = (EditText) v.findViewById(R.id.ed_table_item3);
                ed_item4 = (EditText) v.findViewById(R.id.ed_table_item4);

                crete_table_string = ed_table_name.getText().toString();
                item1 = ed_item1.getText().toString();
                item2 = ed_item2.getText().toString();
                item3 = ed_item3.getText().toString();
                item4 = ed_item4.getText().toString();

                cmd = "create table "+crete_table_string+"("+item1+" text primary key, "+item2+" text, "+item3+" text, "+item4+" text)";
                //mSQLiteDatabase.execSQL(cmd);
                info_view.setText(cmd);
                Toast.makeText(TestSQLiteActivity.this, "创建表成功"+crete_table_string, Toast.LENGTH_LONG).show();
            }
        });
        dlg.setTitle("创建表");
        dlg.setView(v);
        dlg.create().show();
    }

    private void dialog_insert() {
        final EditText myedittext = new EditText(this);
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(TestSQLiteActivity.this, myedittext.getText(), Toast.LENGTH_LONG).show();
            }
        });
        dlg.setTitle("插入数据项目");
        dlg.setView(myedittext);
        dlg.create().show();
    }

    private void dialog_update() {
        final EditText myedittext = new EditText(this);
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(TestSQLiteActivity.this, myedittext.getText(), Toast.LENGTH_LONG).show();
            }
        });
        dlg.setTitle("修改项目");
        dlg.setView(myedittext);
        dlg.create().show();
    }

    private void dialog_query() {
        final EditText myedittext = new EditText(this);
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(TestSQLiteActivity.this, myedittext.getText(), Toast.LENGTH_LONG).show();
            }
        });
        dlg.setTitle("查询的项目");
        dlg.setView(myedittext);
        dlg.create().show();
    }

    private void dialog_del() {
        final EditText myedittext = new EditText(this);
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(TestSQLiteActivity.this, myedittext.getText(), Toast.LENGTH_LONG).show();
            }
        });
        dlg.setTitle("要删除的项目");
        dlg.setView(myedittext);
        dlg.create().show();
    }

    private void dialog_view() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_create_db:
                dialog_db();
                break;
            case R.id.btn_create_table:
                dialog_table();
                break;
            case R.id.btn_insert:
                dialog_insert();
                break;
            case R.id.btn_query:
                dialog_update();
                break;
            case R.id.btn_update:
                dialog_query();
                break;
            case R.id.btn_delete:
                dialog_del();
                break;
            case R.id.btn_view:
                dialog_view();
                break;
            default:
                break;
        }
    }
}
