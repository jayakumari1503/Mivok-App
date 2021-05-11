package com.chhavi.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<>();

        words.add(new Word("weṭeṭṭi", "red", R.raw.color_red, R.drawable.color_red));
        words.add(new Word("chokokki", "green", R.raw.color_green, R.drawable.color_green));
        words.add(new Word("ṭakaakki", "brown", R.raw.color_brown, R.drawable.color_brown));
        words.add(new Word("ṭopoppi", "grey", R.raw.color_gray, R.drawable.color_gray));
        words.add(new Word("kululli", "black", R.raw.color_black, R.drawable.color_black));
        words.add(new Word("kelelli", "white", R.raw.color_white, R.drawable.color_white));
        words.add(new Word("ṭopiisә", "dusty yellow", R.raw.color_dusty_yellow, R.drawable.color_dusty_yellow));
        words.add(new Word("chiwiiṭә", "mustard yellow", R.raw.color_mustard_yellow, R.drawable.color_mustard_yellow));

        WordAdapter itemsAdapter = new WordAdapter(this, R.layout.list_item, words, R.color.colors_category);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);
                mediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getAudioResourceID());
                mediaPlayer.start();
            }
        });
    }
}