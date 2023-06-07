package com.example.calculator;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Stack;
public class Click extends AppCompatActivity {
    private EditText last;
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private Button add;
    private Button sub;
    private Button multi;
    private Button divide;
    private Button point;
    private Button equal;
    private Button clean;
    private Button delete;
    private Button pow;
    private Button left;
    private Button right;
    private Button change;
    private boolean isHasDot = false;
    private Boolean resErr = false;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        int orientation=getResources().getConfiguration().orientation;
        if(orientation==Configuration.ORIENTATION_LANDSCAPE){
            setContentView(R.layout.activity_main);
        }else if(orientation==Configuration.ORIENTATION_PORTRAIT){
            setContentView(R.layout.activity_len);
        }
        setContentView(R.layout.activity_main);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        multi = findViewById(R.id.multi);
        divide = findViewById(R.id.devide);
        point = findViewById(R.id.dot);
        equal = findViewById(R.id.equal);
        clean = findViewById(R.id.clean);
        last = findViewById(R.id.last);
        point = findViewById(R.id.dot);
        equal = findViewById(R.id.equal);
        delete = findViewById(R.id.back);
        left = findViewById(R.id.kuohaoleft);
        right = findViewById(R.id.kuohaoright);
        change= findViewById(R.id.change);
        pow=findViewById(R.id.pow);


        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn11);
        btn2 = findViewById(R.id.btn22);
        btn3 = findViewById(R.id.btn33);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);


        MyClick0 mcl0 = new MyClick0();
        btn0.setOnClickListener(mcl0);
        MyClick1 mcl1 = new MyClick1();
        btn1.setOnClickListener(mcl1);
        MyClick2 mcl2 = new MyClick2();
        btn2.setOnClickListener(mcl2);
        MyClick3 mcl3 = new MyClick3();
        btn3.setOnClickListener(mcl3);
        MyClick4 mcl4 = new MyClick4();
        btn4.setOnClickListener(mcl4);
        MyClick5 mcl5 = new MyClick5();
        btn5.setOnClickListener(mcl5);
        MyClick6 mcl6 = new MyClick6();
        btn6.setOnClickListener(mcl6);
        MyClick7 mcl7 = new MyClick7();
        btn7.setOnClickListener(mcl7);
        MyClick8 mcl8 = new MyClick8();
        btn8.setOnClickListener(mcl8);
        MyClick9 mcl9 = new MyClick9();
        btn9.setOnClickListener(mcl9);
        MyClick mcl = new MyClick();
        point.setOnClickListener(mcl);
        Myclean cle = new Myclean();
        clean.setOnClickListener(cle);
        Myadd add1 = new Myadd();
        add.setOnClickListener(add1);
        Mysub sub1 = new Mysub();
        sub.setOnClickListener(sub1);
        Mymuiti muiti1 = new Mymuiti();
        multi.setOnClickListener(muiti1);
        Mydevide devide1 = new Mydevide();
        divide.setOnClickListener(devide1);
        Myequal equ = new Myequal();
        equal.setOnClickListener(equ);
        Mydelete del = new Mydelete();
        delete.setOnClickListener(del);
        Myleft lef = new Myleft();
        left.setOnClickListener(lef);
        Myright rig = new Myright();
        right.setOnClickListener(rig);
        Mychange chg = new Mychange();
        change.setOnClickListener(chg);
        Mypow po =new Mypow();
        pow.setOnClickListener(po);


    }






    private class Mychange implements View.OnClickListener {
        public void onClick(View v) {

            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            setContentView(R.layout.activity_len);


        }
    }

    private class Mypow implements View.OnClickListener {
        public void onClick(View v) {
            String input = last.getText().toString();
            if(!lastOperation(input, null)) {
                last.setText(input + " ^ ");
                isHasDot=false;
            }



        }
    }


    private class Myleft implements View.OnClickListener {
        public void onClick(View v) {
            String input = last.getText().toString();
            last.setText(input + "(");

        }
    }

    private class Myright implements View.OnClickListener {
        public void onClick(View v) {
            String input = last.getText().toString();
            last.setText(input + ")");
        }
    }

    private class Myclean implements View.OnClickListener {
        public void onClick(View v) {
            last.setText("");
            isHasDot=false;
        }

    }

    private class Myadd implements View.OnClickListener {
        public void onClick(View v) {
            String input = last.getText().toString();
            if (lastOperation(input, "point")) {
                input = input + "0";
            }
            if(!lastOperation(input, null)) {
                last.setText(input+" "+((Button)v).getText()+" ");
                isHasDot=false;
            }
            if (input.length()==0){
                last.setText("0 "+((Button)v).getText()+" ");
                isHasDot=false;
            }
        }

    }

    private class Mysub implements View.OnClickListener {
        public void onClick(View v) {
            String input = last.getText().toString();
            if (lastOperation(input, "point")) {
                input = input + "0";
            }
            if(!lastOperation(input, null)) {
                last.setText(input+" "+((Button)v).getText()+" ");
                isHasDot=false;
            }
            if (input.length()==0){
                last.setText("0 "+((Button)v).getText()+" ");
                isHasDot=false;
            }
        }

    }

    private class Mymuiti implements View.OnClickListener {
        public void onClick(View v) {
            String input = last.getText().toString();
            if (lastOperation(input, "point")) {
                input = input + "0";
            }
            if(!lastOperation(input, null)) {
                last.setText(input+" "+((Button)v).getText()+" ");
                isHasDot=false;
            }
            if (input.length()==0||input.length()=='('){
                last.setText("0 "+((Button)v).getText()+" ");
                isHasDot=false;
            }

        }

    }

    private class Mydevide implements View.OnClickListener {
        public void onClick(View v) {
            String input = last.getText().toString();

            if (lastOperation(input, "point")) {
                input = input + "0";
            }
            if(!lastOperation(input, null)) {
                last.setText(input+" "+((Button)v).getText()+" ");
                isHasDot=false;
            }
            if (input.length()==0){
                last.setText("0 "+((Button)v).getText()+" ");
                isHasDot=false;
            }
        }

    }

    private class Mydelete implements View.OnClickListener {
        public void onClick(View v) {
            String input = last.getText().toString();
            if (input != null && !input.equals("")) {
                last.setText(input.substring(0, input.length() - 1));
            }
            if (input.length() != 0) {
                if (input.charAt(input.length() - 1) == '.') {
                    isHasDot = false;
                    last.setText(input.substring(0, input.length() - 1));
                }

            }
        }

    }

    private class Myequal implements View.OnClickListener {


            public void onClick (View v){
            getResult();

        }

    }

    private class MyClick0 implements View.OnClickListener {
        public void onClick(View v) {
            String input = last.getText().toString();
            last.setText(input + ((Button) v).getText());

        }

    }

    private class MyClick1 implements View.OnClickListener {
        public void onClick(View v) {
            String input = last.getText().toString();
            last.setText(input + ((Button) v).getText());
        }

    }

    private class MyClick2 implements View.OnClickListener {
        public void onClick(View v) {
            String input = last.getText().toString();
            last.setText(input + ((Button) v).getText());
        }

    }

    private class MyClick3 implements View.OnClickListener {
        public void onClick(View v) {
            String input = last.getText().toString();
            last.setText(input + ((Button) v).getText());
        }

    }

    private class MyClick4 implements View.OnClickListener {
        public void onClick(View v) {
            String input = last.getText().toString();
            last.setText(input + ((Button) v).getText());
        }

    }

    private class MyClick5 implements View.OnClickListener {
        public void onClick(View v) {
            String input = last.getText().toString();
            last.setText(input + ((Button) v).getText());
        }

    }

    private class MyClick6 implements View.OnClickListener {
        public void onClick(View v) {
            String input = last.getText().toString();
            last.setText(input + ((Button) v).getText());
        }
    }

    private class MyClick7 implements View.OnClickListener {
        public void onClick(View v) {
            String input = last.getText().toString();
            last.setText(input + ((Button) v).getText());
        }

    }

    private class MyClick8 implements View.OnClickListener {
        public void onClick(View v) {
            String input = last.getText().toString();
            last.setText(input + ((Button) v).getText());
        }

    }

    private class MyClick9 implements View.OnClickListener {
        public void onClick(View v) {
            String input = last.getText().toString();
            last.setText(input + ((Button) v).getText());
        }


    }

    private class MyClick implements View.OnClickListener {
        public void onClick(View v) {

            if (isHasDot == false) {

                String input = last.getText().toString();
                if (lastOperation(input, "point")) {
                    input = input + "0";
                }
                if (!lastOperation(input, null)) {
                    last.setText(input + ((Button) v).getText());
                }
            }
            isHasDot=true;
        }



    }




        private void getResult () {





        String exp = last.getText().toString();
        if (exp == null || exp.equals("")) return;
        resErr = false;
        if (getNum(exp, "(") != getNum(exp, ")")) {
            resErr = true;
            Toast.makeText(this, "输入有误，请重新输入！", Toast.LENGTH_SHORT).show();
                last.setText("");

            return;
        }


        if (!exp.contains(" ")) {
            return;
        }


        if (lastOperation(exp, null) || lastOperation(exp, "point")) {
            exp = exp + "0 ";
        }

        Stack<Double> numStack = new Stack<>();
        Stack<Character> fuhaoStack = new Stack<>();
        int index = 0;
        int len = exp.length();
        while (index < len) {
            char c = exp.charAt(index);
            if (c == '(') {
                fuhaoStack.push(c);
            }

            else if (c == '+' || c == '-' || c == '×' || c == '÷'||c=='^') {
                int currOperLevel = level(c);
                while (true) {
                    int stackOperLevel = 0;
                    if (!fuhaoStack.isEmpty()) {
                        Object obj = fuhaoStack.peek();
                        stackOperLevel = level((char) obj);
                    }

                    if (currOperLevel > stackOperLevel) {
                        fuhaoStack.push(c);
                        break;
                    } else {
                        try {
                            char op = '0';
                            double num1 = 0;
                            double num2 = 0;
                            if (!fuhaoStack.isEmpty()) {
                                op = (char) fuhaoStack.pop();
                            }
                            if (!numStack.isEmpty()) {
                                num1 = (double) numStack.pop();
                                num2 = (double) numStack.pop();
                            }
                            numStack.push(caculateResult(op, num2, num1));
                        } catch (Exception e) {
                            Toast.makeText(this, "输入有误，请重新输入！", Toast.LENGTH_SHORT).show();
                            last.setText("");
                        }
                    }
                }
            } else if (c == ')') {
                while (true) {
                    char theop = (char) fuhaoStack.pop();
                    if (theop == '(') {
                        break;
                    } else {
                        try {
                            double num1 = (double) numStack.pop();
                            double num2 = (double) numStack.pop();
                            numStack.push(caculateResult(theop, num2, num1));
                        } catch (Exception e) {
                            Toast.makeText(this, "输入有误，请重新输入！", Toast.LENGTH_SHORT).show();
                            last.setText("");
                        }
                    }
                }
            } else if (c >= '0' && c <= '9') {
                int tempIndex = index + 1;
                while (tempIndex < len) {
                    char temp = exp.charAt(tempIndex);
                    if ((temp >= '0' && temp <= '9') || temp == '.') {
                        tempIndex++;
                    } else {
                        break;
                    }
                }
                String numstr = exp.substring(index, tempIndex);
                try {
                    double numnum = Double.parseDouble(numstr);
                    numStack.push(numnum);
                    index = tempIndex - 1;
                } catch (Exception e) {
                    Toast.makeText(this, "输入有误，请重新输入！", Toast.LENGTH_SHORT).show();
                    last.setText("");
                }
            }
            index++;
        }


        while (true) {
            Object obj = null;
            if (fuhaoStack.isEmpty() == false) {
                obj = fuhaoStack.pop();
            }
            if (obj == null) {
                break;
            } else {
                char opterTemp = (char) obj;
                double num1 = (double) numStack.pop();
                double num2 = (double) numStack.pop();
                numStack.push(caculateResult(opterTemp, num2, num1));
            }
        }


        double result = (double) numStack.pop();
        last.setText(result + "");


    }

        private static int getNum (String originStr, String targetStr){
        int res = 0;
        int i = originStr.indexOf(targetStr);
        while (i != -1) {
            i = originStr.indexOf(targetStr, i + 1);
            res++;
        }
        return res;
    }


        private static Double caculateResult ( char op, double num1, double num2){

        switch (op) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '×':
                return num1 * num2;
            case '÷':
                return num1 / num2;
            case '^':
                return Math.pow(num1,num2);
        }
        return 0.0;
    }


        private static int level ( char c){

        switch (c) {
            case '+':
            case '-':
                return 1;
            case '×':
            case '÷':

                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }
    public void onClick (View v){
        if (resErr) {
            last.setText("");
            resErr = false;
        }
        String str = last.getText().toString();

    }




    private static Boolean lastOperation (String str, String type){
        String newStr = str.trim();
        if (newStr.equals("")) return false;
        char lastChar = newStr.charAt(newStr.length() - 1);
        if (type == "point") {
            return lastChar == '.';
    } else {
            return lastChar == '+' || lastChar == '-' || lastChar == '×' || lastChar == '÷'|| lastChar == '^';
        }
    }





    }


