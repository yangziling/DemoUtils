package com.houli.demoutils;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.listener.OnTimeSelectChangeListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.bigkoo.pickerview.view.TimePickerView;
import com.houli.demoutils.wheelview.view.WheelViewActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btn_time;
    private TimePickerView pvTime,pvCustomTime;
    private EditText edittext;
    private OptionsPickerView pvOptions;
    private ArrayList<ProjectBean> options1Items = new ArrayList<>();
    private Button document,web_scan;
    private Button menu;
    private Button erweimascan,wheel_view,wheel_view2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.time);
        menu = (Button) findViewById(R.id.menu_button);
        erweimascan = (Button) findViewById(R.id.erweimascan);
        wheel_view = (Button) findViewById(R.id.wheel_view);
        wheel_view2 = (Button) findViewById(R.id.wheel_view2);
        wheel_view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, SencondWheelViewActivity.class);
//                startActivity(intent);
            }
        });


        wheel_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,WheelViewActivity.class);
                startActivity(intent);
            }
        });

        erweimascan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TestActivity.class);
                startActivity(intent);
            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MenuActivity.class);
                startActivity(intent);
            }
        });
         web_scan = (Button) findViewById(R.id.web_scan);
        web_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取当天的时间
                String str = "2018-03-29";

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    long millionSeconds = sdf.parse(str).getTime();//毫秒
                    Toast.makeText(MainActivity.this,millionSeconds+"",Toast.LENGTH_LONG).show();
                Log.d("======", "onClick: "+millionSeconds+"");
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });

        getOptionData();
        initTimePicker();
        initOptionPicker();

        edittext = (EditText) findViewById(R.id.edittext);
        edittext.setOnClickListener(this);

        btn_time = (Button) findViewById(R.id.btn_Time);
        btn_time.setOnClickListener(this);
        //时间选择器

        document = (Button) findViewById(R.id.doucument);
        document.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DocumentActivity.class);
                startActivity(intent);

            }
        });
    }


    @Override
    public void onClick(View v) {
      if (v.getId() == R.id.btn_Time && pvTime != null){
          pvTime.show(v);//弹出时间选择器，传递参数过去，回调的时候则可以绑定此view
        }
        if (v.getId() == R.id.edittext && pvTime != null){
            edittext.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    edittext.setInputType(InputType.TYPE_NULL);
                    return false;
                }
            });
            pvOptions.show();
        }
    }

    private void initOptionPicker() {//单个条件选择器初始化

        pvOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                //返回的是选中位置的数据
                String tx = options1Items.get(options1).getProjectName();
                edittext.setText(tx);
            }
        })
                .setContentTextSize(20)//设置滚轮文字大小
                .setDividerColor(Color.LTGRAY)//设置分割线的颜色
                .setSelectOptions(0, 1)//默认选中项
                .setBgColor(Color.BLACK)
                .setTitleBgColor(Color.DKGRAY)
                .setTitleColor(Color.LTGRAY)
                .setCancelColor(Color.YELLOW)
                .setSubmitColor(Color.YELLOW)
                .setTextColorCenter(Color.LTGRAY)
                .isRestoreItem(true)//切换时是否还原，设置默认选中第一项。
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .setBackgroundId(0x00000000) //设置外部遮罩颜色
                .build();

        pvOptions.setPicker(options1Items);//一级选择器

//        pvOptions.setSelectOptions(1,1);

//        pvOptions.setPicker(options1Items, options2Items);//二级选择器
    }

    private void initTimePicker() {

        pvTime = new TimePickerBuilder(this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                Toast.makeText(MainActivity.this, getTime(date), Toast.LENGTH_SHORT).show();
            }
        })
                .setTimeSelectChangeListener(new OnTimeSelectChangeListener() {
                    @Override
                    public void onTimeSelectChanged(Date date) {
                        Toast.makeText(MainActivity.this, getTime(date), Toast.LENGTH_SHORT).show();
                    }
                })
                .setCancelColor(Color.GRAY)
                .setSubmitColor(Color.GREEN)
                .isCyclic(false)
                .setLabel("","","","","","")
                .setType(new boolean[]{true, true, true, false, false, false})
                .build();
    }


    private String  getTime(Date date) {//自行截图需要获取的时间格式
        Log.d("getTime()", "choice date millis: " + date.getTime());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }
    public void getOptionData() {
        options1Items.add(new ProjectBean(0, "默认项目1"));
        options1Items.add(new ProjectBean(1, "默认项目2"));
        options1Items.add(new ProjectBean(2, "默认项目3"));
    }
}
