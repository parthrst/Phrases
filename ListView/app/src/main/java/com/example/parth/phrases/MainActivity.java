package com.example.parth.phrases;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {
void voiceFinder(String s){
    String lowercase=s.toLowerCase();
    char[] arr=lowercase.toCharArray();
    StringBuilder str= new StringBuilder();
    for(char x:arr){
        if(x!=' '&& x!='?' &&  x!='.')
            str.append(x);
    }
    String identry=str.toString();
    int resid=getResources().getIdentifier(identry,"raw","com.example.parth.phrases");

    MediaPlayer audio=MediaPlayer.create(this,resid);
    audio.start();
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView=findViewById(R.id.list);
          final ArrayList<String> phrases=new ArrayList<String>(asList("Hello","Please","I live in..","Welcome","Do you speak english"
          ,"How are you?","My name is..","Good Evening"));

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,phrases);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                      voiceFinder(phrases.get(i));
            }
        });
    }
}
