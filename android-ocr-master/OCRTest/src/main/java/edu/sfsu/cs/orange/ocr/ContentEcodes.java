package edu.sfsu.cs.orange.ocr;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by cenk.akdeniz on 06.04.2016.
 */
public class ContentEcodes extends Activity {

    private  DatabaseHelper myDb;
    Button btnHome;
    TextView txt2;
    TextView txt3;
    TextView txt4;
    TextView txt5;
    TextView txt1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contentecodes);

        btnHome=(Button) findViewById(R.id.btnHomeEcodes);

        txt1 = (TextView) findViewById(R.id.txtTitle);
        txt2 = (TextView) findViewById(R.id.txtContent);
        txt3 = (TextView) findViewById(R.id.txtContent2);
        txt4 = (TextView) findViewById(R.id.txtContent3);
        txt5 = (TextView) findViewById(R.id.txtContent4);

        Intent intent = getIntent();
        String baslik = intent.getStringExtra("sertifika_adi");
        String lng =LocaleHelper.getLanguage(this);
        myDb = new DatabaseHelper(this);
        System.out.println(lng + " hola");

        Cursor cursor = myDb.getAllData("select * from SERTIFIKA where title LIKE '%" + baslik + "%'" + " and LANGUAGE = '" + lng + "'" );

        cursor.moveToFirst();
        System.out.println(cursor.getString(6).toString());

        String header = cursor.getString(1).toString();
        SpannableString headerString
                = new SpannableString(header);
        int csHeader = header.indexOf(":");
        csHeader++;
        headerString.setSpan(new ForegroundColorSpan(Color.RED), 0, csHeader, 0);
        txt1.setText(headerString);

        String content = cursor.getString(2).toString();
        SpannableString styledString
                = new SpannableString(content);
        int cs = content.indexOf(":");
        cs++;
        styledString.setSpan(new ForegroundColorSpan(Color.RED), 0, cs , 0);
        txt2.setText(styledString);

        String content2 = cursor.getString(3).toString();
        SpannableString styledString2
                = new SpannableString(content2);
        int cs2 = content2.indexOf(":");
        cs2++;
        styledString2.setSpan(new ForegroundColorSpan(Color.RED), 0, cs2 , 0);
        txt3.setText(styledString2);

        String content3 = cursor.getString(4).toString();
        SpannableString styledString3
                = new SpannableString(content3);
        int cs3 = content3.indexOf(":");
        cs3++;
        styledString3.setSpan(new ForegroundColorSpan(Color.RED), 0, cs3 , 0);
        txt4.setText(styledString3);

        String content4 = cursor.getString(5).toString();
        SpannableString styledString4
                = new SpannableString(content4);
        int cs4 = content4.indexOf(":");
        cs4++;
        styledString4.setSpan(new ForegroundColorSpan(Color.RED), 0, cs4 , 0);
        txt5.setText(styledString4);

        btnHome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
