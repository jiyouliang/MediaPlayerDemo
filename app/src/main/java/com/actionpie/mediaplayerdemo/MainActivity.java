package com.actionpie.mediaplayerdemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.actionpie.mediaplayerdemo.view.ActionPiVideoPlayer;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

public class MainActivity extends AppCompatActivity {

    private ActionPiVideoPlayer mVideoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mVideoPlayer = (ActionPiVideoPlayer) findViewById(R.id.videoPlayer);

        String source1 = "http://9890.vod.myqcloud.com/9890_4e292f9a3dd011e6b4078980237cc3d3.f20.mp4";
        mVideoPlayer.setUp(source1, true, "测试视频");
        mVideoPlayer.startPlayLogic();
    }
}
