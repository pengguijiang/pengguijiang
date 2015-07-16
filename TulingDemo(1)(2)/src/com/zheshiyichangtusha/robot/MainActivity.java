package com.zheshiyichangtusha.robot;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.lang.String;

import org.json.JSONObject;

import com.zheshiyichangtusha.robot.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

import android.view.View;

public class MainActivity extends Activity implements HttpGetDataListener,
		View.OnClickListener {

	private HttpData httpData;
	private List<ListData> lists;
	private ListView lv;
	private EditText sendText;
	private Button sendBtn;
	private String content_str;
	private TextAdapter adapter;
	String[] welcomeArray;
	private double currentTime, oldTime = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	private void initView() {
		lv = (ListView) findViewById(R.id.lv);
		sendBtn = (Button) findViewById(R.id.send_btn);
		sendText = (EditText) findViewById(R.id.sendText);
		lists = new ArrayList<ListData>();
		sendBtn.setOnClickListener(this);
		adapter = new TextAdapter(lists, this);
		lv.setAdapter(adapter);
		ListData listData = new ListData(getRandomWelcomeTips(),
				ListData.RECEIVER, getTiem());
		lists.add(listData);
	}

	private String getRandomWelcomeTips() {
		String welcomeTips = null;
		welcomeArray = this.getResources().getStringArray(R.array.welcome_tips);
		int index = (int) (Math.random() * (welcomeArray.length - 1));
		welcomeTips = welcomeArray[index];
		return welcomeTips;
	}

	public void getDataUrl(String data) {
		System.out.println(data);
		parseText(data);
	}

	public void parseText(String str) {
		try {
			JSONObject jb = new JSONObject(str);
			ListData listData;
			listData = new ListData(jb.getString("text"), ListData.RECEIVER,
					getTiem());
			lists.add(listData);
			adapter.notifyDataSetChanged();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onClick(View v) {
		content_str = sendText.getText().toString();

		String dropk = content_str.replace(" ", "");
		String droph = dropk.replace("\n", "");

		sendText.setText(null);
		ListData listData;
		listData = new ListData(content_str, ListData.SEND, getTiem());
		lists.add(listData);
		adapter.notifyDataSetChanged();
		httpData = (HttpData) new HttpData(
				"http://www.tuling123.com/openapi/api?key=2467cca90f9c8ba6e980f54e542235be&info="
						+ droph, this).execute();
	}

	private String getTiem() {
		currentTime = System.currentTimeMillis();
		SimpleDateFormat format = new SimpleDateFormat("yyyyÄêMMÔÂddÈÕ  hh:mm:ss");
		Date cdata = new Date();
		String str = format.format(cdata);
		if (currentTime - oldTime > 1 * 60 * 1000) {
			oldTime = currentTime;
			return str;
		} else {
			return "";
		}

	}
}