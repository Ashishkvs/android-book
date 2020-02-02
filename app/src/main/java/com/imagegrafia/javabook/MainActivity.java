package com.imagegrafia.javabook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Context mContext;
    ArrayList<String> titleArrayList;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
        titleArrayList = getContentTitle();

        mRecyclerView = findViewById(R.id.title_template_recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        TitleAdapter titleAdapter = new TitleAdapter(mContext, titleArrayList, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Log.d(TAG, " : " + position);
                Intent pageIntent = new Intent(mContext, PageActivity.class);
                pageIntent.putExtra("titles", titleArrayList.get(position));
                startActivity(pageIntent);

                Toast.makeText(mContext, "clicked " + titleArrayList.get(position), Toast.LENGTH_SHORT).show();
            }
        });
        mRecyclerView.setAdapter(titleAdapter);
    }

    private ArrayList<String> getContentTitle() {
        ArrayList<String> contetnList = new ArrayList<>();
        contetnList.add(ConstantFile.WHAT_IS_JAVA);
        contetnList.add(ConstantFile.HISTORY_OF_JAVA);
        contetnList.add(ConstantFile.DATA_TYPES);
        contetnList.add(ConstantFile.IDENTIFIERS);
        contetnList.add(ConstantFile.FUNDAMENTALS_INTRO);
        contetnList.add(ConstantFile.JAVA_INTRODUCTION);
        contetnList.add(ConstantFile.MAIN_FEATURES_JAVA);
        contetnList.add(ConstantFile.LITERALS);

        return contetnList;
    }
}
