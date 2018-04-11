package com.houli.demoutils;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by stone on 2018/3/27.
 */

public class DocumentActivity extends AppCompatActivity {

    private EditText edit1,edit2,edit3;
    private Button editBuuton,saveandcommit_button,save_button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document);

        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);
        edit3 = (EditText) findViewById(R.id.edit3);
        notEdit();

        editBuuton = (Button) findViewById(R.id.edit_button);
        save_button = (Button) findViewById(R.id.save_button);
        saveandcommit_button = (Button) findViewById(R.id.saveandcommit_button);

        editBuuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editBuuton.setBackground(getResources().getDrawable(R.drawable.button_selected));
                save_button.setBackground(getResources().getDrawable(R.drawable.button_noselect));
                saveandcommit_button.setBackground(getResources().getDrawable(R.drawable.button_noselect));
                edit();
            }
        });

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeSoftKeyBoard();
                editBuuton.setBackground(getResources().getDrawable(R.drawable.button_noselect));
                save_button.setBackground(getResources().getDrawable(R.drawable.button_selected));
                saveandcommit_button.setBackground(getResources().getDrawable(R.drawable.button_noselect));
                notEdit();
            }
        });

        saveandcommit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeSoftKeyBoard();
                editBuuton.setBackground(getResources().getDrawable(R.drawable.button_noselect));
                save_button.setBackground(getResources().getDrawable(R.drawable.button_noselect));
                saveandcommit_button.setBackground(getResources().getDrawable(R.drawable.button_selected));
                notEdit();
            }
        });
    }
    //点击之后不可编辑
    private void notEdit(){
        edit1.setFocusable(false);
        edit1.setFocusableInTouchMode(false);

        edit2.setFocusable(false);
        edit2.setFocusableInTouchMode(false);

        edit3.setFocusable(false);
        edit3.setFocusableInTouchMode(false);
    }
    //点击之后不可编辑
    private void edit(){
        edit1.setFocusable(true);
        edit1.setFocusableInTouchMode(true);

        edit2.setFocusable(true);
        edit2.setFocusableInTouchMode(true);

        edit3.setFocusable(true);
        edit3.setFocusableInTouchMode(true);
    }

    private void closeSoftKeyBoard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
    }


}
