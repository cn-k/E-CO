package edu.sfsu.cs.orange.ocr;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by cenk.akdeniz on 26.07.2016.
 */
public class ContentDiseases extends Activity{

    private  DatabaseHelper myDb;
    TextView txt1;
    Button btnHome;
    Cursor cursor;
    Context context;
    ListView listView;
    Intent intentEcodes ;
    CustomGridViewAdapter customGridAdapter;
    ArrayList<String> gridArray ;
    ArrayAdapter<String> adapter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_diseases);
        final Intent intentG = new Intent(this, ContentEcodes.class);

        btnHome = (Button) findViewById(R.id.btnHomeDiseases);
        txt1 = (TextView) findViewById(R.id.txtTitleDiseases);
        listView = (ListView) findViewById(R.id.listEcode);
        Intent intent = getIntent();
        String baslik = intent.getStringExtra("hastalik_adi");
        myDb = new DatabaseHelper(this);
        cursor = myDb.getAllData("select * from HASTALIK where TITLE LIKE '%" + baslik + "%'");
        cursor.moveToFirst();

        String header = cursor.getString(1).toString();
        txt1.setText(header);

        String content = cursor.getString(2).toString();

        String tmp[] = content.split(",");
        adapter = new ArrayAdapter<String>(this,R.layout.list_item ,R.id.txtitem ,Arrays.asList(tmp));

        intentEcodes = new Intent(this , ContentEcodes.class);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = (String)listView.getItemAtPosition(position);
                Intent intent = new Intent( getApplicationContext() , ContentEcodes.class);
                intent.putExtra("sertifika_adi" , str);
                startActivity(intent);

            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });


    }

}


