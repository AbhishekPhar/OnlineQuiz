package com.example.krishna.onlinequiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krishna on 5/22/2018.
 */

public class MyDatabase extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION=1;

    public static final String DATABASE_NAME="mydb";

    //table name
    public static final String SINGUP_TABLE="singup_record";
    public static final String JAVAF_TABLE="javaf_record";
    public static final String JAVAS_TABLE="javas_record";
    public static final String ANDROIDF_TABLE="androidf_record";
    public static final String ANDROIDS_TABLE="androids_record";
    public static final String DOTNETF_TABLE="dotnetf_record";
    public static final String DOTNETS_TABLE="dotnets_record";
    public static final String WEBF_TABLE="webf_record";
    public static final String WEBS_TABLE="webs_record";
    public static final String DBF_TABLE="dbf_record";
    public static final String DBS_TABLE="dbs_record";
    public static final String CPF_TABLE="cpf_record";
    public static final String CPS_TABLE="cps_record";
    public static final String CPPF_TABLE="cppf_record";
    public static final String CPPS_TABLE="cpps_record";
    //colums name for singup
    public static final String NAMME="name";
    public static final String USERNAME="username";
    public static final String PASSWORD="password";

    //column name for all question add table
    public static final String ID="id";
    public static final String QUESTION="question";
    public static final String OPTIONF="optionf";
    public static final String OPTIONS="options";
    public static final String OPTIONT="optiont";
    public static final String OPTIONL="optionl";
    public static final String ANSWER="answer";

    public MyDatabase(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE "+SINGUP_TABLE+"("+NAMME+" TEXT,"+USERNAME+" TEXT,"+PASSWORD+" TEXT"+")";
        db.execSQL(query);
        String query2="CREATE TABLE "+JAVAF_TABLE+"("+ID+" NUMBER PRIMARY KEY,"+QUESTION+" TEXT,"+OPTIONF+" TEXT,"+OPTIONS+" TEXT,"+OPTIONT+" TEXT,"+OPTIONL+" TEXT,"+ANSWER+" TEXT"+")";
        db.execSQL(query2);
        String query3="CREATE TABLE "+JAVAS_TABLE+"("+ID+" NUMBER PRIMARY KEY,"+QUESTION+" TEXT,"+OPTIONF+" TEXT,"+OPTIONS+" TEXT,"+OPTIONT+" TEXT,"+OPTIONL+" TEXT,"+ANSWER+" TEXT"+")";
        db.execSQL(query3);
        String query4="CREATE TABLE "+ANDROIDF_TABLE+"("+ID+" NUMBER PRIMARY KEY,"+QUESTION+" TEXT,"+OPTIONF+" TEXT,"+OPTIONS+" TEXT,"+OPTIONT+" TEXT,"+OPTIONL+" TEXT,"+ANSWER+" TEXT"+")";
        db.execSQL(query4);
        String query5="CREATE TABLE "+ANDROIDS_TABLE+"("+ID+" NUMBER PRIMARY KEY,"+QUESTION+" TEXT,"+OPTIONF+" TEXT,"+OPTIONS+" TEXT,"+OPTIONT+" TEXT,"+OPTIONL+" TEXT,"+ANSWER+" TEXT"+")";
        db.execSQL(query5);
        String query6="CREATE TABLE "+WEBF_TABLE+"("+ID+" NUMBER PRIMARY KEY,"+QUESTION+" TEXT,"+OPTIONF+" TEXT,"+OPTIONS+" TEXT,"+OPTIONT+" TEXT,"+OPTIONL+" TEXT,"+ANSWER+" TEXT"+")";
        db.execSQL(query6);
        String query7="CREATE TABLE "+WEBS_TABLE+"("+ID+" NUMBER PRIMARY KEY,"+QUESTION+" TEXT,"+OPTIONF+" TEXT,"+OPTIONS+" TEXT,"+OPTIONT+" TEXT,"+OPTIONL+" TEXT,"+ANSWER+" TEXT"+")";
        db.execSQL(query7);
        String query8="CREATE TABLE "+DBF_TABLE+"("+ID+" NUMBER PRIMARY KEY,"+QUESTION+" TEXT,"+OPTIONF+" TEXT,"+OPTIONS+" TEXT,"+OPTIONT+" TEXT,"+OPTIONL+" TEXT,"+ANSWER+" TEXT"+")";
        db.execSQL(query8);
        String query9="CREATE TABLE "+DBS_TABLE+"("+ID+" NUMBER PRIMARY KEY,"+QUESTION+" TEXT,"+OPTIONF+" TEXT,"+OPTIONS+" TEXT,"+OPTIONT+" TEXT,"+OPTIONL+" TEXT,"+ANSWER+" TEXT"+")";
        db.execSQL(query9);
        String query10="CREATE TABLE "+CPF_TABLE+"("+ID+" NUMBER PRIMARY KEY,"+QUESTION+" TEXT,"+OPTIONF+" TEXT,"+OPTIONS+" TEXT,"+OPTIONT+" TEXT,"+OPTIONL+" TEXT,"+ANSWER+" TEXT"+")";
        db.execSQL(query10);
        String query11="CREATE TABLE "+CPS_TABLE+"("+ID+" NUMBER PRIMARY KEY,"+QUESTION+" TEXT,"+OPTIONF+" TEXT,"+OPTIONS+" TEXT,"+OPTIONT+" TEXT,"+OPTIONL+" TEXT,"+ANSWER+" TEXT"+")";
        db.execSQL(query11);
        String query12="CREATE TABLE "+CPPF_TABLE+"("+ID+" NUMBER PRIMARY KEY,"+QUESTION+" TEXT,"+OPTIONF+" TEXT,"+OPTIONS+" TEXT,"+OPTIONT+" TEXT,"+OPTIONL+" TEXT,"+ANSWER+" TEXT"+")";
        db.execSQL(query12);
        String query13="CREATE TABLE "+CPPS_TABLE+"("+ID+" NUMBER PRIMARY KEY,"+QUESTION+" TEXT,"+OPTIONF+" TEXT,"+OPTIONS+" TEXT,"+OPTIONT+" TEXT,"+OPTIONL+" TEXT,"+ANSWER+" TEXT"+")";
        db.execSQL(query13);
        String query14="CREATE TABLE "+DOTNETF_TABLE+"("+ID+" NUMBER PRIMARY KEY,"+QUESTION+" TEXT,"+OPTIONF+" TEXT,"+OPTIONS+" TEXT,"+OPTIONT+" TEXT,"+OPTIONL+" TEXT,"+ANSWER+" TEXT"+")";
        db.execSQL(query14);
        String query15="CREATE TABLE "+DOTNETS_TABLE+"("+ID+" NUMBER PRIMARY KEY,"+QUESTION+" TEXT,"+OPTIONF+" TEXT,"+OPTIONS+" TEXT,"+OPTIONT+" TEXT,"+OPTIONL+" TEXT,"+ANSWER+" TEXT"+")";
        db.execSQL(query15);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+SINGUP_TABLE);
        //onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS "+JAVAF_TABLE);
        db.execSQL("DROP TABLE IF EXISTS "+JAVAS_TABLE);
        db.execSQL("DROP TABLE IF EXISTS "+ANDROIDF_TABLE);
        db.execSQL("DROP TABLE IF EXISTS "+ANDROIDS_TABLE);
        db.execSQL("DROP TABLE IF EXISTS "+DOTNETF_TABLE);
        db.execSQL("DROP TABLE IF EXISTS "+DOTNETS_TABLE);
        db.execSQL("DROP TABLE IF EXISTS "+WEBF_TABLE);
        db.execSQL("DROP TABLE IF EXISTS "+WEBS_TABLE);
        db.execSQL("DROP TABLE IF EXISTS "+DBF_TABLE);
        db.execSQL("DROP TABLE IF EXISTS "+DBS_TABLE);
        db.execSQL("DROP TABLE IF EXISTS "+CPF_TABLE);
        db.execSQL("DROP TABLE IF EXISTS "+CPS_TABLE);
        db.execSQL("DROP TABLE IF EXISTS "+CPPF_TABLE);
        db.execSQL("DROP TABLE IF EXISTS "+CPPS_TABLE);
        onCreate(db);
    }

    public void insertRecord(SingupRecord record)
    {
        SQLiteDatabase db=getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(NAMME,record.getName());
        values.put(USERNAME,record.getUsername());
        values.put(PASSWORD,record.getPassword());

        db.insert(SINGUP_TABLE,null,values);

        db.close();

    }

    public List<SingupRecord> getAllRecord()
    {
        SQLiteDatabase db=getReadableDatabase();
        List<SingupRecord> list=new ArrayList<SingupRecord>();

        String query="SELECT * FROM "+SINGUP_TABLE;
        Cursor cursor=db.rawQuery(query,null);

        if(cursor.moveToFirst())
        {
            do {
                SingupRecord record=new SingupRecord();
                record.setName(cursor.getString(0));
                record.setUsername(cursor.getString(1));
                record.setPassword(cursor.getString(2));

                list.add(record);
            }
            while (cursor.moveToNext());
        }
        return list;
    }

    public void insertQuestions(AddJavaFirst record)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(ID,record.getId());
        values.put(QUESTION,record.getQuestion());
        values.put(OPTIONF,record.getOptionf());
        values.put(OPTIONS,record.getOptions());
        values.put(OPTIONT,record.getOptiont());
        values.put(OPTIONL,record.getOptionl());
        values.put(ANSWER,record.getAnswer());

        db.insert(JAVAF_TABLE,null,values);
        db.close();
    }

    public List<AddJavaFirst> getAllJavaFquestion()
    {
        SQLiteDatabase db=getReadableDatabase();
        List<AddJavaFirst> list=new ArrayList<AddJavaFirst>();

        String query3="SELECT * FROM "+JAVAF_TABLE;
        Cursor cursor=db.rawQuery(query3,null);

        if(cursor.moveToFirst())
        {
            do {
                AddJavaFirst record = new AddJavaFirst();
                record.setId(cursor.getInt(0));
                record.setQuestion(cursor.getString(1));
                record.setOptionf(cursor.getString(2));
                record.setOptions(cursor.getString(3));
                record.setOptiont(cursor.getString(4));
                record.setOptionl(cursor.getString(5));
                record.setAnswer(cursor.getString(6));

                list.add(record);

            }
             while (cursor.moveToNext());
            }
            return list;
        }

    public void insrtQuestionsJavaS(AddJavaLast record)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(ID,record.getId());
        values.put(QUESTION,record.getQuestion());
        values.put(OPTIONF,record.getOptionf());
        values.put(OPTIONS,record.getOptions());
        values.put(OPTIONT,record.getOptiont());
        values.put(OPTIONL,record.getOptionl());
        values.put(ANSWER,record.getAnswer()); // db.insert(JAVAF_TABLE,null,values);
        db.insert(JAVAS_TABLE,null,values);
        db.close();

    }

    public List<AddJavaLast> getAllJavaSquestion()
    {
        SQLiteDatabase db=getReadableDatabase();
        List<AddJavaLast> list=new ArrayList<AddJavaLast>();
        String query3="SELECT * FROM "+JAVAS_TABLE;
        Cursor cursor=db.rawQuery(query3,null);

        if(cursor.moveToFirst())
        {

            do {
                AddJavaLast record = new AddJavaLast();
                record.setId(cursor.getInt(0));
                record.setQuestion(cursor.getString(1));
                record.setOptionf(cursor.getString(2));
                record.setOptions(cursor.getString(3));
                record.setOptiont(cursor.getString(4));
                record.setOptionl(cursor.getString(5));
                record.setAnswer(cursor.getString(6));

                list.add(record);

            }
            while (cursor.moveToNext());
        }

        return list;
    }

    public void insrtQuestionsAndroidF(AddAndroidFirst record)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(ID,record.getId());
        values.put(QUESTION,record.getQuestion());
        values.put(OPTIONF,record.getOptionf());
        values.put(OPTIONS,record.getOptions());
        values.put(OPTIONT,record.getOptiont());
        values.put(OPTIONL,record.getOptionl());
        values.put(ANSWER,record.getAnswer());
        db.insert(ANDROIDF_TABLE,null,values);
        db.close();

    }


      public List<AddAndroidFirst> getAllAndroidFquestion()
      {
        SQLiteDatabase db=getReadableDatabase();
        //List<AddJavaFirst> list=new ArrayList<AddJavaFirst>();
        List<AddAndroidFirst> list=new ArrayList<AddAndroidFirst>();
        String query3="SELECT * FROM "+ANDROIDF_TABLE;
        Cursor cursor=db.rawQuery(query3,null);

        if(cursor.moveToFirst())
        {

            do {
                AddAndroidFirst record = new AddAndroidFirst();
                record.setId(cursor.getInt(0));
                record.setQuestion(cursor.getString(1));
                record.setOptionf(cursor.getString(2));
                record.setOptions(cursor.getString(3));
                record.setOptiont(cursor.getString(4));
                record.setOptionl(cursor.getString(5));
                record.setAnswer(cursor.getString(6));

                list.add(record);

            }
            while (cursor.moveToNext());
        }

        return list;
    }

    public void insrtQuestionsAndroidS(AddAndroidLast record)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(ID,record.getId());
        values.put(QUESTION,record.getQuestion());
        values.put(OPTIONF,record.getOptionf());
        values.put(OPTIONS,record.getOptions());
        values.put(OPTIONT,record.getOptiont());
        values.put(OPTIONL,record.getOptionl());
        values.put(ANSWER,record.getAnswer());
        db.insert(ANDROIDS_TABLE,null,values);
        db.close();

    }

    public List<AddAndroidLast> getAllAndroidSquestion()
    {
        SQLiteDatabase db=getReadableDatabase();

        List<AddAndroidLast> list=new ArrayList<AddAndroidLast>();
        String query3="SELECT * FROM "+ANDROIDS_TABLE;
        Cursor cursor=db.rawQuery(query3,null);

        if(cursor.moveToFirst())
        {

            do {
                AddAndroidLast record = new AddAndroidLast();
                record.setId(cursor.getInt(0));
                record.setQuestion(cursor.getString(1));
                record.setOptionf(cursor.getString(2));
                record.setOptions(cursor.getString(3));
                record.setOptiont(cursor.getString(4));
                record.setOptionl(cursor.getString(5));
                record.setAnswer(cursor.getString(6));

                list.add(record);

            }
            while (cursor.moveToNext());
        }

        return list;
    }


    public void insrtQuestionsDotNetFirst(AddDotNetFirst record)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(ID,record.getId());
        values.put(QUESTION,record.getQuestion());
        values.put(OPTIONF,record.getOptionf());
        values.put(OPTIONS,record.getOptions());
        values.put(OPTIONT,record.getOptiont());
        values.put(OPTIONL,record.getOptionl());
        values.put(ANSWER,record.getAnswer());
        db.insert(DOTNETF_TABLE,null,values);
        db.close();

    }
    public List<AddDotNetFirst> getAllDotNetFirst()
    {
        SQLiteDatabase db=getReadableDatabase();

        List<AddDotNetFirst> list=new ArrayList<AddDotNetFirst>();
        String query3="SELECT * FROM "+DOTNETF_TABLE;
        Cursor cursor=db.rawQuery(query3,null);

        if(cursor.moveToFirst())
        {

            do {
                AddDotNetFirst record = new AddDotNetFirst();
                record.setId(cursor.getInt(0));
                record.setQuestion(cursor.getString(1));
                record.setOptionf(cursor.getString(2));
                record.setOptions(cursor.getString(3));
                record.setOptiont(cursor.getString(4));
                record.setOptionl(cursor.getString(5));
                record.setAnswer(cursor.getString(6));

                list.add(record);

            }
            while (cursor.moveToNext());
        }

        return list;
    }
    public void insrtQuestionsDotNetSecond(AddDotNetLast record)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(ID,record.getId());
        values.put(QUESTION,record.getQuestion());
        values.put(OPTIONF,record.getOptionf());
        values.put(OPTIONS,record.getOptions());
        values.put(OPTIONT,record.getOptiont());
        values.put(OPTIONL,record.getOptionl());
        values.put(ANSWER,record.getAnswer());
        db.insert(DOTNETS_TABLE,null,values);
        db.close();

    }
    public List<AddDotNetLast> getAllDotNetLast()
    {
        SQLiteDatabase db=getReadableDatabase();

        List<AddDotNetLast> list=new ArrayList<AddDotNetLast>();
        String query3="SELECT * FROM "+DOTNETS_TABLE;
        Cursor cursor=db.rawQuery(query3,null);

        if(cursor.moveToFirst())
        {

            do {
                AddDotNetLast record = new AddDotNetLast();
                record.setId(cursor.getInt(0));
                record.setQuestion(cursor.getString(1));
                record.setOptionf(cursor.getString(2));
                record.setOptions(cursor.getString(3));
                record.setOptiont(cursor.getString(4));
                record.setOptionl(cursor.getString(5));
                record.setAnswer(cursor.getString(6));

                list.add(record);

            }
            while (cursor.moveToNext());
        }

        return list;
    }

    public void insrtQuestionWebFirst(AddWebFirst record)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(ID,record.getId());
        values.put(QUESTION,record.getQuestion());
        values.put(OPTIONF,record.getOptionf());
        values.put(OPTIONS,record.getOptions());
        values.put(OPTIONT,record.getOptiont());
        values.put(OPTIONL,record.getOptionl());
        values.put(ANSWER,record.getAnswer());
        db.insert(WEBF_TABLE,null,values);
        db.close();

    }
    public List<AddWebFirst> getAllWebFirst()
    {
        SQLiteDatabase db=getReadableDatabase();

        List<AddWebFirst> list=new ArrayList<AddWebFirst>();
        String query3="SELECT * FROM "+WEBF_TABLE;
        Cursor cursor=db.rawQuery(query3,null);

        if(cursor.moveToFirst())
        {

            do {
                AddWebFirst record = new AddWebFirst();
                record.setId(cursor.getInt(0));
                record.setQuestion(cursor.getString(1));
                record.setOptionf(cursor.getString(2));
                record.setOptions(cursor.getString(3));
                record.setOptiont(cursor.getString(4));
                record.setOptionl(cursor.getString(5));
                record.setAnswer(cursor.getString(6));

                list.add(record);

            }
            while (cursor.moveToNext());
        }

        return list;
    }

    public void insrtQuestionWebLast(AddWebLast record)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(ID,record.getId());
        values.put(QUESTION,record.getQuestion());
        values.put(OPTIONF,record.getOptionf());
        values.put(OPTIONS,record.getOptions());
        values.put(OPTIONT,record.getOptiont());
        values.put(OPTIONL,record.getOptionl());
        values.put(ANSWER,record.getAnswer());
        db.insert(WEBS_TABLE,null,values);
        db.close();

    }
    public List<AddWebLast> getAllWebLast()
    {
        SQLiteDatabase db=getReadableDatabase();

        List<AddWebLast> list=new ArrayList<AddWebLast>();
        String query3="SELECT * FROM "+WEBS_TABLE;
        Cursor cursor=db.rawQuery(query3,null);

        if(cursor.moveToFirst())
        {

            do {
                AddWebLast record = new AddWebLast();
                record.setId(cursor.getInt(0));
                record.setQuestion(cursor.getString(1));
                record.setOptionf(cursor.getString(2));
                record.setOptions(cursor.getString(3));
                record.setOptiont(cursor.getString(4));
                record.setOptionl(cursor.getString(5));
                record.setAnswer(cursor.getString(6));

                list.add(record);

            }
            while (cursor.moveToNext());
        }

        return list;
    }

    public void insrtQuestionDBFirst(AddDBFirst record)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(ID,record.getId());
        values.put(QUESTION,record.getQuestion());
        values.put(OPTIONF,record.getOptionf());
        values.put(OPTIONS,record.getOptions());
        values.put(OPTIONT,record.getOptiont());
        values.put(OPTIONL,record.getOptionl());
        values.put(ANSWER,record.getAnswer());
        db.insert(DBF_TABLE,null,values);
        db.close();

    }

    public List<AddDBFirst> getAllDBFirst()
    {
        SQLiteDatabase db=getReadableDatabase();

        List<AddDBFirst> list=new ArrayList<AddDBFirst>();
        String query3="SELECT * FROM "+DBF_TABLE;
        Cursor cursor=db.rawQuery(query3,null);

        if(cursor.moveToFirst())
        {

            do {
                AddDBFirst record = new AddDBFirst();
                record.setId(cursor.getInt(0));
                record.setQuestion(cursor.getString(1));
                record.setOptionf(cursor.getString(2));
                record.setOptions(cursor.getString(3));
                record.setOptiont(cursor.getString(4));
                record.setOptionl(cursor.getString(5));
                record.setAnswer(cursor.getString(6));

                list.add(record);

            }
            while (cursor.moveToNext());
        }

        return list;
    }

    public void insrtQuestionDBLast(AddDBLast record)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(ID,record.getId());
        values.put(QUESTION,record.getQuestion());
        values.put(OPTIONF,record.getOptionf());
        values.put(OPTIONS,record.getOptions());
        values.put(OPTIONT,record.getOptiont());
        values.put(OPTIONL,record.getOptionl());
        values.put(ANSWER,record.getAnswer());
        db.insert(DBS_TABLE,null,values);
        db.close();

    }

    public List<AddDBLast> getAllDBLast()
    {
        SQLiteDatabase db=getReadableDatabase();

        List<AddDBLast> list=new ArrayList<AddDBLast>();
        String query3="SELECT * FROM "+DBS_TABLE;
        Cursor cursor=db.rawQuery(query3,null);

        if(cursor.moveToFirst())
        {

            do {
                AddDBLast record = new AddDBLast();
                record.setId(cursor.getInt(0));
                record.setQuestion(cursor.getString(1));
                record.setOptionf(cursor.getString(2));
                record.setOptions(cursor.getString(3));
                record.setOptiont(cursor.getString(4));
                record.setOptionl(cursor.getString(5));
                record.setAnswer(cursor.getString(6));

                list.add(record);

            }
            while (cursor.moveToNext());
        }

        return list;
    }
    public void insrtQuestionCfirst(AddCFirst record)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(ID,record.getId());
        values.put(QUESTION,record.getQuestion());
        values.put(OPTIONF,record.getOptionf());
        values.put(OPTIONS,record.getOptions());
        values.put(OPTIONT,record.getOptiont());
        values.put(OPTIONL,record.getOptionl());
        values.put(ANSWER,record.getAnswer());
        db.insert(CPF_TABLE,null,values);
        db.close();

    }
    public List<AddCFirst> getAllCfirst()
    {
        SQLiteDatabase db=getReadableDatabase();

        List<AddCFirst> list=new ArrayList<AddCFirst>();
        String query3="SELECT * FROM "+CPF_TABLE;
        Cursor cursor=db.rawQuery(query3,null);

        if(cursor.moveToFirst())
        {

            do {
                AddCFirst record = new AddCFirst();
                record.setId(cursor.getInt(0));
                record.setQuestion(cursor.getString(1));
                record.setOptionf(cursor.getString(2));
                record.setOptions(cursor.getString(3));
                record.setOptiont(cursor.getString(4));
                record.setOptionl(cursor.getString(5));
                record.setAnswer(cursor.getString(6));

                list.add(record);

            }
            while (cursor.moveToNext());
        }

        return list;
    }

    public void insrtQuestionCLast(AddCLast record)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(ID,record.getId());
        values.put(QUESTION,record.getQuestion());
        values.put(OPTIONF,record.getOptionf());
        values.put(OPTIONS,record.getOptions());
        values.put(OPTIONT,record.getOptiont());
        values.put(OPTIONL,record.getOptionl());
        values.put(ANSWER,record.getAnswer());
        db.insert(CPS_TABLE,null,values);
        db.close();

    }
    public List<AddCLast> getAllClast()
    {
        SQLiteDatabase db=getReadableDatabase();

        List<AddCLast> list=new ArrayList<AddCLast>();
        String query3="SELECT * FROM "+CPS_TABLE;
        Cursor cursor=db.rawQuery(query3,null);

        if(cursor.moveToFirst())
        {

            do {
                AddCLast record = new AddCLast();
                record.setId(cursor.getInt(0));
                record.setQuestion(cursor.getString(1));
                record.setOptionf(cursor.getString(2));
                record.setOptions(cursor.getString(3));
                record.setOptiont(cursor.getString(4));
                record.setOptionl(cursor.getString(5));
                record.setAnswer(cursor.getString(6));

                list.add(record);

            }
            while (cursor.moveToNext());
        }

        return list;
    }

    public void insrtQuestionCPPfirst(AddCppFirst record)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(ID,record.getId());
        values.put(QUESTION,record.getQuestion());
        values.put(OPTIONF,record.getOptionf());
        values.put(OPTIONS,record.getOptions());
        values.put(OPTIONT,record.getOptiont());
        values.put(OPTIONL,record.getOptionl());
        values.put(ANSWER,record.getAnswer());
        db.insert(CPPF_TABLE,null,values);
        db.close();

    }
    public List<AddCppFirst> getAllCPPfirst()
    {
        SQLiteDatabase db=getReadableDatabase();

        List<AddCppFirst> list=new ArrayList<AddCppFirst>();
        String query3="SELECT * FROM "+CPPF_TABLE;
        Cursor cursor=db.rawQuery(query3,null);

        if(cursor.moveToFirst())
        {

            do {
                AddCppFirst record = new AddCppFirst();
                record.setId(cursor.getInt(0));
                record.setQuestion(cursor.getString(1));
                record.setOptionf(cursor.getString(2));
                record.setOptions(cursor.getString(3));
                record.setOptiont(cursor.getString(4));
                record.setOptionl(cursor.getString(5));
                record.setAnswer(cursor.getString(6));

                list.add(record);

            }
            while (cursor.moveToNext());
        }

        return list;
    }
    public void insrtQuestionCPPlast(AddCppLast record)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(ID,record.getId());
        values.put(QUESTION,record.getQuestion());
        values.put(OPTIONF,record.getOptionf());
        values.put(OPTIONS,record.getOptions());
        values.put(OPTIONT,record.getOptiont());
        values.put(OPTIONL,record.getOptionl());
        values.put(ANSWER,record.getAnswer());
        db.insert(CPPS_TABLE,null,values);
        db.close();

    }

    public List<AddCppLast> getAllCPPlast()
    {
        SQLiteDatabase db=getReadableDatabase();

        List<AddCppLast> list=new ArrayList<AddCppLast>();
        String query3="SELECT * FROM "+CPPS_TABLE;
        Cursor cursor=db.rawQuery(query3,null);

        if(cursor.moveToFirst())
        {

            do {
                AddCppLast record = new AddCppLast();
                record.setId(cursor.getInt(0));
                record.setQuestion(cursor.getString(1));
                record.setOptionf(cursor.getString(2));
                record.setOptions(cursor.getString(3));
                record.setOptiont(cursor.getString(4));
                record.setOptionl(cursor.getString(5));
                record.setAnswer(cursor.getString(6));

                list.add(record);

            }
            while (cursor.moveToNext());
        }

        return list;
    }

}

