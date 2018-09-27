package com.example.atulchaudhary.studentattendancesystem;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.makeramen.roundedimageview.RoundedImageView;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.adapters.FastItemAdapter;


import java.lang.reflect.Array;
import java.util.ArrayList;

import static android.widget.ArrayAdapter.createFromResource;

public class StudentCountActivity extends AppCompatActivity {

    ArrayList<String> mImageUrls;
    ArrayList<String> mNames;
    FastItemAdapter<RecyclerViewAdapter> mFastAdapter;
    private RecyclerView recyclerView;
    RoundedImageView classImageView;
    Bitmap bmp;
    private FastItemAdapter<FastAdapter_for_DialogBox> fastAdpater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_count);


        classImageView = (RoundedImageView) findViewById(R.id.classImageView);

        //getting image from the mainActivtiy to this activity and setting it to the classImageView

        //Bundle extras = getIntent().getExtras();


        byte[] byteArray = VariablesStorageClassSingleton.getInstance().picture;
        bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        classImageView.post(new Runnable() {
            @Override
            public void run() {

                classImageView.setImageBitmap(Bitmap.createScaledBitmap(bmp,classImageView.getWidth(), classImageView.getHeight(), false));

            }
        });

        mFastAdapter = new FastItemAdapter<RecyclerViewAdapter>();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view11);
        mImageUrls = new ArrayList<String>();
        mNames = new ArrayList<String>();

        mImageUrls.add("https://cdn.dribbble.com/users/3460/screenshots/3737157/message-bird-illustration-and-icons-2_1x.png");
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

        LinearLayoutManager lm = new LinearLayoutManager(this);
        Log.e("atulLOG", "rec>> " + recyclerView + lm);
        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(mFastAdapter);
        recyclerView.post(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < mImageUrls.size(); i++) {
                    RecyclerViewAdapter mObj = new RecyclerViewAdapter();
                    mObj.setmStudentImages(mImageUrls.get(i));
                    mObj.setmStudentNames(mNames.get(i));
                    mFastAdapter.add(mObj);
                }
            }
        });


        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Dialog dialog = new Dialog(StudentCountActivity.this);
                dialog.setContentView(R.layout.custom_dialog_box);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });


        //this array list Contains item for course Details
        final ArrayList<Course_details_item> arrayList = new ArrayList<>();
        arrayList.add(new Course_details_item("Btech","CS","1 year"));
        arrayList.add(new Course_details_item("Btech","CS","2 year"));
        arrayList.add(new Course_details_item("Btech","CS","3 year"));
        arrayList.add(new Course_details_item("Btech","CS","4 year"));
        arrayList.add(new Course_details_item("Btech","IT","1 year"));
        arrayList.add(new Course_details_item("Btech","IT","2 year"));
        arrayList.add(new Course_details_item("Btech","IT","3 year"));










        ImageView pencilButton = (ImageView)findViewById(R.id.pencilButton);
        pencilButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(StudentCountActivity.this);
                final LayoutInflater inflater = getLayoutInflater();
                final View dialogView = inflater.inflate(R.layout.customdialogbox_editbutton, null);
                dialogBuilder.setView(dialogView);
                final AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                alertDialog.show();
                //alertDialog.setCancelable(false);


                //mSpinnerBranch=(Spinner)dialogView.findViewById(R.id.st_ad_sub_div_spi);
//
//                final Dialog dialog = new Dialog(StudentCountActivity.this);
//                dialog.setContentView(R.layout.customdialogbox_editbutton);
//                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                dialog.show();




                Spinner selectCourse = (Spinner)dialogView.findViewById(R.id.selectCourse);
                ArrayAdapter<CharSequence> arrayAdapter0 = ArrayAdapter.createFromResource(StudentCountActivity.this,R.array.course,android.R.layout.simple_spinner_item);
                arrayAdapter0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                //selectCourse.setPrompt(R.string.prompt_forCourse);
                selectCourse.setAdapter(arrayAdapter0);

                Spinner selectBranch = (Spinner)dialogView.findViewById(R.id.selectBranch);
                ArrayAdapter<CharSequence> arrayAdapter1 = createFromResource(StudentCountActivity.this,R.array.Branch,android.R.layout.simple_spinner_item);
                arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                selectBranch.setAdapter(arrayAdapter1);

                Spinner selectYear = (Spinner)dialogView.findViewById(R.id.selectYear);
                ArrayAdapter<CharSequence> arrayAdapter2 = createFromResource(StudentCountActivity.this,R.array.year,android.R.layout.simple_spinner_item);
                arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                selectYear.setAdapter(arrayAdapter2);


                RecyclerView recyclerView = (RecyclerView)dialogView.findViewById(R.id.courseSelector_recyclerView);
                fastAdpater = new FastItemAdapter<FastAdapter_for_DialogBox>();
                recyclerView.setAdapter(fastAdpater);
                recyclerView.setLayoutManager(new LinearLayoutManager(StudentCountActivity.this,LinearLayoutManager.HORIZONTAL,false));
                recyclerView.post(new Runnable() {
                    @Override
                    public void run() {

                        for(Course_details_item item:arrayList){
                            FastAdapter_for_DialogBox mObj=new FastAdapter_for_DialogBox();
                            mObj.setmStudentCourse(item.getmCourseName());
                            mObj.setmStudentBranch(item.getmBranchName());
                            mObj.setmStudentYear(item.getmYearName());
                            fastAdpater.add(mObj);
                        }

                    }
                });


            }
        });


    }


}
