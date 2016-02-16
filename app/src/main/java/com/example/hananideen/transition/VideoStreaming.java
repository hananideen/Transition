package com.example.hananideen.transition;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by Hananideen on 7/5/2015.
 */
public class VideoStreaming extends ActionBarActivity{

    String vidAddress = "http://www.androidbegin.com/tutorial/AndroidCommercial.3gp";
    Uri vidUri = Uri.parse(vidAddress);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_view);

        VideoView vidView = (VideoView)findViewById(R.id.videoView);
        vidView.setVideoURI(vidUri);

        MediaController vidControl = new MediaController(this);
        vidControl.setAnchorView(vidView);
        vidView.setMediaController(vidControl);

        vidView.start();

}
}