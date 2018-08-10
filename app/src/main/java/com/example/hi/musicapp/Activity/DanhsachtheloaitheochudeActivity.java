package com.example.hi.musicapp.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.hi.musicapp.Model.Chude;
import com.example.hi.musicapp.R;

public class DanhsachtheloaitheochudeActivity extends AppCompatActivity {

    Chude chude;
    RecyclerView recyclerViewtheloaitheochude;
    Toolbar toolbartheloaitheochude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachtheloaitheochude);
        GetIntent();
        init();

    }

    private void init() {
        recyclerViewtheloaitheochude = findViewById(R.id.recyclerviewtheloaitheochude);
        toolbartheloaitheochude = findViewById(R.id.toolbartheloaitheochude);
        setSupportActionBar(toolbartheloaitheochude);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(chude.getTenChuDe());
        toolbartheloaitheochude.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void GetIntent() {
        Intent intent = getIntent();
        if (intent.hasExtra("chude")){
            chude = (Chude) intent.getSerializableExtra("chude");
            Toast.makeText(this, chude.getTenChuDe(), Toast.LENGTH_SHORT).show();
        }
    }
}
