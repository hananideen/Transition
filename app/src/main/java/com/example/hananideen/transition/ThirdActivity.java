package com.example.hananideen.transition;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Hananideen on 5/5/2015.
 */
public class ThirdActivity extends ActionBarActivity {

    //Like Button Variables
    private Button LikeButton;
    private int LikeCounter;
    private TextView LikeDisplay;
    private boolean ButtonStart = true;

    //Dislike Button Variables
    private Button DislikeButton;
    private int DislikeCounter;
    private TextView DislikeDisplay;

    private boolean userLiked = false;
    private boolean userDisliked = false;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        //Like Button Counter
        LikeButton = (Button)findViewById(R.id.like);
        LikeDisplay = (TextView)findViewById(R.id.like);
        LikeCounter = 3;
        LikeDisplay.setText("Like " + LikeCounter);
//        int liked = bundle.getInt("liked");
//        LikeCounter = liked;

        LikeButton.setOnClickListener(new View.OnClickListener ()
        {
            @Override
            public void onClick(View v)
            {
                userLiked = true;
                userDisliked = false;
                if(ButtonStart == true) {
                    LikeCounter++;
                    LikeDisplay.setText("Like " + LikeCounter);
                    LikeButton.setEnabled(false);
                    ButtonStart = false;
                } else if(ButtonStart == false) {
                    LikeCounter++;
                    DislikeCounter--;
                    LikeDisplay.setText("Like " + LikeCounter);
                    DislikeDisplay.setText("Dislike " + DislikeCounter);
                    LikeButton.setEnabled(false);
                    DislikeButton.setEnabled(true);
                }
            }
        });


        //Dislike Button Counter
        DislikeButton = (Button)findViewById(R.id.dislike);
        DislikeDisplay = (TextView)findViewById(R.id.dislike);
        DislikeCounter = 1;
        DislikeDisplay.setText("Dislike " + DislikeCounter);
//        int disliked = bundle.getInt("disliked");
//        DislikeCounter = disliked;

        DislikeButton.setOnClickListener(new View.OnClickListener ()
        {
            @Override
            public void onClick(View v)
            {
                userDisliked = true;
                userLiked = false;
                if(ButtonStart == true) {
                    DislikeCounter++;
                    DislikeDisplay.setText("Dislike " + DislikeCounter);
                    DislikeButton.setEnabled(false);
                    ButtonStart = false;
                } else if(ButtonStart == false) {
                    DislikeCounter++;
                    LikeCounter--;
                    DislikeDisplay.setText("Dislike " + DislikeCounter);
                    LikeDisplay.setText("Like " + LikeCounter);
                    DislikeButton.setEnabled(false);
                    LikeButton.setEnabled(true);
                }
            }
        });

        Button video = (Button)findViewById(R.id.video);
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdActivity.this, VideoStreaming.class);
                startActivity(intent);
            }
        });


    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.animator.hold, R.animator.animator2);

    }

}
