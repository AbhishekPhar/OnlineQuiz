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
import android.widget.ListView;
import android.widget.Toast;

public class QuizHome extends AppCompatActivity {
    Integer image[]={R.drawable.java,R.drawable.android,R.drawable.dotnet,R.drawable.web,R.drawable.db,R.drawable.cp,R.drawable.cpp};
    String course[]={"Java Programming","Android Programming",".Net Programming","Web Desgning","DBMS","C programming","C++ programming"};
    ListView lv;
    //ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_home);
        lv= (ListView) findViewById(R.id.list);

        CostomAdapter adapter=new CostomAdapter(this,course,image);
        lv.setAdapter(adapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getApplication(),StartQuiz.class);
                intent.putExtra("pos_key",position);
                startActivity(intent);
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
                Intent intent=new Intent(QuizHome.this,MainActivity.class);
                finish();
                break;

            case R.id.item2:
                Toast.makeText(this, "welcome to About page", Toast.LENGTH_SHORT).show();
                Intent intent1=new Intent(QuizHome.this,AboutActivity.class);
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
