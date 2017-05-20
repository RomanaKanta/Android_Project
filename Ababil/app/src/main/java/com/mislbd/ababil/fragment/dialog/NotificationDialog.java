package com.mislbd.ababil.fragment.dialog;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.mislbd.ababil.R;


public class NotificationDialog extends DialogFragment {

	public void onResume() {
		super.onResume();

		DisplayMetrics displaymetrics = new DisplayMetrics();
		getActivity().getWindowManager().getDefaultDisplay()
				.getMetrics(displaymetrics);
		int width = displaymetrics.widthPixels;

		getDialog().getWindow().getAttributes().gravity = Gravity.CENTER;
		WindowManager.LayoutParams lp = getDialog().getWindow().getAttributes();
//		lp.width = (int) (width);
		lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
		lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
		getDialog().getWindow().setAttributes(lp);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.notification_dialog, container,
				false);

		getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		getDialog().getWindow().setBackgroundDrawableResource(
				android.R.color.transparent);
		getDialog().getWindow().setGravity(Gravity.CENTER);


		return rootView;
	}

	
}
