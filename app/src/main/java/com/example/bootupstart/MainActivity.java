package com.example.bootupstart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkConnection();



        final VideoView videoView = (VideoView) findViewById(R.id.videoView);
        videoView.setVideoPath("https://sample-videos.com/video123/mp4/720/big_buck_bunny_720p_1mb.mp4");
        videoView.start();

//        String videoPath = "android.resource://" +getPackageName() + "/" + R.raw.costa;
//        Uri uri = Uri.parse(videoPath);
//        videoView.setVideoURI(uri);

        //https://sample-videos.com/video123/mp4/720/big_buck_bunny_720p_1mb.mp4
    }
    public void checkConnection(){
        ConnectivityManager manager = (ConnectivityManager) getApplicationContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = manager.getActiveNetworkInfo();

        if(null!=activeNetwork){
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI){
                Toast.makeText(this, "WiFi Enabled", Toast.LENGTH_SHORT).show();

            }else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE){
                Toast.makeText(this, "Mobile data Enabled", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
            //context.startActivity(activityIntent);

        }
    }

}