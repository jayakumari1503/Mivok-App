package com.chhavi.miwok;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
        final String LOG_TAG = WordAdapter.class.getSimpleName();
        int mResourceLayout;
        int mColorResourceID;

        WordAdapter(Activity context, int resource, ArrayList<Word > words,int colorResourceID){
            super(context, 0, words);
            mResourceLayout = resource;
            mColorResourceID = colorResourceID;
        }

        @NonNull
        @Override
        public View getView ( int position, @Nullable View convertView, @NonNull ViewGroup parent){
            View listItemView = convertView;

            if (listItemView == null) {
                listItemView = LayoutInflater.from(getContext()).inflate(this.mResourceLayout, parent, false);
            }

            Word currentWord = getItem(position);

            TextView miwokTextView = listItemView.findViewById(R.id.miwok_text_view);
            miwokTextView.setText(currentWord.getMiwokTranslation());

            TextView defaultTextView = listItemView.findViewById(R.id.default_text_view);
            defaultTextView.setText(currentWord.getDefaultTranslation());

            ImageView imageView = listItemView.findViewById(R.id.image_view);

            if (currentWord.hasImage()) {
                imageView.setImageResource(currentWord.getImageResourceID());
                imageView.setVisibility(View.VISIBLE);
            } else {
                imageView.setVisibility(View.GONE);
            }

            View textContainer = listItemView.findViewById(R.id.text_container);
//        Find the color that the resource ID maps to
            int color = ContextCompat.getColor(getContext(), mColorResourceID);
            textContainer.setBackgroundColor(color);

            return listItemView;
        }
    }

