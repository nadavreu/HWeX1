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
        for (int j = 0; j < 9; j += 3) {
            for (int i = 0; i < 3; i++) {
                textViewArray[j + i].setWidth(250);
                textViewArray[j + i].setHeight(250);
                textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.button_off, getTheme()));
                //for the first diagonal
                if(j/3 == i) {
                    textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.button_bold, getTheme()));
                }
                // all the cells that's their row j index is bigger then the column index i
                if(j/3 > i){
                    textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.button_bold, getTheme()));
                }
            }
        }
    }
    public void upperPart(View v){
        for (int j = 0; j < 9; j += 3) {
            for (int i = 0; i < 3; i++) {
                textViewArray[j + i].setWidth(250);
                textViewArray[j + i].setHeight(250);
                textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.button_off, getTheme()));
                if(j/3 == i) {
                    textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.button_bold, getTheme()));
                }
                if(i > j/3){
                    textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.button_bold, getTheme()));
                }
            }
        }

    }
    public void diagonals(View v){
        for (int j = 0; j < 9; j += 3) {
            for (int i = 0; i < 3; i++) {
                textViewArray[j + i].setWidth(250);
                textViewArray[j + i].setHeight(250);
                textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.button_off, getTheme()));

                if(j/3 == i) {
                    textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.button_bold, getTheme()));
                }

                if(j/3 + i == 2) {
                    textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.button_bold, getTheme()));
                }
            }
        }
    }
    public void border(View v){
        for (int j = 0; j < 9; j += 3) {
            for (int i = 0; i < 3; i++) {
                textViewArray[j + i].setWidth(250);
                textViewArray[j + i].setHeight(250);
                textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.button_off, getTheme()));

                if(j == 0 || j/3 == 2 || i == 0 || i == 2) {
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
                linLayoutRows[i].setLayoutParams(layoutParams); // importent!!! remember it
                outerLayout.addView(linLayoutRows[i]);
            }

            // creating a TextView array with 9 cells
            int textViewCount = 9;
            textViewArray = new TextView[textViewCount];
            for (int i = 0; i < textViewCount; i++) {
                textViewArray[i] = new TextView(this);
            }

            for (int j = 0; j < 9; j += 3) {
                for (int i = 0; i < 3; i++) {
                    textViewArray[j + i].setWidth(250);
                    textViewArray[j + i].setHeight(250);
                    textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.button_off, getTheme()));
                    linLayoutRows[j / 3].addView(textViewArray[j + i]);
                }
            }





        }

    }
}
