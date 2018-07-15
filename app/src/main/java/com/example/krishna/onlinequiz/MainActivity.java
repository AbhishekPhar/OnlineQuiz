package com.example.krishna.onlinequiz;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2;
    Button btn1,btn2;
    MyDatabase db;
    int c=0;
    String adminuname;
    String adminpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db=new MyDatabase(this);
        adminuname="srikrishanbhatt";
        adminpass="mypass";

        et1= (EditText) findViewById(R.id.edtiText1);
        et2= (EditText) findViewById(R.id.edit);
        btn1= (Button) findViewById(R.id.button);
        btn2= (Button) findViewById(R.id.button2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username=et1.getText().toString();
                String password=et2.getText().toString();
                if(username.length()==0)
                {
                    et1.setError("please enter username");
                }
                else if(password.length()==0)
                {
                    et2.setText("pleas enter password");
                }
                else if(username.equals("srikrishanbhatt")&&password.equals("mypass"))
                {
                    Intent intent1=new Intent(MainActivity.this,AddQuestions.class);
                    startActivity(intent1);
                }
                else
                {

                    List<SingupRecord> list=db.getAllRecord();
                    for(SingupRecord record:list)
                    {
                        if(username.equals(record.getUsername())&&password.equals(record.getPassword()))
                        {
                            Toast.makeText(MainActivity.this,"you successfully login",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(MainActivity.this,QuizHome.class);
                            startActivity(intent);
                        }

                        else if(!username.equals(record.getUsername())&&!password.equals(record.getPassword()))
                        {
                          c=1;
                        }
                    }

                }
                if(c==1)
                {
                    Toast.makeText(MainActivity.this,"Enter correct username and password",Toast.LENGTH_SHORT).show();
                }



                //Intent intent=new Intent(MainActivity.this,QuizHome.class);
                //startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Singup.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();

        switch(id) {
            case R.id.item1:
                Toast.makeText(this, "welcome to Home page", Toast.LENGTH_SHORT).show();
                break;

            case R.id.item2:
                Toast.makeText(this, "welcome to About page", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getApplicationContext(),AboutActivity.class);
                startActivity(intent);
                break;

            case R.id.item3:
                Toast.makeText(this, "welcome to Rate to App page", Toast.LENGTH_SHORT).show();
                Uri uri2=Uri.parse("http://play.google.com/store");//open play store of our phone
                Intent i=new Intent(Intent.ACTION_VIEW,uri2);
                startActivity(i);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
