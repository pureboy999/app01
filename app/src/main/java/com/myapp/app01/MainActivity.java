package com.myapp.app01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvTitle;       //静态文本框
    private TextView tvResult;
    private EditText editInput;     //定义文本框
    private Button btnC2F;          //定义按钮
    private Button btnF2C;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        //通过finViewById方法实例化以上控件类
        tvTitle = (TextView)findViewById(R.id.tv_title);
        tvResult = (TextView)findViewById(R.id.tv_result);
        editInput = (EditText) findViewById(R.id.et_input);
        btnC2F = (Button)findViewById(R.id.c_to_f);
        btnF2C = (Button)findViewById(R.id.f_to_c);

        //设置按钮点击监听
        btnC2F.setOnClickListener(this);
        btnF2C.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.c_to_f:
                outputValue(false);
                break;
            case R.id.f_to_c:
                outputValue(true);
                break;
            default:
        }
    }
    private void outputValue(boolean isF2C){
        float inputValue = Float.parseFloat(editInput.getText().toString());
        if(isF2C){
            tvResult.setText(String.valueOf(getF2C(inputValue)));
        }else{
            tvResult.setText(String.valueOf(getC2F(inputValue)));
        }
    }
    private float getF2C(float f){
        return ((f-32.0f)/1.8f);
    }
    private float getC2F(float c){
        return (c*1.8f)+32.0f;
    }
}