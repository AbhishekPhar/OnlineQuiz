package com.example.krishna.onlinequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddQuestions extends AppCompatActivity {
    EditText et1,et2,et3,et4,et5,et6,et7;
    Button btn;
    MyDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_questions);
        db=new MyDatabase(this);
        et1= (EditText) findViewById(R.id.editText);
        et2= (EditText) findViewById(R.id.editText2);
        et3= (EditText) findViewById(R.id.editText3);
        et4= (EditText) findViewById(R.id.editText4);
        et5= (EditText) findViewById(R.id.editText5);
        et6= (EditText) findViewById(R.id.editText6);
        et7= (EditText) findViewById(R.id.editText7);
        btn= (Button) findViewById(R.id.button7);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(et1.getText().toString());
                String question = et2.getText().toString();
                String option1 = et3.getText().toString();
                String option2 = et4.getText().toString();
                String option3 = et5.getText().toString();
                String option4 = et6.getText().toString();
                String answer = et7.getText().toString();

                if (id == 0 && question.length() == 0 && option1.length() == 0 && option2.length() == 0 && option3.length() == 0 && option4.length() == 0 && answer.length() == 0) {
                    Toast.makeText(AddQuestions.this, "please fill all detail", Toast.LENGTH_SHORT).show();
                }
                else
                {

                //AddJavaFirst record = new AddJavaFirst();
                //AddJavaFirst record=new AddJavaFirst();
                    AddCppFirst record=new AddCppFirst();
                record.setId(id);
                record.setQuestion(question);
                record.setOptionf(option1);
                record.setOptions(option2);
                record.setOptiont(option3);
                record.setOptionl(option4);
                record.setAnswer(answer);

                db.insrtQuestionCPPfirst(record);

                et1.setText("");
                et2.setText("");
                et3.setText("");
                et4.setText("");
                et5.setText("");
                et6.setText("");
                et7.setText("");

                Toast.makeText(AddQuestions.this, "Record succssfully added", Toast.LENGTH_SHORT).show();
            }


            }
        });

    }
}
