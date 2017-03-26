package com.example.android.camera2basic;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v13.app.FragmentCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by andrew on 3/25/17.
 */

public class DisplayPhoto extends Fragment implements View.OnClickListener,
        FragmentCompat.OnRequestPermissionsResultCallback {


    public static DisplayPhoto newInstance() {
        return new DisplayPhoto();
    }

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
}
