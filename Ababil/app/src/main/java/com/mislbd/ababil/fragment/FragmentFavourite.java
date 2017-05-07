package com.mislbd.ababil.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mislbd.ababil.R;
import com.mislbd.ababil.activity.TopUpActivity;
import com.mislbd.ababil.dialogfragment.DialogTopUp;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentFavourite extends Fragment {

	public FragmentFavourite() {
		// Required empty public constructor
	}

	// TODO: Rename and change types and number of parameters
	public static FragmentFavourite newInstance() {
		FragmentFavourite fragment = new FragmentFavourite();
		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}


	@OnClick(R.id.receive_money)
	public void receiveMoney(){

//		DialogTopUp topup = new DialogTopUp();
//		topup.show(getActivity().getFragmentManager(), "Mobile Top-Up");

		Intent i = new Intent(getActivity(), TopUpActivity.class);
		startActivity(i);
		getActivity().overridePendingTransition(R.anim.bottom_up,
				R.anim.nothing);
	}

	@OnClick(R.id.bal_transfer)
	public void balanceTransfer(){

//		DialogTopUp topup = new DialogTopUp();
//		topup.show(getActivity().getFragmentManager(), "Mobile Top-Up");
//
		Intent i = new Intent(getActivity(), TopUpActivity.class);
		startActivity(i);
		getActivity().overridePendingTransition(R.anim.bottom_up,
				R.anim.nothing);
	}

	@OnClick(R.id.top_up)
	public void topUp(){

//		DialogTopUp topup = new DialogTopUp();
//		topup.show(getActivity().getFragmentManager(), "Mobile Top-Up");

		Intent i = new Intent(getActivity(), TopUpActivity.class);
		startActivity(i);
		getActivity().overridePendingTransition(R.anim.bottom_up,
				R.anim.nothing);
	}

	@OnClick(R.id.utility)
	public void utilityBill(){

//		DialogTopUp topup = new DialogTopUp();
//		topup.show(getActivity().getFragmentManager(), "Mobile Top-Up");

		Intent i = new Intent(getActivity(), TopUpActivity.class);
		startActivity(i);
		getActivity().overridePendingTransition(R.anim.bottom_up,
				R.anim.nothing);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {

		View myFragmentView = inflater.inflate(R.layout.fragment_favourite,
				container, false);

		ButterKnife.bind(this, myFragmentView);

		return myFragmentView;
	}
}
