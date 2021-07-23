package com.example.callerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements itemClickListner{
    private RecyclerView recyclerView;
    private final int REQUEST_CODE=0;
    private ArrayList<view> studentList=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        String[]Permission={Manifest.permission.READ_CONTACTS};
        ActivityCompat.requestPermissions(MainActivity.this,Permission,REQUEST_CODE);
    }private void setRecyclerView(){
        Adapter studentAdapter=new Adapter(studentList,this);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(studentAdapter);
    }
    private void buildsetData(){
        view student1=new view("tel:123456789");
        studentList.add(student1);
        view student2=new view("tel:7750887613");
        studentList.add(student2);
        view student3 =new view("tel:9777508577");
        studentList.add(student3);
        view student4=new view("tel:7978635281");
        studentList.add(student1);
        view student5=new view("tel:7750887613");
        studentList.add(student2);
        view student6 =new view("tel:9777508577");
        studentList.add(student3);
        view student7=new view("tel:7978635281");
        studentList.add(student1);
        view student8=new view("tel:7750887613");
        studentList.add(student2);
        view student9 =new view("tel:9777508577");
        studentList.add(student3);

    }
    private  void initView(){
        recyclerView=findViewById(R.id.recycleView);
    }


    @Override
    public void onItemClicked(view model, int position) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse(model.getName()));
        startActivity(intent);




    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull  String[] permissions, @NonNull  int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults[0]== PackageManager.PERMISSION_GRANTED){

            buildsetData();
            setRecyclerView();
        }else {
            String[]Permission={Manifest.permission.READ_CONTACTS};
            ActivityCompat.requestPermissions(MainActivity.this,Permission,REQUEST_CODE);
        }
    }
}