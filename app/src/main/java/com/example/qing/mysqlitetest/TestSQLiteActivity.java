package com.example.qing.mysqlitetest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TestSQLiteActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button btn_db,btn_table,btn_insert,btn_query,btn_update,btn_del,btn_view;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_sqlite);

        btn_db = (Button) findViewById(R.id.btn_create_db);
        btn_table = (Button) findViewById(R.id.btn_create_table);
        btn_insert = (Button) findViewById(R.id.btn_insert);
        btn_query = (Button) findViewById(R.id.btn_query);
        btn_update = (Button) findViewById(R.id.btn_update);
        btn_del = (Button) findViewById(R.id.btn_delete);
        btn_view = (Button) findViewById(R.id.btn_view);

        btn_db.setOnClickListener(this);
        btn_table.setOnClickListener(this);
        btn_insert.setOnClickListener(this);
        btn_query.setOnClickListener(this);
        btn_update.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_view.setOnClickListener(this);
    }


    private void dialog_db(){
        final EditText myedittext = new EditText(this);
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(TestSQLiteActivity.this,myedittext.getText(),Toast.LENGTH_LONG).show();
            }
        });
        dlg.setTitle("请输入数据库名称");
        dlg.setView(myedittext);
        dlg.create().show();
    }
    private void dialog_table(){
        final EditText myedittext = new EditText(this);
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(TestSQLiteActivity.this,myedittext.getText(),Toast.LENGTH_LONG).show();
            }
        });
        dlg.setTitle("表名称");
        dlg.setView(myedittext);
        dlg.create().show();
    }
    private void dialog_insert(){
        final EditText myedittext = new EditText(this);
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(TestSQLiteActivity.this,myedittext.getText(),Toast.LENGTH_LONG).show();
            }
        });
        dlg.setTitle("插入数据项目");
        dlg.setView(myedittext);
        dlg.create().show();
    }
    private void dialog_update(){
        final EditText myedittext = new EditText(this);
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(TestSQLiteActivity.this,myedittext.getText(),Toast.LENGTH_LONG).show();
            }
        });
        dlg.setTitle("修改项目");
        dlg.setView(myedittext);
        dlg.create().show();
    }
    private void dialog_query(){
        final EditText myedittext = new EditText(this);
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(TestSQLiteActivity.this,myedittext.getText(),Toast.LENGTH_LONG).show();
            }
        });
        dlg.setTitle("查询的项目");
        dlg.setView(myedittext);
        dlg.create().show();
    }
    private void dialog_del(){
        final EditText myedittext = new EditText(this);
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(TestSQLiteActivity.this,myedittext.getText(),Toast.LENGTH_LONG).show();
            }
        });
        dlg.setTitle("要删除的项目");
        dlg.setView(myedittext);
        dlg.create().show();
    }
    private void dialog_view(){

    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.btn_create_db:dialog_db();break;
            case R.id.btn_create_table:dialog_table();break;
            case R.id.btn_insert:dialog_insert();break;
            case R.id.btn_query:dialog_update();break;
            case R.id.btn_update:dialog_query();break;
            case R.id.btn_delete:dialog_del();break;
            case R.id.btn_view:dialog_view();break;
            default:break;
        }
    }
}
