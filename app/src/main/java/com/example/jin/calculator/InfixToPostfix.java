package com.example.jin.calculator;

import java.util.Stack;

/**
 * Created by jin on 2017/8/8.
 */

public class InfixToPostfix {

    public static int priority(char c) {
        switch (c) {
            case '(':
                return 0;
            case '+':
            case '-':
                return 1;
            case '×':
            case '÷':
                return 2;
            default:
                return -1;
        }
    }

    public static String infixToPostfix(String infix) {
        String postfix = "";
        Stack<Character> operation = new Stack<Character>();
        for (int i = 0; i < infix.length(); i++) {
            if (infix.charAt(i) >= 48 && infix.charAt(i) <= 57) {
                postfix += infix.charAt(i);
            } else if (infix.charAt(i) == '(') {
                operation.push('(');
            } else if (infix.charAt(i) == ')') {
                char temp;
                while (!operation.isEmpty()) {
                    temp = operation.pop();
                    if (temp != '(') {
                        postfix += temp;
                    } else {
                        break;
                    }
                }
                continue;
            }else {
                while (!operation.isEmpty() && priority(operation.peek()) >= priority(infix.charAt(i))) {
                    postfix += operation.pop();
                }
                operation.push(infix.charAt(i));
            }
        }
        while (!operation.isEmpty()) {
            postfix += operation.pop();
        }
        return postfix;
    }

    public static double evaluate(String postfix) {
        Stack<Double> stack=new Stack<Double>();
        double operand1,operand2;
        for(int i=0;i<postfix.length();i++) {
            if(postfix.charAt(i)>=48 && postfix.charAt(i) <= 57) {
                stack.push(Double.valueOf(postfix.charAt(i))-48);
            }else if(postfix.charAt(i)=='+') {
                operand2=stack.pop();
                operand1=stack.pop();
                stack.push(operand1+operand2);
            }else if(postfix.charAt(i)=='-') {
                operand2=stack.pop();
                operand1=stack.pop();
                stack.push(operand1-operand2);
            }else if(postfix.charAt(i)=='×') {
                operand2=stack.pop();
                operand1=stack.pop();
                stack.push(operand1*operand2);
            }else if(postfix.charAt(i)=='÷') {
                operand2=stack.pop();
                operand1=stack.pop();
                stack.push(operand1/operand2);
            }
        }
        return stack.pop();
    }
}
