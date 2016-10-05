package edu.sfsu.cs.orange.ocr;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentTab2 extends Fragment
{
	Button btnCamera ,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10;
	private PopupWindow popupWindow;
	private LayoutInflater layoutInflater;
	LinearLayout linear;
	int width;
	int height;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		// Get the view from fragmenttab2.xml
		View view = inflater.inflate(R.layout.fragmenttab2, container, false);

		btnCamera=(Button) view.findViewById(R.id.camera_button) ;
		btn1=(Button) view.findViewById(R.id.icon1);
		btn2=(Button) view.findViewById(R.id.icon2);
		btn3=(Button) view.findViewById(R.id.icon3);
		btn4=(Button) view.findViewById(R.id.icon4);
		btn5=(Button) view.findViewById(R.id.icon5);
		btn6=(Button) view.findViewById(R.id.icon6);
		btn7=(Button) view.findViewById(R.id.icon7);
		btn8=(Button) view.findViewById(R.id.icon8);
		btn9=(Button) view.findViewById(R.id.icon9);
		btn10=(Button) view.findViewById(R.id.icon10);

		linear = (LinearLayout) view.findViewById(R.id.LinearL);

		Display display = getActivity().getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		width = ((size.x)/10)*6;
		height = ((size.y)/10)*4;

		ConnectivityManager cm =
				(ConnectivityManager)getActivity().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

		NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
		boolean isConnected = activeNetwork != null &&
				activeNetwork.isConnectedOrConnecting();
		System.out.println(isConnected);
		btnCamera.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				Intent intent = new Intent(getActivity(), CaptureActivity.class);
				startActivity(intent);
			}
		});

		btn1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				layoutInflater = (LayoutInflater) getActivity().getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				ViewGroup container = (ViewGroup)layoutInflater.inflate(R.layout.popwindow,null);
				popupWindow = new PopupWindow(container , width ,height ,true);
				popupWindow.showAtLocation(linear , Gravity.CENTER, 0 ,50);

				container.setOnTouchListener(new View.OnTouchListener() {
												 public boolean onTouch(View vw, MotionEvent motionEvent) {
													 popupWindow.dismiss();
													 return true;

												 }
											 }
				);
			}
		});

		btn2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				layoutInflater = (LayoutInflater) getActivity().getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				ViewGroup container = (ViewGroup)layoutInflater.inflate(R.layout.popwindow,null);
				popupWindow = new PopupWindow(container , width ,height ,true);
				popupWindow.showAtLocation(linear , Gravity.CENTER , 0 ,50);

				container.setOnTouchListener(new View.OnTouchListener() {
												 public boolean onTouch(View vw, MotionEvent motionEvent) {
													 popupWindow.dismiss();
													 return true;

												 }
											 }
				);
			}
		});


		btn3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				layoutInflater = (LayoutInflater) getActivity().getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				ViewGroup container = (ViewGroup)layoutInflater.inflate(R.layout.popwindow,null);
				popupWindow = new PopupWindow(container , width ,height ,true);
				popupWindow.showAtLocation(linear , Gravity.CENTER , 0 ,50);

				container.setOnTouchListener(new View.OnTouchListener() {
												 public boolean onTouch(View vw, MotionEvent motionEvent) {
													 popupWindow.dismiss();
													 return true;

												 }
											 }
				);
			}
		});


		btn4.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				layoutInflater = (LayoutInflater) getActivity().getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				ViewGroup container = (ViewGroup)layoutInflater.inflate(R.layout.popwindow,null);
				popupWindow = new PopupWindow(container , width ,height ,true);
				popupWindow.showAtLocation(linear , Gravity.CENTER , 0 ,50);

				container.setOnTouchListener(new View.OnTouchListener() {
												 public boolean onTouch(View vw, MotionEvent motionEvent) {
													 popupWindow.dismiss();
													 return true;

												 }
											 }
				);
			}
		});
		btn5.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				layoutInflater = (LayoutInflater) getActivity().getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				ViewGroup container = (ViewGroup)layoutInflater.inflate(R.layout.popwindow,null);
				popupWindow = new PopupWindow(container , width ,height ,true);
				popupWindow.showAtLocation(linear , Gravity.CENTER , 0 ,50);

				container.setOnTouchListener(new View.OnTouchListener() {
												 public boolean onTouch(View vw, MotionEvent motionEvent) {
													 popupWindow.dismiss();
													 return true;

												 }
											 }
				);
			}
		});
		btn6.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				layoutInflater = (LayoutInflater) getActivity().getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				ViewGroup container = (ViewGroup)layoutInflater.inflate(R.layout.popwindow,null);
				popupWindow = new PopupWindow(container , width ,height ,true);
				popupWindow.showAtLocation(linear , Gravity.CENTER , 0 ,50);

				container.setOnTouchListener(new View.OnTouchListener() {
												 public boolean onTouch(View vw, MotionEvent motionEvent) {
													 popupWindow.dismiss();
													 return true;

												 }
											 }
				);
			}
		});
		btn7.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				layoutInflater = (LayoutInflater) getActivity().getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				ViewGroup container = (ViewGroup)layoutInflater.inflate(R.layout.popwindow,null);
				popupWindow = new PopupWindow(container , width ,height ,true);
				popupWindow.showAtLocation(linear , Gravity.CENTER , 0 ,50);

				container.setOnTouchListener(new View.OnTouchListener() {
												 public boolean onTouch(View vw, MotionEvent motionEvent) {
													 popupWindow.dismiss();
													 return true;

												 }
											 }
				);
			}
		});
		btn8.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				layoutInflater = (LayoutInflater) getActivity().getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				ViewGroup container = (ViewGroup)layoutInflater.inflate(R.layout.popwindow,null);
				popupWindow = new PopupWindow(container , width ,height ,true);
				popupWindow.showAtLocation(linear , Gravity.CENTER , 0 ,50);

				container.setOnTouchListener(new View.OnTouchListener() {
												 public boolean onTouch(View vw, MotionEvent motionEvent) {
													 popupWindow.dismiss();
													 return true;

												 }
											 }
				);
			}
		});
		btn9.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				layoutInflater = (LayoutInflater) getActivity().getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				ViewGroup container = (ViewGroup)layoutInflater.inflate(R.layout.popwindow,null);
				popupWindow = new PopupWindow(container , width ,height ,true);
				popupWindow.showAtLocation(linear , Gravity.CENTER , 0 ,50);

				container.setOnTouchListener(new View.OnTouchListener() {
												 public boolean onTouch(View vw, MotionEvent motionEvent) {
													 popupWindow.dismiss();
													 return true;

												 }
											 }
				);
			}
		});
		btn10.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				layoutInflater = (LayoutInflater) getActivity().getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				ViewGroup container = (ViewGroup)layoutInflater.inflate(R.layout.popwindow,null);
				popupWindow = new PopupWindow(container , width ,height ,true);
				popupWindow.showAtLocation(linear , Gravity.CENTER , 0 ,50);

				container.setOnTouchListener(new View.OnTouchListener() {
												 public boolean onTouch(View vw, MotionEvent motionEvent) {
													 popupWindow.dismiss();
													 return true;

												 }
											 }
				);
			}
		});
		return view;
	}

}
