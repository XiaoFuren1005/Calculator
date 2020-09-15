package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button bt_0,bt_1,bt_2,bt_3,bt_4,bt_5,bt_6,bt_7,bt_8,bt_9,bt_point;
    Button bt_add,bt_subtraction,bt_multiplication,bt_divide;
    Button bt_clear,bt_equal;
    TextView tv_inpput;
    boolean clear_flag;        //判断et中是否清空

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);        //实例化对象
        bt_0=(Button) findViewById(R.id.bt_0);
        bt_1=(Button) findViewById(R.id.bt_1);
        bt_2=(Button) findViewById(R.id.bt_2);
        bt_3=(Button) findViewById(R.id.bt_3);
        bt_4=(Button) findViewById(R.id.bt_4);
        bt_5=(Button) findViewById(R.id.bt_5);
        bt_6=(Button) findViewById(R.id.bt_6);
        bt_7=(Button) findViewById(R.id.bt_7);
        bt_8=(Button) findViewById(R.id.bt_8);
        bt_9=(Button) findViewById(R.id.bt_9);
        bt_point=(Button) findViewById(R.id.bt_point);
        bt_add=(Button) findViewById(R.id.bt_add);
        bt_subtraction=(Button) findViewById(R.id.bt_subtraction);
        bt_multiplication=(Button) findViewById(R.id.bt_multiplication);
        bt_divide=(Button) findViewById(R.id.bt_divide);
        bt_clear=(Button) findViewById(R.id.bt_clear);
        bt_equal=(Button) findViewById(R.id.bt_equal);
        TextView tv_input = (TextView) findViewById(R.id.tv_input);

        bt_0.setOnClickListener((View.OnClickListener) this);        //设置按钮的点击事件
        bt_1.setOnClickListener((View.OnClickListener) this);
        bt_2.setOnClickListener((View.OnClickListener) this);
        bt_3.setOnClickListener((View.OnClickListener) this);
        bt_4.setOnClickListener((View.OnClickListener) this);
        bt_5.setOnClickListener((View.OnClickListener) this);
        bt_6.setOnClickListener((View.OnClickListener) this);
        bt_7.setOnClickListener((View.OnClickListener) this);
        bt_8.setOnClickListener((View.OnClickListener) this);
        bt_9.setOnClickListener((View.OnClickListener) this);
        bt_point.setOnClickListener((View.OnClickListener) this);
        bt_add.setOnClickListener((View.OnClickListener) this);
        bt_subtraction.setOnClickListener((View.OnClickListener) this);
        bt_multiplication.setOnClickListener((View.OnClickListener) this);
        bt_divide.setOnClickListener((View.OnClickListener) this);
        bt_clear.setOnClickListener((View.OnClickListener) this);
        bt_equal.setOnClickListener((View.OnClickListener) this);
    }
    public void onClick(View v) {
        String str=tv_input.getText().toString();
        switch(v.getId()){
            case R.id.bt_0:
            case R.id.bt_1:
            case R.id.bt_2:
            case R.id.bt_3:
            case R.id.bt_4:
            case R.id.bt_5:
            case R.id.bt_6:
            case R.id.bt_7:
            case R.id.bt_8:
            case R.id.bt_9:
            case R.id.bt_point:
                if(clear_flag){
                    clear_flag=false;
                    str="";
                    tv_input.setText("");
                }
                tv_inpput.setText(str+((Button) v).getText());
                break;
            case R.id.bt_add:
            case R.id.bt_subtraction:
            case R.id.bt_multiplication:
            case R.id.bt_divide:
                if(clear_flag){
                    clear_flag=false;
                    str="";
                    tv_inpput.setText("");
                }
                if(str.contains("+")||str.contains("-")||str.contains("*")||str.contains("/")){
                    str=str.substring(0,str.indexOf(" "));
                }
                tv_inpput.setText(str+" "+((Button)v).getText()+" ");
                break;
            case R.id.bt_clear:
                if(clear_flag)
                    clear_flag=false;
                str="";
                tv_input.setText("");
                break;
            case R.id.bt_equal:        //单独运算最后结果
                getResult();
                break;
        }
    }
    private void getResult(){
        String exp=tv_inpput.getText().toString();
    }
}