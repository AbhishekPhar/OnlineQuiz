package com.example.krishna.onlinequiz;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class JavaHardFragment extends Fragment {

    RadioButton r1,r2,r3,r4;
    Button btn,btn2;
    AlertDialog.Builder ab;
    MyDatabase db;
    TextView tv;
    int i=0;
    String answer;

    public JavaHardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_java_hard, container, false);

        db=new MyDatabase(getActivity());

        tv= (TextView) v.findViewById(R.id.textView8);
        r1= (RadioButton) v.findViewById(R.id.rb1);
        r2= (RadioButton) v.findViewById(R.id.rb2);
        r3= (RadioButton) v.findViewById(R.id.rb3);
        r4= (RadioButton) v.findViewById(R.id.rb4);
        btn= (Button) v.findViewById(R.id.button5);
        btn2= (Button) v.findViewById(R.id.button6);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(r1.isChecked())
                {
                    if(r1.getText().toString().equals(answer))
                    {
                        r1.setBackgroundColor(Color.GREEN);
                    }
                    else {
                        r1.setBackgroundColor(Color.RED);
                    }
                } else if (r2.isChecked())
                {
                    if(r2.getText().toString().equals(answer)) {
                        r2.setBackgroundColor(Color.GREEN);
                    }
                    else
                    {
                        r2.setBackgroundColor(Color.RED);
                    }
                }
                else if(r3.isChecked())
                {
                    if(r3.getText().toString().equals(answer))
                    {
                        r3.setBackgroundColor(Color.GREEN);
                    }
                    else {
                        r3.setBackgroundColor(Color.RED);
                    }
                }
                else
                {
                    if(r4.getText().toString().equals(answer))
                    {
                        r4.setBackgroundColor(Color.GREEN);
                    }
                    else {
                        r4.setBackgroundColor(Color.RED);
                    }
                }

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=i+1;
                List<AddJavaFirst> list=db.getAllJavaFquestion();
                for(AddJavaFirst record:list)
                {
                    if(i==record.getId())
                    {
                        tv.setText(record.getQuestion());
                        r1.setText(record.getOptionf());
                        r2.setText(record.getOptions());
                        r3.setText(record.getOptiont());
                        r4.setText(record.getOptionl());
                        answer=record.getAnswer();
                        r1.setBackgroundColor(Color.WHITE);
                        r2.setBackgroundColor(Color.WHITE);
                        r3.setBackgroundColor(Color.WHITE);
                        r4.setBackgroundColor(Color.WHITE);
                    }
                    //Toast.makeText(GetExam.this,"id :="+record.getId()+"\nquestion :="+record.getQuestion()+"\noption1 :="+record.getOptionf()+"\noption2 :="+record.getOptions()+"\noption3 :="+record.getOptiont()+"\noption4 :="+record.getOptionl()+"\nanswer :="+record.answer,Toast.LENGTH_SHORT).show();
                }
            }
        });

        return v;
    }


}
