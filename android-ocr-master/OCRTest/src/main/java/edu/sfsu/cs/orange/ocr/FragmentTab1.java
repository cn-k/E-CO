package edu.sfsu.cs.orange.ocr;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class FragmentTab1 extends Fragment
{

	DatabaseHelper myDb ;
	Context context ;

	ArrayList<String> listItems = new ArrayList<String>();
	ArrayAdapter<String> adapter;
	ListView listView;
	EditText editText;
	String TABLE_NAME="SERTIFIKA";

	dosyaOku oku= new dosyaOku();
	ArrayList<Certificates> certificates;
	Certificates certificate;
	String title;
	String application_areas;
	String deseases;
	String banned_countries;
	String condition;
	String language;
	String dosya = "EKodlari.txt";
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)	
	{

		// Get the view from fragmenttab1.xml
		View view = inflater.inflate(R.layout.fragmenttab1, container, false);
		initDatabaseHelper();

		listView = (ListView) view.findViewById(R.id.listECodes);
		editText = (EditText) view.findViewById(R.id.txtsearchECodes);

		Cursor cur = myDb.getAllData("select * from " + TABLE_NAME );
		if(cur==null) {
			dosyadanOku(dosya);
		}
			initList();



		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);





		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				String str = (String)listView.getItemAtPosition(position);
				Intent intent = new Intent( getActivity() , ContentEcodes.class);
				intent.putExtra("sertifika_adi" , str);
				startActivity(intent);

			}
		});

		editText.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				FragmentTab1.this.adapter.getFilter().filter(s);
			}

			@Override
			public void afterTextChanged(Editable s) {

			}
		});

	}

	public void initList(){
			Cursor res = myDb.getAllData("select * from " + TABLE_NAME + " where LANGUAGE = '" + LocaleHelper.getLanguage(this.getActivity())  +"'");

			if (res.moveToFirst() && listItems.size() < 20) {
				do {

					String tut = res.getString(1).toString();
					System.out.println(tut);
					listItems.add(tut);
				} while (res.moveToNext());
			}

		adapter = new ArrayAdapter<String>(getActivity(),R.layout.list_item ,R.id.txtitem ,listItems);
		listView.setAdapter(adapter);
		myDb.close();
	}
	public void dosyadanOku(String dosya) {
		certificates=oku.dosyadanOkumaCer(getActivity() , dosya);
		for(int i = 0; i<certificates.size() ; i++) {
			certificate = certificates.get(i);
			title = certificate.gettitle();
			application_areas = certificate.getapplication_areas();
			deseases = certificate.getdeseases();
			banned_countries = certificate.get_banned_countries();
			condition = certificate.get_condition();
			language = certificate.get_language();
			myDb.insertData(title ,application_areas ,deseases ,banned_countries ,condition , language);
			myDb.cursor.close();
			myDb.db.close();
		}
	}

	private void initDatabaseHelper(){
		if(myDb == null){
			myDb = new DatabaseHelper(getActivity());
		}
	}
}
