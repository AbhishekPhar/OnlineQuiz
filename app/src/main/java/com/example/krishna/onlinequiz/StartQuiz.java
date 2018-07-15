package com.example.krishna.onlinequiz;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class StartQuiz extends AppCompatActivity {
    TextView tv;
    Button btn,btn2;
    String level[]={"Easy Mode","Hard Mode"};
    ArrayAdapter<String> adapter;
    Spinner sp;
    int p;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_quiz);
        tv= (TextView) findViewById(R.id.textView6);
        btn2= (Button) findViewById(R.id.backbtn);

        btn= (Button) findViewById(R.id.button4);
        sp= (Spinner) findViewById(R.id.spinner);
        sp.setPrompt("Select the Level");

        adapter=new ArrayAdapter<String>(StartQuiz.this,android.R.layout.simple_list_item_1,level);

        sp.setAdapter(adapter);

        Bundle b=getIntent().getExtras();
        p=b.getInt("pos_key");
        if(p==0)
        {
            tv.setText("Select Java Quiz Level");
        }
        else if(p==1)
        {
            tv.setText("Select Android Quiz Level");
        }
        else if(p==2){
            tv.setText("Select .Net Quiz Level");
        }
        else if(p==3)
        {
            tv.setText("Select Web Desgining Quiz Level");
        }
        else if(p==4)
        {
            tv.setText("Select DBMS Quiz Level");
        }
        else if(p==5)
        {
            tv.setText("Select C Programming Quiz Level");
        }
        else if(p==6)
        {
            tv.setText("Select C++ Programming Quiz Level");
        }


        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pos=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent=new Intent(getApplicationContext(),GetExam.class);
            intent.putExtra("list_key",p);
            intent.putExtra("sp_key",pos);
            startActivity(intent);
            finish();
        }
    });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),QuizHome.class);
                startActivity(i);
                finish();
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
                Intent intent=new Intent(StartQuiz.this,MainActivity.class);
                finish();
                break;

            case R.id.item2:
                Toast.makeText(this, "welcome to About page", Toast.LENGTH_SHORT).show();
                Intent intent1=new Intent(StartQuiz.this,AboutActivity.class);
                startActivity(intent1);
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
