package com.example.jersonmartinez.galeria2.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.jersonmartinez.galeria2.R;
import com.example.jersonmartinez.galeria2.database.models.Imagenes;
import com.raizlabs.android.dbflow.sql.language.SQLite;



public class DetalleActivity extends AppCompatActivity {
    private CoordinatorLayout coordinatorLayout;
    private ViewPager viewPager;
    private ImageView imagen;
    private Imagenes mostrar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalleimagen);

        coordinatorLayout = findViewById(R.id.coordinador);
        viewPager = findViewById(R.id.viewpager);
        imagen = findViewById(R.id.imagen);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        if(getIntent().hasExtra("imagen")){
            mostrar = SQLite.select().from(Imagenes.class).where(Imagenes_Table.id.eq(getIntent().getExtras().getLong("imagen"))).querySingle();
            Glide.with(this).load(mostrar.imagen).error( Glide.with(this)
                    .load(R.mipmap.ic_launcher)).centerCrop().into(imagen);
        }


    }
}
