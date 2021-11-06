package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.math.BigDecimal;

public class MainActivity2 extends AppCompatActivity {
    TextView ChineseScore, ChinesePoint, MathScore, MathPoint, EnglishScore, EnglishPoint, ComputerScore, ComputerPoint, sumCredit,sumPoint,grade,gradeChinese,gradeMath,gradeEnglish,gradeComputer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //数据传输
        Intent intent2 = getIntent();
        String ChineseS = intent2.getStringExtra("ChineseScore");
        String ChineseC = intent2.getStringExtra("ChineseCredit");
        String MathS = intent2.getStringExtra("MathScore");
        String MathC = intent2.getStringExtra("MathCredit");
        String EnglishS = intent2.getStringExtra("EnglishScore");
        String EnglishC = intent2.getStringExtra("EnglishCredit");
        String ComputerS = intent2.getStringExtra("ComputerScore");
        String ComputerC = intent2.getStringExtra("ComputerCredit");

        final TextView ChineseScore = findViewById(R.id.ChineseScore);
        final TextView MathScore = findViewById(R.id.MathScore);
        final TextView EnglishScore = findViewById(R.id.EnglishScore);
        final TextView ComputerScore = findViewById(R.id.ComputerScore);


        ChineseScore.setText(ChineseS);
        MathScore.setText(MathS);
        EnglishScore.setText(EnglishS);
        ComputerScore.setText(ComputerS);

        //求总学分
        double credit1 = Double.parseDouble(ChineseC);
        double credit2 = Double.parseDouble(MathC);
        double credit3 = Double.parseDouble(EnglishC);
        double credit4 = Double.parseDouble(ComputerC);
        double sum2 = credit1 + credit2 + credit3 + credit4;

        TextView sumCredit = (TextView) findViewById(R.id.sumCredit);
        sumCredit.setText("" + sum2 + "");

        //加权平均分
        double score1 = Double.parseDouble(ChineseS);
        double score2 = Double.parseDouble(MathS);
        double score3 = Double.parseDouble(EnglishS);
        double score4 = Double.parseDouble(ComputerS);
        double avg = (score1 * credit1 + score2 * credit2 + score3 * credit3 + score4 * credit4) / sum2;
        java.text.DecimalFormat myformat=new
        java.text.DecimalFormat("0.00");
        String avg2=myformat.format(avg);

        final TextView average = (TextView) findViewById(R.id.average);
        average.setText("" + avg2 + "");


        //绩点

        double point1=P(score1);
        double point2=P(score2);
        double point3=P(score3);
        double point4=P(score4);

        TextView ChinesePoint = findViewById(R.id.ChinesePoint);
        final TextView MathPoint = findViewById(R.id.MathPoint);
        TextView EnglishPoint = findViewById(R.id.EnglishPoint);
        TextView ComputerPoint = findViewById(R.id.ComputerPoint);

        ChinesePoint.setText(""+point1+"");
        MathPoint.setText(""+point2+"");
        EnglishPoint.setText(""+point3+"");
        ComputerPoint.setText(""+point4+"");

        //等级

        String grade1=G(score1);
        String grade2=G(score2);
        String grade3=G(score3);
        String grade4=G(score4);

        final TextView gradeChinese = findViewById(R.id.gradeChinese);
        final TextView gradeMath = findViewById(R.id.gradeMath);
        final TextView gradeEnglish = findViewById(R.id.gradeEnglish);
        final TextView gradeComputer = findViewById(R.id.gradeComputer);

        gradeChinese.setText(""+grade1+"");
        gradeMath.setText(""+grade2+"");
        gradeEnglish.setText(""+grade3+"");
        gradeComputer.setText(""+grade4+"");

        //总绩点
        double sumP = (point1 * credit1 + point2 * credit2 + point3 * credit3 + point4 * credit4) / sum2;
        TextView sumPoint = (TextView) findViewById(R.id.sumPoint);
        java.text.DecimalFormat myformat2=new
        java.text.DecimalFormat("0.00");
        String sumP2=myformat2.format(sumP);
        sumPoint.setText("" + sumP2 + "");

        //综合评级
        String grade5=G(avg);
        TextView grade = findViewById(R.id.grade);
        grade.setText(""+grade5+"");

        //稳定性
        double avg3=(score1+score2+score3+score4)/4;
        final double stab=((score1-avg3)*(score1-avg3)+(score2-avg3)*(score2-avg3)+(score3-avg3)*(score3-avg3)+(score4-avg3)*(score4-avg3))/8;
        final TextView stability = (TextView) findViewById(R.id.stability);

        if (stab<=0.99)
            stability.setText("优秀");
        else if (stab<=3.99)
            stability.setText("良好");
        else if (stab<=9.99)
            stability.setText("较差");
        else
            stability.setText("差");






        //跳转
        Button button = findViewById(R.id.next);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                //数据传输
                intent.putExtra("ChineseScore",ChineseScore.getText().toString());
                intent.putExtra("MathScore",MathScore.getText().toString());
                intent.putExtra("EnglishScore",EnglishScore.getText().toString());
                intent.putExtra("ComputerScore",ComputerScore.getText().toString());
                intent.putExtra("average",average.getText().toString());
                intent.putExtra("stability",stab);


                startActivity(intent);

            }

        });

        //返回
        Button button2 = findViewById(R.id.last);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }

        });


    }

    public static double P(double score) {

        if (score >= 90) {
            double point =4.0;
            return point;
        } else if (score >= 86) {
            double point = 3.7;
            return point;
        } else if (score >= 83) {
            double point = 3.3;
            return point;
        } else if (score >= 80) {
            double point = 3.0;
            return point;
        } else if (score >= 76) {
            double point = 2.7;
            return point;
        } else if (score >= 73) {
            double point = 2.3;
            return point;
        } else if (score >= 70) {
            double point = 2.0;
            return point;
        } else if (score >= 66) {
            double point = 1.7;
            return point;
        } else if (score >= 63) {
            double point = 1.3;
            return point;
        } else if (score >= 60) {
            double point = 1.0;
            return point;
        } else {
            double point = 0;
            return point;
        }
    }


    public static String G(double score) {

        if (score >= 90) {
            String grade = "A";
            return grade;
        } else if (score >= 86) {
            String grade = "A-";
            return grade;
        } else if (score >= 83) {
            String grade = "B+";
            return grade;
        } else if (score >= 80) {
            String grade = "B-";
            return grade;
        } else if (score >= 76) {
            String grade = "C+";
            return grade;
        } else if (score >= 73) {
            String grade = "C";
            return grade;
        } else if (score >= 70) {
            String grade = "C-";
            return grade;
        } else if (score >= 66) {
            String grade = "D+";
            return grade;
        } else if (score >= 63) {
            String grade = "D";
            return grade;
        } else if (score >= 60) {
            String grade = "D-";
            return grade;
        } else {
            String grade = "F";
            return grade;
        }
    }
}