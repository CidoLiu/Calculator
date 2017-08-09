/**
 * 最后更新于2017/7/7
 * 功能描述：
 * 1.只能支持两位double数做四则运算
 * 2.无法判断算术优先级
 * <p>
 * 待解决问题：
 * 1.支持多个操作数的连续运算---已解决2017/8/9 jin
 * 2.能判断算术优先级---已解决2017/8/9 jin
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


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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

    private static String text = "";
    private static String operator = "";
    private boolean leftBacket = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.text);
        mButtonClear = (Button) findViewById(R.id.button_clear);
        mButtonBacket = (Button) findViewById(R.id.button_backet);
        mButtonBackspace = (Button) findViewById(R.id.button_backspace);
        mButtonDiv = (Button) findViewById(R.id.button_div);
        mButtonMul = (Button) findViewById(R.id.button_mul);
        mButtonSub = (Button) findViewById(R.id.button_sub);
        mButtonAdd = (Button) findViewById(R.id.button_add);
        mButtonEqual = (Button) findViewById(R.id.button_equal);
        mButtonNumber1 = (Button) findViewById(R.id.button_number1);
        mButtonNumber2 = (Button) findViewById(R.id.button_number2);
        mButtonNumber3 = (Button) findViewById(R.id.button_number3);
        mButtonNumber4 = (Button) findViewById(R.id.button_number4);
        mButtonNumber5 = (Button) findViewById(R.id.button_number5);
        mButtonNumber6 = (Button) findViewById(R.id.button_number6);
        mButtonNumber7 = (Button) findViewById(R.id.button_number7);
        mButtonNumber8 = (Button) findViewById(R.id.button_number8);
        mButtonNumber9 = (Button) findViewById(R.id.button_number9);
        mButtonNumber0 = (Button) findViewById(R.id.button_number0);
        mButtonDot = (Button) findViewById(R.id.button_dot);

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
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_number0:
                text += '0';
                break;
            case R.id.button_number1:
                text += '1';
                break;
            case R.id.button_number2:
                text += '2';
                break;
            case R.id.button_number3:
                text += '3';
                break;
            case R.id.button_number4:
                text += '4';
                break;
            case R.id.button_number5:
                text += '5';
                break;
            case R.id.button_number6:
                text += '6';
                break;
            case R.id.button_number7:
                text += '7';
                break;
            case R.id.button_number8:
                text += '8';
                break;
            case R.id.button_number9:
                text += '9';
                break;
            case R.id.button_dot:
                text += '.';
                break;
            case R.id.button_clear:
                text = "";
                leftBacket=false;
                break;
            case R.id.button_add:
                text += '+';
                break;
            case R.id.button_sub:
                text += '-';
                break;
            case R.id.button_mul:
                text += '×';
                break;
            case R.id.button_div:
                text += '÷';
                break;
            case R.id.button_backet:
                if (text == "") {
                    text += '(';
                    leftBacket = true;
                } else {
                    if (isWhat(text.charAt(text.length() - 1)) == "leftbacket" ||
                            isWhat(text.charAt(text.length() - 1)) == "operation") {
                        text += '(';
                        leftBacket = true;
                    } else if (isWhat(text.charAt(text.length() - 1)) == "rightbacket") {
                        text += "×(";
                        leftBacket = true;
                    } else if (isWhat(text.charAt(text.length() - 1)) == "number" && leftBacket) {
                        text += ')';
                    } else if (isWhat(text.charAt(text.length() - 1)) == "number" && !leftBacket) {
                        text += "×(";
                        leftBacket = true;
                    }
                }
                break;
            case R.id.button_backspace:
                if (text.length()>0){
                    text = text.substring(0, text.length() - 1);
                }
                break;
            case R.id.button_equal:
                String answer = getAnswer();
                text += '=';
                text += answer;
                break;
            default:
                break;
        }
        mTextView.setText(text);
    }

    String isWhat(char c) {
        switch (c) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                return "number";
            case '+':
            case '-':
            case '×':
            case '÷':
                return "operation";
            case '(':
                return "leftbacket";
            case ')':
                return "rightbacket";
            default:
                return "nodefind";
        }
    }

    /**
     * 计算表达式函数
     *
     * @return运算结果
     */
    public String getAnswer() {
        String TAG = "MainActivity";
        Log.d(TAG, "getAnswer: text:" + text);
        String postfix = InfixToPostfix.infixToPostfix(text);
        Log.d(TAG, "getAnswer: postfix:" + postfix);
        String answerString = String.valueOf(InfixToPostfix.evaluate(postfix));
        Log.d(TAG, "getAnswer: answer:" + answerString);
        return answerString;
    }
}
