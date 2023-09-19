package com.example.zametki;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public List<Notes> listNotes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OpenNote(View view) {
        setContentView(R.layout.activity_note);
    }

    public void AddNote(View view) {
        Notes newNotes = new Notes();
        EditText eName = findViewById(R.id.editTextTextPersonName);
        newNotes.name = eName.getText().toString();
        MultiAutoCompleteTextView eText = findViewById(R.id.multiAutoCompleteTextView);
        newNotes.text = eText.getText().toString();
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd");
        newNotes.date = formatForDateNow.format(dateNow);
        listNotes.add(newNotes);
        setContentView(R.layout.activity_main);
        onLoad();
    }

    public void onLoad() {
        LinearLayout parent = findViewById(R.id.parent);
        System.out.print(listNotes.size());
        for(int i = 0; i < listNotes.size(); i++) {
            LinearLayout ll = new LinearLayout(this);
            ll.setOrientation(LinearLayout.HORIZONTAL);
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.MATCH_PARENT
            );
            ll.setLayoutParams(params);
            ImageView iv = new ImageView(this);
            iv.setImageResource(R.drawable.icon);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(150, 150);
            iv.setPadding(20, 20, 20, 20);
            LinearLayout llVer = new LinearLayout(this);
            llVer.setOrientation(LinearLayout.VERTICAL);
            llVer.setLayoutParams(params);
            TextView tvName = new TextView(this);
            tvName.setText(listNotes.get(i).name);
            RelativeLayout.LayoutParams paramsTv = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
            );
            tvName.setLayoutParams(paramsTv);
            tvName.setTextColor(Color.BLACK);
            tvName.setTextSize(18);
            TextView tvData = new TextView(this);
            tvData.setText(listNotes.get(i).date);
            tvData.setLayoutParams(paramsTv);
            tvData.setTextColor(Color.GRAY);
            parent.addView(ll);
            ll.addView(iv);
            ll.addView(llVer);
            llVer.addView(tvName);
            llVer.addView(tvData);
        }
    }
}