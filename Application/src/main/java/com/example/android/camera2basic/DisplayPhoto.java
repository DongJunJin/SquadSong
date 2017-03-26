package com.example.android.camera2basic;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v13.app.FragmentCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by andrew on 3/25/17.
 */

public class DisplayPhoto extends Fragment implements View.OnClickListener,
        FragmentCompat.OnRequestPermissionsResultCallback {

    private MediaPlayer mediaPlayer;
    public static DisplayPhoto newInstance() {
        return new DisplayPhoto();
    }

    Bundle extras;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.display_photo, container, false);

    }

    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        view.findViewById(R.id.music_play).setOnClickListener(this);
        view.findViewById(R.id.save_music).setOnClickListener(this);
        int resource = view.findViewById(R.id.saved_img).getId();

        String imgSrc = getArguments().getString("Imagefile");
        if(imgSrc != null){
                Uri uri = Uri.parse(imgSrc);
                ImageView imageView = (ImageView) view.findViewById(resource);
                imageView.setImageURI(uri);
            }
        }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.music_play:
                if(extras.getStringArrayList("EmoteList") != null){
                    extras.getStringArrayList("EmoteList");
                    playMusic();
                }
                else{
                    Log.d("Empty", "Empty");
                }

                break;

            case R.id.save_music:
                break;
        }
    }

//    @Override
//    public void onBackPressed(){
//        super.onBackPressed();
//        FragmentManager fragmentManager = getFragmentManager();
//        Fragment fragment = new Camera2BasicFragment();
//        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
//    }

    public void playMusic(){
        if(extras.getParcelableArrayList("EmoteList") == null){
            return;
        }
        else{
            ArrayList<String> emotes= extras.getStringArrayList("EmoteList");
            for(int i = 0; i <= emotes.size(); i++){
                playNote(emotes.get(i));
            }
        }
    }

    public void playNote(String emotion){
        if(emotion.equalsIgnoreCase("Fear")){
            mediaPlayer = MediaPlayer.create(getActivity(), R.raw.a);
            mediaPlayer.start();
            timeblock();
        }

        else if (emotion.equalsIgnoreCase("Disgust")){
            mediaPlayer = MediaPlayer.create(getActivity(), R.raw.b);
            mediaPlayer.start();
            timeblock();
        }

        else if (emotion.equalsIgnoreCase("Contempt")){
            return;
        }

        else if (emotion.equalsIgnoreCase("Happiness")){
            mediaPlayer = MediaPlayer.create(getActivity(), R.raw.c);
            mediaPlayer.start();
            timeblock();
        }

        else if (emotion.equalsIgnoreCase("Anger")){
            mediaPlayer = MediaPlayer.create(getActivity(), R.raw.d);
            mediaPlayer.start();
            timeblock();
        }

        else if (emotion.equalsIgnoreCase("Sadness")){
            mediaPlayer = MediaPlayer.create(getActivity(), R.raw.e);
            mediaPlayer.start();
            timeblock();
        }

        else if (emotion.equalsIgnoreCase("Neutral")){
            mediaPlayer = MediaPlayer.create(getActivity(), R.raw.f);
            mediaPlayer.start();
            timeblock();
        }

        else if (emotion.equalsIgnoreCase("Surprise")){
            mediaPlayer = MediaPlayer.create(getActivity(), R.raw.g);
            mediaPlayer.start();
            timeblock();
        }

        else{
            return;
        }
    }

    public void timeblock(){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    Log.d("Time", "Stop");
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 1000);
    }
}
