package rabi.cgpacalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
    EditText etcourse1,etcourse2,etcourse3,etcourse4,preCourse;
    EditText etcredit1,etcredit2,etcredit3,etcredit4,etprecredit;
    EditText etcgpa,etgrade1,etgrade2,etgrade3,etgrade4,etpreGrade;
    Button bcalculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etcourse1=(EditText)findViewById(R.id.course1);
        etcourse2=(EditText)findViewById(R.id.course2);
        etcourse3=(EditText)findViewById(R.id.course3);
        etcourse4=(EditText)findViewById(R.id.course4);
        etcredit1=(EditText)findViewById(R.id.credit1);
        etcredit2=(EditText)findViewById(R.id.credit2);
        etcredit3=(EditText)findViewById(R.id.credit3);
        etcredit4=(EditText)findViewById(R.id.credit4);
        etgrade1=(EditText)findViewById(R.id.grade1);
        etgrade2=(EditText)findViewById(R.id.grade2);
        etgrade3=(EditText)findViewById(R.id.grade3);
        etgrade4=(EditText)findViewById(R.id.grade4);
        etprecredit=(EditText)findViewById(R.id.preCredit);
        etpreGrade = (EditText)findViewById(R.id.preGrade);
        etcgpa = (EditText)findViewById(R.id.cgpa);
        bcalculate = (Button)findViewById(R.id.calculate_b);
                    bcalculate.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.calculate_b:
                calCGPA();
                break;
        }
    }

    private void calCGPA() {
        //preSem grade
        String preC = etprecredit.getText().toString();
        int preCr;
        try {
            preCr = Integer.parseInt(preC);
        }catch(NumberFormatException e){
            preCr=0;
        }
        String preCou =etpreGrade.getText().toString();
        float preCo;
        try {
            preCo = Float.parseFloat(preCou);
        }catch (NumberFormatException e){
            preCo=0;
        }

        //course1
        String c1 = etcredit1.getText().toString();
        int cr1;
        try {
            cr1 = Integer.parseInt(c1);
        }catch (NumberFormatException e){
            cr1=0;
        }
        String cou1 =etgrade1.getText().toString();
        float co1;
        try {
            co1 = Float.parseFloat(cou1);
        }catch (NumberFormatException e){
            co1=0;
        }

        //course2
        String c2 = etcredit2.getText().toString();
        int cr2;
        try {
            cr2 = Integer.parseInt(c2);
        }catch (NumberFormatException e){
            cr2=0;
        }
        String cou2 =etgrade2.getText().toString();
        float co2;
        try {
            co2 = Float.parseFloat(cou2);
        }catch (NumberFormatException e){
            co2=0;
        }

        //course3
        String c3 = etcredit3.getText().toString();
        int cr3;
        try {
            cr3 = Integer.parseInt(c3);
        }catch (NumberFormatException e){
            cr3 =0;
        }
        String cou3 =etgrade3.getText().toString();
        float co3;
        try {
            co3 = Float.parseFloat(cou3);
        }catch (NumberFormatException e){
            co3=0;
        }

        //course4
        String c4 = etcredit4.getText().toString();
        int cr4;
        try {
            cr4 = Integer.parseInt(c4);
        }catch (NumberFormatException e){
            cr4=0;
        }
        String cou4 =etgrade4.getText().toString();

        float co4;
        try {
            co4 = Float.parseFloat(cou4);
        }catch (NumberFormatException e){
            co4=0;
        }
        try {
            //sumMultis
            float sum1 = forMulti(cr1, co1);
            float sum2 = forMulti(cr2, co2);
            float sum3 = forMulti(cr3, co3);
            float sum4 = forMulti(cr4, co4);
            float perSum = forMulti(preCr, preCo);
            if(perSum==0){
                preCr=0;
            }
            //Sum of credit
            int creSum = cr1 + cr2 + cr3 + cr4 + preCr;

            //sum of multis
            float sumMulti = sum1 + sum2 + sum3 + sum4 + perSum;

            float cgpa = sumMulti / creSum;
            if(Float.isNaN(cgpa)){
                cgpa=0;

            }
            String h =(String.format("%.2f",cgpa));
            etcgpa.setText(h);


        }catch (Exception e){
            e.printStackTrace();
        }




        //return cgpa;
    }


    //for multiplivation
    private float forMulti(int a,float b){
        return a*b;
    }













}
