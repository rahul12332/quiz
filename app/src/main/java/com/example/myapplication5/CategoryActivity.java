package com.example.myapplication5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity implements RecycleViewOnClick{
    RecyclerView recyclerView;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        mAuth = FirebaseAuth.getInstance();

        recyclerView = findViewById(R.id.recyclerView);

        List<String> catList = new ArrayList<>();
        CatGridAdapter adpter = new CatGridAdapter(CategoryActivity.this, catList, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2,RecyclerView.VERTICAL,false);
        //DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getApplicationContext(),RecyclerView.VERTICAL);
        // DividerItemDecoration HoridividerItemDecoration = new DividerItemDecoration(getApplicationContext(),RecyclerView.HORIZONTAL);
        //  recyclerView.addItemDecoration(dividerItemDecoration);
        // recyclerView.addItemDecoration(HoridividerItemDecoration);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adpter);


        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference root = db.getReference("Category");
        root.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {

                        for (DataSnapshot s : snapshot.getChildren()) {
                            String category = s.getKey();
                            catList.add(category);
                            adpter.notifyDataSetChanged();
                        }


                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(CategoryActivity.this, "Unexpected error!", Toast.LENGTH_LONG).show();
            }
        });




    }

    @Override
    public void onItemClick(int position, String category) {
        startActivity(new Intent(CategoryActivity.this, NewSetActivity.class).putExtra("category",category));

    }

    @Override
    public void onLongItemClick(int position) {

    }
}