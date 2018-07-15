package com.example.krishna.onlinequiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class GetExam extends AppCompatActivity {

    RadioButton r1,r2,r3,r4;
    Button btn,btn2;
    AlertDialog.Builder ab;
    MyDatabase db;
    TextView tv,tv2;
    int i=0;
    int lk;
    int sk;
    String answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_exam);

        db=new MyDatabase(this);

        tv2= (TextView) findViewById(R.id.textView7);
        tv= (TextView) findViewById(R.id.textView8);
        r1= (RadioButton) findViewById(R.id.rb1);
        r2= (RadioButton) findViewById(R.id.rb2);
        r3= (RadioButton) findViewById(R.id.rb3);
        r4= (RadioButton) findViewById(R.id.rb4);
        btn= (Button) findViewById(R.id.button5);

        btn2= (Button) findViewById(R.id.button6);
        Bundle b=getIntent().getExtras();
        lk=b.getInt("list_key");
        sk=b.getInt("sp_key");
        r1.setVisibility(View.INVISIBLE);
        r2.setVisibility(View.INVISIBLE);
        r3.setVisibility(View.INVISIBLE);
        r4.setVisibility(View.INVISIBLE);
        tv2.setVisibility(View.INVISIBLE);
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

                if(r1.getText().toString().equals(answer))
                {
                    r1.setBackgroundColor(Color.GREEN);
                }
                else if(r2.getText().toString().equals(answer))
                {
                    r2.setBackgroundColor(Color.GREEN);
                }
                else if(r3.getText().toString().equals(answer))
                {
                    r3.setBackgroundColor(Color.GREEN);
                }
                else if(r4.getText().toString().equals(answer))
                {
                    r4.setBackgroundColor(Color.GREEN);
                }



            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r1.setVisibility(View.VISIBLE);
                r2.setVisibility(View.VISIBLE);
                r3.setVisibility(View.VISIBLE);
                r4.setVisibility(View.VISIBLE);
                tv2.setVisibility(View.VISIBLE);
                r1.setChecked(false);
                r2.setChecked(false);
                r3.setChecked(false);
                r4.setChecked(false);


                i=i+1;
                if(lk==0&&sk==0) {
                    List<AddJavaFirst> list = db.getAllJavaFquestion();
                    for (AddJavaFirst record : list)

                    {
                        if (i == record.getId()) {
                            tv.setText(record.getQuestion());
                            r1.setText(record.getOptionf());
                            r2.setText(record.getOptions());
                            r3.setText(record.getOptiont());
                            r4.setText(record.getOptionl());
                            answer = record.getAnswer();
                            r1.setBackgroundColor(Color.WHITE);
                            r2.setBackgroundColor(Color.WHITE);
                            r3.setBackgroundColor(Color.WHITE);
                            r4.setBackgroundColor(Color.WHITE);
                        }
                        //Toast.makeText(GetExam.this,"id :="+record.getId()+"\nquestion :="+record.getQuestion()+"\noption1 :="+record.getOptionf()+"\noption2 :="+record.getOptions()+"\noption3 :="+record.getOptiont()+"\noption4 :="+record.getOptionl()+"\nanswer :="+record.answer,Toast.LENGTH_SHORT).show();
                    }
                }

                else if(lk==0&&sk==1)
                {
                    List<AddJavaLast> list=db.getAllJavaSquestion();
                    for(AddJavaLast record:list)
                    {
                        if (i == record.getId()) {
                            tv.setText(record.getQuestion());
                            r1.setText(record.getOptionf());
                            r2.setText(record.getOptions());
                            r3.setText(record.getOptiont());
                            r4.setText(record.getOptionl());
                            answer = record.getAnswer();
                            r1.setBackgroundColor(Color.WHITE);
                            r2.setBackgroundColor(Color.WHITE);
                            r3.setBackgroundColor(Color.WHITE);
                            r4.setBackgroundColor(Color.WHITE);
                        }
                    }
                }
                else if(lk==1&&sk==0)
                {
                    List<AddAndroidFirst> list=db.getAllAndroidFquestion();
                    for(AddAndroidFirst record:list)
                    {
                        if (i == record.getId()) {
                            tv.setText(record.getQuestion());
                            r1.setText(record.getOptionf());
                            r2.setText(record.getOptions());
                            r3.setText(record.getOptiont());
                            r4.setText(record.getOptionl());
                            answer = record.getAnswer();
                            r1.setBackgroundColor(Color.WHITE);
                            r2.setBackgroundColor(Color.WHITE);
                            r3.setBackgroundColor(Color.WHITE);
                            r4.setBackgroundColor(Color.WHITE);
                        }
                    }
                }
                else if(lk==1&&sk==1)
                {

                    List<AddAndroidLast> list=db.getAllAndroidSquestion();
                    for(AddAndroidLast record:list)
                    {
                        if (i == record.getId()) {
                            tv.setText(record.getQuestion());
                            r1.setText(record.getOptionf());
                            r2.setText(record.getOptions());
                            r3.setText(record.getOptiont());
                            r4.setText(record.getOptionl());
                            answer = record.getAnswer();
                            r1.setBackgroundColor(Color.WHITE);
                            r2.setBackgroundColor(Color.WHITE);
                            r3.setBackgroundColor(Color.WHITE);
                            r4.setBackgroundColor(Color.WHITE);
                        }
                    }
                }
                else if(lk==2&&sk==0)
                {
                    List<AddDotNetFirst> list=db.getAllDotNetFirst();
                    for(AddDotNetFirst record:list)
                    {
                        if (i == record.getId()) {
                            tv.setText(record.getQuestion());
                            r1.setText(record.getOptionf());
                            r2.setText(record.getOptions());
                            r3.setText(record.getOptiont());
                            r4.setText(record.getOptionl());
                            answer = record.getAnswer();
                            r1.setBackgroundColor(Color.WHITE);
                            r2.setBackgroundColor(Color.WHITE);
                            r3.setBackgroundColor(Color.WHITE);
                            r4.setBackgroundColor(Color.WHITE);
                        }
                    }
                }
                else if(lk==2&&sk==1)
                {
                    List<AddDotNetLast> list=db.getAllDotNetLast();
                    for(AddDotNetLast record:list)
                    {
                        if (i == record.getId()) {
                            tv.setText(record.getQuestion());
                            r1.setText(record.getOptionf());
                            r2.setText(record.getOptions());
                            r3.setText(record.getOptiont());
                            r4.setText(record.getOptionl());
                            answer = record.getAnswer();
                            r1.setBackgroundColor(Color.WHITE);
                            r2.setBackgroundColor(Color.WHITE);
                            r3.setBackgroundColor(Color.WHITE);
                            r4.setBackgroundColor(Color.WHITE);
                        }
                    }
                }
                else if(lk==3&&sk==0)
                {
                    List<AddWebFirst> list=db.getAllWebFirst();
                    for(AddWebFirst record:list)
                    {
                        if (i == record.getId()) {
                            tv.setText(record.getQuestion());
                            r1.setText(record.getOptionf());
                            r2.setText(record.getOptions());
                            r3.setText(record.getOptiont());
                            r4.setText(record.getOptionl());
                            answer = record.getAnswer();
                            r1.setBackgroundColor(Color.WHITE);
                            r2.setBackgroundColor(Color.WHITE);
                            r3.setBackgroundColor(Color.WHITE);
                            r4.setBackgroundColor(Color.WHITE);
                        }
                    }
                }
                else if(lk==3&&sk==1)
                {
                    List<AddWebLast> list=db.getAllWebLast();
                    for(AddWebLast record:list)
                    {
                        if (i == record.getId()) {
                            tv.setText(record.getQuestion());
                            r1.setText(record.getOptionf());
                            r2.setText(record.getOptions());
                            r3.setText(record.getOptiont());
                            r4.setText(record.getOptionl());
                            answer = record.getAnswer();
                            r1.setBackgroundColor(Color.WHITE);
                            r2.setBackgroundColor(Color.WHITE);
                            r3.setBackgroundColor(Color.WHITE);
                            r4.setBackgroundColor(Color.WHITE);
                        }
                    }

                }
                else if(lk==4&&sk==0)
                {
                    List<AddDBFirst> list=db.getAllDBFirst();
                    for(AddDBFirst record:list)
                    {
                        if (i == record.getId()) {
                            tv.setText(record.getQuestion());
                            r1.setText(record.getOptionf());
                            r2.setText(record.getOptions());
                            r3.setText(record.getOptiont());
                            r4.setText(record.getOptionl());
                            answer = record.getAnswer();
                            r1.setBackgroundColor(Color.WHITE);
                            r2.setBackgroundColor(Color.WHITE);
                            r3.setBackgroundColor(Color.WHITE);
                            r4.setBackgroundColor(Color.WHITE);
                        }
                    }
                }
                else if(lk==4&&sk==1)
                {
                    List<AddDBLast> list=db.getAllDBLast();
                    for(AddDBLast record:list)
                    {
                        if (i == record.getId()) {
                            tv.setText(record.getQuestion());
                            r1.setText(record.getOptionf());
                            r2.setText(record.getOptions());
                            r3.setText(record.getOptiont());
                            r4.setText(record.getOptionl());
                            answer = record.getAnswer();
                            r1.setBackgroundColor(Color.WHITE);
                            r2.setBackgroundColor(Color.WHITE);
                            r3.setBackgroundColor(Color.WHITE);
                            r4.setBackgroundColor(Color.WHITE);
                        }
                    }
                }
                else if(lk==5&&sk==0)
                {

                    List<AddCFirst> list=db.getAllCfirst();
                    for(AddCFirst record:list)
                    {
                        if (i == record.getId()) {
                            tv.setText(record.getQuestion());
                            r1.setText(record.getOptionf());
                            r2.setText(record.getOptions());
                            r3.setText(record.getOptiont());
                            r4.setText(record.getOptionl());
                            answer = record.getAnswer();
                            r1.setBackgroundColor(Color.WHITE);
                            r2.setBackgroundColor(Color.WHITE);
                            r3.setBackgroundColor(Color.WHITE);
                            r4.setBackgroundColor(Color.WHITE);
                        }
                    }
                }
                else if(lk==5&&sk==1)
                {
                    List<AddCLast> list=db.getAllClast();
                    for(AddCLast record:list)
                    {
                        if (i == record.getId()) {
                            tv.setText(record.getQuestion());
                            r1.setText(record.getOptionf());
                            r2.setText(record.getOptions());
                            r3.setText(record.getOptiont());
                            r4.setText(record.getOptionl());
                            answer = record.getAnswer();
                            r1.setBackgroundColor(Color.WHITE);
                            r2.setBackgroundColor(Color.WHITE);
                            r3.setBackgroundColor(Color.WHITE);
                            r4.setBackgroundColor(Color.WHITE);
                        }
                    }
                }
                else if(lk==6&&sk==0)
                {
                    List<AddCppFirst> list=db.getAllCPPfirst();
                    for(AddCppFirst record:list)
                    {
                        if (i == record.getId()) {
                            tv.setText(record.getQuestion());
                            r1.setText(record.getOptionf());
                            r2.setText(record.getOptions());
                            r3.setText(record.getOptiont());
                            r4.setText(record.getOptionl());
                            answer = record.getAnswer();
                            r1.setBackgroundColor(Color.WHITE);
                            r2.setBackgroundColor(Color.WHITE);
                            r3.setBackgroundColor(Color.WHITE);
                            r4.setBackgroundColor(Color.WHITE);
                        }
                    }
                }
                else if(lk==6&&sk==0)
                {
                    List<AddCppLast> list=db.getAllCPPlast();
                    for(AddCppLast record:list)
                    {
                        if (i == record.getId()) {
                            tv.setText(record.getQuestion());
                            r1.setText(record.getOptionf());
                            r2.setText(record.getOptions());
                            r3.setText(record.getOptiont());
                            r4.setText(record.getOptionl());
                            answer = record.getAnswer();
                            r1.setBackgroundColor(Color.WHITE);
                            r2.setBackgroundColor(Color.WHITE);
                            r3.setBackgroundColor(Color.WHITE);
                            r4.setBackgroundColor(Color.WHITE);
                        }
                    }
                }
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
                Intent intent=new Intent(GetExam.this,MainActivity.class);
                finish();
                break;

            case R.id.item2:
                Toast.makeText(this, "welcome to About page", Toast.LENGTH_SHORT).show();
                Intent intent1=new Intent(GetExam.this,AboutActivity.class);
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

    @Override
    public void onBackPressed() {

        ab = new AlertDialog.Builder(this);
        ab.setTitle("Finish  Quiz");
        ab.setMessage("You really want to finish the quiz");
        ab.setIcon(R.drawable.ic_add_alert_black_24dp);
        ab.setCancelable(false);
        ab.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                finish();

            }
        });
        ab.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                //Toast.makeText(SecondActivity.this, "No button work", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        ab.show();
        //super.onBackPressed();
    }
}
