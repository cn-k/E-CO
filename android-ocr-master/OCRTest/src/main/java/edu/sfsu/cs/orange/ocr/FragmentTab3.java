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

public class FragmentTab3 extends Fragment
{


	DatabaseHelper myDb ;
	Context context ;
	ArrayList<String> listItemss = new ArrayList<String>();
	ArrayAdapter<String> adapter;
	ListView listView;
	EditText editText;
	String TABLE_NAME="HASTALIK";

	dosyaOku oku= new dosyaOku();
	ArrayList<Diseases> diseases;
	Diseases disease;
	String title;
	String ecodes;
	String language;
	String dosya = "EKodHastaliklar.txt";

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		// Get the view from fragmenttab2.xml
		View view = inflater.inflate(R.layout.fragmenttab3, container, false);

		initDatabaseHelper();
		listView = (ListView) view.findViewById(R.id.listDiseases);
		editText = (EditText) view.findViewById(R.id.txtsearchDiseases);

		Cursor cur = myDb.getAllData("select * from " + TABLE_NAME );

		if(cur==null) {
			dosyadanOku(dosya);
		}
		initList();

		return view;

	}

	//@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	 super.onActivityCreated(savedInstanceState);





		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				String str = (String) listView.getItemAtPosition(position);
				Intent intent = new Intent(getActivity(), ContentDiseases.class);
				intent.putExtra("hastalik_adi", str);
				startActivity(intent);

			}
		});

		editText.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				FragmentTab3.this.adapter.getFilter().filter(s);
			}

			@Override
			public void afterTextChanged(Editable s) {

			}
		});

	}


	public void initList(){

		System.out.println(LocaleHelper.getLanguage(this.getActivity()) + " hey");
		Cursor res = myDb.getAllData("select * from " + TABLE_NAME + " where LANGUAGE LIKE '" + LocaleHelper.getLanguage(this.getActivity())  +"'");
		if(res.moveToFirst() && listItemss.size()<20) {
			do{

				String tut=res.getString(1).toString();
				listItemss.add(tut);
			}while(res.moveToNext());
		}
		adapter = new ArrayAdapter<String>(getActivity(),R.layout.list_itemdis ,R.id.txtitemDis ,listItemss);
		listView.setAdapter(adapter);
		myDb.db.close();
	}

	public void dosyadanOku(String dosya) {
		diseases=oku.dosyadanOkumaDis(getActivity() , dosya);
		for(int i = 0; i<diseases.size() ; i++) {
			disease = diseases.get(i);
			title = disease.gettitle();
			ecodes = disease.getecodes();
			language = disease.get_language();
			myDb.insertDataDis(title ,ecodes ,language);
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
