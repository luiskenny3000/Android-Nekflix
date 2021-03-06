package app.kaisa.tmdb.utils

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import app.kaisa.tmdb.model.Movie
import app.kaisa.tmdb.model.Video
import app.kaisa.tmdb.ui.landing.MovieLandingActivity
import app.kaisa.tmdb.ui.player.PlayerActivity
import app.kaisa.tmdb.ui.player.PlayerActivity.Companion.PARAM_URL

object NavigationManager {

    fun handle(context: Context?, item: Video){
        if(context != null && item.urlPlayback?.isNotBlank() == true) {
            val intent = Intent(context, PlayerActivity::class.java)
            intent.putExtra(PARAM_URL, item.urlPlayback)
            context.startActivity(intent)
        }
    }

    fun handle(context: Activity?, movie: Movie, activityOptions: ActivityOptions = ActivityOptions.makeSceneTransitionAnimation(context)){
        val intent = Intent(context, MovieLandingActivity::class.java)
        intent.putExtra(PARAM_CONTENT, movie)
        context?.startActivity(intent, activityOptions.toBundle())
    }

    const val PARAM_CONTENT = "param_content"
}