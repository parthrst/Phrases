package com.example.parth.phrases;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
public void tapped(View view){
    int id=view.getId();

    String idb="";
    idb=view.getResources().getResourceEntryName(id);
    Log.i("ButtonTapped",idb);
    int resid=getResources().getIdentifier(idb,"raw","com.example.parth.phrases");
    Log.i("ButtonTapped",Integer.toString(resid));
    MediaPlayer audio=MediaPlayer.create(this,resid);
    audio.start();
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
