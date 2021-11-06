package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    private TextView reportChinese,reportMath,reportEnglish,reportComputer,evaluate;
    private String ChineseScore, MathScore, EnglishScore, ComputerScore,average,stability;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //数据传递
        Intent intent=getIntent();
        String ChineseS=intent.getStringExtra("ChineseScore");
        String MathS=intent.getStringExtra("MathScore");
        String EnglishS=intent.getStringExtra("EnglishScore");
        String ComputerS=intent.getStringExtra("ComputerScore");
        String avg=intent.getStringExtra("average");
        double stab=intent.getDoubleExtra("stability",0.00);


        //综合评价
        double avg2=Double.parseDouble(avg);
        String evaluateComprehensive2=A(avg2,stab);
        TextView evaluateComprehensive = findViewById(R.id.evaluate);
        evaluateComprehensive.setText(evaluateComprehensive2);

        //评级
        final ImageView imageView = findViewById(R.id.photo);
        if (avg2 >= 90) {
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.excellent));
        } else if (avg2 >= 85) {
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.good));
        } else if (avg2 >= 75) {
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.commonly));
        } else if (avg2 >= 60) {
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.poor));
        } else {
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.fail));
        }

        //单科评价
        double score1 = Double.parseDouble(ChineseS);
        double score2 = Double.parseDouble(MathS);
        double score3 = Double.parseDouble(EnglishS);
        double score4 = Double.parseDouble(ComputerS);

        String evaluate1 = G(score1);
        String evaluate2 = G(score2);
        String evaluate3 = G(score3);
        String evaluate4 = G(score4);

        TextView  reportChinese= findViewById(R.id.reportChinese);
        TextView  reportMath= findViewById(R.id.reportMath);
        TextView  reportEnglish= findViewById(R.id.reportEnglish);
        TextView  reportComputer= findViewById(R.id.reportComputer);

        reportChinese.setText(evaluate1);
        reportMath.setText(evaluate2);
        reportEnglish.setText(evaluate3);
        reportComputer.setText(evaluate4);


        Button button2 = findViewById(R.id.last);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }

        });

    }
    //综合评价
    public static String A(double average,double stability) {

        if (average >= 90)
        {
            if (stability < 4)
            {
                String judge = "总体成绩表现为优秀，请继续努力！";
                return judge;
            }
            else
            {
                String judge = "总体成绩表现为优秀，但存在偏科现象，请注意！";
                return judge;
            }
        }
        else if (average >= 85)
        {
            if (stability < 4)
            {
                String judge = "总体成绩表现为良好，请继续努力！";
                return judge;
            }
            else
            {
                String judge = "总体成绩表现为良好，但存在偏科现象，请注意！";
                return judge;
            }
        }
        else if (average >= 75)
        {
            if (stability < 4)
            {
                String judge = "总体成绩表现为一般，请继续努力！";
                return judge;
            }
            else
            {
                String judge = "总体成绩表现为一般，且存在偏科现象，请注意！";
                return judge;
            }
        }
        else if (average >= 60)
        {
            if (stability < 4)
            {
                String judge = "总体成绩表现为较差，请改进学习方法以免挂科！";
                return judge;
            }
            else
            {
                String judge = "总体成绩表现为较差，且存在偏科现象，请改进学习方法以免挂科！";
                return judge;
            }
        }
        else
        {
            if (stability < 4)
            {
                String judge = "总体成绩表现为不合格，请改进学习方法！";
                return judge;
            }
            else
            {
                String judge = "总体成绩表现为不合格，且存在偏科现象，请改进学习方法！";
                return judge;
            }
        }
    }

    //评级
    public static void B(double score) {

        if (score >= 90) {

        } else if (score >= 85) {

        } else if (score >= 75) {

        } else if (score >= 60) {

        } else {

        }
    }


    //单科评价
    public static String G(double score) {

        if (score >= 90) {
            String evaluate = "您的成绩为优秀，请继续努力！";
            return evaluate;
        } else if (score >= 85) {
            String evaluate = "您的成绩为良好，请继续努力！";
            return evaluate;
        } else if (score >= 75) {
            String evaluate = "您的成绩为一般，请改进学习方法！";
            return evaluate;
        } else if (score >= 60) {
            String evaluate = "您的成绩为较差，请小心挂科！";
            return evaluate;
        } else {
            String evaluate = "您的成绩为不合格，您已挂科！";
            return evaluate;
        }
    }

}