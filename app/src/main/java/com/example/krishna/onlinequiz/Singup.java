package com.example.krishna.onlinequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Singup extends AppCompatActivity {
    MyDatabase db;
    EditText et1,et2,et3;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        db=new MyDatabase(this);

        et1= (EditText) findViewById(R.id.ett1);
        et2= (EditText) findViewById(R.id.ett2);
        et3= (EditText) findViewById(R.id.ett3);
        btn= (Button) findViewById(R.id.button3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=et1.getText().toString();
                String username=et2.getText().toString();
                String password=et3.getText().toString();

                if(name.length()==0)
                {
                    et1.setError("Please enter your name");
                }
                else if(username.length()==0)
                {
                    et2.setError("Please enter username");
                }
                else if(password.length()==0)
                {
                    et3.setError("Please enter Password");
                }
                else
                {
                    SingupRecord record=new SingupRecord();
                    record.setName(name);
                    record.setUsername(username);
                    record.setPassword(password);

                    db.insertRecord(record);
                    et1.setText("");
                    et2.setText("");
                    et3.setText("");

                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(Singup.this,"You are successfully registerd",Toast.LENGTH_SHORT).show();

                }
              /*
                Toast.makeText(Singup.this, "you are successfully register", Toast.LENGTH_SHORT).show();

               */
            }
        });

    }
}
