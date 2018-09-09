package com.example.atulchaudhary.studentattendancesystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.mikepenz.fastadapter.adapters.FastItemAdapter;


import java.util.ArrayList;

public class StudentCountActivity extends AppCompatActivity {

    ArrayList<String> mImageUrls;
    ArrayList<String> mNames;
    FastItemAdapter<RecyclerViewAdapter> mFastAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_count);

        mFastAdapter=new FastItemAdapter<RecyclerViewAdapter>();
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view11);
        mImageUrls = new ArrayList<String>();
        mNames  = new ArrayList<String>();

        mImageUrls.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        mNames.add("Havasu Falls");

        mImageUrls.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        mNames.add("Trondheim");

        mImageUrls.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        mNames.add("Portugal");

        mImageUrls.add("https://i.redd.it/j6myfqglup501.jpg");
        mNames.add("Rocky Mountain National Park");


        mImageUrls.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        mNames.add("Mahahual");

        mImageUrls.add("https://i.redd.it/k98uzl68eh501.jpg");
        mNames.add("Frozen Lake");


        mImageUrls.add("https://i.redd.it/glin0nwndo501.jpg");
        mNames.add("White Sands Desert");

        mImageUrls.add("https://i.redd.it/obx4zydshg601.jpg");
        mNames.add("Austrailia");

        mImageUrls.add("https://i.imgur.com/ZcLLrkY.jpg");
        mNames.add("Washington");

        LinearLayoutManager lm= new LinearLayoutManager(this);
        Log.e("atulLOG","rec>> "+recyclerView+lm);
        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(mFastAdapter);
        recyclerView.post(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<mImageUrls.size();i++){
                    RecyclerViewAdapter mObj=new RecyclerViewAdapter();
                    mObj.setmStudentImages(mImageUrls.get(i));
                    mObj.setmStudentNames(mNames.get(i));
                    mFastAdapter.add(mObj);
                }
            }
        });


    }


}
