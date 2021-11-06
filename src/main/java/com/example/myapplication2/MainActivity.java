package com.example.myapplication2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private EditText getChineseScore, getChineseCredit, getMathScore, getMathCredit, getEnglishScore, getEnglishCredit, getComputerScore, getComputerCredit;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.get);
        final EditText getChineseScore=findViewById(R.id.getChineseScore);
        final EditText getChineseCredit=findViewById(R.id.getChineseCredit);
        final EditText getMathScore=findViewById(R.id.getMathScore);
        final EditText getMathCredit=findViewById(R.id.getMathCredit);
        final EditText getEnglishScore=findViewById(R.id.getEnglishScore);
        final EditText getEnglishCredit=findViewById(R.id.getEnglishCredit);
        final EditText getComputerScore=findViewById(R.id.getComputerScore);
        final EditText getComputerCredit=findViewById(R.id.getComputerCredit);







        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                if (getChineseScore.getText().toString().equals("")||getChineseCredit.getText().toString().equals("")||getMathScore.getText().toString().equals("")||getMathCredit.getText().toString().equals("")||getEnglishScore.getText().toString().equals("")||getEnglishCredit.getText().toString().equals("")||getComputerScore.getText().toString().equals("")||getComputerCredit.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this, "请正确输入", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    double ChineseScore =Double.parseDouble(getChineseScore.getText().toString());
                    double ChineseCredit =Double.parseDouble(getChineseCredit.getText().toString());
                    double MathScore =Double.parseDouble(getMathScore.getText().toString());
                    double MathCredit =Double.parseDouble(getMathCredit.getText().toString());
                    double EnglishScore =Double.parseDouble(getEnglishScore.getText().toString());
                    double EnglishCredit =Double.parseDouble(getEnglishCredit.getText().toString());
                    double ComputerScore =Double.parseDouble(getComputerScore.getText().toString());
                    double ComputerCredit =Double.parseDouble(getComputerCredit.getText().toString());

                    if (ChineseScore<0||ChineseScore>100||ChineseCredit<0||ChineseCredit>100||MathScore<0||MathScore>100||MathCredit<0||MathCredit>100||EnglishScore<0||EnglishScore>100||EnglishCredit<0||EnglishCredit>100||ComputerScore<0||ComputerScore>100||ComputerCredit<0||ComputerCredit>100)
                    {
                        Toast.makeText(MainActivity.this, "请正确输入", Toast.LENGTH_SHORT).show();
                    }
                    else {


                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        intent.putExtra("ChineseScore", getChineseScore.getText().toString());
                        intent.putExtra("ChineseCredit", getChineseCredit.getText().toString());
                        intent.putExtra("MathScore", getMathScore.getText().toString());
                        intent.putExtra("MathCredit", getMathCredit.getText().toString());
                        intent.putExtra("EnglishScore", getEnglishScore.getText().toString());
                        intent.putExtra("EnglishCredit", getEnglishCredit.getText().toString());
                        intent.putExtra("ComputerScore", getComputerScore.getText().toString());
                        intent.putExtra("ComputerCredit", getComputerCredit.getText().toString());


                        startActivity(intent);
                    }
                }
            }

        });
    }



}








