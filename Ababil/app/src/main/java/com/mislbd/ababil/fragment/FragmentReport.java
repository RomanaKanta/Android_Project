package com.mislbd.ababil.fragment;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.charts.CombinedChart.DrawOrder;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.XAxis.XAxisPosition;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;
import com.mislbd.ababil.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FragmentReport extends Fragment {

	public FragmentReport() {
		// Required empty public constructor
	}

	// TODO: Rename and change types and number of parameters
	public static FragmentReport newInstance() {
		FragmentReport fragment = new FragmentReport();
		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

    @Bind(R.id.net_pro_bar)
	CircularProgressBar netBar;

	@Bind(R.id.rece_pro_bar)
	CircularProgressBar receivedBar;

	@Bind(R.id.spent_pro_bar)
	CircularProgressBar spentBar;

	@Bind(R.id.chart)
	CombinedChart mChart;

	@Bind(R.id.repotr_title)
	TextView title;

	protected String[] mMonths = new String[] {
			"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"
	};

	private ArrayList<Integer> chartData = new ArrayList<>();
	int position = 0;


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {

		View myFragmentView = inflater.inflate(R.layout.fragment_report,
				container, false);

		ButterKnife.bind(this, myFragmentView);
//		position = FragmentPagerItem.getPosition(getArguments());

		setProgrssUI();
		setChart();

		return myFragmentView;
	}


	private  void setProgrssUI(){
		//circulerbar.setProgressWithAnimation(progress, animation_time)
		netBar.setProgressWithAnimation(65, 2500);
		receivedBar.setProgressWithAnimation(35, 2500);
		spentBar.setProgressWithAnimation(40, 2500);
	}

	private void setChart(){

		if (chartData != null && chartData.size()>0)
		{
			chartData.clear();
		}

		chartData.add(10);
		chartData.add(5);
		chartData.add(15);
		chartData.add(7);
		chartData.add(13);
		chartData.add(13);
		chartData.add(8);
		chartData.add(5);
		chartData.add(20);
		chartData.add(18);


		mChart.getDescription().setEnabled(false);
		mChart.setBackgroundColor(Color.TRANSPARENT);
		mChart.setDrawGridBackground(false);
		mChart.setDrawBarShadow(false);
		mChart.setHighlightFullBarEnabled(false);

		// draw bars behind lines
		mChart.setDrawOrder(new DrawOrder[]{
				DrawOrder.BAR,  DrawOrder.LINE
		});

		Legend l = mChart.getLegend();
		l.setWordWrapEnabled(true);
		l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
		l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
		l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
		l.setDrawInside(false);

		YAxis rightAxis = mChart.getAxisRight();
		rightAxis.setDrawGridLines(false);
		rightAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)

		YAxis leftAxis = mChart.getAxisLeft();
		leftAxis.setDrawGridLines(false);
		leftAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)

		XAxis xAxis = mChart.getXAxis();
		xAxis.setPosition(XAxisPosition.BOTH_SIDED);
		xAxis.setAxisMinimum(0f);
		xAxis.setGranularity(1f);
		xAxis.setValueFormatter(new IAxisValueFormatter() {
			@Override
			public String getFormattedValue(float value, AxisBase axis) {
				return mMonths[(int) value % mMonths.length];
			}
		});

		CombinedData data = new CombinedData();

		data.setData(generateLineData());
		data.setData(generateBarData());
		data.setValueTypeface(Typeface.createFromAsset(getActivity().getAssets(), "font/ROBOTO-LIGHT.TTF"));

		xAxis.setAxisMaximum(data.getXMax() + 0.25f);

		mChart.setData(data);
		mChart.invalidate();

	}


	private LineData generateLineData() {

		LineData d = new LineData();

		ArrayList<Entry> entries = new ArrayList<Entry>();

		for (int index = 0; index < chartData.size(); index++) {
			entries.add(new Entry(index + 0.5f, chartData.get(index)));
		}

		LineDataSet set = new LineDataSet(entries, "Line DataSet");
		set.setColor(Color.rgb(240, 238, 70));
		set.setLineWidth(2.5f);
		set.setCircleColor(Color.rgb(240, 238, 70));
		set.setCircleRadius(5f);
		set.setFillColor(Color.rgb(240, 238, 70));
		set.setMode(LineDataSet.Mode.CUBIC_BEZIER);
		set.setDrawValues(true);
		set.setValueTextSize(0f);
		set.setValueTextColor(Color.rgb(240, 238, 70));

		set.setAxisDependency(YAxis.AxisDependency.LEFT);
		d.addDataSet(set);

		return d;
	}

	private BarData generateBarData() {

		ArrayList<BarEntry> entries1 = new ArrayList<BarEntry>();
		ArrayList<BarEntry> entries2 = new ArrayList<BarEntry>();

		for (int index = 0; index < chartData.size(); index++) {

			entries1.add(new BarEntry(0, chartData.get(index)));

			// stacked
//			entries2.add(new BarEntry(0, chartData.get(index)));

		}

		BarDataSet set1 = new BarDataSet(entries1, "Bar DataSet");
		set1.setColor(Color.rgb(60, 220, 78));
		set1.setValueTextColor(Color.rgb(60, 220, 78));
		set1.setValueTextSize(10f);
		set1.setAxisDependency(YAxis.AxisDependency.LEFT);

		BarDataSet set2 = new BarDataSet(entries2, "");
		set2.setStackLabels(new String[]{"Stack 1", "Stack 2"});
		set2.setColors(new int[]{Color.rgb(61, 165, 255), Color.rgb(23, 197, 255)});
		set2.setValueTextColor(Color.rgb(61, 165, 255));
		set2.setValueTextSize(10f);
		set2.setAxisDependency(YAxis.AxisDependency.LEFT);

		float groupSpace = 0.06f;
		float barSpace = 0.02f; // x2 dataset
		float barWidth = 0.45f; // x2 dataset
		// (0.45 + 0.02) * 2 + 0.06 = 1.00 -> interval per "group"

		BarData d = new BarData(set1, set2);
		d.setBarWidth(barWidth);

		// make this BarData object grouped
		d.groupBars(0, groupSpace, barSpace); // start at x = 0

		return d;
	}


}
