
package com.example.mycalculator;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public final static String ERROR="ERROR";
    public static String myString;
    public static boolean isNumber2=false;
    Button button0=null;
    Button button1=null;
    Button button2=null;
    Button button3=null;
    Button button4=null;
    Button button5=null;
    Button button6=null;
    Button button7=null;
    Button button8=null;
    Button button9=null;
    Button btnBackspace=null;
    Button btnC=null;
    Button btnAdd=null;
    Button btnSub=null;
    Button btnMul=null;
    Button btnDiv=null;
    Button btnEqu=null;
    Button btnCE=null;
    Button btnPoint=null;
    Button btnMi=null;
    Button btnSin=null;
    Button btnCos=null;
    Button btnTan=null;
    EditText tvResult=null;
    Button btnLn=null;
    Button btn2=null;
    Button btn8=null;
    Button btn10=null;
    EditText editText=null;
    double num1=0;
    double num2=0;
    double result=0;
    int op=0;
    boolean  isClickEqu=false;
    boolean isClickOpr=false;
    boolean isPoint=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE)
//            setContentView(R.layout.content_main);
        setContentView(R.layout.activity_main);
        //addActivity
        SysApplication.getInstance().addActivity(this);





        editText=(EditText)findViewById(R.id.editText) ;
        button0=(Button)findViewById(R.id.button0);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        button4=(Button)findViewById(R.id.button4);
        button5=(Button)findViewById(R.id.button5);
        button6=(Button)findViewById(R.id.button6);
        button7=(Button)findViewById(R.id.button7);
        button8=(Button)findViewById(R.id.button8);
        button9=(Button)findViewById(R.id.button9);
        btnBackspace=(Button)findViewById(R.id.btnBackspace);
        btnC=(Button)findViewById(R.id.btnC);
        btnEqu=(Button)findViewById(R.id.btnEqu);
        btnAdd=(Button)findViewById(R.id.btnAdd);
        btnSub=(Button)findViewById(R.id.btnSub);
        btnMul=(Button)findViewById(R.id.btnMul);
        btnDiv=(Button)findViewById(R.id.btnDiv);
        tvResult=(EditText) findViewById(R.id.tvResult);
        btnCE=(Button)findViewById(R.id.btnCE);
        btnPoint=(Button)findViewById(R.id.btnPoint);
        btnMi=(Button)findViewById(R.id.btnMi);
        btnSin=(Button)findViewById(R.id.btnSin);
        btnCos=(Button)findViewById(R.id.btnCos);
        btnTan=(Button)findViewById(R.id.btnTan);
        btnLn=(Button)findViewById(R.id.btnLn);
        btn2=(Button)findViewById(R.id.btn2);
        btn8=(Button)findViewById(R.id.btn8);
        btn10=(Button)findViewById(R.id.btn16);
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button0.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnEqu.setOnClickListener(this);
        btnBackspace.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnCE.setOnClickListener(this);
        btnPoint.setOnClickListener(this);
        btnMi.setOnClickListener(this);
        btnSin.setOnClickListener(this);
        btnCos.setOnClickListener(this);
        btnTan.setOnClickListener(this);
        btnLn.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn10.setOnClickListener(this);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.help:
                Intent intent1 = new Intent(MainActivity.this, HelpActivity.class);
                startActivity(intent1);
                break;
            case R.id.exit:
                SysApplication.getInstance().exit();
            case R.id.unitConversion:
                Intent intent2 = new Intent(MainActivity.this, UnitConversionActivity.class);
                startActivity(intent2);
                break;
            case R.id.stopwatch:
                Intent intent3 = new Intent(MainActivity.this,StopWatchActivity.class);
                startActivity(intent3);
                break;
            case R.id.calendar:
                Intent inten4 = new Intent(MainActivity.this,CalendarActivity.class);
                startActivity(inten4);
                break;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnBackspace:
                myString = tvResult.getText().toString();
                try {
                    tvResult.setText(myString.substring(0, myString.length() - 1));
                } catch (Exception e) {
                    tvResult.setText("");
                }
                break;
            case R.id.btnCE:
                tvResult.setText(null);
                editText.setText(null);
//                num1=0;num2=0;op=0;
                break;
            case R.id.btnC:
                tvResult.setText(null);
                editText.setText(null);
