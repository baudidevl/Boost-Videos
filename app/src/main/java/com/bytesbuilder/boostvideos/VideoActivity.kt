package com.bytesbuilder.boostvideos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerFragment

class VideoActivity : YouTubeBaseActivity(), YouTubePlayer.OnInitializedListener {

    private val API_KEY = "YOUR_API_KEY" // Reemplaza con tu clave API
    private val VIDEO_ID = "YOUR_VIDEO_ID" // Reemplaza con el ID del video de YouTube que quieras reproducir

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        val youTubePlayerFragment = fragmentManager.findFragmentById(R.id.youtube_fragment) as YouTubePlayerFragment
        youTubePlayerFragment.initialize(API_KEY, this)
    }

    override fun onInitializationSuccess(provider: YouTubePlayer.Provider, youTubePlayer: YouTubePlayer, wasRestored: Boolean) {
        if (!wasRestored) {
            youTubePlayer.cueVideo(VIDEO_ID) // Plays https://www.youtube.com/watch?v=VIDEO_ID
        }
    }

    override fun onInitializationFailure(provider: YouTubePlayer.Provider, youTubeInitializationResult: YouTubeInitializationResult) {
        // Handle the failure to initialize the YouTube player
    }
}
