package com.hit.underthesea;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.hit.underthesea.fragments.SettingsFragment;
import com.hit.underthesea.score.ScoreTable;


public class PlayMenu extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_menu);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ImageButton scorebtn = findViewById(R.id.score_btn);
        scorebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlayMenu.this , ScoreTable.class);
                startActivity(intent);
            }
        });

      //  ImageButton setting = findViewById(R.id.settings);
      //  setting.setOnClickListener(new View.OnClickListener() {
        //    @Override
         //   public void onClick(View view) {
                //support חייב להוסיף בגירסא החדשה
          //      getSupportFragmentManager().beginTransaction().add(R.id.fragment_containerplay, new SettingsFragment(), null).addToBackStack("Settings").commit();

                //FragmentManager fragmentManager = getSupportFragmentManager();
                //FragmentTransaction transaction = fragmentManager.beginTransaction();
                //transaction.add(R.id.fragment_container, new SettingsFragment(), SETTINGS_FRAGMENT_TAG);
                //transaction. addToBackStack(null); מוריד את העסקא האחרונה
                //transaction.commit();

         //   }
      //  });

        ImageButton easylevel = findViewById(R.id.level1);
        ImageButton midlevel = findViewById(R.id.level2);
        ImageButton hardlevel = findViewById(R.id.level3);
        easylevel.setOnClickListener(this);
        midlevel.setOnClickListener(this);
        hardlevel.setOnClickListener(this);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_settings,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.actions_set){
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_containerplay, new SettingsFragment(), null).addToBackStack("Settings").commit();

            return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        int numberlevel=1;
        if(view.getId()==R.id.level2)
            numberlevel = 2;
        else if(view.getId()==R.id.level3){
            numberlevel=3;
        }

        Bundle bundle = new Bundle();
        bundle.putInt("num_level", numberlevel);
        Intent intent = new Intent(PlayMenu.this, GameActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
