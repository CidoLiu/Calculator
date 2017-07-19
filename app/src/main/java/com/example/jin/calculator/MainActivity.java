/**
 * 最后更新与2017/7/7
 * 功能描述：
 * 1.只能支持两位double数做四则运算
 * 2.无法判断算术优先级
 *
 * 待解决问题：
 * 1.支持多个操作数的连续运算
 * 2.能判断算术优先级
 * 3.按下等号输出结果后能继续运算
 * 4运算结果小数部分为0时不显示
 */
package com.example.jin.calculator;

import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //文本框
    TextView mTextView;

    //功能键
    Button mButtonClear;
    Button mButtonBacket;
    Button mButtonBackspace;
    Button mButtonDiv;
    Button mButtonMul;
    Button mButtonSub;
    Button mButtonAdd;
    Button mButtonEqual;

    //数字键
    Button mButtonNumber1;
    Button mButtonNumber2;
    Button mButtonNumber3;
    Button mButtonNumber4;
    Button mButtonNumber5;
    Button mButtonNumber6;
    Button mButtonNumber7;
    Button mButtonNumber8;
    Button mButtonNumber9;
    Button mButtonNumber0;
    Button mButtonDot;

    private static String text="";
    private static String operator="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView=(TextView)findViewById(R.id.text);
        mButtonClear=(Button)findViewById(R.id.button_clear);
        mButtonBacket=(Button)findViewById(R.id.button_backet);
        mButtonBackspace=(Button)findViewById(R.id.button_backspace);
        mButtonDiv=(Button)findViewById(R.id.button_div);
        mButtonMul=(Button)findViewById(R.id.button_mul);
        mButtonSub=(Button)findViewById(R.id.button_sub);
        mButtonAdd=(Button)findViewById(R.id.button_add);
        mButtonEqual=(Button)findViewById(R.id.button_equal);
        mButtonNumber1=(Button)findViewById(R.id.button_number1);
        mButtonNumber2=(Button)findViewById(R.id.button_number2);
        mButtonNumber3=(Button)findViewById(R.id.button_number3);
        mButtonNumber4=(Button)findViewById(R.id.button_number4);
        mButtonNumber5=(Button)findViewById(R.id.button_number5);
        mButtonNumber6=(Button)findViewById(R.id.button_number6);
        mButtonNumber7=(Button)findViewById(R.id.button_number7);
        mButtonNumber8=(Button)findViewById(R.id.button_number8);
        mButtonNumber9=(Button)findViewById(R.id.button_number9);
        mButtonNumber0=(Button)findViewById(R.id.button_number0);
        mButtonDot=(Button)findViewById(R.id.button_dot);

        mButtonClear.setOnClickListener(this);
        mButtonBacket.setOnClickListener(this);
        mButtonBackspace.setOnClickListener(this);
        mButtonDiv.setOnClickListener(this);
        mButtonMul.setOnClickListener(this);
        mButtonSub.setOnClickListener(this);
        mButtonAdd.setOnClickListener(this);
        mButtonAdd.setOnClickListener(this);
        mButtonEqual.setOnClickListener(this);
        mButtonDot.setOnClickListener(this);
        mButtonNumber1.setOnClickListener(this);
        mButtonNumber2.setOnClickListener(this);
        mButtonNumber3.setOnClickListener(this);
        mButtonNumber4.setOnClickListener(this);
        mButtonNumber5.setOnClickListener(this);
        mButtonNumber6.setOnClickListener(this);
        mButtonNumber7.setOnClickListener(this);
        mButtonNumber8.setOnClickListener(this);
        mButtonNumber9.setOnClickListener(this);
        mButtonNumber0.setOnClickListener(this);
    }

    /**
     * 响应点击事件
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_number0:
                text+='0';
                break;
            case R.id.button_number1:
                text+='1';
                break;
            case R.id.button_number2:
                text+='2';
                break;
            case R.id.button_number3:
                text+='3';
                break;
            case R.id.button_number4:
                text+='4';
                break;
            case R.id.button_number5:
                text+='5';
                break;
            case R.id.button_number6:
                text+='6';
                break;
            case R.id.button_number7:
                text+='7';
                break;
            case R.id.button_number8:
                text+='8';
                break;
            case R.id.button_number9:
                text+='9';
                break;
            case R.id.button_dot:
                text+='.';
                break;
            case R.id.button_clear:
                text="";
                break;
            case R.id.button_add:
                text+='+';
                operator="+";
                break;
            case R.id.button_sub:
                text+='－';
                operator="－";
                break;
            case R.id.button_mul:
                text+='×';
                operator="×";
                break;
            case R.id.button_div:
                text+='÷';
                operator="÷";
                break;
            case R.id.button_backspace:
                text=text.substring(0,text.length()-1);
                break;
            case R.id.button_equal:
                text+='=';
                text+=getAnswer();
                break;
            default:
                break;
        }
        mTextView.setText(text);
    }

    /**
     * 计算表达式函数
     * @return运算结果
     */
    public String getAnswer(){
        double answer=0;//运算结果
        String answerString="";
        String TAG ="MainActivityTest";

        int operaterIndex=text.indexOf(operator);//运算符位置
        Log.d(TAG, "operaterIndex: "+operaterIndex);
        int equalIndex=text.indexOf('=');//等号位置
        Log.d(TAG, "equalIndex: "+equalIndex);

        if (operaterIndex==0||equalIndex==operaterIndex+1){//缺少操作数
            Toast.makeText(MainActivity.this,"Errot Input!!!",Toast.LENGTH_SHORT).show();
            return "error";
        }

        //截取出操作数
        double number1=Double.parseDouble(text.substring(0,operaterIndex));//强制类型转换，string转double
        Log.d(TAG, "number1: "+number1);
        double number2=Double.parseDouble(text.substring(operaterIndex+1,equalIndex));
        Log.d(TAG, "number2: "+number2);

        //做运算
        switch (operator){
            case "+":
                answer=number1+number2;
                break;
            case "－":
                answer=number1-number2;
                break;
            case "×":
                answer=number1*number2;
                break;
            case "÷":
                answer=number1/number2;
                break;
            default:
                break;
        }
        answerString=String.valueOf(answer);//强制类型转换，double转string
        Log.d(TAG, "answer: "+answer);

        return answerString;
    }
}
