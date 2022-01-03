package com.example.myapplication5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class NewSetActivity extends AppCompatActivity {
    RecyclerView setsRecyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_set);
        setsRecyclerview = findViewById(R.id.Sets_recyclerView);
        List<String> setsList = new ArrayList<>();


        Intent in = getIntent();
        String category = in.getStringExtra("category");
        SetsAdapter setsAdapter = new SetsAdapter(NewSetActivity.this, setsList, new RecycleViewOnClick() {
            @Override
            public void onItemClick(int position, String set) {
                startActivity(new Intent(NewSetActivity.this,QuestionActivity.class)
                        .putExtra("category",category)
                        .putExtra("set",set));
            }

            @Override
            public void onLongItemClick(int position) {

            }
        });
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 2, RecyclerView.VERTICAL, false);
        //DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getApplicationContext(),RecyclerView.VERTICAL);
        // DividerItemDecoration HoridividerItemDecoration = new DividerItemDecoration(getApplicationContext(),RecyclerView.HORIZONTAL);
        //  recyclerView.addItemDecoration(dividerItemDecoration);
        // recyclerView.addItemDecoration(HoridividerItemDecoration);
        setsRecyclerview.setLayoutManager(layoutManager);
        setsRecyclerview.setAdapter(setsAdapter);
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference root = db.getReference("Category").child(category);
        root.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {

                    for (DataSnapshot s : snapshot.getChildren()) {
                        String sets = s.getKey();
                        setsList.add(sets);
                        setsAdapter.notifyDataSetChanged();
                    }


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }


        });
    }
}
