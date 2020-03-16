package com.example.bsmr;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.DebugTextViewHelper;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

public class DateVideoPlayer extends AppCompatActivity {
    private static final String VIDEO_SAMPLE = "http://mri.olivineltd.com/bsmr/video.mp4";
    private PlayerView playerView;
    private LinearLayout debugRootView;
    private Button selectTracksButton;
    private TextView debugTextView;
    private boolean isShowingTrackSelectionDialog;

    private DataSource.Factory dataSourceFactory;
    private SimpleExoPlayer player;
    private MediaSource mediaSource;
    private DefaultTrackSelector trackSelector;
    private DefaultTrackSelector.Parameters trackSelectorParameters;
    private DebugTextViewHelper debugViewHelper;
    private TrackGroupArray lastSeenTrackGroupArray;


    private boolean startAutoPlay;
    private int startWindow;
    private long startPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_date_video_player);
        getSupportActionBar().hide();
        playerView = findViewById(R.id.exoplayer);
    }

    @Override
    protected void onStart() {
        super.onStart();

        playerView.requestFocus();
        player = new SimpleExoPlayer.Builder(getApplicationContext()).build();
        playerView.setPlayer(player);


        DefaultDataSourceFactory dataSourceFactory = new DefaultDataSourceFactory( this,
                com.google.android.exoplayer2.util.Util.getUserAgent(this,"BSMR"));

        MediaSource mediaSource = new ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(Uri.parse("http://mri.olivineltd.com/bsmr/video.mp4"));
        player.prepare(mediaSource);
        player.setPlayWhenReady(true);
    }
    @Override
    protected void onStop() {
        super.onStop();
        playerView.setPlayer(null);
        player = null;

    }
    @Override
    protected void onPause() {
        super.onPause();

        if (Util.SDK_INT <= 23) {
            if (playerView != null) {
                playerView.onPause();
            }
            releasePlayer();
        }
    }
    private void releasePlayer() {
        if (player != null) {
            updateStartPosition();
            player.release();
            player = null;
            mediaSource = null;
            trackSelector = null;
        }

    }
    private void updateStartPosition() {
        if (player != null) {
            startAutoPlay = player.getPlayWhenReady();
            startWindow = player.getCurrentWindowIndex();
            startPosition = Math.max(0, player.getContentPosition());
        }
    }

    private void clearStartPosition() {
        startAutoPlay = true;
        startWindow = C.INDEX_UNSET;
        startPosition = C.TIME_UNSET;
    }



}
