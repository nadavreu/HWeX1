package com.example.reubens_pc.homeworkex1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button diagonalsButton ;
    private Button upperPartButton ;
    private Button downPartButton ;
    private Button borderButton ;
    private Button setMatrix ;
    private EditText matrixNumber;
    private LinearLayout outerLayout;
    private LinearLayout[] linLayoutRows;
    private TextView[] textViewArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        outerLayout = (LinearLayout) findViewById(R.id.outerLayout);
    }
    public void downPart(View v){
        EditText matrixNumber=(EditText)findViewById(R.id.matrixNumber);
        String value= matrixNumber.getText().toString();
        int matrixNum=Integer.parseInt(value);
        int textViewCount = matrixNum*matrixNum;
        for (int j = 0; j < textViewCount; j +=  matrixNum) {
            for (int i = 0; i < matrixNum; i++) {
                textViewArray[j + i].setWidth(100);
                textViewArray[j + i].setHeight(100);
                textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.button_off, getTheme()));

                if(j/matrixNum == i) {
                    textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.button_bold, getTheme()));
                }

                if(j/matrixNum > i){
                    textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.button_bold, getTheme()));
                }
            }
        }
    }
    public void upperPart(View v){
        EditText matrixNumber=(EditText)findViewById(R.id.matrixNumber);
        String value= matrixNumber.getText().toString();
        int matrixNum=Integer.parseInt(value);
        int textViewCount = matrixNum*matrixNum;
        for (int j = 0; j < textViewCount; j += matrixNum) {
            for (int i = 0; i < matrixNum; i++) {
                textViewArray[j + i].setWidth(100);
                textViewArray[j + i].setHeight(100);
                textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.button_off, getTheme()));
                if(j/matrixNum == i) {
                    textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.button_bold, getTheme()));
                }
                if(i > j/matrixNum){
                    textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.button_bold, getTheme()));
                }
            }
        }

    }
    public void diagonals(View v){
        EditText matrixNumber=(EditText)findViewById(R.id.matrixNumber);
        String value= matrixNumber.getText().toString();
        int matrixNum=Integer.parseInt(value);
        int textViewCount = matrixNum*matrixNum;
        for (int j = 0; j < textViewCount; j += matrixNum) {
            for (int i = 0; i < matrixNum; i++) {
                textViewArray[j + i].setWidth(100);
                textViewArray[j + i].setHeight(100);
                textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.button_off, getTheme()));

                if(j/matrixNum == i) {
                    textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.button_bold, getTheme()));
                }

                if(j/matrixNum + i == matrixNum-1) {
                    textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.button_bold, getTheme()));
                }
            }
        }
    }
    public void border(View v){
        EditText matrixNumber=(EditText)findViewById(R.id.matrixNumber);
        String value= matrixNumber.getText().toString();
        int matrixNum=Integer.parseInt(value);
        int textViewCount = matrixNum*matrixNum;
        for (int j = 0; j < textViewCount; j += matrixNum) {
            for (int i = 0; i < matrixNum; i++) {
                textViewArray[j + i].setWidth(100);
                textViewArray[j + i].setHeight(100);
                textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.button_off, getTheme()));

                if(j == 0 || j/matrixNum == matrixNum-1 || i == 0 || i == matrixNum-1) {
                    textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.button_bold, getTheme()));
                }
            }
        }
    }
    public void setMatrix(View v) {
        EditText matrixNumber=(EditText)findViewById(R.id.matrixNumber);
        String value= matrixNumber.getText().toString();
        int matrixNum=Integer.parseInt(value);
        if (matrixNum<3||matrixNum>10){
            Context context = getApplicationContext();
            CharSequence text = "you entered wrong number";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        }else{
           linLayoutRows = new LinearLayout[matrixNum];
            for (int i = 0; i < matrixNum; i++) {
                linLayoutRows[i] = new LinearLayout(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                layoutParams.gravity = Gravity.CENTER;
                linLayoutRows[i].setLayoutParams(layoutParams);
                outerLayout.addView(linLayoutRows[i]);
            }


            int textViewCount = matrixNum*matrixNum;
            textViewArray = new TextView[textViewCount];
            for (int i = 0; i < textViewCount; i++) {
                textViewArray[i] = new TextView(this);
            }

            for (int j = 0; j < textViewCount; j += matrixNum) {
                for (int i = 0; i < matrixNum; i++) {
                    textViewArray[j + i].setWidth(100);
                    textViewArray[j + i].setHeight(100);
                    textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.button_off, getTheme()));
                    linLayoutRows[j / matrixNum].addView(textViewArray[j + i]);
                }
            }
            setMatrix=(Button)findViewById(R.id.setMatrix);
            setMatrix.setEnabled(false);




        }

    }
}