//                num1=0;num2=0;op=0;

                break;
            case R.id.btnPoint:
                if (isClickEqu) {
                    tvResult.setText(null);
                    isClickEqu = false;
                }
                if(isPoint==true){
                    tvResult.setText(ERROR);
                }else {
                    myString = tvResult.getText().toString();
                    myString += ".";
                    tvResult.setText(myString);
                    editText.setText(editText.getText()+".");
                }
                break;
            case R.id.button0:
                if (isClickEqu) {
                    tvResult.setText(null);
                    isClickEqu = false;
                }
                if (isNumber2) {
                    tvResult.setText(null);
                    isNumber2 = false;
                }
                myString = tvResult.getText().toString();
                myString += "0";
                tvResult.setText(myString);
                editText.setText(editText.getText()+"0");
                break;
            case R.id.button1:
                if (isClickEqu) {
                    tvResult.setText(null);
                    isClickEqu = false;
                }
                if (isNumber2) {
                    tvResult.setText(null);
                    isNumber2 = false;
                }
                myString = tvResult.getText().toString();
                myString += "1";
                tvResult.setText(myString);
                editText.setText(editText.getText()+"1");
                break;
            case R.id.button2:
                if (isClickEqu) {
                    tvResult.setText(null);
                    isClickEqu = false;
                }
                if (isNumber2) {
                    tvResult.setText(null);
                    isNumber2 = false;
                }
                myString = tvResult.getText().toString();
                myString += "2";
                tvResult.setText(myString);
                editText.setText(editText.getText()+"2");
                break;
            case R.id.button3:
                if (isClickEqu) {
                    tvResult.setText(null);
                    isClickEqu = false;
                }
                if (isNumber2) {
                    tvResult.setText(null);
                    isNumber2 = false;
                }
                myString = tvResult.getText().toString();
                myString += "3";
                tvResult.setText(myString);
                editText.setText(editText.getText()+"3");
                break;
            case R.id.button4:
                if (isClickEqu) {
                    tvResult.setText(null);
                    isClickEqu = false;
                }
                if (isNumber2) {
                    tvResult.setText(null);
                    isNumber2 = false;
                }
                myString = tvResult.getText().toString();
                myString += "4";
                tvResult.setText(myString);
                editText.setText(editText.getText()+"4");
                break;
            case R.id.button5:
                if (isClickEqu) {
                    tvResult.setText(null);
                    isClickEqu = false;
                }
                if (isNumber2) {
                    tvResult.setText(null);
                    isNumber2 = false;
                }
                myString = tvResult.getText().toString();
                myString += "5";
                tvResult.setText(myString);
                editText.setText(editText.getText()+"5");
                break;
            case R.id.button6:
                if (isClickEqu) {
                    tvResult.setText(null);
                    isClickEqu = false;
                }
                if (isNumber2) {
                    tvResult.setText(null);
                    isNumber2 = false;
                }
                myString = tvResult.getText().toString();
                myString += "6";
                tvResult.setText(myString);
                editText.setText(editText.getText()+"6");
                break;
            case R.id.button7:
                if (isClickEqu) {
                    tvResult.setText(null);
                    isClickEqu = false;
                }
                if (isNumber2) {
                    tvResult.setText(null);
                    isNumber2 = false;
                }
                myString = tvResult.getText().toString();
                myString += "7";
                tvResult.setText(myString);
                editText.setText(editText.getText()+"7");
                break;
            case R.id.button8:
                if (isClickEqu) {
                    tvResult.setText(null);
                    isClickEqu = false;
                }
                if (isNumber2) {
                    tvResult.setText(null);
                    isNumber2 = false;
                }
                myString = tvResult.getText().toString();
                myString += "8";
                tvResult.setText(myString);
                editText.setText(editText.getText()+"8");
                break;
            case R.id.button9:
                if (isClickEqu) {
                    tvResult.setText(null);
                    isClickEqu = false;
                }
                if (isNumber2) {
                    tvResult.setText(null);
                    isNumber2 = false;
                }
                myString = tvResult.getText().toString();
                myString += "9";
                tvResult.setText(myString);
                editText.setText(editText.getText()+"9");
                break;

            case R.id.btnAdd:
                myString=tvResult.getText().toString();
                if(isClickOpr==false){
                    num1=Double.valueOf(myString);
                    num2=0;
                    op=1;
                    editText.setText(String.valueOf(num1)+"+");
                }

                tvResult.setText(null);

                if(isClickOpr==true){
                    num2=Double.valueOf(myString);
                    if(calculate(num1,num2,op)==000){
                        editText.setText(ERROR);
                    }
                    else {
                        editText.setText(String.valueOf(calculate(num1, num2, op))+"+");
                        num1 = calculate(num1, num2, op);
                        tvResult.setText(null);
                        op = 1;
                    }
                }
                isClickOpr=true;
                break;
            case R.id.btnSub:
                myString=tvResult.getText().toString();
                if(isClickOpr==false){
                    num1=Double.valueOf(myString);
                    num2=0;
                    op=2;
                    editText.setText(String.valueOf(num1)+"-");
                }
                tvResult.setText(null);

                if(isClickOpr==true){
                    num2=Double.valueOf(myString);
                    if(calculate(num1,num2,op)==000){
                        editText.setText(ERROR);
                    }
                    else {
                        editText.setText(String.valueOf(calculate(num1,num2,op))+"-");
                        num1=calculate(num1,num2,op);
                        tvResult.setText(null);
                        op=2;
                    }
                }
                isClickOpr=true;
                break;
            case R.id.btnMul:
                myString=tvResult.getText().toString();
                if(isClickOpr==false){
                    num1=Double.valueOf(myString);
                    num2=0;
                    op=3;
                    editText.setText(String.valueOf(num1)+"x");
                }
                tvResult.setText(null);
                if(isClickOpr==true){
                    num2=Double.valueOf(myString);
                    if(calculate(num1,num2,op)==000){
                        editText.setText(ERROR);
                    }
                    else {
                        editText.setText(String.valueOf(calculate(num1,num2,op))+"x");
                        num1=calculate(num1,num2,op);
                        tvResult.setText(null);
                        op=3;
                    }

                }
                isClickOpr=true;
                break;
            case R.id.btnDiv:
                myString=tvResult.getText().toString();
                if(isClickOpr==false){
                    num1=Double.valueOf(myString);
                    op=4;
                    editText.setText(String.valueOf(num1)+"/");
                }
                tvResult.setText(null);
                if(isClickOpr==true){
                    num2=Double.valueOf(myString);
                    if(calculate(num1,num2,op)==000){
                        editText.setText(ERROR);
                    }
                    else {
                        editText.setText(String.valueOf(calculate(num1, num2, op))+"/");
                        num1 = calculate(num1, num2, op);
                        tvResult.setText(null);
                        op = 4;
                    }
                }
                isClickOpr=true;
                break;
            case R.id.btnMi:
                String myStringMi=tvResult.getText().toString();
                if(myStringMi.equals(""))
                {
                    return;
                }
                num1=Double.valueOf(myStringMi);
                tvResult.setText(myStringMi+"^");
                editText.setText(editText.getText()+"^");
                op=5;
                isClickEqu=false;
                isNumber2=true;
                break;
            case R.id.btnLn:
                String myStringLn=tvResult.getText().toString();
                editText.setText(null);
                if(myStringLn.equals(""))
                {
                    return;
                }

                num1=Double.valueOf(myStringLn);
                tvResult.setText("ln"+myStringLn+"="+Math.log(num1));
                return;
            case R.id.btn2:
                String myStringTwo=tvResult.getText().toString();
                if(myStringTwo.equals(""))
                {
                    return;
                }
                num1=Double.valueOf(myStringTwo);

                tvResult.setText("十进制："+myStringTwo+"转换成二进制为："+Integer.toBinaryString((int)num1));
                editText.setText(null);
                return;

            case R.id.btn8:
                String myString8=tvResult.getText().toString();
                if(myString8.equals(""))
                {
                    return;
                }
                num1=Double.valueOf(myString8);
                editText.setText(null);
                tvResult.setText("十进制："+myString8+"转换成八进制为："+Integer.toOctalString((int)num1));
                return;
            case R.id.btn16:
                String myString16=tvResult.getText().toString();
                if(myString16.equals(""))
                {
                    return;
                }
                num1=Double.valueOf(myString16);
                editText.setText(null);
                tvResult.setText("十进制："+myString16+"转换成二进制为："+Integer.toHexString((int)num1));
                return;
            case R.id.btnSin:
                String myStringSin=tvResult.getText().toString();
                if(myStringSin.equals(""))
                {
                    return;
                }
                num1=Double.valueOf(myStringSin);
                editText.setText(null);
                tvResult.setText("Sin"+myStringSin+"="+Math.sin(num1));;
                return;
            case R.id.btnCos:
                String myStringCos=tvResult.getText().toString();
                num1=Double.valueOf(myStringCos);
                editText.setText(null);
                tvResult.setText("Cos"+myStringCos+"="+Math.cos(num1));
                return;
            case R.id.btnTan:
                String myStringTan=tvResult.getText().toString();
                num1=Double.valueOf(myStringTan);
                editText.setText(null);
                tvResult.setText("Tan"+myStringTan+"="+Math.tan(num1));
                return;
            case R.id.btnEqu:
                editText.setText(editText.getText()+"=");
                String myStringEqu=tvResult.getText().toString();
                if(myStringEqu.equals("")){
                    return;
                }
                num2=Double.valueOf(myStringEqu);
                tvResult.setText(null);
                switch(op){
                    case 0:
                        result=num2;
                        break;
                    case 1:
                        result=num1+num2;
                        break;
                    case 2:
                        result=num1-num2;
                        break;
                    case 3:
                        result=num1*num2;
                        break;
                    case 4:
                        result=num1/num2;
                        break;
                    case 5:
                        result=num1;
                        for(int i=1;i<num2;i++){
                            result*=num1;
                        }
                        break;
                    default:
                        result =0;
                        break;
                }
                tvResult.setText(String.valueOf(result));
                isClickEqu=true;//count++;
                break;

            default:
                break;
        }

    }

    public double calculate(double num1,double num2,int op){
        switch(op){
            case 1:
                return num1+num2;
            case 2:
                return num1-num2;
            case 3:
                return num1*num2;
            case 4:
                if(num2!=0)
                    return num1/num2;
                else  return 000;
        }
        return result;
    }
}

